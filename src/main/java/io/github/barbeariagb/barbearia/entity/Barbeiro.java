package io.github.barbeariagb.barbearia.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "barbeiros")
@Getter // <-- Adicione esta anotação para criar o getId() e outros getters
@Setter // <-- Adicione esta para criar os setters
public class Barbeiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_barbeiro")
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "especialidade", length = 100)
    private String especialidade;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "email", length = 100, unique = true)
    private String email;

    @Column(name = "data_contratacao", nullable = false, updatable = false)
    private LocalDate dataContratacao;

    @Column(name = "ativo", nullable = false)
    private boolean ativo = true;

    // Não é mais necessário o @PrePersist aqui, pois a lógica está no Service


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

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
