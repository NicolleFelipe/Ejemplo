package com.biblioteca.backend.controller;

import com.biblioteca.backend.exception.BadRequestException;
import com.biblioteca.backend.model.Autor;
import com.biblioteca.backend.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public List<Autor> listarAutores() {
        return autorService.getAllAutores();
    }

    @GetMapping("/{id}")
    public Autor obtenerAutorPorId(@PathVariable int id) {
        return autorService.getAutorById(id);
    }

    @PostMapping("/crear")
    public int crearAutor(@Valid @RequestBody Autor autor) {
        if (autor.getNombre() == null || autor.getNombre().trim().isEmpty()) {
            throw new BadRequestException("El campo 'nombre' es obligatorio.");
        }
        return autorService.crearAutor(autor.getNombre());
    }


    @PutMapping("actualizar/{id}")
    public int actualizarAutor(@PathVariable int id, @RequestBody Autor autor) {
        return autorService.actualizarAutor(id, autor.getNombre());
    }

    @PutMapping("/eliminar/{id}")
    public int eliminarAutor(@PathVariable int id) {
        return autorService.eliminarAutor(id);
    }

    @PutMapping("/activar/{id}")
    public int activarAutor(@PathVariable int id) {
        return autorService.activarAutor(id);
    }



}
