package com.example.leitorcedula.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.context.annotation.Configuration;

import com.example.leitorcedula.Model.Usuario;

@Configuration
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
        public Usuario findByUsername(String username);
}
