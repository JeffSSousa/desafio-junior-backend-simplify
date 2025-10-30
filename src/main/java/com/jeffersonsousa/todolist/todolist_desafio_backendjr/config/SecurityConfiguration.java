package com.jeffersonsousa.todolist.todolist_desafio_backendjr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		return http
				.csrf(AbstractHttpConfigurer::disable)
				.formLogin(configurer -> {
					configurer.loginPage("/login").permitAll();
				})
				.httpBasic(Customizer.withDefaults())
				.authorizeHttpRequests(auth -> { 
					auth.requestMatchers("/login").permitAll(); // rotas públicas
					auth.requestMatchers("/todos/**").hasRole("USER"); // define qual role poderar acessar
					auth.requestMatchers(HttpMethod.GET,"/user/**").hasAnyRole("USER", "ADMIN"); // define quais role poderaram acessar
					auth.anyRequest().authenticated(); // demais exigem autenticação
				})
				.build();
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
	
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		
		UserDetails user1 = User.builder()
				.username("user")
				.password(encoder.encode("1234567"))
				.roles("USER")
				.build();
		
		UserDetails user2 = User.builder()
                .username("admin")
                .password(encoder.encode("1234567"))
                .roles("ADMIN")
                .build();
		
		return new InMemoryUserDetailsManager(user1, user2);
	}
	
}
