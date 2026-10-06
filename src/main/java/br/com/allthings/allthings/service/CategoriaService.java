package br.com.allthings.allthings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.allthings.allthings.entity.Categoria;
import br.com.allthings.allthings.repository.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria save(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public List <Categoria> findAll(){
        return categoriaRepository.findAll();
    }

    public void deleteById(Integer id){
        categoriaRepository.deleteById(id);
    }

    public Categoria findById(Integer id){
        return categoriaRepository.findById(id).orElse(null);
    }
}
