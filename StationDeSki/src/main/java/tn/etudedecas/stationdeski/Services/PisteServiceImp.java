package tn.etudedecas.stationdeski.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.etudedecas.stationdeski.Entities.Piste;
import tn.etudedecas.stationdeski.Entities.Skieur;
import tn.etudedecas.stationdeski.Respositories.PisteRepositories;
import tn.etudedecas.stationdeski.Respositories.SkieurRepositories;

import java.util.List;
@Service
@AllArgsConstructor
public class PisteServiceImp implements IPisteService{
    public PisteRepositories pisteRepositories;
    public SkieurRepositories skieurRepositories;

    @Override
    public Piste addPiste(Piste piste) {
        return pisteRepositories.save(piste);
    }

    @Override
    public Piste updatePiste(Piste piste) {
        return pisteRepositories.save(piste);
    }

    @Override
    public List<Piste> retrieveAllPistes() {
        return pisteRepositories.findAll();
    }

    @Override
    public Piste retrievePiste(long numPiste) {
        return pisteRepositories.findById(numPiste).orElse(null);
    }

    @Override
    public void deletePiste(long numPiste) {
        pisteRepositories.deleteById(numPiste);
    }

    @Override
    public Piste AssignPisteToSkieur(Long numSkieur, Long numPiste) {
        Piste piste=pisteRepositories.findById(numPiste).orElse(null);
        Skieur skieur=skieurRepositories.findById(numSkieur).orElse(null);
        piste.getSkieurs().add(skieur);
       return pisteRepositories.save(piste);

    }
}
