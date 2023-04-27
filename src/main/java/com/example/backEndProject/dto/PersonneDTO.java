package com.example.backEndProject.dto;

import com.example.backEndProject.Modele.Personne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PersonneDTO {
    private Long id;
    private String cni;
    private String nom;
    private String prenom;
    private Date datenaiss;
    private String ville;
    private String nationality;
    private String tel;
    private String sexe;
    private String sutuaFamil;
    private String addresse;
    private String role;

    public PersonneDTO(Personne personne) {
        this.id = personne.getId();
        this.cni = personne.getCni();
        this.nom = personne.getNom();
        this.prenom = personne.getPrenom();
        this.datenaiss = personne.getDatenaiss();
        this.ville = personne.getVille();
        this.nationality = personne.getNationality();
        this.tel = personne.getTel();
        this.sexe = personne.getSexe();
        this.sutuaFamil = personne.getSutuaFamil();
        this.addresse = personne.getAddresse();
        this.role = personne.getRole();
    }
}