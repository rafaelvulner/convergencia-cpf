package br.com.convergencia.testejavar1.config;

import br.com.convergencia.testejavar1.filter.TokenAuthenticationFilter;
import br.com.convergencia.testejavar1.repository.UserRepository;
import br.com.convergencia.testejavar1.service.impl.AuthenticationServiceImpl;
import br.com.convergencia.testejavar1.service.impl.TokenServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private final AuthenticationServiceImpl authenticationService;

	private final TokenServiceImpl tokenService;

	private final UserRepository repository;

	public SecurityConfiguration(AuthenticationServiceImpl authenticationService, TokenServiceImpl tokenService, UserRepository repository) {
		this.authenticationService = authenticationService;
		this.tokenService = tokenService;
		this.repository = repository;
	}

	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(authenticationService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        	.antMatchers(HttpMethod.POST, "/auth").permitAll()
				.antMatchers(HttpMethod.GET, "/actuator/**").permitAll()
        	.anyRequest().authenticated()
        	.and().csrf().disable()
        	.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        	.and().addFilterBefore(new TokenAuthenticationFilter(tokenService, repository), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web)  {


		/*web.ignoring()
				.antMatchers("/h2-console")
				.anyRequest();*/
    }


	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
