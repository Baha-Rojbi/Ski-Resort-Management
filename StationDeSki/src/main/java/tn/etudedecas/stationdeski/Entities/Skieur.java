package tn.etudedecas.stationdeski.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity

public class Skieur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numSkieur;
    private String nomS;
    private String prenomS;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private String ville;
    @JsonIgnore
    @ManyToMany(mappedBy = "skieurs")
    private Set<Piste> pistes;
    @OneToMany(mappedBy = "skieur")
    private Set<Inscription> inscriptions;
    @OneToOne(cascade = CascadeType.ALL)
    private Abonnement abonnement;
}
