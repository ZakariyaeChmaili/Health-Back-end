/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backEndProject.Modele;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author hp
 */

@Data
@NoArgsConstructor
@Entity
public class Patient extends Personne{
    
    
    @Column(length=55)
    private String nompere;
    @Column(length=55)
    private String nommere;   
    private float poids;
    
   @OneToMany 
   @JoinColumn(name="id_patient")
   List<Report> listeRapport=new ArrayList();
   
   @OneToMany 
   @JoinColumn(name="id_patient")
   List<Vaccin> listeVaccin=new ArrayList();
   
}
