package tn.esprit.tpfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entity.Reservation;

import java.util.List;

public interface ReservationRepository  extends JpaRepository<Reservation,String> {
}
