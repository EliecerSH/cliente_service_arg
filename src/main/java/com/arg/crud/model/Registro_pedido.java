package com.arg.crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Registro_pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_registro_pedido;
    private int id_pedido;
    private String accion;
    private LocalDate fecha_accion;
    private String usuario;


    public int getId_registro_pedido() {
        return id_registro_pedido;
    }
    public void setId_registro_pedido(int id_registro_pedido) {
        this.id_registro_pedido = id_registro_pedido;
    }

    public int getId_pedido() {
        return id_pedido;
    }
    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
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
