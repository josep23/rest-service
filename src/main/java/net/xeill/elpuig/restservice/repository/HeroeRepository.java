package net.xeill.elpuig.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.xeill.elpuig.restservice.model.Heroe;

/**
 * Created by rusben on 22/04/21.
 */

@Repository
public interface HeroeRepository extends JpaRepository<Heroe, Integer> {

}

