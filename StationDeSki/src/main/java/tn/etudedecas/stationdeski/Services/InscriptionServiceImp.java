package tn.etudedecas.stationdeski.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.etudedecas.stationdeski.Entities.Inscription;
import tn.etudedecas.stationdeski.Respositories.InscriptionRepositories;

import java.util.List;
@Service
@AllArgsConstructor
public class InscriptionServiceImp implements IInscriptionService{
    public InscriptionRepositories inscriptionRepositories;

    @Override
    public Inscription addInscription(Inscription inscription) {
        return inscriptionRepositories.save(inscription);
    }

    @Override
    public Inscription updateInscription(Inscription inscription) {
        return inscriptionRepositories.save(inscription);
    }

    @Override
    public List<Inscription> retrieveAllInscriptions() {
        return inscriptionRepositories.findAll();
    }

    @Override
    public Inscription retrieveInscription(long numInscription) {
        return inscriptionRepositories.findById(numInscription).orElse(null);
    }

    @Override
    public void deleteInscription(long numInscription) {
        inscriptionRepositories.deleteById(numInscription);
    }
}
