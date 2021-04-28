package net.xeill.elpuig.restservice.controller;

import java.util.List;

import javax.validation.Valid;

import net.xeill.elpuig.restservice.model.Heroe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.xeill.elpuig.restservice.exception.ResourceNotFoundException;

import net.xeill.elpuig.restservice.model.User;
import net.xeill.elpuig.restservice.repository.HeroeRepository;

/**
 * Created by rusben on 22/04/21.
 */
@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost" })
@RequestMapping("/api")

public class HeroeController {

    @Autowired
    HeroeRepository heroeRepository;

    @GetMapping("/Heroes")
    public List<Heroe> getAllUsers() {
        return heroeRepository.findAll();
    }

    @PostMapping("/Heroes")
    //public Note createNote(@Valid @RequestBody Note note) {
    //https://stackoverflow.com/questions/51337489/content-type-multipart-form-databoundary-webkitformboundary-not-suppor
    public Heroe createHeroe(@Valid @RequestBody Heroe heroe) {
        return heroeRepository.save(heroe);
    }
    @GetMapping("/Heroes/{id}")
    public Heroe getUserById(@PathVariable(value = "heroe_id") Integer heroe_id) {
        return heroeRepository.findById(heroe_id)
                .orElseThrow(() -> new ResourceNotFoundException("Heroe", "heroe_id", heroe_id));
    }

    @PutMapping("/Heroes/{id}")
    public Heroe updateHeroe(@PathVariable(value = "heroe_id") Integer heroe_id,
                           @Valid @RequestBody Heroe heroeDetails) {

        Heroe heroe = heroeRepository.findById(heroe_id)
                .orElseThrow(() -> new ResourceNotFoundException("Heroes", "heroe_id", heroe_id));

        heroe.setHeroe_id(heroeDetails.getHeroe_id());
        heroe.setNombre(heroeDetails.getNombre());
        heroe.setVida(heroeDetails.getVida());
        heroe.setRol(heroeDetails.getRol());

        Heroe updatedHeroe = heroeRepository.save(heroe);
        return updatedHeroe;
    }

        @DeleteMapping("/Heroes/{id}")
    public ResponseEntity<?> deleteHeroe(@PathVariable(value = "heroe_id") Integer heroe_id) {
        Heroe heroe = heroeRepository.findById(heroe_id)
                .orElseThrow(() -> new ResourceNotFoundException("Heroe", "heroe_id", heroe_id));

        heroeRepository.delete(heroe);

        return ResponseEntity.ok().build();
    }

}
