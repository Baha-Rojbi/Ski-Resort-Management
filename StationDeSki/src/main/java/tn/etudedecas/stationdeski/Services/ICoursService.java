package tn.etudedecas.stationdeski.Services;

import tn.etudedecas.stationdeski.Entities.Cours;

import java.util.List;

public interface ICoursService {
    public Cours addCours(Cours cours);
    public Cours updateCours(Cours cours);
    public List<Cours> retriveAllCourses();
    public Cours retrieveCours(long numsCours);
    public void deleteCours(long numsCours);
}
