package tn.etudedecas.stationdeski.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.etudedecas.stationdeski.Entities.Cours;
import tn.etudedecas.stationdeski.Entities.Moniteur;
import tn.etudedecas.stationdeski.Respositories.CoursRepositories;
import tn.etudedecas.stationdeski.Respositories.MoniteurRepositories;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
}
