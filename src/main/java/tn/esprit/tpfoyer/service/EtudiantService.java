package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.repository.EtudiantRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantService implements IEtudiantService{
    @Autowired
    EtudiantRepository etudiantRepo;
    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepo.findAll();
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
