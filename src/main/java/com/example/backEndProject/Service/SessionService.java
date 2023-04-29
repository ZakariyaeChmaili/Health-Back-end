/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backEndProject.Service;

import com.example.backEndProject.Modele.Session;
import com.example.backEndProject.Repository.Sessionrepository;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
@AllArgsConstructor
public class SessionService implements ServiceInterface<Session>{
   private Sessionrepository repo;
    @Override
    public Session creer(Session se) {
    return repo.save(se);
    }
 
    
    
    public ResponseEntity<Map<String,String>> delete(Long id){
    repo.deleteById(id);
    return ResponseEntity.ok(Map.of("msg","Session destroy"));
    }
    
    @Override
    public List<Session> lire() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Session modifier(Long id, Session objet) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Session getById(Long id) {
        return null;

    }
    
      public Session getByPatientId(Long id) {
        return repo.findSessionByIdpatient(id);

    }
      
      public Session getByCode(String code){
          return repo.findSessionByCode(code);
      }
    
    
    
}
