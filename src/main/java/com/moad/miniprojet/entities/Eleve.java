package com.moad.miniprojet.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private Filiere filiere;

    @OneToOne(cascade = CascadeType.ALL)
    private DossierAdministratif dossierAdministratif;

    @ManyToMany
    private List<Cours> cours;
}
