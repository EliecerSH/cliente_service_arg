package com.arg.crud.repository;
import com.arg.crud.model.Administradores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradoresRepository extends JpaRepository<Administradores,Integer>{

    boolean existsByCorreo(String correo);
}
