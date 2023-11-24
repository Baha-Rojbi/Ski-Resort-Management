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
        /// trouver le cours
        Cours cours = coursRepositories.findById(numCourse).orElse(null);
        // save skieur
        Skieur savedSkieur = skieurRepositories.save(skieur);
        // Create and set Abonnement for Skieur
        Abonnement abonnement = new Abonnement();
        savedSkieur.setAbonnement(abonnement);

        // creer inscription
        Inscription inscription = new Inscription();
        inscription.setCours(cours);
        inscription.setSkieur(savedSkieur);
        // Set Inscription
        savedSkieur.setInscriptions(Set.of(inscription));
        // Save the Skieur
        return skieurRepositories.save(savedSkieur);
    }

    @Override
    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement) {
        return skieurRepositories.findAllByAbonnementTypeAbon(typeAbonnement);
    }
}
