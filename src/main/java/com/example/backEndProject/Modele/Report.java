/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backEndProject.Modele;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "Report")
@Getter
@Setter
@NoArgsConstructor
public class Report {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY) 
   private Long id;
   @Column(length=55)
   private String titre;
   @Column(length=55)
   private Date datecrea;
  
    
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor; 
   
   
   @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
   
   
   @OneToOne
    @JoinColumn(name = "traitement_id")
    private Traitement traitement;
}
