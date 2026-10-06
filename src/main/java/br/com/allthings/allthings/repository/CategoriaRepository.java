package br.com.allthings.allthings.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.allthings.allthings.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
    
}
