package tn.etudedecas.stationdeski.Services;

import tn.etudedecas.stationdeski.Entities.Moniteur;
import tn.etudedecas.stationdeski.Entities.Support;

import java.util.List;

public interface IMoniteurService {
    public Moniteur addMoniteur(Moniteur moniteur);
    public Moniteur updateMoniteur(Moniteur moniteur);
    public List<Moniteur> retrieveAllMoniteurs();
    public Moniteur retrieveMoniteur(long numMoniteur);
    public void deleteMoniteur(long numMoniteur);
    public Moniteur addMoniteurAndAssignToCours(Moniteur moniteur,Long numCours);
    public List<Integer> numWeeksCoursOfMoniteurBySupport(Long numMoniteur, Support support);

}
