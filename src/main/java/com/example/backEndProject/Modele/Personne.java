/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backEndProject.Modele;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
    private Long id_perso;
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
    private String nasionality;
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
    public Collection<? extends GrantedAuthority > getAuthorities() {
     
        Collection<GrantedAuthority> roles = new ArrayList();
        roles.add(new SimpleGrantedAuthority("patient"));
        return roles;

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
