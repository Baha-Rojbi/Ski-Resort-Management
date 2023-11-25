package tn.etudedecas.stationdeski.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.etudedecas.stationdeski.Entities.Cours;
import tn.etudedecas.stationdeski.Entities.Inscription;
import tn.etudedecas.stationdeski.Entities.Moniteur;
import tn.etudedecas.stationdeski.Entities.Support;
import tn.etudedecas.stationdeski.Respositories.CoursRepositories;
import tn.etudedecas.stationdeski.Respositories.MoniteurRepositories;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MoniteurServiceImp implements IMoniteurService{
    public MoniteurRepositories moniteurRepositories;
    public CoursRepositories coursRepositories;

    @Override
    public Moniteur addMoniteur(Moniteur moniteur) {
        return moniteurRepositories.save(moniteur);
    }

    @Override
    public Moniteur updateMoniteur(Moniteur moniteur) {
        return moniteurRepositories.save(moniteur);
    }

    @Override
    public List<Moniteur> retrieveAllMoniteurs() {
        return moniteurRepositories.findAll();
    }

    @Override
    public Moniteur retrieveMoniteur(long numMoniteur) {
        return moniteurRepositories.findById(numMoniteur).orElse(null);
    }


    @Override
    public void deleteMoniteur(long numMoniteur) {
        moniteurRepositories.deleteById(numMoniteur);
    }

    @Override
    public Moniteur addMoniteurAndAssignToCours(Moniteur moniteur, Long numCours) {
        Cours cours=coursRepositories.findById(numCours).orElse(null);
        Set<Cours> coursSet = new HashSet<>();
        coursSet.add(cours);
        moniteur.setCours(coursSet);
        moniteurRepositories.save(moniteur);
        return moniteur;
    }

    @Override
    public List<Integer> numWeeksCoursOfMoniteurBySupport(Long numMoniteur, Support support) {
        Moniteur moniteur = moniteurRepositories.findById(numMoniteur).orElse(null);
        Set<Integer> weeks = moniteur.getCours().stream()
                .filter(cours -> cours.getSupport() == support)
                .flatMap(cours -> cours.getInscriptions().stream())
                .map(Inscription::getNumSemaine)
                .collect(Collectors.toSet());

        return new ArrayList<>(weeks);
    }
}
