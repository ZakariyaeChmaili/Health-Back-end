/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backEndProject.Modele;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author hp
 */

@Data
@NoArgsConstructor
@Entity
public class Doctor  {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id_doc;
    
    @Column(length=55)
    private String specialite;
    
   @OneToMany 
   @JoinColumn(name="id_doc")
   List<Report> listeRapport=new ArrayList();
   
   @OneToMany 
   @JoinColumn(name="id_doc")
   List<Vaccin> listeVaccin=new ArrayList(); 
   
   
   @OneToOne
@JoinColumn(name="id_perso")
private Doctor doctor;
}
