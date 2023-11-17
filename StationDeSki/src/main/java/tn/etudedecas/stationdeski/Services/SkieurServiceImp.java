package tn.etudedecas.stationdeski.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.etudedecas.stationdeski.Entities.Piste;
import tn.etudedecas.stationdeski.Entities.Skieur;
import tn.etudedecas.stationdeski.Respositories.PisteRepositories;
import tn.etudedecas.stationdeski.Respositories.SkieurRepositories;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor

public class SkieurServiceImp implements ISkieurService{
    public SkieurRepositories skieurRepositories;
    public PisteRepositories pisteRepositories;

    @Override
    public Skieur addSkieur(Skieur skieur) {
        return skieurRepositories.save(skieur);
    }

    @Override
    public Skieur updateSkieur(Skieur skieur) {
        return skieurRepositories.save(skieur);
    }

    @Override
    public List<Skieur> retrieveAllSkieurs() {
        return skieurRepositories.findAll();
    }

    @Override
    public Skieur retrieveSkieur(long numSkieur) {
        return skieurRepositories.findById(numSkieur).orElse(null);
    }

    @Override
    public void deleteSkieur(long numSkieur) {
        skieurRepositories.deleteById(numSkieur);
    }

    @Override
    public Skieur AssignSkieurToPiste(Long numSkieur, Long numPiste){
        Piste piste=pisteRepositories.findById(numPiste).orElse(null);
        Skieur skieur=skieurRepositories.findById(numSkieur).orElse(null);
        piste.getSkieurs().add(skieur);
         pisteRepositories.save(piste);
         return skieur;
    }
}
