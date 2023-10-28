package tn.etudedecas.stationdeski.Services;

import tn.etudedecas.stationdeski.Entities.Abonnement;

import java.util.List;

public interface IAbonnementService {
    public Abonnement addAbonnement(Abonnement e);
    public Abonnement updateAbonnement(Abonnement e);
    public List<Abonnement> getAllAbonnement();
    public Abonnement getAbonnementById(long idE);
    public void deleteAbonnement(long idE);
}
