package net.xeill.elpuig.restservice.repository;

import net.xeill.elpuig.restservice.model.Habilidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rusben on 22/04/21.
 */

@Repository
public interface HabilidadesRepository extends JpaRepository<Habilidades, Integer> {

}