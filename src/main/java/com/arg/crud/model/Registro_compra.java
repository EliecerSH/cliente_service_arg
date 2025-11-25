package com.arg.crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Registro_compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_registro_compra;
    private int id_compra;
    private String accion;
    private LocalDate fecha_accion;
    private String usuario;


    private int getId_registro_compra() {
        return id_registro_compra;
    }
    public void setId_registro_compra(int id_registro_compra) {
        this.id_registro_compra = id_registro_compra;
    }

    public int getId_compra() {
        return id_compra;
    }
    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public String getAccion() {
        return accion;
    }
    public void setAccion(String accion) {
        this.accion = accion;
    }

    public LocalDate getFecha_accion() {
        return fecha_accion;
    }

    public void setFecha_accion(LocalDate fecha_accion) {
        this.fecha_accion = fecha_accion;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
