package tn.etudedecas.stationdeski.Respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.etudedecas.stationdeski.Entities.Moniteur;
import tn.etudedecas.stationdeski.Entities.Support;

import java.util.List;

public interface MoniteurRepositories extends JpaRepository<Moniteur,Long> {
   // page 23 afficher les num de semaines ou un moniteur a donné des cours selon un support donné numWeeksCoursOfMoniteurBySupport

}
