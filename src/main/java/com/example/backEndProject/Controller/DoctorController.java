/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backEndProject.Controller;

import com.example.backEndProject.Modele.Doctor;
import com.example.backEndProject.Service.DoctorService;
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
@RequestMapping("/doctors")
@AllArgsConstructor
public class DoctorController {
    private final DoctorService docserv;   
    
     @PostMapping("/create")
    public Doctor create(@RequestBody Doctor doc){
    return docserv.creer(doc);
    }
 @GetMapping("doctorlist")
    public List<Doctor> read(){
    return docserv.lire();
    }
     @PutMapping("/update/{id}")
    public Doctor update(@PathVariable Long id,@RequestBody  Doctor doc){
    return docserv.modifier(id, doc);
    }
    @GetMapping("doctor/{id}")
    public Doctor getpatient(@PathVariable Long id){
    return docserv.getById(id);
    }
}
