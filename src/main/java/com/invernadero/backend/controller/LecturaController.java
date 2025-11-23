package com.invernadero.backend.controller;

import com.invernadero.backend.model.Lectura;
import com.invernadero.backend.repository.LecturaRepository;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/lecturas")
@CrossOrigin(origins = "*")
public class LecturaController {

    private final LecturaRepository repo;

    public LecturaController(LecturaRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Lectura> listar() {
        return repo.findAll();
    }

    @GetMapping("/ultima")
    public Lectura ultima() {
        return repo.findTopByOrderByFechaHoraDesc().orElse(null);
    }

    @PostMapping
    public Lectura crear(@RequestBody Lectura lectura) {
        if (lectura.getFechaHora() == null) {
            lectura.setFechaHora(OffsetDateTime.now());
        }
        return repo.save(lectura);
    }
}

