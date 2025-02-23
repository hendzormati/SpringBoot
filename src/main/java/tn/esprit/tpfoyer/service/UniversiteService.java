package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.repository.UniversiteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteService implements IUniversiteService{
    @Autowired
    UniversiteRepository universiteRepo;
    @Override
    public List<Universite> retrieveAllUniversites() {
        return universiteRepo.findAll();
    }
    @Override
    public Universite retrieveUniversite(Long universiteId) {
        return universiteRepo.findById(universiteId).get();
    }

    @Override
    public Universite addUniversite(Universite c) {
        return universiteRepo.save(c);
    }

    @Override
    public void removeUniversite(Long universiteId) {
        universiteRepo.deleteById(universiteId);
    }

    @Override
    public Universite modifyUniversite(Universite universite) {
        return universiteRepo.save(universite);
    }
}
