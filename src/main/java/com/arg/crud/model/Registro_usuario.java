package com.arg.crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Registro_usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_registro_usuario;
    private int id_cliente;
    private String accion;
    private LocalDate fecha_accion;
    private String usuario;


    private int getId_registro_usuario() {
        return id_registro_usuario;
    }
    public void setId_registro_usuario(int id_registro_usuario) {
        this.id_registro_usuario = id_registro_usuario;
    }

    public int getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
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
