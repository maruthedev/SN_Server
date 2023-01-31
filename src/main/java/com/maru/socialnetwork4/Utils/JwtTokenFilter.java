package com.maru.socialnetwork4.Utils;

import com.maru.socialnetwork4.Model.User;
import com.maru.socialnetwork4.Service.UserService;
import org.apache.coyote.Request;
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

import org.springframework.http.HttpHeaders;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {
    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String requestHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
            String[] splitHeaders = requestHeader.split(" ");
            String token = splitHeaders[1];
            User loggedUser = userService.loadUserById(jwtTokenProvider.getIdFromToken(token));
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    loggedUser.getUsername(),
                    loggedUser.getPassword(),
                    loggedUser.getAuthorities()
            );
            authenticationToken.setDetails(
                    new WebAuthenticationDetailsSource().buildDetails(request)
            );
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        } catch (Exception e) {
            System.out.println(e);
        }
        filterChain.doFilter(request, response);
    }
}
