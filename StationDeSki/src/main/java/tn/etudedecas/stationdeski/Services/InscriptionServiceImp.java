package tn.etudedecas.stationdeski.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.etudedecas.stationdeski.Entities.*;
import tn.etudedecas.stationdeski.Respositories.CoursRepositories;
import tn.etudedecas.stationdeski.Respositories.InscriptionRepositories;
import tn.etudedecas.stationdeski.Respositories.SkieurRepositories;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class InscriptionServiceImp implements IInscriptionService{
    public InscriptionRepositories inscriptionRepositories;
    public SkieurRepositories skieurRepositories;
    public CoursRepositories coursRepositories;

    @Override
    public Inscription addInscription(Inscription inscription) {
        return inscriptionRepositories.save(inscription);
    }

    @Override
    public Inscription updateInscription(Inscription inscription) {
        return inscriptionRepositories.save(inscription);
    }

    @Override
    public List<Inscription> retrieveAllInscriptions() {
        return inscriptionRepositories.findAll();
    }

    @Override
    public Inscription retrieveInscription(long numInscription) {
        return inscriptionRepositories.findById(numInscription).orElse(null);
    }

    @Override
    public void deleteInscription(long numInscription) {
        inscriptionRepositories.deleteById(numInscription);
    }

    @Override
    public Inscription addInscriptionAndAssignToSkieur(Inscription inscription, Long numSkieur) {
        Skieur skieur=skieurRepositories.findById(numSkieur).orElse(null);//lawejna aal skieur
        inscription.setSkieur(skieur);//affectina el skieur lel inscrit teena
        return inscriptionRepositories.save(inscription);//sajelna el inscrit
    }

    @Override
    public Inscription addInscriptionAndAssignToCours(Inscription inscription, Long numCours) {
        Cours cours=coursRepositories.findById(numCours).orElse(null);
        inscription.setCours(cours);
        return inscriptionRepositories.save(inscription);
    }
/////Ajouter inscription avec cours ne depasse pas 6skieurs par Cours
    ///// A completer la condition
    @Override
    public Inscription addInscriptionAndAssignToSkieurAndCours(Inscription inscription, Long numSkieur, Long numCours) {
        Skieur skieur=skieurRepositories.findById(numSkieur).orElse(null);
        Cours cours=coursRepositories.findById(numCours).orElse(null);
        // Check if the course is a COLLECTIF type and has reached the maximum number of skiers
        if (cours.getTypeCours() == TypeCours.COLLECTIF_ENFANT || cours.getTypeCours() == TypeCours.COLLECTIF_ADULTE) {
            if (cours.getInscriptions().size() >= 6) {
                log.info("Maximum number of skiers reached for the COLLECTIF course");
            }
        }
        // Check skier's age before adding the inscription

        // Create the inscription
        inscription.setSkieur(skieur);
        inscription.setCours(cours);
        // Save the inscription
        return inscriptionRepositories.save(inscription);
    }

    @Override
    public Inscription assignInscriptionToCours(Long numInscription, Long numCours) {
        Inscription inscription=inscriptionRepositories.findById(numInscription).orElse(null);
        Cours cours=coursRepositories.findById(numCours).orElse(null);
        inscription.setCours(cours);
        return inscriptionRepositories.save(inscription);
    }

    @Override
    public List<Integer> numWeeksCoursOfMoniteurBySupportQuery(Long numMoniteur, Support support) {
        return inscriptionRepositories.numWeeksCoursOfMoniteurBySupportQuery(numMoniteur,support);
    }
}
