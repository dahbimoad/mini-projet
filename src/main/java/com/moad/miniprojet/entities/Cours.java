package com.moad.miniprojet.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String intitule;

    @ManyToOne
    @ToString.Exclude
    private Filiere filiere;

    @ManyToMany(mappedBy = "cours")
    @ToString.Exclude
    private List<Eleve> eleves;
}
