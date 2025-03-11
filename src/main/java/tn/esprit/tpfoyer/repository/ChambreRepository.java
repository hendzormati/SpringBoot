package tn.esprit.tpfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.TypeChambre;

import java.util.List;

public interface ChambreRepository  extends JpaRepository<Chambre,Long> {
    public List<Chambre> findAllByTypeC(TypeChambre type);
    public Chambre findByNumeroChambre(Long num);
}
