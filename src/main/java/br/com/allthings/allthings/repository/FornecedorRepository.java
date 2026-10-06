package br.com.allthings.allthings.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.allthings.allthings.entity.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer>{
    
}
