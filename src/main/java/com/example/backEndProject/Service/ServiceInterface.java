/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.backEndProject.Service;

import java.util.List;

/**
 *
 * @author hp
 */
public interface ServiceInterface<S> {
    S creer(S object);
     List<S>lire();
     S modifier(Long id,S objet);
     String supprimer(Long id);
}
