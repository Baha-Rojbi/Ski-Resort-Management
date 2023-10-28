package tn.etudedecas.stationdeski.Services;

import tn.etudedecas.stationdeski.Entities.Piste;

import java.util.List;

public interface IPisteService {
    public Piste addPiste(Piste piste);
    public Piste updatePiste(Piste piste);
    public List<Piste> retrieveAllPistes();
    public Piste retrievePiste(long numPiste);
    public void deletePiste(long numPiste);
}
