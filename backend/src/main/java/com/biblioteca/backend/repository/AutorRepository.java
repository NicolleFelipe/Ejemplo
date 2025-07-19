package com.biblioteca.backend.repository;

import com.biblioteca.backend.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class AutorRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Autor> listarAutores() {
        return jdbcTemplate.query(
                "EXEC crudAutor @opcion = 4",
                (rs, rowNum) -> {
                    Autor autor = new Autor();
                    autor.setId(rs.getInt("id"));
                    autor.setNombre(rs.getString("nombre"));
                    autor.setEstado(rs.getInt("estado"));
                    return autor;
                }
        );
    }

    public Autor obtenerAutorPorId(int id) {
        return jdbcTemplate.queryForObject(
                "EXEC crudAutor @id = ?, @opcion = 5",
                new Object[]{id},
                (rs, rowNum) -> {
                    Autor autor = new Autor();
                    autor.setId(rs.getInt("id"));
                    autor.setNombre(rs.getString("nombre"));
                    autor.setEstado(rs.getInt("estado"));
                    return autor;
                }
        );
    }

    public int crearAutor(String nombre) {
        return jdbcTemplate.queryForObject(
                "EXEC crudAutor @nombre = ?, @opcion = 1",
                new Object[]{nombre},
                Integer.class
        );
    }

    public int actualizarAutor(int id, String nombre) {
        return jdbcTemplate.queryForObject(
                "EXEC crudAutor @id = ?, @nombre = ?, @opcion = 2",
                new Object[]{id, nombre},
                Integer.class
        );
    }

    public int eliminarAutor(int id) {
        return jdbcTemplate.queryForObject(
                "EXEC crudAutor @id = ?, @estado = 0, @opcion = 3",
                new Object[]{id},
                Integer.class
        );
    }

    public int activarAutor(int id) {
        return jdbcTemplate.queryForObject(
                "EXEC crudAutor @id = ?, @estado = 1, @opcion = 3",
                new Object[]{id},
                Integer.class
        );
    }



}
