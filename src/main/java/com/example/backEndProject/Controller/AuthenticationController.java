package com.example.backEndProject.Controller;

import com.example.backEndProject.Modele.Personne;
import com.example.backEndProject.Service.JwtService;
import com.example.backEndProject.Service.PersonService;
import com.example.backEndProject.dto.PersonneDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("authentication")
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtService jwtService;
    @Autowired
    PersonService personService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Personne p, HttpServletResponse response) {
        Authentication user = new UsernamePasswordAuthenticationToken(p.getCni(), p.getPassword());
        System.out.println(user);
        try {
            authenticationManager.authenticate(user);
        } catch (Exception e) {
            return ResponseEntity.status(401).body(Map.of("error", "wrong username or password"));

        }
        String token = this.jwtService.generateToken(p.getCni());
        Cookie cookie = new Cookie("token", token);
        cookie.setDomain("localhost");
        cookie.setPath("/");
        cookie.setMaxAge(60*60);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        Personne personne = personService.loadUserByUsername(p.getCni());
        PersonneDTO personneDTO = new PersonneDTO(personne);
        System.out.println(personneDTO);
//        return token;
//        return ResponseEntity.ok(Map.of("token", token));
        return ResponseEntity.ok(Map.of("token", token, "user", personneDTO));
//        return ResponseEntity.ok(Map.of("user", personService.loadUserByUsername(p.getCni())));
    }

    @GetMapping("/test")
    public String test() {
        return "this is test";
    }
}
