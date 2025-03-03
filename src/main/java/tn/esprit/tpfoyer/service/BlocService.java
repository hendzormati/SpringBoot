package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.repository.BlocRepository;
import tn.esprit.tpfoyer.repository.FoyerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocService implements IBlocService{
    @Autowired
    BlocRepository blocRepo;
    @Autowired
    FoyerRepository foyerRepo;
    @Override
    public List<Bloc> retrieveAllBlocs() {
        return blocRepo.findAll();
    }
    @Override
    public Bloc retrieveBloc(Long blocId) {
        return blocRepo.findById(blocId).get();
    }

    @Override
    public Bloc addBloc(Bloc c) {
        return blocRepo.save(c);
    }

    @Override
    public void removeBloc(Long blocId) {
        blocRepo.deleteById(blocId);
    }

    @Override
    public Bloc modifyBloc(Bloc bloc) {
        return blocRepo.save(bloc);
    }

    @Override
    public Bloc addBlocandFoyer(Bloc bloc) {
        foyerRepo.save(bloc.getFoyer());
        return blocRepo.save(bloc);
    }
}
