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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "Patient")
@Getter
@Setter
@NoArgsConstructor
public class Patient extends Personne{
    @Column(length=55)
    private String nompere;
    @Column(length=55)
    private String nommere;   
    private float poids;
    
    @OneToMany(mappedBy = "Report", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Report> repports = new ArrayList<>();
    
      @OneToMany(mappedBy = "Vaccin", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vaccin> vaccins = new ArrayList<>();
}
