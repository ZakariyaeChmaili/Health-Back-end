/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backEndProject.filters;

import com.example.backEndProject.Modele.Personne;
import com.example.backEndProject.Service.JwtService;
import com.example.backEndProject.Service.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

    JwtService jwtService;
    PersonService personService;

    JwtFilter(JwtService jwtService, PersonService personService){
        this.jwtService = jwtService;
        this.personService = personService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        
        
        String path = request.getRequestURI();
        String method = request.getMethod();
        String token = "";
        String cni;
        
        
        if (path.equals("/authentication/login") && method.equals("POST")) {
            filterChain.doFilter(request, response);
            return;
        }

        // token = request.getHeader("token");
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    token = cookie.getValue();
                }
                System.out.println(cookie.getName());

            }
        }
        System.out.println("the token :" + token);

        if (token != null && !token.equals("")) {
            try {
                cni = jwtService.extractClaimFromToken(token, "cni");

            } catch (Exception e) {
                response.setStatus(401);
                response.getWriter()
                        .write(new ObjectMapper().writeValueAsString(Map.of("error", "the token is invalid")));
                return;
            }
            System.out.println(cni);
            System.out.println("start printing person");
            Personne p = this.personService.loadUserByUsername(cni);
//            Personne p = this.personService.findPersonneByCni(cni).orElse(null);
            System.out.println(p);

            if (p != null) {
                SecurityContextHolder.getContext()
                        .setAuthentication(new UsernamePasswordAuthenticationToken(p, null, p.getAuthorities()));
            }

        }
        filterChain.doFilter(request, response);
    }
}
