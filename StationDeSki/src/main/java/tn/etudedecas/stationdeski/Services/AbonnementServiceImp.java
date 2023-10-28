package tn.etudedecas.stationdeski.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.etudedecas.stationdeski.Entities.Abonnement;
import tn.etudedecas.stationdeski.Respositories.AbonnementRepositories;

import java.util.List;
@Service
@AllArgsConstructor
public class AbonnementServiceImp implements IAbonnementService{
    public AbonnementRepositories abonnementRepositories;
    @Override
    public Abonnement addAbonnement(Abonnement e) {
        return abonnementRepositories.save(e);
    }

    @Override
    public Abonnement updateAbonnement(Abonnement e) {
        return abonnementRepositories.save(e);
    }

    @Override
    public List<Abonnement> getAllAbonnement() {
        return abonnementRepositories.findAll();
    }

    @Override
    public Abonnement getAbonnementById(long idE) {
        return abonnementRepositories.findById(idE).orElse(null);
    }

    @Override
    public void deleteAbonnement(long idE) {
        abonnementRepositories.deleteById(idE);
    }
}
