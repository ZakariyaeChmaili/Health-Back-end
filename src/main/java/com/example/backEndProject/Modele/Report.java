/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backEndProject.Modele;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Repo;
    @Column(length = 55)
    private String titre;
    @Column(length = 55)
    private Date datecrea;
    @Column(length = 7)
    private String heartBeat;
    @Column(length = 7)
    private String bloodSugar;
    @Column(length = 7)
    private String bloodPressure;
    @Column(length = 7)
    private String temperature;
    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    private Patient patient;
    @OneToMany(mappedBy = "report")
    private List<Traitement> listeTraitement = new ArrayList<>();

    @JsonIgnore
    public Doctor getDoctor() {
        return doctor;
    }

    @JsonIgnore
    public Patient getPatient() {
        return patient;
    }
}
