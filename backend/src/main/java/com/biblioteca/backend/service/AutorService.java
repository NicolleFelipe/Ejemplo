package com.biblioteca.backend.service;

import com.biblioteca.backend.exception.ResourceNotFoundException;
import com.biblioteca.backend.model.Autor;
import com.biblioteca.backend.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> getAllAutores() {
        return autorRepository.listarAutores();
    }

    public Autor getAutorById(int id) {
        try {
            return autorRepository.obtenerAutorPorId(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("No se encontró el autor con ID: " + id);
        }
    }


    public int crearAutor(String nombre) { return autorRepository.crearAutor(nombre);}

    public int actualizarAutor(int id, String nombre) {
        return autorRepository.actualizarAutor(id, nombre);
    }

    public int eliminarAutor(int id) {
        return autorRepository.eliminarAutor(id);
    }
    public int activarAutor(int id) {
        return autorRepository.activarAutor(id);
    }


}
