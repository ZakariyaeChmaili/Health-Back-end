/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backEndProject.Controller;

import com.example.backEndProject.Modele.Personne;
import com.example.backEndProject.Service.PersonService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hp
 */
@RestController
@RequestMapping("/signin")
@AllArgsConstructor

public class PersonController {
 private final PersonService serv;   
 
 @PostMapping("/create")
    public Personne create(@RequestBody Personne perso){
    return serv.creer(perso);
    }
 @GetMapping("personlist")
    public List<Personne> read(){
    return serv.lire();
    }
    //finnaaa hyaaaaaaaa @RequestBody 
    @PutMapping("/update/{id}")
    public Personne update(@PathVariable Long id,@RequestBody  Personne perso){
      System.out.println("this is inseide the update method");
      System.out.println(perso);
    return serv.modifier(id, perso);
    }
    
     @GetMapping("person/{id}")
    public Personne getPerson(@PathVariable Long id){
    return serv.getById(id);
    }
    
}
