package com.example.backEndProject.Controller;

import com.example.backEndProject.Modele.Personne;
import com.example.backEndProject.Service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtService jwtService ;

    @PostMapping("/login")
    public String login(@RequestBody Personne p) {
        Authentication user = new UsernamePasswordAuthenticationToken(p.getCni(), p.getPassword());
        System.out.println(user);
        try {
            authenticationManager.authenticate(user);
        } catch (Exception e) {
//            return ResponseEntity.status(401).body(Map.of("error", "wrong username or password"));
            return "error";

        }
        String token = this.jwtService.generateToken(p.getCni());

        return token;
    }
    
    @GetMapping("/test")
    public String test(){
        return "this is test";
    }
}
