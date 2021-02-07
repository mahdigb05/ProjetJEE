package com.jee.Repositories;

import com.jee.Beans.Cours;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursDAO extends CrudRepository<Cours, Long> {
    Cours findByTitre(String titre);
    List<Cours> getAllByModule(Long id_module);
}
