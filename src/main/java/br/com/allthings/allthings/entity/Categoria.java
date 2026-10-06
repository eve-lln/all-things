package br.com.allthings.allthings.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Categoria {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer idCategoria;
    
    @Column(nullable = false, length = 20)
    private String nomeCategoria;

    @Column(nullable = true, length = 200)
    private String descricaoCategoria;
}
