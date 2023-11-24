package tn.etudedecas.stationdeski.Respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.etudedecas.stationdeski.Entities.Skieur;
import tn.etudedecas.stationdeski.Entities.TypeAbonnement;

import java.util.List;

public interface SkieurRepositories extends JpaRepository<Skieur,Long> {
    public List<Skieur> findByAbonnementTypeAbon (TypeAbonnement typeAbonnement);
    public List<Skieur> getSkieurByAbonnementTypeAbon(TypeAbonnement typeAbonnement);

}
