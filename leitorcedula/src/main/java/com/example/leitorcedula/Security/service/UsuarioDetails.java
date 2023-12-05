package com.example.leitorcedula.Security.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.leitorcedula.Model.Usuario;

public class UsuarioDetails implements UserDetails {
    private Usuario usuarioApp;

    public UsuarioDetails(Usuario Usuario){
        this.usuarioApp = Usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.usuarioApp.getPassword();
    }

    @Override
    public String getUsername() {
        return this.usuarioApp.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
