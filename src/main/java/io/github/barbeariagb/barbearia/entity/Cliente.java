package io.github.barbeariagb.barbearia.entity;

import jakarta.persistence.*;
import lombok.Getter; // Garanta que o @Getter está aqui
import lombok.Setter; // E o @Setter também

import java.time.LocalDate;

@Entity
@Table(name = "clientes")
@Getter // <-- Esta anotação cria o getNome(), getTelefone(), etc.
@Setter // <-- Esta anotação cria o setNome(), setTelefone(), etc.
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "telefone", length = 20, unique = true, nullable = false)
    private String telefone;

    @Column(name = "email", length = 100, unique = true)
    private String email;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    // Não precisa escrever os getters e setters manualmente
}