/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backEndProject.Modele;

import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author hp
 */
@Data
@Entity
public class Session {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
     private Long id; 
     private String code;
     @Column(length=55)   
     private Long idpatient;
}
