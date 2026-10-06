package br.com.allthings.allthings.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.allthings.allthings.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByLoginUsuario(String loginUsuario);
    
}
