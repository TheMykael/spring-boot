package br.com.alura.forum.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
<<<<<<< HEAD
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
=======
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
>>>>>>> 6fc1e2b1efea72d0fff32e3d95e400a84cb361e9
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
<<<<<<< HEAD
@Profile(value = {"prod", "test"})
@Order(99)
=======
@Order(value = Ordered.HIGHEST_PRECEDENCE)
>>>>>>> 6fc1e2b1efea72d0fff32e3d95e400a84cb361e9
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
<<<<<<< HEAD
	        .antMatchers("/actuator/**").hasRole("ADMIN")
	        .antMatchers(HttpMethod.GET, "/topicos").permitAll()
			.antMatchers(HttpMethod.GET, "/topicos/*").permitAll()
	        .antMatchers(HttpMethod.POST, "/auth").permitAll()
	        .antMatchers(HttpMethod.DELETE, "/topicos/*").hasRole("MODERADOR")
	        .anyRequest().authenticated()
			.and().csrf().disable()
	        .httpBasic();
=======
        .antMatchers("/actuator/**").hasRole("ADMIN")
        .and().httpBasic();
>>>>>>> 6fc1e2b1efea72d0fff32e3d95e400a84cb361e9
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    } 
	
}
