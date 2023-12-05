package com.example.leitorcedula.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.leitorcedula.Model.Usuario;
import com.example.leitorcedula.Repository.UsuarioRepository;

@RestController
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/conteudo")
    public String getDados(){
        return "Dados retornados com sucesso";
    }

    @GetMapping("/livre")
    public String naoPrecisaDeLogin(@RequestBody Usuario user){
        return "Usuário acessou sem login";
    }

    @PostMapping("/criar")
    public String criarUsuario(@RequestBody Usuario novo){
        novo.setPassword(
            passwordEncoder.encode(novo.getPassword())
        );
        Usuario usuarioCriado = usuarioRepository.save(novo);

        if(usuarioCriado != null)
            return "Usuário criado com sucesso!";        
        
        return "Criação do usuário deu erro.";
    }
}
