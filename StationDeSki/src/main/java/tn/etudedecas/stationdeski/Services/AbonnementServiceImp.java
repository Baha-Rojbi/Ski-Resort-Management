package tn.etudedecas.stationdeski.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.etudedecas.stationdeski.Entities.Abonnemenet;
import tn.etudedecas.stationdeski.Respositories.AbonnementRepositories;

import java.util.List;
@Service
@AllArgsConstructor
public class AbonnementServiceImp implements IAbonnementService{
    public AbonnementRepositories abonnementRepositories;
    @Override
    public Abonnemenet addAbonnement(Abonnemenet e) {
        return abonnementRepositories.save(e);
    }

    @Override
    public Abonnemenet updateAbonnement(Abonnemenet e) {
        return abonnementRepositories.save(e);
    }

    @Override
    public List<Abonnemenet> getAllAbonnement() {
        return abonnementRepositories.findAll();
    }

    @Override
    public Abonnemenet getAbonnementById(long idE) {
        return abonnementRepositories.findById(idE).orElse(null);
    }

    @Override
    public void deleteAbonnement(long idE) {
        abonnementRepositories.deleteById(idE);
    }
}
