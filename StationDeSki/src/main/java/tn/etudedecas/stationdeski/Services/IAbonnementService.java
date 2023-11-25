package tn.etudedecas.stationdeski.Services;

import tn.etudedecas.stationdeski.Entities.Abonnement;
import tn.etudedecas.stationdeski.Entities.TypeAbonnement;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface IAbonnementService {
    public Abonnement addAbonnement(Abonnement abonnement);
    public Abonnement updateAbonnement(Abonnement abonnement);
    public List<Abonnement> retrieveAllAbonnements();
    public Abonnement retrieveAbonnement(long numAbon);
    public void deleteAbonnement(long numAbon);
    public Set<Abonnement> getAbonnementByType(TypeAbonnement typeAbonnement);
    public List<Abonnement> retrieveAbonnementByDates(Date dateDebut, Date dateFin);
}
