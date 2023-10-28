package tn.etudedecas.stationdeski.Services;

import tn.etudedecas.stationdeski.Entities.Abonnemenet;

import java.util.List;

public interface IAbonnementService {
    public Abonnemenet addAbonnement(Abonnemenet e);
    public Abonnemenet updateAbonnement(Abonnemenet e);
    public List<Abonnemenet> getAllAbonnement();
    public Abonnemenet getAbonnementById(long idE);
    public void deleteAbonnement(long idE);
}
