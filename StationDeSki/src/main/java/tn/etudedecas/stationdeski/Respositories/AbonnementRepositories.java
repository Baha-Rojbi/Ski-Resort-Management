package tn.etudedecas.stationdeski.Respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import tn.etudedecas.stationdeski.Entities.Abonnement;
import tn.etudedecas.stationdeski.Entities.TypeAbonnement;

import java.util.Set;

public interface AbonnementRepositories extends JpaRepository<Abonnement,Long> {
public Set<Abonnement> findByTypeAbonOrderByDateDebut (TypeAbonnement typeAbonnement);
}
