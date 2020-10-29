package com.greatoutdoor.authenticationservicefilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import org.springframework.util.StringUtils;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.greatoutdoor.authenticationservice.service.UserDetailsServiceImpl;
import com.greatoutdoor.authenticationservice.util.JwtUtil;


/*
 * Name: JwtFilter
 * Description: Its will validate the authentication token from the request headed
 * and its will filter the authentication.
 * Examines the header
 */
@Component
public class JwtFilter extends OncePerRequestFilter{

	
	
	@Autowired
	private JwtUtil jwtUtils;
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	private static final Logger jwtFilterLogger = LoggerFactory.getLogger(JwtFilter.class);

	
	/**
	 * Finds a valid JWT, get the user details service and save it in context
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String jwt = parseJwt(request);
			if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
				String username = jwtUtils.getUserNameFromJwtToken(jwt);

				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		} catch (Exception e) {
			jwtFilterLogger.error("Cannot set user authentication: {}", e);
		}

		filterChain.doFilter(request, response);
	}
	

	private String parseJwt(HttpServletRequest request) {
		String headerAuth = request.getHeader("Authorization");
		jwtFilterLogger.info("filter the request and response entity with header");
		if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
			return headerAuth.substring(7, headerAuth.length());
		}

		return null;
	}
	

}
