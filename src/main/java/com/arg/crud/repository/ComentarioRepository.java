package com.arg.crud.repository;
import com.arg.crud.model.Comentarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentarios, Integer> {
}
