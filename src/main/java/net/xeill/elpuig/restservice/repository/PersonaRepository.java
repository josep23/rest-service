package net.xeill.elpuig.restservice.repository;

import net.xeill.elpuig.restservice.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.xeill.elpuig.restservice.model.Heroe;

/**
 * Created by rusben on 22/04/21.
 */

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

}