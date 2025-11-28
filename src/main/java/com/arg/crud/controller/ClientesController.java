package com.arg.crud.controller;
import com.arg.crud.model.Clientes;
import com.arg.crud.repository.ClientesRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/v1/clientes")
@CrossOrigin("*")

public class ClientesController {

    private ClientesRepository cliRepo;

    public ClientesController(ClientesRepository cliRepo) {
        this.cliRepo = cliRepo;
    }

    //-------------------------------------metodos de cliente----------------------------------------------------------

    @GetMapping
    public List<Clientes> findAll(){
        return cliRepo.findAll();
    }

    @GetMapping("{id}")
    public Clientes findById(@PathVariable Integer id){
        return cliRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente con ID " + id + " no existe"));

    }

    @PostMapping
    public Clientes save(@RequestBody Clientes clientes){
        return cliRepo.save(clientes);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id){
        if (!cliRepo.existsById(id)) {
            throw new RuntimeException("El cliente con ID " + id + " no existe");
        }
        cliRepo.deleteById(id);
    }

    @PutMapping("{id}")
    public Clientes update(@PathVariable Integer id, @RequestBody Clientes clientes){
        return cliRepo.findById(id)
                .map(cliExistente -> {
                    cliExistente.setNombre(clientes.getNombre());
                    cliExistente.setApellido(clientes.getApellido());
                    cliExistente.setCorreo(clientes.getCorreo());
                    cliExistente.setDireccion(clientes.getDireccion());
                    cliExistente.setClave(clientes.getClave());
                    cliExistente.setTelefono(clientes.getTelefono());
                    cliExistente.setFecha_registro(clientes.getFecha_registro());
                    return cliRepo.save(cliExistente);
                })
                .orElseThrow(() -> new RuntimeException("Cliente con ID " + id + " no existe"));
    }

}
