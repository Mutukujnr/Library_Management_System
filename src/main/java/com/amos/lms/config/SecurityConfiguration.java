package com.amos.lms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.amos.lms.service.CustomUserDetails;
import com.amos.lms.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@Bean
	 static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	 SecurityFilterChain  securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(requests -> requests
                .requestMatchers("/register").permitAll()       
                .requestMatchers("/CSS/**","/Images/**","/js/**","/plugins/**","/fonts/**","/auth/**").permitAll()
                .requestMatchers("/home","/students","/add-student","/edit-student/{id}","/delete-student/{id}","/update-student").permitAll()
                .requestMatchers("/books","/add-book","/editBook/{id}","/deleteBook/{id}","/updateBook","/issueBookForm","/issueBook","/issuedBooks","/return","/issued-books").permitAll())
                .formLogin(login -> login
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/home?success", true).permitAll())
                .logout(logout -> logout
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logout").permitAll());
		
		return http.build();
	}

	@Autowired
	public void ConfigureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
		authenticationManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
		
	}
	
}
