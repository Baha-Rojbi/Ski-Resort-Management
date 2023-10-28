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
    public Abonnement addAbonnement(@RequestBody Abonnement E) {
        return iAbonnementService.addAbonnement(E);
    }
    @PutMapping("/updateAbonnement")
    public Abonnement updateAbonnement(@RequestBody Abonnement E) {
        return iAbonnementService.updateAbonnement(E);
    }
    @GetMapping("/showAbonnement")
    public List<Abonnement> getAllAbonnement(){
        return iAbonnementService.getAllAbonnement();
    }
    @GetMapping("/showAbById/{idE}")
    public Abonnement getAbonnementById(@PathVariable  long idE){
        return iAbonnementService.getAbonnementById(idE);
    }
    @DeleteMapping("/deleteAbonnement/{idE}")
    public void deleteAbonnement(@PathVariable long idE){
        iAbonnementService.deleteAbonnement(idE);
    }

}
