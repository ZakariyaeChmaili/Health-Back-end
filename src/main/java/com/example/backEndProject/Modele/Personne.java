/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backEndProject.Modele;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author hp
 */
@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 70)
    private String cni;
    @Column(length = 70)
    private String nom;
    @Column(length = 70)
    private String prenom;
    @Column(length = 25)
    private Date datenaiss;
    @Column(length = 55)
    private String ville;
    @Column(length = 55)
    private String nationality;
    @Column(length = 55)
    private String tel;
    @Column(length = 7)
    private String sexe;
    @Column(length = 25)
    private String sutuaFamil;
    @Column(length = 75)
    private String addresse;
    @Column(length = 100)
    private String password;
    @Column(length = 25)
    @Value("patient")
    private String role;



    @Override
    public String toString() {
        return "Personne{" +
                "id=" + id +
                ", cni='" + cni + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "doctor_person", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "doctor_id"))
//    private List<Doctor> doctors = new ArrayList<>();

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "patient_person", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "patient_id"))
//    private List<Patient> patients = new ArrayList<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("patient"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return cni;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
