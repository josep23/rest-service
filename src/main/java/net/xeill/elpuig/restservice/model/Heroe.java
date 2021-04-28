package net.xeill.elpuig.restservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "heroe")
public class Heroe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer heroe_id;

    @NotBlank
    private String nombre;
    @NotBlank
    private Integer vida;
    @NotBlank
    private String rol;

    public Integer getHeroe_id() {
        return heroe_id;
    }

    public void setHeroe_id(Integer heroe_id) {
        this.heroe_id = heroe_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getVida() {
        return vida;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}

