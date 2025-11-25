package com.arg.crud.controller;

import com.arg.crud.model.*;
import com.arg.crud.repository.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@CrossOrigin("*")
public class AdministadoresController {

    private AdministradoresRepository admRepo;
    private RegistroCompraRepository reCompRepo;
    private RegistroInventarioRepository invRepo;
    private RegistroPedidoRepository pedRepo;
    private RegistroUsuarioRepository userRepo;

    public AdministadoresController(AdministradoresRepository admRepo, RegistroCompraRepository reCompRepo, RegistroInventarioRepository invRepo, RegistroPedidoRepository pedRepo, RegistroUsuarioRepository userRepo) {
        this.admRepo = admRepo;
        this.reCompRepo = reCompRepo;
        this.invRepo = invRepo;
        this.pedRepo = pedRepo;
        this.userRepo = userRepo;

    }


    //-------------------------------------------metodo admin-----------------------------------------------------------

    @GetMapping
    public List<Administradores> findAll() {
        return admRepo.findAll();
    }

    @GetMapping("{id}")
    public Administradores findOne(@PathVariable Integer id) {
        return admRepo.findById(id).orElseThrow(() -> new RuntimeException("El administrador con id: "+id+" no existe"));
    }

    @PostMapping
    public Administradores create(@RequestBody Administradores adm) {
        return admRepo.save(adm);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        if (!admRepo.existsById(id)) {
            throw new RuntimeException("El administrador con id: "+id+" no existe");
        }
        admRepo.deleteById(id);
    }

    @PutMapping("{id}")
    public Administradores update(@PathVariable Integer id, @RequestBody Administradores adm) {

        Administradores actual = admRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("El administrador con id: " + id + " no existe"));

        // Validar duplicidad de correo si se cambia
        if (!actual.getCorreo().equals(adm.getCorreo())) {
            if (admRepo.existsByCorreo(adm.getCorreo())) {
                throw new RuntimeException("El correo '" + adm.getCorreo() + "' ya está registrado");
            }
        }

        actual.setNombre(adm.getNombre());
        actual.setApellido(adm.getApellido());
        actual.setCorreo(adm.getCorreo());
        actual.setUsuario(adm.getUsuario());
        actual.setPassword(adm.getPassword());
        actual.setFecha_creacion(adm.getFecha_creacion());
        actual.setActivo(adm.getActivo());

        return admRepo.save(actual);
    }

    //--------------------------------------metodos de registro compra-------------------------------------------------

    @GetMapping("/registro_compra")
    public List<Registro_compra> findAllRegistroCompra() {
        return reCompRepo.findAll();
    }

    @GetMapping("/registro_compra/{id}")
    public Registro_compra findRegistroCompraById(@PathVariable Integer id) {
        return reCompRepo.findById(id).orElseThrow(() -> new RuntimeException("El administrador con id: "+id+" no existe"));
    }

    //-----------------------------------metodos de registro inventario ------------------------------------------------

    @GetMapping("/registro_inventario")
    public List<Registro_inventario> findAllRegistroInventario() {
        return invRepo.findAll();
    }

    @GetMapping("/registro_inventario/{id}")
    public Registro_inventario findRegistroInventarioById(@PathVariable Integer id) {
        return invRepo.findById(id).orElseThrow(() -> new RuntimeException("El administrador con id: "+id+" no existe"));
    }

    //---------------------------------metodos de registro pedido ------------------------------------------------------

    @GetMapping("/registro_pedido")
    public List<Registro_pedido> findAllRegistroPedido() {
        return pedRepo.findAll();
    }

    @GetMapping("/registro_pedido/{id}")
    public Registro_pedido findRegistroPedidoById(@PathVariable Integer id) {
        return pedRepo.findById(id).orElseThrow(() -> new RuntimeException("El administrador con id: "+id+" no existe"));
    }

    //-------------------------------------METODOS REGISTRO usuario -----------------------------------------------------

    @GetMapping("/registro_usuario")
    public List<Registro_usuario> findAllRegistroUsuario() {
        return userRepo.findAll();
    }

    @GetMapping("/registro_usuario/{id}")
    public Registro_usuario findRegistroUsuarioById(@PathVariable Integer id) {
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException("El administrador con id: "+id+" no existe"));
    }
}
