package com.greatoutdoor.authenticationservice.util;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.function.Function;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.greatoutdoor.authenticationservice.service.UserDetailsImpl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

/*
 * Name:JwtUtil
 * Description: It will generate JWT token , authenticate JWT token and validate JWT token.
 */
@Service
public class JwtUtil {

    private String secret = "iter123";
    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

    
    
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    
    
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    
    
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    
    public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
	}


    
    public String generateToken(Authentication authentication) {

    	UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
    	
        return Jwts.builder().setSubject(userPrincipal.getUsername())
        		.setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
    
    

    public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			logger.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage());
		}

		return false;
	}
}