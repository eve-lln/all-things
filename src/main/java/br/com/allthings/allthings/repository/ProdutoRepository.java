package br.com.allthings.allthings.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.allthings.allthings.entity.Produto;

                                // extends quer dizer que herda = herança
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
    
}
