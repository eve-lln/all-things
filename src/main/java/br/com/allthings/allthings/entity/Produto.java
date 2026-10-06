package br.com.allthings.allthings.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Produto {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer idProduto;

    @Column(nullable = false, length = 40)
    private String nomeProduto;

    @Column(nullable = false, length = 40)
    private String descricaoProduto;

    @Column(nullable = false, length = 40)
    private String marcaProduto;

    @Column(nullable = false, length = 40)
    private String modeloProduto;

    @Column(nullable = false, length = 10)
    private String unidadeProduto;

    @Column(nullable = false)
    private double valorProduto;

    // muitos produtos para um unico fornecedor
    @ManyToOne
    @JoinColumn(name = "idFornecedor_fk")
    private Fornecedor fornecedor;

    @ManyToOne
    @JoinColumn (name = "idCategoria_fk")
    private Categoria categoria;

}