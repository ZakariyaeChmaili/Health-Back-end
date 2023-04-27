/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backEndProject.Service;

import com.example.backEndProject.Modele.Personne;
import com.example.backEndProject.Repository.Personnerepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 *
 * @author hp
 */
@Service
//@AllArgsConstructor
public class PersonService implements ServiceInterface<Personne>,UserDetailsService{

 private final Personnerepository perso;

    public PersonService(Personnerepository perso) {
        this.perso = perso;
    }

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
     p.setCni(per.getCni());
     p.setDatenaiss(per.getDatenaiss());
     p.setVille(per.getVille());
     p.setNationality(per.getNationality());
     p.setSexe(per.getSexe());
     p.setSutuaFamil(per.getSutuaFamil());
     p.setAddresse(per.getAddresse());
     
     return perso.save(p);
     }).orElseThrow(()->new RuntimeException("Produit non trouver"));
    }

    @Override
    public Personne getById(Long id) {
        System.out.println(id);
        System.out.println(perso.findById(id).orElse(null));
        return perso.findById(id).orElse(null);

    }

    @Override
    public Personne loadUserByUsername(String cni) throws UsernameNotFoundException {
        Personne p= this.perso.findPersonneByCni(cni);
        System.out.println(cni);
        System.out.println("start printing person from service");
        System.out.println(p);
        return this.perso.findPersonneByCni(cni);
    }

    public Optional<Personne> findPersonneByCni(String cni){
        return perso.findPersonneByCni2(cni);
    }


}
