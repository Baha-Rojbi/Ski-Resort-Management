package tn.etudedecas.stationdeski.RestControllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.etudedecas.stationdeski.Entities.Cours;
import tn.etudedecas.stationdeski.Services.ICoursService;

import java.util.List;
@RestController
@AllArgsConstructor
public class CoursRestController {
    private ICoursService iCoursService;
    @PostMapping("/addCours")
    public Cours addCours(@RequestBody Cours cours){
        return iCoursService.addCours(cours);
    }
    @PutMapping("/updateCours")
    public Cours updateCours(@RequestBody Cours cours){
        return iCoursService.updateCours(cours);
    }
    @GetMapping("/retriveAllCourses")
    public List<Cours> retriveAllCourses(){
        return iCoursService.retriveAllCourses();
    }
    @GetMapping("/retrieveCours/{numCours}")
    public Cours retrieveCours(@PathVariable long numCours){
        return iCoursService.retrieveCours(numCours);
    }
    @DeleteMapping("/deleteCours/{numCours}")
    public void deleteCours(@PathVariable long numCours){
        iCoursService.deleteCours(numCours);
    }
}
