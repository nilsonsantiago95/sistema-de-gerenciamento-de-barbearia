package com.nilsonSantiago.SistemaDeGerenciamentoDeBarbearia.services;

import com.nilsonSantiago.SistemaDeGerenciamentoDeBarbearia.entities.Barber;
import com.nilsonSantiago.SistemaDeGerenciamentoDeBarbearia.repositories.BarberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BarberService {

    @Autowired
    private BarberRepository barberRepository;

    public Barber insert(Barber barber) {
        barber = barberRepository.save(barber);
        return barber;
    }

    public Barber findById(Long id) {
        Optional<Barber> barberOptional =  barberRepository.findById(id);
        return barberOptional.orElseThrow(() -> new NoSuchElementException("Not found"));
    }

    public List<Barber> findAll() {
        return barberRepository.findAll();
    }

    public Barber update(Barber barber, Long id) {
        Barber barberEntity = barberRepository.getReferenceById(id);
        updateData(barber, barberEntity);
        return barberRepository.save(barberEntity);
    }

    private void updateData(Barber barber, Barber barberEntity) {

        Optional<Barber> barberOptional = Optional.of(barber);
        barber = barberOptional.orElseThrow(() -> new NoSuchElementException("Not found"));

        barberEntity.setName(checkIsNull(barber.getName()) ? barberEntity.getName() : barber.getName());
        barberEntity.setSpecialty(checkIsNull(barber.getSpecialty()) ? barberEntity.getSpecialty() : barber.getSpecialty());
        barberEntity.setImgUrlBarber(checkIsNull(barber.getImgUrlBarber()) ? barberEntity.getImgUrlBarber() : barber.getImgUrlBarber());
        barberEntity.setActive(checkIsNull(barber.getActive()) ? barberEntity.getActive() : barber.getActive());

    }

    private <T> boolean checkIsNull(T data) {
        return data == null;
    }

}