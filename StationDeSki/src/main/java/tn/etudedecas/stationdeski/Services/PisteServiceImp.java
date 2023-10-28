package tn.etudedecas.stationdeski.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.etudedecas.stationdeski.Entities.Piste;
import tn.etudedecas.stationdeski.Respositories.PisteRepositories;

import java.util.List;
@Service
@AllArgsConstructor
public class PisteServiceImp implements IPisteService{
    public PisteRepositories pisteRepositories;

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
}
