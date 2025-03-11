package tn.esprit.tpfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.entity.Universite;

import java.util.Date;
import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
     public List<Etudiant> findAllByUniversite(Universite uni);
     public List<Etudiant> findAllByUniversiteAndDateNaissance(Universite uni, Date date);
}

