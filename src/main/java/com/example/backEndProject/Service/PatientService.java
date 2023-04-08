/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backEndProject.Service;

import com.example.backEndProject.Modele.Patient;
import com.example.backEndProject.Modele.Report;
import com.example.backEndProject.Repository.Patientrepository;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
@AllArgsConstructor
public class PatientService implements ServiceInterface<Patient> {
    private final Patientrepository patientrepo;

    @Override
    public Patient creer(Patient patient) {
     return patientrepo.save(patient);
    }

    @Override
    public List<Patient> lire() {
     return patientrepo.findAll();
    }

    @Override
    public Patient modifier(Long id, Patient pas) {
        return patientrepo.findById(id)
             .map(p->{
    p.setNommere(pas.getNommere());
    p.setNompere(pas.getNompere());
    p.setPoids(pas.getPoids());
     return patientrepo.save(p);
     }).orElseThrow(()->new RuntimeException("doctor non trouver"));
    
    }

    @Override
    public Patient getById(Long id) {
     return patientrepo.findById(id).orElse(null);

    }
 
   
    
}
