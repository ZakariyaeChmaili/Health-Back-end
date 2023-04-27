/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backEndProject.Service;

import com.example.backEndProject.Modele.Report;
import com.example.backEndProject.Repository.Reportrepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
@AllArgsConstructor
public class ReportService implements ServiceInterface<Report> {
 private Reportrepository report;

    @Override
    public Report creer(Report repo) {
    return report.save(repo);

    }

    @Override
    public List<Report> lire() {
    return report.findAll();

    }

    @Override
    public Report modifier(Long id, Report objet) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Report getById(Long id) {
       return report.findById(id).orElse(null);
    }

    public List<Report> getPatientReports(Long id){
//    return report.findByPatient(id);
//       System.out.println(report.findByPatientId(id));
       return report.findByPatientId(id);
    }
}
