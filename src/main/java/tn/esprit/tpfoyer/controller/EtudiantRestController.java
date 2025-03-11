package tn.esprit.tpfoyer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.entity.TypeChambre;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.service.IEtudiantService;

import java.util.Date;
import java.util.List;
@Tag(name = "Gestion Etudiant")
@RestController
@RequestMapping("/etudiant")
@RequiredArgsConstructor
public class EtudiantRestController {
    @Autowired
    IEtudiantService etudiantService;
    // http://localhost:8089/tpfoyer/etudiant/retrieve-all-etudiants
    @Operation(description = "Récupération des données des etudiants")
    @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> getEtudiants() {
        List<Etudiant> listEtudiants = etudiantService.retrieveAllEtudiants();
        return listEtudiants;
    }
    @GetMapping("/retrieve-all-etudiants-by-uni")
    public List<Etudiant> getEtudiantsbyuni(@RequestParam Long uni_ID) {
        List<Etudiant> listEtudiants = etudiantService.retrieveAllEtudiantsByUni(uni_ID);
        return listEtudiants;
    }
    @GetMapping("/retrieve-all-etudiants-by-uni-and-date")
    public List<Etudiant> getEtudiantsbyunianddate(@RequestParam Long uni_ID, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date date) {
        List<Etudiant> listEtudiants = etudiantService.retrieveAllEtudiantsByUniandDate(uni_ID,date);
        return listEtudiants;
    }
    // http://localhost:8089/tpfoyer/etudiant/retrieve-etudiant/8
    @GetMapping("/retrieve-etudiant/{etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Long chId) {
        Etudiant etudiant = etudiantService.retrieveEtudiant(chId);
        return etudiant;
    }
    // http://localhost:8089/tpfoyer/etudiant/add-etudiant
    @PostMapping("/add-etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant c) {
        Etudiant etudiant = etudiantService.addEtudiant(c);
        return etudiant;
    }
    // http://localhost:8089/tpfoyer/etudiant/remove-etudiant/{etudiant-id}
    @DeleteMapping("/remove-etudiant/{etudiant-id}")
    public void removeEtudiant(@PathVariable("etudiant-id") Long chId) {
        etudiantService.removeEtudiant(chId);
    }
    // http://localhost:8089/tpfoyer/etudiant/modify-etudiant
    @PutMapping("/modify-etudiant")
    public Etudiant modifyEtudiant(@RequestBody Etudiant c) {
        Etudiant etudiant = etudiantService.modifyEtudiant(c);
        return etudiant;
    }


}
