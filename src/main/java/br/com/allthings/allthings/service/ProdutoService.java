package br.com.allthings.allthings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.allthings.allthings.entity.Produto;
import br.com.allthings.allthings.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository; //ta criando um obj do tipo tal nome tal

// métodos
    // salvar produto
    public Produto save (Produto produto){
        return produtoRepository.save(produto);
    }

    // listar produtos(todos)
    public List <Produto> findAll(){
        return produtoRepository.findAll();
    }

    //excluir por id
    public void deleteById(Integer id){
        produtoRepository.deleteById(id);
    }

    //buscar por id
    public Produto findByID(Integer id){
        return produtoRepository.findById(id).orElse(null);
    }
}
