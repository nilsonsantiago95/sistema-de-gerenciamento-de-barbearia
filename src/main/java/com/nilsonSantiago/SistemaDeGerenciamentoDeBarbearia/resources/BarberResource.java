package com.nilsonSantiago.SistemaDeGerenciamentoDeBarbearia.resources;

import com.nilsonSantiago.SistemaDeGerenciamentoDeBarbearia.entities.Barber;
import com.nilsonSantiago.SistemaDeGerenciamentoDeBarbearia.services.BarberService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

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
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(barber.getId())
                .toUri();
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

}