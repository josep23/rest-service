package net.xeill.elpuig.restservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "habilidades")
public class Habilidades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_habilidades;

    @NotBlank
    private String nombre_habilidad;
    @NotBlank
    private Integer cooldown;

    public Integer getId_habilidades() {
        return id_habilidades;
    }

    public void setId_habilidades(Integer id_habilidades) {
        this.id_habilidades = id_habilidades;
    }

    public String getNombre_habilidad() {
        return nombre_habilidad;
    }

    public void setNombre_habilidad(String nombre_habilidad) {
        this.nombre_habilidad = nombre_habilidad;
    }

    public Integer getCooldown() {
        return cooldown;
    }

    public void setCooldown(Integer cooldown) {
        this.cooldown = cooldown;
    }
}
