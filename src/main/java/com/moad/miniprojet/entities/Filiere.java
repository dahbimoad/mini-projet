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
public class Filiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String nom;

    @OneToMany(mappedBy = "filiere")
    private List<Eleve> eleves;

    @OneToMany(mappedBy = "filiere")
    private List<Cours> cours;
}
