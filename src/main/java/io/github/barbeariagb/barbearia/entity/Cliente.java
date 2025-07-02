package io.github.barbeariagb.barbearia.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clientes")
public class Cliente {

    @Id // Marca este campo como chave primária
    @GeneratedValue(strategy = GenerationType.AUTO) // Gera o valor do ID automaticamente
    private UUID id;

    @Column(name = "nome", length = 100, nullable = false) // Mapeia para a coluna nome
    private String nome;

    @Column(name = "telefone", length = 20, unique = true, nullable = false)
    private String telefone;

    @Column(name = "email", length = 100, unique = true)
    private String email;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "data_cadastro", nullable = false, updatable = false)
    private LocalDateTime dataCadastro;
}
