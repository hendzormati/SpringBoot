package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Foyer;

import java.util.List;

public interface IFoyerService {
    public List<Foyer> retrieveAllFoyers();
    public Foyer retrieveFoyer(Long foyerId);
    public Foyer addFoyer(Foyer c);
    public void removeFoyer(Long foyerId);
    public Foyer modifyFoyer(Foyer foyer);
    public  void affecterBlocaFoyer(Long idFoyer,Long idBloc);
    public  void désaffecterBlocaFoyer(Long idFoyer,Long idBloc);
}
