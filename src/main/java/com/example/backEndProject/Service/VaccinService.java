/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backEndProject.Service;

import com.example.backEndProject.Modele.Patient;
import com.example.backEndProject.Modele.Vaccin;
import com.example.backEndProject.Repository.Vaccinrepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
@AllArgsConstructor
public class VaccinService implements ServiceInterface<Vaccin>{
 private Vaccinrepository vaccinrepo;

    @Override
    public Vaccin creer(Vaccin vac) {
       System.out.println(vac);
       return vaccinrepo.save(vac);
    }

    @Override
    public List<Vaccin> lire() {
       return vaccinrepo.findAll();}

    @Override
    public Vaccin modifier(Long id, Vaccin objet) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Vaccin getById(Long id) {
       return vaccinrepo.findById(id).orElse(null);
    }

    public List<Vaccin> getPatientVaccins(Long id){
       Patient p = new Patient();
       p.setId(id);
    return vaccinrepo.findByPatient(p);
    }

    public List<Vaccin> searchVaccin(String kword,long id){
       return vaccinrepo.searchPatientVaccin(kword,id);
    }
    
}
