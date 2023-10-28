package tn.etudedecas.stationdeski.RestControllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.etudedecas.stationdeski.Entities.Piste;
import tn.etudedecas.stationdeski.Services.IPisteService;

import java.util.List;
@RestController
@AllArgsConstructor
public class PisteRestController {
    private IPisteService iPisteService;
@PostMapping("/addPiste")
    public Piste addPiste(@RequestBody Piste piste) {
        return iPisteService.addPiste(piste);
    }
@PutMapping("/updatePiste")

    public Piste updatePiste(@RequestBody Piste piste) {
        return iPisteService.updatePiste(piste);
    }
@GetMapping("/retrieveAllPistes")
    public List<Piste> retrieveAllPistes() {
        return iPisteService.retrieveAllPistes();
    }
@GetMapping("/retrievePiste/{numPiste}")
    public Piste retrievePiste(@PathVariable long numPiste) {
        return iPisteService.retrievePiste(numPiste);
    }
@DeleteMapping("/deletePiste/{numPiste}")
    public void deletePiste(@PathVariable long numPiste) {
        iPisteService.deletePiste(numPiste);
    }
}
