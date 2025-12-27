package com.moad.miniprojet.repositories;

import com.moad.miniprojet.entities.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursRepository extends JpaRepository<Cours, Long> {
}
