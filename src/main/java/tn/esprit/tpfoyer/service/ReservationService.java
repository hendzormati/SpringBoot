package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.repository.ReservationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService implements IReservationService{
    @Autowired
    ReservationRepository reservationRepo;
    @Override
    public List<Reservation> retrieveAllReservations() {
        return reservationRepo.findAll();
    }
    @Override
    public Reservation retrieveReservation(String reservationId) {
        return reservationRepo.findById(reservationId).get();
    }

    @Override
    public Reservation addReservation(Reservation c) {
        return reservationRepo.save(c);
    }

    @Override
    public void removeReservation(String reservationId) {
        reservationRepo.deleteById(reservationId);
    }

    @Override
    public Reservation modifyReservation(Reservation reservation) {
        return reservationRepo.save(reservation);
    }
}
