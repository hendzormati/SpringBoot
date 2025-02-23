package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.FoyerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerService implements IFoyerService{
    @Autowired
    FoyerRepository foyerRepo;
    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerRepo.findAll();
    }
    @Override
    public Foyer retrieveFoyer(Long foyerId) {
        return foyerRepo.findById(foyerId).get();
    }

    @Override
    public Foyer addFoyer(Foyer c) {
        return foyerRepo.save(c);
    }

    @Override
    public void removeFoyer(Long foyerId) {
        foyerRepo.deleteById(foyerId);
    }

    @Override
    public Foyer modifyFoyer(Foyer foyer) {
        return foyerRepo.save(foyer);
    }
}
