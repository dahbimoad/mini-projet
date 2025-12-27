package com.moad.miniprojet.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Eleve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;

    @ManyToOne
    @ToString.Exclude
    private Filiere filiere;

    @OneToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    private DossierAdministratif dossierAdministratif;

    @ManyToMany
    @ToString.Exclude
    private List<Cours> cours;
}
