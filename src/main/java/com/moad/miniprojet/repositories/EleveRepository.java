package com.moad.miniprojet.repositories;

import com.moad.miniprojet.entities.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EleveRepository extends JpaRepository<Eleve, Long> {
}
