package br.com.allthings.allthings.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Fornecedor {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer idFornecedor;

    @Column(nullable = false, length = 40)
    private String nomeFornecedor;

    @Column(nullable = false, length = 40)
    private String enderecoFornecedor;

    @Column(nullable = false, length = 40)
    private String cidadeFornecedor;

    @Column(nullable = false, length = 40)
    private String estadoFornecedor;

    @Column(nullable = false, length = 40)
    private String cepFornecedor;

    @Column(nullable = false, length = 40)
    private String cnpjFornecedor;
}
