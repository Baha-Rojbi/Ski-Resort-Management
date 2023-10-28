package tn.etudedecas.stationdeski.Services;

import tn.etudedecas.stationdeski.Entities.Skieur;

import java.util.List;

public interface ISkieurService {
    public Skieur addSkieur(Skieur skieur);
    public Skieur updateSkieur(Skieur skieur);
    public List<Skieur> retrieveAllSkieurs();
    public Skieur retrieveSkieur(long numSkieur);
    public void deleteSkieur(long numSkieur);

}