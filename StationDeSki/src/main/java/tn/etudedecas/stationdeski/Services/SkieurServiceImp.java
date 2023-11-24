package tn.etudedecas.stationdeski.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.etudedecas.stationdeski.Entities.*;
import tn.etudedecas.stationdeski.Respositories.*;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor

public class SkieurServiceImp implements ISkieurService{
    public SkieurRepositories skieurRepositories;
    public PisteRepositories pisteRepositories;
    public AbonnementRepositories abonnementRepositories;
    public InscriptionRepositories inscriptionRepositories;
    public CoursRepositories coursRepositories;

    @Override
    public Skieur addSkieur(Skieur skieur) {
        return skieurRepositories.save(skieur);
    }

    @Override
    public Skieur updateSkieur(Skieur skieur) {
        return skieurRepositories.save(skieur);
    }

    @Override
    public List<Skieur> retrieveAllSkieurs() {
        return skieurRepositories.findAll();
    }

    @Override
    public Skieur retrieveSkieur(long numSkieur) {
        return skieurRepositories.findById(numSkieur).orElse(null);
    }

    @Override
    public void deleteSkieur(long numSkieur) {
        skieurRepositories.deleteById(numSkieur);
    }

    @Override
    public Skieur AssignSkieurToPiste(Long numSkieur, Long numPiste){
        Piste piste=pisteRepositories.findById(numPiste).orElse(null);
        Skieur skieur=skieurRepositories.findById(numSkieur).orElse(null);
        piste.getSkieurs().add(skieur);
         pisteRepositories.save(piste);
         return skieur;
    }

    @Override
    public Skieur addSkierAndAssignToCourse(Skieur skieur, Long numCourse) {
        // ajouter le skieur
        Skieur savedSkieur = skieurRepositories.save(skieur);
        /// trouver le cours
        Cours cours = coursRepositories.findById(numCourse).orElse(null);
        /// creer inscriptio,
        Set<Inscription> inscriptions=savedSkieur.getInscriptions();
        for(Inscription inscription:inscriptions){
            inscription.setSkieur(savedSkieur);
            inscription.setCours(cours);
            inscriptionRepositories.save(inscription);
        }
        addSkieurAndAbonnement(skieur);
        //else Save the Skieur
        return skieurRepositories.save(savedSkieur);
    }

    @Override
    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement) {
        return skieurRepositories.findByAbonnementTypeAbon(typeAbonnement);
    }

    @Override
    public Skieur addSkieurAndAbonnement(Skieur skieur) {

      Abonnement abonnement= abonnementRepositories.save(skieur.getAbonnement());
       return skieurRepositories.save(skieur);


    }
}
