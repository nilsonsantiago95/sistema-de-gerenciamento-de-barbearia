package com.nilsonSantiago.SistemaDeGerenciamentoDeBarbearia.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "tb_barber")
public class Barber implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String specialty;
    private String imgUrlBarber;
    private Boolean active;

    @OneToMany(mappedBy = "barber")
    private Set<Scheduling> appointments = new TreeSet<>();

    public Barber() {
    }

    public Barber(Long id, String name, String specialty, String imgUrlBarber, Boolean active) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.imgUrlBarber = imgUrlBarber;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getImgUrlBarber() {
        return imgUrlBarber;
    }

    public void setImgUrlBarber(String imgUrlBarber) {
        this.imgUrlBarber = imgUrlBarber;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<Scheduling> getAppointments() {
        return appointments;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Barber barber = (Barber) o;
        return Objects.equals(id, barber.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}