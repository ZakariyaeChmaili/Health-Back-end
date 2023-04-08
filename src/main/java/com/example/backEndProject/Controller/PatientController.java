/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backEndProject.Controller;

import com.example.backEndProject.Modele.Patient;
import com.example.backEndProject.Modele.Personne;
import com.example.backEndProject.Service.PatientService;
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
@RequestMapping("/patient")
@AllArgsConstructor
public class PatientController {
    private final PatientService serv;   
    
     @PostMapping("/create")
    public Patient create(@RequestBody Patient patient){
    return serv.creer(patient);
    }
 @GetMapping("patientlist")
    public List<Patient> read(){
    return serv.lire();
    }
     @GetMapping("patient/{id}")
    public Patient getpatient(@PathVariable Long id){
    return serv.getById(id);
    }
     @PutMapping("/update/{id}")
    public Patient update(@PathVariable Long id,@RequestBody  Patient pas){
    return serv.modifier(id, pas);
    }
}
