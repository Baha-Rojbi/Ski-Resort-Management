package tn.etudedecas.stationdeski.Services;

import tn.etudedecas.stationdeski.Entities.Cours;

import java.util.List;

public interface ICoursService {
    public Cours addCours(Cours c);
    public Cours updateCours(Cours c);
    public List<Cours> getAllCours();
    public Cours GetCoursById(long idC);
    public void deleteCours(long idC);
}
