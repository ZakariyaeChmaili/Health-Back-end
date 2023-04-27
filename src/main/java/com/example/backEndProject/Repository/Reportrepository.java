/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.backEndProject.Repository;

import com.example.backEndProject.Modele.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 *
 * @author hp
 */

public interface Reportrepository extends JpaRepository<Report, Long>{


    List<Report> findByPatient( long id);
//    @Query("select r from Report r where r.patient.personne.id=:id")
@Query("SELECT r FROM Report r WHERE r.patient.id = :patientId")
List<Report> findByPatientId(@Param("patientId") Long patientId);


//    @Query("SELECT r FROM Report r JOIN r.patient p JOIN p.person WHERE p.id = :patientId")
//    List<Report> findByPatientId(@Param("patientId") Long patientId);
}
