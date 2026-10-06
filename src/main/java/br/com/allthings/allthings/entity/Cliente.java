package br.com.allthings.allthings.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Entity
@Data
public class Cliente {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer idCliente;

    @Column(nullable = false, length = 40)
    private String nomeCliente;

    @Column(nullable = false, length = 40)
    private String enderecoCliente;

    @Column(nullable = false, length = 40)
    private String cidadeCliente;

    @Column(nullable = false, length = 2)
    private String estadoCliente;

    @Column(nullable = false, length = 20)
    private String cepCliente;

    @Column(nullable = false, length = 20)
    private String cpfCliente;

    @Column(nullable = false, length = 20)
    private String rgCliente;

    // Large Object: Indica que o dado é grande demais para tipos normais (como VARCHAR ou INT).
        // Se for String ou caracteres, vira um CLOB (Character Large Object).
        // byte[], arquivos ou objetos serializados, vira um BLOB (Binary Large Object).
    @Lob
    private byte[] fotoCliente;

    @Column(length = 50)
    private String tipoFoto;

}