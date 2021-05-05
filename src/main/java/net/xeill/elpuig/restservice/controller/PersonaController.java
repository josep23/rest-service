package net.xeill.elpuig.restservice.controller;

import java.util.List;

import javax.validation.Valid;

import net.xeill.elpuig.restservice.model.Persona;
import net.xeill.elpuig.restservice.repository.PersonaRepository;
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
import net.xeill.elpuig.restservice.repository.UserRepository;

/**
 * Created by rusben on 22/04/21.
 */
@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost" })
@RequestMapping("/api")

public class PersonaController {

    @Autowired
    PersonaRepository personaRepository;

    @GetMapping("/persona")
    public List<Persona> getAllPersona() {
        return personaRepository.findAll();
    }

    @PostMapping("/persona")
    //public Note createNote(@Valid @RequestBody Note note) {
    //https://stackoverflow.com/questions/51337489/content-type-multipart-form-databoundary-webkitformboundary-not-suppor
    public Persona createPersona(@Valid @RequestBody Persona persona) {
        return personaRepository.save(persona);
    }

    @GetMapping("/persona/{id}")
    public Persona getPersonaById(@PathVariable(value = "id") Integer persona_id) {
        return personaRepository.findById(persona_id)
                .orElseThrow(() -> new ResourceNotFoundException("Persona", "id", persona_id));
    }

    @PutMapping("/persona/{id}")
    public Persona updatePersona(@PathVariable(value = "id") Integer persona_id,
                           @Valid @RequestBody Persona personaDetails) {

        Persona persona = personaRepository.findById(persona_id)
                .orElseThrow(() -> new ResourceNotFoundException("Persona", "id", persona_id));

        persona.setPersona_id(personaDetails.getPersona_id());
        persona.setFullname(personaDetails.getFullname());
        persona.setHeroe_id(personaDetails.getHeroe_id());


        Persona updatedPersona = personaRepository.save(persona);
        return updatedPersona;
    }

    @DeleteMapping("/persona/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable(value = "id") Integer persona_id) {
        Persona persona = personaRepository.findById(persona_id)
                .orElseThrow(() -> new ResourceNotFoundException("Persona", "id", persona_id));

        personaRepository.delete(persona);

        return ResponseEntity.ok().build();
    }
}

