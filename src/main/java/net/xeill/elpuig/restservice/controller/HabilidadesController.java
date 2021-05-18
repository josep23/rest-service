package net.xeill.elpuig.restservice.controller;

import java.util.List;

import javax.validation.Valid;

import net.xeill.elpuig.restservice.model.Habilidades;
import net.xeill.elpuig.restservice.repository.HabilidadesRepository;
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

import net.xeill.elpuig.restservice.model.User;<
import net.xeill.elpuig.restservice.repository.UserRepository;

/**
 * Created by rusben on 22/04/21.
 */
@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost" })
@RequestMapping("/api")

public class HabilidadesController {

    @Autowired
    HabilidadesRepository habilidadesRepository;

    @GetMapping("/habilidades")
    public List<Habilidades> getAllHabilidades() {
        return habilidadesRepository.findAll();
    }

    @PostMapping("/habilidades")
    //public Note createNote(@Valid @RequestBody Note note) {
    //https://stackoverflow.com/questions/51337489/content-type-multipart-form-databoundary-webkitformboundary-not-suppor
    public Habilidades createHabilidades(@Valid @RequestBody Habilidades habilidades) {
        return habilidadesRepository.save(habilidades);
    }

    @GetMapping("/habilidades/{id}")
    public Habilidades getHabilidadById(@PathVariable(value = "id") Integer id_habilidades) {
        return habilidadesRepository.findById(id_habilidades)
                .orElseThrow(() -> new ResourceNotFoundException("Habilidades", "id", id_habilidades));
    }

    @PutMapping("/habilidades/{id}")
    public Habilidades updateHabilidades(@PathVariable(value = "id") Integer id_habilidades,
                                         @Valid @RequestBody Habilidades habilidadesDetails) {

        Habilidades habilidades = habilidadesRepository.findById(id_habilidades)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id_habilidades));

        habilidades.setId_habilidades(habilidadesDetails.getId_habilidades());
        habilidades.setNombre_habilidad(habilidadesDetails.getNombre_habilidad());
        habilidades.setCooldown(habilidadesDetails.getCooldown());
        habilidades.setHeroe_id(habilidadesDetails.getHeroe_id());

        Habilidades updatedHabilidades = habilidadesRepository.save(habilidades);
        return updatedHabilidades;
    }

    @DeleteMapping("/habilidades/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id_habilidades") Integer id_habilidades) {
        Habilidades habilidades = habilidadesRepository.findById(id_habilidades)
                .orElseThrow(() -> new ResourceNotFoundException("Habilidades", "id_habilidades", id_habilidades));

        habilidadesRepository.delete(habilidades);

        return ResponseEntity.ok().build();
    }
}
