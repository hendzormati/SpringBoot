package tn.esprit.tpfoyer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.service.IFoyerService;

import java.util.List;
@Tag(name = "Gestion Foyer")
@RestController
@RequestMapping("/foyer")
@RequiredArgsConstructor
public class FoyerRestController {
    @Autowired
    IFoyerService foyerService;
    // http://localhost:8089/tpfoyer/foyer/retrieve-all-foyers
    @Operation(description = "Récupération des données des foyers")
    @GetMapping("/retrieve-all-foyers")
    public List<Foyer> getFoyers() {
        List<Foyer> listFoyers = foyerService.retrieveAllFoyers();
        return listFoyers;
    }
    // http://localhost:8089/tpfoyer/foyer/retrieve-foyer/8
    @GetMapping("/retrieve-foyer/{foyer-id}")
    public Foyer retrieveFoyer(@PathVariable("foyer-id") Long chId) {
        Foyer foyer = foyerService.retrieveFoyer(chId);
        return foyer;
    }
    // http://localhost:8089/tpfoyer/foyer/add-foyer
    @PostMapping("/add-foyer")
    public Foyer addFoyer(@RequestBody Foyer c) {
        Foyer foyer = foyerService.addFoyer(c);
        return foyer;
    }
    // http://localhost:8089/tpfoyer/foyer/remove-foyer/{foyer-id}
    @DeleteMapping("/remove-foyer/{foyer-id}")
    public void removeFoyer(@PathVariable("foyer-id") Long chId) {
        foyerService.removeFoyer(chId);
    }
    // http://localhost:8089/tpfoyer/foyer/modify-foyer
    @PutMapping("/modify-foyer")
    public Foyer modifyFoyer(@RequestBody Foyer c) {
        Foyer foyer = foyerService.modifyFoyer(c);
        return foyer;
    }
    @PutMapping("/affecter-foyer-a-bloc-/{foyer-id}/{bloc-id}")
    public void assignProjetToEquipe(@PathVariable("foyer-id") Long foyerId,
                                     @PathVariable("bloc-id") Long blocId) {
        foyerService.affecterBlocaFoyer(foyerId, blocId);
    }
    @PutMapping("/désaffecter-foyer-from-bloc-/{foyer-id}/{bloc-id}")
    public void desaffecterProjetFromEquipe(@PathVariable("foyer-id") Long foyerId,
                                            @PathVariable("bloc-id") Long blocId) {
        foyerService.désaffecterBlocaFoyer(foyerId, blocId);
    }

}
