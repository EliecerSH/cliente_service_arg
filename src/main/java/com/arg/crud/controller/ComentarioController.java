package com.arg.crud.controller;

import com.arg.crud.model.Comentarios;
import com.arg.crud.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/comentarios")
@CrossOrigin("*")//permite llamdas desde el froned
public class ComentarioController {

    @Autowired
    private ComentarioRepository repo;

    public ComentarioRepository getRepo() {
        return repo;
    }


    @GetMapping
    public List<Comentarios> findAll() {
        return repo.findAll();
    }

    @GetMapping("{id}")
    public Comentarios findById(@PathVariable int id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("El comentario con el ID: "+ id +" no existe"));
    }

    @PostMapping
    public Comentarios save(@RequestBody Comentarios comentario) {
        return repo.save(comentario);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("El comentario con el ID: " + id + " no existe");
        }
        repo.deleteById(id);
    }

    @PutMapping("{id}")
    public Comentarios update(@PathVariable int id, @RequestBody Comentarios comentario) {
        return repo.findById(id)
                .map(prodExistente -> {

                    prodExistente.setNombre(comentario.getNombre());
                    prodExistente.setContenido(comentario.getContenido());
                    prodExistente.setTematica(comentario.getTematica());

                    return repo.save(prodExistente);
                })
                .orElseThrow(() ->
                        new RuntimeException("El el comentario con ID " + id + " no existe"));
    }


}
