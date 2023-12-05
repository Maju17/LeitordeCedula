package com.example.leitorcedula.Security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.leitorcedula.Model.Usuario;
import com.example.leitorcedula.Repository.UsuarioRepository;

public class UsuarioDetailsService implements UserDetailsService{
    @Autowired
    UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario userLogin = usuarioRepository.findByUsername(username);
        if(userLogin == null)
            throw new UsernameNotFoundException(username);
        return new UsuarioDetails(userLogin);
    }
}
