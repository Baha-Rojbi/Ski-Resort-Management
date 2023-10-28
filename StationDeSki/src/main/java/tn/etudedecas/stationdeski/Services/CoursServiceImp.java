package tn.etudedecas.stationdeski.Services;

import tn.etudedecas.stationdeski.Entities.Couleur;
import tn.etudedecas.stationdeski.Entities.Cours;
import tn.etudedecas.stationdeski.Respositories.CoursRepositories;

import java.util.List;

public class CoursServiceImp implements ICoursService{
public CoursRepositories coursRepositories;
    @Override
    public Cours addCours(Cours c) {
        return coursRepositories.save(c);
    }

    @Override
    public Cours updateCours(Cours c) {
        return coursRepositories.save(c);
    }

    @Override
    public List<Cours> getAllCours() {
        return coursRepositories.findAll();
    }

    @Override
    public Cours GetCoursById(long idC) {
        return coursRepositories.findById(idC).orElse(null);
    }

    @Override
    public void deleteCours(long idC) {
        coursRepositories.deleteById(idC);
    }
}
