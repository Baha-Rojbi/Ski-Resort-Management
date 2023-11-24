package tn.etudedecas.stationdeski.Services;

import tn.etudedecas.stationdeski.Entities.Skieur;
import tn.etudedecas.stationdeski.Entities.TypeAbonnement;

import java.util.List;

public interface ISkieurService {
    public Skieur addSkieur(Skieur skieur);
    public Skieur updateSkieur(Skieur skieur);
    public List<Skieur> retrieveAllSkieurs();
    public Skieur retrieveSkieur(long numSkieur);
    public void deleteSkieur(long numSkieur);
    public Skieur AssignSkieurToPiste(Long numSkieur,Long numPiste);

///////the toughest one yet
    Skieur addSkierAndAssignToCourse(Skieur skieur, Long numCourse);
    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement);
    public Skieur addSkieurAndAbonnement(Skieur skieur);

}
