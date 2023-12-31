package tn.etudedecas.stationdeski.RestControllers;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.etudedecas.stationdeski.Entities.Abonnement;
import tn.etudedecas.stationdeski.Entities.TypeAbonnement;
import tn.etudedecas.stationdeski.Services.IAbonnementService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
    //Recuperer la liste des abonnement selon un type d abonnement trié en fct de date debut
    @GetMapping("/getAbonnementByType/{typeAbonnement}")
    public Set<Abonnement> getAbonnementByType(@PathVariable TypeAbonnement typeAbonnement){
        return iAbonnementService.getAbonnementByType(typeAbonnement);
    }
    ////////Afficher les abonnements qui ont ete crées entre deux dates données
    @GetMapping("retrieveAbonnementByDates/{dateDebut}/{dateFin}")
    public List<Abonnement> retrieveAbonnementByDates(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")Date dateFin){
        return iAbonnementService.retrieveAbonnementByDates(dateDebut,dateFin);
    }
}
