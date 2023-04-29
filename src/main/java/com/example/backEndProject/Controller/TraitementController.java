/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backEndProject.Controller;

import com.example.backEndProject.Modele.Report;
import com.example.backEndProject.Modele.Traitement;
import com.example.backEndProject.Service.TraitementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author hp
 */
@RestController
@RequestMapping("/traitements")
@AllArgsConstructor
public class TraitementController {
       private final TraitementService serv;
        @PostMapping("/create")
    public Traitement create(
//            @RequestBody Traitement trait
                @RequestParam("id") Long id
//                @RequestParam("nomtraimenet") String nomtraimenet,
//                @RequestParam("observation") String observation,
//                @RequestParam("period") String period,
//                @RequestParam("dose") String dose,
//                @RequestParam("report") String report
        ){
            System.out.println(id);
//            System.out.println(nomtraimenet);
//            System.out.println(observation);
//            System.out.println(period);
//            System.out.println(dose);
//            System.out.println(report);
//            System.out.println(trait);
//            return serv.creer(trait);
            return null;
    }
       
}
