package tn.etudedecas.stationdeski.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Cours implements Serializable {
    @Id
    private Long numCours;
    private int niveau;
    private TypeCours typeCours;
    private Support support;
    private Float prix;
    private int creneau;
}
