package br.com.alura.forum.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Profile(value = {"prod", "test"})
@Order(99)
public class ActuatorSecurityConfigurations extends WebSecurityConfigurerAdapter {

	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
        .withUser("root").password(passwordEncoder().encode("P@$$w0rd"))
        .authorities("ROLE_ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
	        .antMatchers("/actuator/**").hasRole("ADMIN")
	        .antMatchers(HttpMethod.GET, "/topicos").permitAll()
			.antMatchers(HttpMethod.GET, "/topicos/*").permitAll()
	        .antMatchers(HttpMethod.POST, "/auth").permitAll()
	        .antMatchers(HttpMethod.DELETE, "/topicos/*").hasRole("MODERADOR")
	        .anyRequest().authenticated()
			.and().csrf().disable()
	        .httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    } 
	
}
