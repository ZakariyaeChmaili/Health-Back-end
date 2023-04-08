/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backEndProject.Controller;

import com.example.backEndProject.Modele.Vaccin;
import com.example.backEndProject.Service.VaccinService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hp
 */
@RestController
@RequestMapping("/vaccins")
@AllArgsConstructor
public class VaccinController {
     private final VaccinService serv; 
     @PostMapping("/create")
    public Vaccin create(@RequestBody Vaccin vac){
    return serv.creer(vac);
    }
    
    @GetMapping("vaccinlist")
    public List<Vaccin> read(){
    return serv.lire();
    }
    
    @GetMapping("vaccin/{id}")
    public Vaccin getVaccin(@PathVariable Long id){
    return serv.getById(id);
    }
}
