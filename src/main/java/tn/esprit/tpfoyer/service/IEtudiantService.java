package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.entity.Universite;

import java.util.Date;
import java.util.List;

public interface IEtudiantService {
    public List<Etudiant> retrieveAllEtudiants();
    public List<Etudiant> retrieveAllEtudiantsByUni(Long universiteID);
    public List<Etudiant> retrieveAllEtudiantsByUniandDate(Long universiteID, Date date);
    public Etudiant retrieveEtudiant(Long etudiantId);
    public Etudiant addEtudiant(Etudiant c);
    public void removeEtudiant(Long etudiantId);
    public Etudiant modifyEtudiant(Etudiant etudiant);
}
