package tn.etudedecas.stationdeski.Respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.etudedecas.stationdeski.Entities.Inscription;
import tn.etudedecas.stationdeski.Entities.Support;

import java.util.List;

public interface InscriptionRepositories extends JpaRepository<Inscription,Long> {
    //page 23 afficher les num de semaines ou un moniteur a donné des cours selon un support donné numWeeksCoursOfMoniteurBySupport
    @Query("select i.numSemaine FROM Inscription i "+
    "join Moniteur m "+
    "on i.cours member of m.cours "+
    "where m.numMoniteur =:numMoniteur and i.cours.support =:support")
    public List<Integer> numWeeksCoursOfMoniteurBySupportQuery(@Param("numMoniteur") Long numMoniteur,@Param("support") Support support);
}
