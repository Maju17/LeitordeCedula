package com.example.leitorcedula.Repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.leitorcedula.Model.Usuario;

@Configuration
public class LoadDataInDb implements CommandLineRunner {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Override
    public void run(String... args) throws Exception {
        ArrayList<Usuario> usuariosNovos = new ArrayList<>();
        usuariosNovos.add(new Usuario("Lucas", passwordEncoder.encode("1234")));
        usuariosNovos.add(new Usuario("Maria", passwordEncoder.encode("1234")));
        
        usuarioRepository.saveAll(usuariosNovos);
    }
}