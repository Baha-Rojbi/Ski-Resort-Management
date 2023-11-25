package tn.etudedecas.stationdeski.Respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.etudedecas.stationdeski.Entities.Cours;
import tn.etudedecas.stationdeski.Entities.Support;

import java.util.List;

public interface CoursRepositories extends JpaRepository<Cours,Long> {
    //page 23 afficher les num de semaines ou un moniteur a donné des cours selon un support donné

}
