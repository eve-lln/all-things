package br.com.allthings.allthings.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.allthings.allthings.entity.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente, Integer>{
    
}
