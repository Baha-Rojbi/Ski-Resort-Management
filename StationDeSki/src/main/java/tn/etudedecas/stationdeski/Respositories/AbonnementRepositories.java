package tn.etudedecas.stationdeski.Respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import tn.etudedecas.stationdeski.Entities.Abonnement;
import tn.etudedecas.stationdeski.Entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface AbonnementRepositories extends JpaRepository<Abonnement,Long> {
public Set<Abonnement> findByTypeAbonOrderByDateDebut (TypeAbonnement typeAbonnement);
/// retrieve abonnement entre deux dates
public List<Abonnement> findByDateDebutBetween(Date dateDebut, Date dateFin);

}
