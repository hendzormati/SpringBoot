package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.TypeChambre;

import java.util.List;

public interface IChambreService {
    public List<Chambre> retrieveAllChambres();
    public List<Chambre> retrieveAllChambresbytype(TypeChambre type);
    public Chambre retrieveChambre(Long chambreId);
    public Chambre retrieveChambreBynumero(Long num);
    public Chambre addChambre(Chambre c);
    public void removeChambre(Long chambreId);
    public Chambre modifyChambre(Chambre chambre);
    public void listeChambresParBloc();
    public void pourcentageChambreParTypeChambre();
    public void nombrePlacesDispoParchambreAnneeEnCours();
}
