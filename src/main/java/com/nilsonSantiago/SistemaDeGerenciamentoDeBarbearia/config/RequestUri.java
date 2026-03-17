package com.nilsonSantiago.SistemaDeGerenciamentoDeBarbearia.config;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class RequestUri {

    private final URI uri;

    public RequestUri(String path, Long idEntity) {
        this.uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path(path)
                .buildAndExpand(idEntity)
                .toUri();
    }

    public URI getUri() {
        return uri;
    }
}