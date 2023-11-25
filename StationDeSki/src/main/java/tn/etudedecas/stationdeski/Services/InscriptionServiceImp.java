package tn.etudedecas.stationdeski.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.etudedecas.stationdeski.Entities.Cours;
import tn.etudedecas.stationdeski.Entities.Inscription;
import tn.etudedecas.stationdeski.Entities.Skieur;
import tn.etudedecas.stationdeski.Respositories.CoursRepositories;
import tn.etudedecas.stationdeski.Respositories.InscriptionRepositories;
import tn.etudedecas.stationdeski.Respositories.SkieurRepositories;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
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
        Skieur skieur=skieurRepositories.findById(numSkieur).orElse(null);
        inscription.setSkieur(skieur);
        return inscriptionRepositories.save(inscription);
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
        inscription.setSkieur(skieur);
        inscription.setCours(cours);
        return inscription;
    }
}
