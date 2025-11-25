package com.arg.crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Registro_inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_registro;
    private int id_producto;
    private String accion;
    private LocalDate fecha_accion;
    private String usuario;


    private int getId_registro() {
        return id_registro;
    }
    public void setId_registro(int id_registro) {
        this.id_registro = id_registro;
    }

    public int getId_producto() {
        return id_producto;
    }
    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
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
