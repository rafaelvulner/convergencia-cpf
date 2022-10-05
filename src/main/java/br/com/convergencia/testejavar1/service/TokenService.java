package br.com.convergencia.testejavar1.service;

import org.springframework.security.core.Authentication;

public interface TokenService {

    String generateToken(Authentication authentication);

    boolean isTokenValid(String token);

    Integer getTokenId(String token);
}
