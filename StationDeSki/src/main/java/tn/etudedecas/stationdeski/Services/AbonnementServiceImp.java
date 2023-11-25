package tn.etudedecas.stationdeski.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.etudedecas.stationdeski.Entities.Abonnement;
import tn.etudedecas.stationdeski.Entities.TypeAbonnement;
import tn.etudedecas.stationdeski.Respositories.AbonnementRepositories;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class AbonnementServiceImp implements IAbonnementService{
    public AbonnementRepositories abonnementRepositories;
    @Override
    public Abonnement addAbonnement(Abonnement abonnement) {
        return abonnementRepositories.save(abonnement);
    }

    @Override
    public Abonnement updateAbonnement(Abonnement abonnement) {
        return abonnementRepositories.save(abonnement);
    }

    @Override
    public List<Abonnement> retrieveAllAbonnements() {
        return abonnementRepositories.findAll();
    }

    @Override
    public Abonnement retrieveAbonnement(long numAbon) {
        return abonnementRepositories.findById(numAbon).orElse(null);
    }


    @Override
    public void deleteAbonnement(long numAbon) {
        abonnementRepositories.deleteById(numAbon);
    }

    @Override
    public Set<Abonnement> getAbonnementByType(TypeAbonnement typeAbonnement) {
        return abonnementRepositories.findByTypeAbonOrderByDateDebut(typeAbonnement);
    }

    @Override
    public List<Abonnement> retrieveAbonnementByDates(Date dateDebut, Date dateFin) {
        return abonnementRepositories.findByDateDebutBetween(dateDebut,dateFin);
    }

}
