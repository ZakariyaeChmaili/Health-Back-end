/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backEndProject.Repository;

import com.example.backEndProject.Modele.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 *
 * @author hp
 */
public interface Personnerepository extends JpaRepository<Personne, Long> {
        Personne findPersonneByCni(String cni);
        @Query("select cni,password,role from Personne where cni=:cni")
        Optional<Personne> findPersonneByCni2(@Param("cni") String cni);
}


