package io.github.barbeariagb.barbearia.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "barbeiros")
public class Barbeiro {

    @Id // Marca este campo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_barbeiro")// Gera o valor do ID automaticamente
    private Long id;

    @Column(name = "nome", length = 100, nullable = false) // Mapeia para a coluna nome
    private String name;

    @Column(name = "especialidade", length = 100)
    private String especialidade;

    @Column(name = "telefone", length = 100)
    private String telefone;

    @Column(name = "email")
    private String email;

    @Column(name = "data_contratacao", nullable = false, updatable = false)
    private LocalDate dataContratacao;

    @Column(name = "ativo", nullable = false)
    private boolean ativo = true;

    // Define a data de contratação para a data atual antes de persistir pela primeira vez
    @PrePersist
    public void prePersist() {
        if (dataContratacao == null) {
            dataContratacao = LocalDate.now();
        }
    }

}

