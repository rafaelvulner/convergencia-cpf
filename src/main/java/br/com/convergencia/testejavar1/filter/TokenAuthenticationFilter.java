package br.com.convergencia.testejavar1.filter;

import br.com.convergencia.testejavar1.entity.User;
import br.com.convergencia.testejavar1.repository.UserRepository;
import br.com.convergencia.testejavar1.service.impl.TokenServiceImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class TokenAuthenticationFilter extends OncePerRequestFilter {
	
	private final TokenServiceImpl tokenService;
	private final UserRepository repository;
	
	public TokenAuthenticationFilter(TokenServiceImpl tokenService, UserRepository repository) {
		this.tokenService = tokenService;
		this.repository = repository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String tokenFromHeader = getTokenFromHeader(request);
		boolean tokenValid = tokenService.isTokenValid(tokenFromHeader);
		if(tokenValid) {
			this.authenticate(tokenFromHeader);
		}

		filterChain.doFilter(request, response);
	}

	private void authenticate(String tokenFromHeader) {
		Integer id = tokenService.getTokenId(tokenFromHeader);
		
		Optional<User> optionalUser = repository.findById(id);
		
		if(optionalUser.isPresent()) {
			
			User user = optionalUser.get();
			
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getPerfis());
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		}
	}

	private String getTokenFromHeader(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if(token == null || !token.startsWith("Bearer ")) {
			return null;
		}
		
		return token.substring(7);
	}

}
