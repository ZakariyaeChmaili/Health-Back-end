/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backEndProject.Service;

import com.example.backEndProject.Modele.Personne;
import com.example.backEndProject.Repository.Personnerepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
@AllArgsConstructor
public class PersonService implements ServiceInterface<Personne>{
 private final Personnerepository perso;
    @Override
    public Personne creer(Personne per) {
      return perso.save(per);
    }

    @Override
    public List<Personne> lire() {
       return perso.findAll();
    }

    @Override
    public Personne modifier(Long id,Personne per) {
        return perso.findById(id)
             .map(p->{
     p.setNom(per.getNom());
     p.setPrenom(per.getPrenom());
     p.setCne(per.getCne());
     p.setDatenaiss(per.getDatenaiss());
     p.setVille(per.getVille());
     p.setNasionality(per.getNasionality());
     p.setSexe(per.getSexe());
     p.setSutuaFamil(per.getSutuaFamil());
     p.setAddresse(per.getAddresse());
     
     return perso.save(p);
     }).orElseThrow(()->new RuntimeException("Produit non trouver"));
    }

   
}
