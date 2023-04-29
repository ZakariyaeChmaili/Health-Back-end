/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backEndProject.Modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Vaccin {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;  
   @Column(length=75)
    private String type;
    @Column(length=200)
    private String observation;
    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    private Patient patient;

}
