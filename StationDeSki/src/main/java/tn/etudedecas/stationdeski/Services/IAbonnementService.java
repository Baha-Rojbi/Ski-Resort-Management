package tn.etudedecas.stationdeski.Services;

import tn.etudedecas.stationdeski.Entities.Abonnement;

import java.util.List;

public interface IAbonnementService {
    public Abonnement addAbonnement(Abonnement abonnement);
    public Abonnement updateAbonnement(Abonnement abonnement);
    public List<Abonnement> retrieveAllAbonnements();
    public Abonnement retrieveAbonnement(long numAbon);
    public void deleteAbonnement(long numAbon);
}
