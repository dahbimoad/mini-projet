package com.moad.miniprojet.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Filiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String nom;

    @OneToMany(mappedBy = "filiere")
    @ToString.Exclude
    private List<Eleve> eleves;

    @OneToMany(mappedBy = "filiere")
    @ToString.Exclude
    private List<Cours> cours;
}
