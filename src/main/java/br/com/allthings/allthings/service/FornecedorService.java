package br.com.allthings.allthings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.allthings.allthings.entity.Fornecedor;
import br.com.allthings.allthings.repository.FornecedorRepository;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor save (Fornecedor fornecedor){
        return fornecedorRepository.save(fornecedor);
    }

    public List <Fornecedor> findAll(){
        return fornecedorRepository.findAll();
    }

    public void deleteById(Integer id){
        fornecedorRepository.deleteById(id);
    }

    public Fornecedor findByID(Integer id){
        return fornecedorRepository.findById(id).orElse(null);
    }
}
