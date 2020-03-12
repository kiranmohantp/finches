package com.finches.finchesservice.security.filters;

import com.finches.finchesservice.entities.UserDetails;
import com.finches.finchesservice.exceptions.apiexceptions.NoDataFoundException;
import com.finches.finchesservice.models.response.UserJwtDetails;
import com.finches.finchesservice.services.UserDetailsService;
import com.finches.finchesservice.utils.JwtHelper;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {
    private final String AUTHORIZATION = "Authorization";
    private final String BEARER = "Bearer ";

    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        final String requestTokenHeader = httpServletRequest.getHeader(AUTHORIZATION);
        String encodedId = null;
        String jwtToken = null;
        if (requestTokenHeader != null && requestTokenHeader.startsWith(BEARER)) {
            jwtToken = requestTokenHeader.substring(7);
            try {
                encodedId = jwtHelper.getEncodedId(jwtToken);
            } catch (Exception e) {
                logger.warn("Jwt token parsing failed!");
                logger.warn(e.getMessage());
            }
        } else {
            logger.warn("Bearer String Missing at the beginning!");
        }
        if (encodedId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            try {
                UserJwtDetails userJwtDetails = this.userDetailsService.getUserDataForAuthenticationByEncodedId(encodedId);
                if (jwtHelper.validateToken(jwtToken, userJwtDetails)) {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                            userJwtDetails, null, null);
                    usernamePasswordAuthenticationToken
                            .setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            } catch (NoDataFoundException e) {
                logger.warn("Id in JWT Token does not found in Database!");
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
