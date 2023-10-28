package tn.etudedecas.stationdeski.Respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.etudedecas.stationdeski.Entities.Cours;

public interface CoursRepositories extends JpaRepository<Cours,Long> {
}
