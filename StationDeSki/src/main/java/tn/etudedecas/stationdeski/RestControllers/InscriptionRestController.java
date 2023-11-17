package tn.etudedecas.stationdeski.RestControllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.etudedecas.stationdeski.Entities.Inscription;
import tn.etudedecas.stationdeski.Services.IInscriptionService;

import java.util.List;
@RestController
@AllArgsConstructor
public class InscriptionRestController {
    private IInscriptionService iInscriptionService;
    @PostMapping("/addInscription")
    public Inscription addInscription(@RequestBody Inscription inscription){
        return iInscriptionService.addInscription(inscription);
    }
    @PutMapping("/updateInscription")
    public Inscription updateInscription(@RequestBody Inscription inscription){
        return iInscriptionService.updateInscription(inscription);
    }
    @GetMapping("/retrieveAllInscriptions")
    public List<Inscription> retrieveAllInscriptions(){
        return iInscriptionService.retrieveAllInscriptions();
    }
    @GetMapping("/retrieveInscription/{numInscription}")
    public Inscription retrieveInscription(@PathVariable long numInscription){
        return iInscriptionService.retrieveInscription(numInscription);
    }
    @DeleteMapping("/deleteInscription/{numInscription}")
    public void deleteInscription(@PathVariable long numInscription){
        iInscriptionService.deleteInscription(numInscription);
    }
    @PostMapping("addInscriptionAndAssignToSkieur/{numSkieur}")
    public Inscription addInscriptionAndAssignToSkieur(@RequestBody Inscription inscription,@PathVariable Long numSkieur){
       return iInscriptionService.addInscriptionAndAssignToSkieur(inscription,numSkieur);
    }
}
