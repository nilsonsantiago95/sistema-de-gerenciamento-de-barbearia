package com.nilsonSantiago.SistemaDeGerenciamentoDeBarbearia.resources;

import com.nilsonSantiago.SistemaDeGerenciamentoDeBarbearia.config.RequestUri;
import com.nilsonSantiago.SistemaDeGerenciamentoDeBarbearia.entities.Barber;
import com.nilsonSantiago.SistemaDeGerenciamentoDeBarbearia.services.BarberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/barbers")
public class BarberResource {

    @Autowired
    private BarberService barberService;

    @PostMapping
    public ResponseEntity<Barber> insert(@RequestBody Barber barber) {
        barber = barberService.insert(barber);
        URI uri = new RequestUri("/{id}", barber.getId()).getUri();
        return ResponseEntity.created(uri).body(barber);
    }

    @GetMapping
    public ResponseEntity<List<Barber>> findAll() {
        return ResponseEntity.ok().body(barberService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Barber> findById(@PathVariable Long id) {
        Barber barber = barberService.findById(id);
        return ResponseEntity.ok().body(barber);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Barber> update(@RequestBody Barber barber, @PathVariable Long id) {
        barber = barberService.update(barber, id);
        return ResponseEntity.ok().body(barber);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Barber> delete(@PathVariable Long id) {
        barberService.delete(id);
        return ResponseEntity.noContent().build();
    }

}