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
        return cliRepo.findById(id).get();
    }

    @PostMapping
    public Clientes save(@RequestBody Clientes clientes){
        return cliRepo.save(clientes);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id){
        cliRepo.deleteById(id);
    }

    @PutMapping("{id}")
    public Clientes update(@PathVariable Integer id, @RequestBody Clientes clientes){
        return cliRepo.save(clientes);
    }

}
