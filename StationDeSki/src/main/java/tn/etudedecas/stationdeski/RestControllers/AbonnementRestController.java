package tn.etudedecas.stationdeski.RestControllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.etudedecas.stationdeski.Entities.Abonnement;
import tn.etudedecas.stationdeski.Services.IAbonnementService;

import java.util.List;

@RestController
@AllArgsConstructor
public class AbonnementRestController {
    private IAbonnementService iAbonnementService;
    @PostMapping("/addAbonnement")
    public Abonnement addAbonnement(@RequestBody Abonnement abonnement) {
        return iAbonnementService.addAbonnement(abonnement);
    }
    @PutMapping("/updateAbonnement")
    public Abonnement updateAbonnement(@RequestBody Abonnement abonnement) {
        return iAbonnementService.updateAbonnement(abonnement);
    }
    @GetMapping("/retrieveAllAbonnements")
    public List<Abonnement> retrieveAllAbonnements(){
        return iAbonnementService.retrieveAllAbonnements();
    }
    @GetMapping("/retrieveAbonnement/{numAbon}")
    public Abonnement retrieveAbonnement(@PathVariable  long numAbon){
        return iAbonnementService.retrieveAbonnement(numAbon);
    }
    @DeleteMapping("/deleteAbonnement/{numAbon}")
    public void deleteAbonnement(@PathVariable long numAbon){
        iAbonnementService.deleteAbonnement(numAbon);
    }

}
