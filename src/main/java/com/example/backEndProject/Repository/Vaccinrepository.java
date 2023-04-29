/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.backEndProject.Repository;

import com.example.backEndProject.Modele.Patient;
import com.example.backEndProject.Modele.Vaccin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 *
 * @author hp
 */
@Transactional

public interface Vaccinrepository extends JpaRepository<Vaccin, Long>{

    List<Vaccin> findByPatient(Patient p);
//    @Query("select v from Vaccin v where v.patient.id=:id")
//    List<Vaccin> getPatientVaccins(@Param("id") Long id);

    @Query("select v from Vaccin v where v.id=:id and v.type like %:type%")
    List<Vaccin> searchPatientVaccin(@Param("type") String type,@Param("id") long id);
}
