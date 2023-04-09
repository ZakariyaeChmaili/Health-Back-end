/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backEndProject.filters;

import com.example.backEndProject.Modele.Personne;
import com.example.backEndProject.Service.JwtService;
import com.example.backEndProject.Service.PersonService;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author ADMIN
 */
@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    JwtService jwtService;
    @Autowired
    PersonService personService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = request.getHeader("token");//null
        if (token != null) {
            String cni = this.jwtService.extractClaimFromToken(token, "cni");
            Personne p = this.personService.loadUserByUsername(cni);
            System.out.println(token);
            System.out.println(p);
            Authentication user = new UsernamePasswordAuthenticationToken(cni, null, p.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(user);
        }

        filterChain.doFilter(request, response);
    }

}
