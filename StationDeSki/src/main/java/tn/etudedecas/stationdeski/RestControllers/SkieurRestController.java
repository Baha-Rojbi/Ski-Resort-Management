package tn.etudedecas.stationdeski.RestControllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.etudedecas.stationdeski.Entities.Skieur;
import tn.etudedecas.stationdeski.Entities.TypeAbonnement;
import tn.etudedecas.stationdeski.Services.ISkieurService;

import java.util.List;
@RestController
@AllArgsConstructor
public class SkieurRestController {
    private ISkieurService iSkieurService;
@PostMapping("/addSkieur")
    public Skieur addSkieur(@RequestBody Skieur skieur) {
        return iSkieurService.addSkieur(skieur);
    }
@PutMapping("/updateSkieur")
    public Skieur updateSkieur(@RequestBody Skieur skieur) {
        return iSkieurService.updateSkieur(skieur);
    }
    @GetMapping("/retrieveAllSkieurs")
    public List<Skieur> retrieveAllSkieurs() {
        return iSkieurService.retrieveAllSkieurs();
    }
    @GetMapping("/retrieveSkieur/{numSkieur}")
    public Skieur retrieveSkieur(@PathVariable long numSkieur) {
        return iSkieurService.retrieveSkieur(numSkieur);
    }
    @DeleteMapping("/deleteSkieur/{numSkieur}")
    public void deleteSkieur(@PathVariable long numSkieur) {
        iSkieurService.deleteSkieur(numSkieur);
    }
    @PostMapping("AssignSkieurToPiste/{numSkieur}/{numPiste}")
    public Skieur AssignSkieurToPiste(@PathVariable Long numSkieur,@PathVariable Long numPiste){
    return iSkieurService.AssignSkieurToPiste(numSkieur,numPiste);
    }
    @PostMapping("addSkierAndAssignToCourse/{numCourse}")
    public Skieur addSkierAndAssignToCourse(@RequestBody Skieur skieur,@PathVariable Long numCourse){
    return iSkieurService.addSkierAndAssignToCourse(skieur,numCourse);
    }
    ///retrieve skieur par type d abonnement
    @GetMapping("retrieveSkiersBySubscriptionType/{typeAbonnement}")
    public List<Skieur> retrieveSkiersBySubscriptionType(@PathVariable TypeAbonnement typeAbonnement){
    return iSkieurService.retrieveSkiersBySubscriptionType(typeAbonnement);
    }
    @PostMapping("addSkieurAndAbonnement")
    public Skieur addSkieurAndAbonnement(@RequestBody Skieur skieur){
    return iSkieurService.addSkieurAndAbonnement(skieur);
    }
}
