/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backEndProject.Modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "Traitement")
@Getter
@Setter
@NoArgsConstructor
public class Traitement {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
   private Long id;
   @Column(length=55)
   private String nomtraimenet;
   @Column(length=200)
   private String observation;
   
    @OneToOne(mappedBy = "traitement")
    private Report report;
}
