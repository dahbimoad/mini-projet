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
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String intitule;

    @ManyToOne
    private Filiere filiere;

    @ManyToMany(mappedBy = "cours")
    private List<Eleve> eleves;
}
