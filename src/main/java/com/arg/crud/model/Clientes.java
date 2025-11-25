package com.arg.crud.model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cliente;
    private String nombre;
    private String apellido;
    private String correo;
    private String clave;
    private String direccion;
    private String telefono;
    private LocalDate fecha_registro;


    private int getId_Cliente(){
        return id_cliente;
    }
    public void setId_Cliente(int id_Cliente){
        this.id_cliente=id_Cliente;
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getApellido(){
        return apellido;
    }
    public void setApellido(String apellido){
        this.apellido=apellido;
    }

    public String getCorreo(){
        return correo;
    }
    public void setCorreo(String correo){
        this.correo=correo;
    }

    public String getClave(){
        return clave;
    }
    public void setClave(String clave){
        this.clave=clave;
    }

    public String getDireccion(){
        return direccion;
    }
    public void setDireccion(String direccion){
        this.direccion=direccion;
    }

    public String getTelefono(){
        return telefono;
    }
    public void setTelefono(String telefono){
        this.telefono=telefono;
    }

    public LocalDate getFecha_registro(){
        return fecha_registro;
    }
    public void setFecha_registro(LocalDate fecha_registro){
        this.fecha_registro=fecha_registro;
    }
}
