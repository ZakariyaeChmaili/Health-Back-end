/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.backEndProject.Repository;

import com.example.backEndProject.Modele.Patient;
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


    List<Report> findByPatient(Patient p);
//    List<Report> findByTitreContainingAndId_Repo(String titre, Long id);
    @Query("select r from Report r where r.patient.id=:id and r.titre like %:titre%")
List<Report> searchReportPatient(@Param("id") Long patientId,@Param("titre") String titre);


//    @Query("SELECT r FROM Report r JOIN r.patient p JOIN p.person WHERE p.id = :patientId")
//    List<Report> findByPatientId(@Param("patientId") Long patientId);
}
