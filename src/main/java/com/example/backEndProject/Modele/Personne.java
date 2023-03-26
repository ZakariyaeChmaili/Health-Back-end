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
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author hp
 */
@Entity
@Table(name="Personne")
@Getter
@Setter
@NoArgsConstructor
public class Personne {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(length=70)
    private String cne;
    @Column(length=70)
    private String nom;
    @Column(length=70)
    private String prenom;
    @Column(length=25)
    private String datenaiss;
    @Column(length=55)
    private String ville;
    @Column(length=55)
    private String nasionality;
    @Column(length=7)
    private String sexe;
    @Column(length=25)
    private String sutuaFamil;
    @Column(length=75)
    private String addresse;
    @Column(length=100)
    private String passwrd;
    @Column(length=25)
    @Value("patient")
    private String role;


    
}