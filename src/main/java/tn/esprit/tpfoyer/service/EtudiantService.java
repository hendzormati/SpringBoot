package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.repository.EtudiantRepository;
import tn.esprit.tpfoyer.repository.UniversiteRepository;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantService implements IEtudiantService{
    @Autowired
    EtudiantRepository etudiantRepo;
    @Autowired
    UniversiteRepository uniRepo;
    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepo.findAll();
    }

    @Override
    public List<Etudiant> retrieveAllEtudiantsByUni(Long universiteID) {
        return etudiantRepo.findAllByUniversite(uniRepo.findById(universiteID).get());
    }

    @Override
    public List<Etudiant> retrieveAllEtudiantsByUniandDate(Long universiteID, Date date) {
        return etudiantRepo.findAllByUniversiteAndDateNaissance(uniRepo.findById(universiteID).get(),date);
    }

    @Override
    public Etudiant retrieveEtudiant(Long etudiantId) {
        return etudiantRepo.findById(etudiantId).get();
    }

    @Override
    public Etudiant addEtudiant(Etudiant c) {
        return etudiantRepo.save(c);
    }

    @Override
    public void removeEtudiant(Long etudiantId) {
        etudiantRepo.deleteById(etudiantId);
    }

    @Override
    public Etudiant modifyEtudiant(Etudiant etudiant) {
        return etudiantRepo.save(etudiant);
    }
}
