package com.nilsonSantiago.SistemaDeGerenciamentoDeBarbearia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nilsonSantiago.SistemaDeGerenciamentoDeBarbearia.enums.Status;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_scheduling")
public class Scheduling implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;

    @OneToOne
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private Client client;

    @OneToOne
    @JoinColumn(name = "barber_id")
    @JsonIgnore
    private Barber barber;
    private Status status;
    private BigDecimal price;

    public Scheduling() {
    }

    public Scheduling(Long id, LocalDateTime date, Client client, Barber barber, Status status, BigDecimal price) {
        this.id = id;
        this.date = date;
        this.client = client;
        this.barber = barber;
        this.status = status;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Barber getBarber() {
        return barber;
    }

    public void setBarber(Barber barber) {
        this.barber = barber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Scheduling that = (Scheduling) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}