/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backEndProject.Controller;

import com.example.backEndProject.Modele.Report;
import com.example.backEndProject.Service.ReportService;
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
@RequestMapping("/reports")
@AllArgsConstructor
public class reportController {
     private final ReportService serv;   
 @PostMapping("/create")
    public Report create(@RequestBody Report repo){
    return serv.creer(repo);
    }
    
    @GetMapping("reportlist")
    public List<Report> read(){
    return serv.lire();
    }
    
    @GetMapping("report/{id}")
    public Report getReport(@PathVariable Long id){
    return serv.getById(id);
    }
}
