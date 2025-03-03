package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.BlocRepository;
import tn.esprit.tpfoyer.repository.FoyerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerService implements IFoyerService{
    @Autowired
    FoyerRepository foyerRepo;
    @Autowired
    BlocRepository blocRepo;
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

    @Override
    public void affecterBlocaFoyer(Long idFoyer, Long idBloc) {
        Bloc bloc = blocRepo.findById(idBloc).get();
        Foyer foyer = foyerRepo.findById(idFoyer).get();
        foyer.getBlocs().add(bloc);
        bloc.setFoyer(foyer);
        foyerRepo.save(foyer);
        blocRepo.save(bloc);
    }

    @Override
    public void désaffecterBlocaFoyer(Long idFoyer, Long idBloc) {
        Bloc bloc = blocRepo.findById(idBloc).get();
        Foyer foyer = foyerRepo.findById(idFoyer).get();
        bloc.setFoyer(null);
        foyer.getBlocs().remove(bloc);
        foyerRepo.save(foyer);
        blocRepo.save(bloc);
    }
}
