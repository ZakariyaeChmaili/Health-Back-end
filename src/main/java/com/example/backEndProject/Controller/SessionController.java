/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backEndProject.Controller;

import com.example.backEndProject.Modele.Session;
import com.example.backEndProject.Service.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 *
 * @author hp
 */
@RestController
@RequestMapping("/session")
@AllArgsConstructor
public class SessionController {
     private final SessionService serv;   
 @PostMapping("/create")
    public Session create(@RequestBody Session se){
    return serv.creer(se);
    }
    
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Map<String,String>> delete(@PathVariable Long id){
    return serv.delete(id);
    } 
    
    
    
    @GetMapping("get/{id}")
    public Session get(@PathVariable Long id){
        return serv.getByPatientId(id);
    }
    
    
    @GetMapping("getCode/{code}")
    public Session getCode(@PathVariable String code){
        return serv.getByCode(code);
    }
}
