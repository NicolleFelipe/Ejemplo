package com.biblioteca.backend.model;

import jakarta.validation.constraints.NotBlank;

public class Autor {

    private int id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    private int estado;

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEstado() { return estado; }
    public void setEstado(int estado) { this.estado = estado; }
}
