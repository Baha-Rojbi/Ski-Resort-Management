package tn.etudedecas.stationdeski.RestControllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.etudedecas.stationdeski.Entities.Moniteur;
import tn.etudedecas.stationdeski.Entities.Support;
import tn.etudedecas.stationdeski.Services.IMoniteurService;

import java.util.List;
@RestController
@AllArgsConstructor

public class MoniteurRestController {
    private IMoniteurService iMoniteurService;
@PostMapping("/addMoniteur")
    public Moniteur addMoniteur(@RequestBody Moniteur moniteur) {
       return iMoniteurService.addMoniteur(moniteur);
    }
@PutMapping("/updateMoniteur")
    public Moniteur updateMoniteur(@RequestBody Moniteur moniteur) {
        return iMoniteurService.updateMoniteur(moniteur);
    }
@GetMapping("/retrieveAllMoniteurs")
    public List<Moniteur> retrieveAllMoniteurs() {
        return iMoniteurService.retrieveAllMoniteurs();
    }
    @GetMapping("/retrieveMoniteur/{numMoniteur}")
    public Moniteur retrieveMoniteur(@PathVariable long numMoniteur) {
        return iMoniteurService.retrieveMoniteur(numMoniteur);
    }
    @DeleteMapping("/deleteMoniteur/{numMoniteur}")
    public void deleteMoniteur(@PathVariable long numMoniteur) {
        iMoniteurService.deleteMoniteur(numMoniteur);
    }
    @PostMapping("/addMoniteurAndAssignToCours/{numCours}")
    public Moniteur addMoniteurAndAssignToCours(@RequestBody Moniteur moniteur,@PathVariable Long numCours){
    return iMoniteurService.addMoniteurAndAssignToCours(moniteur,numCours);
    }
    @GetMapping("/numWeeksCoursOfMoniteurBySupport/{numMoniteur}/{support}")
    public List<Integer> numWeeksCoursOfMoniteurBySupport(@PathVariable Long numMoniteur,@PathVariable Support support){
    return iMoniteurService.numWeeksCoursOfMoniteurBySupport(numMoniteur,support);
    }
}
