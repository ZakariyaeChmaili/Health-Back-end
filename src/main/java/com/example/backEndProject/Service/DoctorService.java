/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backEndProject.Service;

import com.example.backEndProject.Modele.Doctor;
import com.example.backEndProject.Repository.Doctorrepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
@AllArgsConstructor
public class DoctorService implements ServiceInterface<Doctor> {
    private Doctorrepository docrepo;
    @Override
    public Doctor creer(Doctor doc) {
        return docrepo.save(doc);
    }

    @Override
    public List<Doctor> lire() {
       return docrepo.findAll();
    }

    @Override
    public Doctor modifier(Long id, Doctor doc) {
        return docrepo.findById(id)
             .map(d->{
     d.setSpecialite(doc.getSpecialite());
   
     
     return docrepo.save(d);
     }).orElseThrow(()->new RuntimeException("doctor non trouver"));
    }

    @Override
    public Doctor getById(Long id) {
    return docrepo.findById(id).orElse(null);

    }
    
}
