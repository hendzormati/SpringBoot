package tn.esprit.tpfoyer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.TypeChambre;
import tn.esprit.tpfoyer.repository.BlocRepository;
import tn.esprit.tpfoyer.repository.ChambreRepository;
import tn.esprit.tpfoyer.repository.ReservationRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class ChambreService  implements IChambreService {
    @Autowired
    ChambreRepository chambreRepo;
    @Autowired
    BlocRepository blocRepo;
    @Autowired
    ReservationRepository reservationRepo;

    @Override
    //@Scheduled(fixedRate = 60000)
    public List<Chambre> retrieveAllChambres() {
        List<Chambre> listC = chambreRepo.findAll();
        for (Chambre c: listC) log.info(c.toString());
        return listC;
    }

    @Override
    public List<Chambre> retrieveAllChambresbytype(TypeChambre type) {
        return chambreRepo.findAllByTypeC(type);
    }

    @Override
    public Chambre retrieveChambre(Long chambreId) {
        return chambreRepo.findById(chambreId).get();
    }

    @Override
    public Chambre retrieveChambreBynumero(Long num) {
        return chambreRepo.findByNumeroChambre(num);
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepo.save(c);
    }

    @Override
    public void removeChambre(Long chambreId) {
    chambreRepo.deleteById(chambreId);
    }

    @Override
    public Chambre modifyChambre(Chambre chambre) {
        return chambreRepo.save(chambre);
    }

    @Override
    //@Scheduled(fixedRate = 60000)
    public void listeChambresParBloc() {
        List<Bloc> blocs = blocRepo.findAll();
        for (Bloc b:blocs
             ) {
            log.info("Bloc => "+b.getNomBloc()+" ayant pour capacité "+b.getCapaciteBloc());
            List<Chambre> chambres = chambreRepo.findChambresByBloc(b);
           if(chambres.size() ==0)
               log.info("Pas De Chambres disponnible dans ce bloc");
           else
           {
               for (Chambre c:chambres
                    ) {
                   log.info("NumChambre: "+c.getNumeroChambre()+" type "+c.getTypeC());
                   log.info("*************");
               }
           }

        }
    }

    @Override
    //@Scheduled(fixedRate = 300000)
    public void pourcentageChambreParTypeChambre() {
        float tt=chambreRepo.findAll().size();
        log.info("\n Nombre total des chambres: "+tt);
        for (TypeChambre t:TypeChambre.values()
             ) {
          log.info("\n Le pourcentage des chambres pour le type "+t.toString()+" est egale à "+chambreRepo.findAllByTypeC(t).size()/tt*100 ) ;
        }
    }

    @Override
    @Scheduled(fixedRate = 300000)
    public void nombrePlacesDispoParchambreAnneeEnCours() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);

        Calendar startCal = Calendar.getInstance();
        startCal.set(year, Calendar.JANUARY, 1, 0, 0, 0);
        Date startDate = startCal.getTime();

        Calendar endCal = Calendar.getInstance();
        endCal.set(year, Calendar.DECEMBER, 31, 23, 59, 59);
        Date endDate = endCal.getTime();

        for (Chambre c : chambreRepo.findByReservationDateAndCurrentAcademicYear(startDate, endDate)) {
           int nbres = c.getReservations().size();

            // Get total capacity based on room type
            int totalCapacity;
            switch (c.getTypeC()) {
                case SIMPLE:
                    totalCapacity = 1;
                    break;
                case DOUBLE:
                    totalCapacity = 2;
                    break;
                case TRIPLE:
                    totalCapacity = 3;
                    break;
                default:
                    totalCapacity = 0;
            }

            // Calculate available places
            int placesDisponibles = totalCapacity - nbres;

            log.info("Chambre " + c.getNumeroChambre() +
                    " (Type: " + c.getTypeC() + "): " +
                    placesDisponibles + " places disponibles");
        }
    }
}
