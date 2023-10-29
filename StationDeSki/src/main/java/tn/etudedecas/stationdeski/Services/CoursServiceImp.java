package tn.etudedecas.stationdeski.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.etudedecas.stationdeski.Entities.Couleur;
import tn.etudedecas.stationdeski.Entities.Cours;
import tn.etudedecas.stationdeski.Respositories.CoursRepositories;

import java.util.List;

@Service
@AllArgsConstructor
public class CoursServiceImp implements ICoursService{
public CoursRepositories coursRepositories;
    @Override
    public Cours addCours(Cours cours) {
        return coursRepositories.save(cours);
    }
    @Override
    public Cours updateCours(Cours cours) {
        return coursRepositories.save(cours);
    }
    @Override
    public List<Cours> retriveAllCourses() {
        return coursRepositories.findAll();
    }
    @Override
    public Cours retrieveCours(long numsCours) {
        return coursRepositories.findById(numsCours).orElse(null);
    }
    @Override
    public void deleteCours(long numsCours) {
        coursRepositories.deleteById(numsCours);
    }
}
