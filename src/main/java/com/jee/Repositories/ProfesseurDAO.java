package com.jee.Repositories;

import com.jee.Beans.Professeur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesseurDAO extends CrudRepository<Professeur, Long> {
    boolean existsByEmail(String email);

    @Query("select p from Professeur p where  p.email = ?1")
    Professeur getProfesseurByEmail(String email);
}
