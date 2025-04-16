package tn.esprit.tpfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.entity.TypeChambre;

import java.util.Date;
import java.util.List;

public interface ChambreRepository  extends JpaRepository<Chambre,Long> {
    public List<Chambre> findAllByTypeC(TypeChambre type);
    public Chambre findByNumeroChambre(Long num);
    public List<Chambre> findChambresByBloc(Bloc b);
    public List<Chambre> findChambresByTypeC(TypeChambre t);
    // In your ChambreRepository interface
    @Query("SELECT c FROM Chambre c JOIN c.reservations r WHERE r.anneeUniversitaire BETWEEN :startDate AND :endDate")
    public List<Chambre> findByReservationDateAndCurrentAcademicYear(
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate);
}
