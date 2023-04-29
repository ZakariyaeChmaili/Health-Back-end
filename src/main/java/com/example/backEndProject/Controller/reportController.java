/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backEndProject.Controller;

import com.example.backEndProject.Modele.Doctor;
import com.example.backEndProject.Modele.Report;
import com.example.backEndProject.Modele.Traitement;
import com.example.backEndProject.Service.DoctorService;
import com.example.backEndProject.Service.PersonService;
import com.example.backEndProject.Service.ReportService;
import java.util.List;

import com.example.backEndProject.Service.TraitementService;
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
     private final TraitementService Tserv;
 @PostMapping("/create")
    public Report create(@RequestBody Report repo){
//    Doctor d = Dserv.getById(2L);
//    repo.setDoctor(d);
//    System.out.println(repo);
//    System.out.println(repo.getDoctor().getId());
//    System.out.println(repo.getDoctor());
     System.out.println(repo);
     List<Traitement> traitementList = repo.getListeTraitement();
     for(Traitement t : traitementList){
         t.setReport(repo.getId_Repo());
         Tserv.creer(t);
     }
//     repo.setListeTraitement(null);
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


    @GetMapping("patientReports/{id}")
    public List<Report> getPatientReports(@PathVariable Long id){
    return serv.getPatientReports(id);
    }


    @GetMapping("search/{kword}/{id}")
    public List<Report> searchReport(@PathVariable long id,@PathVariable String kword){
    return serv.searchReport(kword,id);
//     return null;
    }
}
