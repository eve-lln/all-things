package br.com.allthings.allthings.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idUsuario;

    @Column(nullable = false, length = 40)
    private String nomeUsuario;

    @Column (nullable = false, length = 100)
    private String loginUsuario;

    @Column (nullable = false, length = 100)
    private String senhaUsuario;

    @Column (nullable = false, length = 20)
    private String CPFUsuario;

    @Column (nullable = false, length = 100)
    private String emailUsuario;

    private String role = "ROLE_USER";

}
