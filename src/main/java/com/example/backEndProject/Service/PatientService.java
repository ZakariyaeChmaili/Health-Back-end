/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backEndProject.Service;

import com.example.backEndProject.Modele.Patient;
import com.example.backEndProject.Repository.Patientrepository;
import java.util.List;
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
    public Patient modifier(Long id, Patient objet) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    }

   
    
}
