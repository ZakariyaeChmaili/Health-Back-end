/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backEndProject.Modele;

import javax.persistence.*;

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
public class Traitement {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
   private Long id;
   @Column(length=55)
   private String nomtraimenet;
   @Column(length=200)
   private String observation;
   @Column(length=40)
   private String period;
   @Column(length=40)
   private String dose;
   @ManyToOne
   private Report report;
   
   
}
