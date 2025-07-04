package io.github.barbeariagb.barbearia.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "servicos")
@Getter
@Setter
@NoArgsConstructor // Gera um construtor sem argumentos, exigido pelo JPA
@AllArgsConstructor // Gera um construtor com todos os argumentos, útil para criação de objetos
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servico")
    private Long id;

    // Mapeia para: nome VARCHAR(100) NOT NULL UNIQUE
    @Column(name = "nome", length = 100, nullable = false, unique = true)
    private String nome;

    // Mapeia para: descricao TEXT
    @Lob
    @Column(name = "descricao")
    private String descricao;

    // Mapeia para: preco NUMERIC(10, 2) NOT NULL
    @Column(name = "preco", nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    // Mapeia para: duracao_estimada_min INT NOT NULL
    @Column(name = "duracao_estimada_min", nullable = false)
    private Integer duracaoEstimadaMin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getDuracaoEstimadaMin() {
        return duracaoEstimadaMin;
    }

    public void setDuracaoEstimadaMin(Integer duracaoEstimadaMin) {
        this.duracaoEstimadaMin = duracaoEstimadaMin;
    }
}