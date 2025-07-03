package io.github.barbeariagb.barbearia.entity;

import io.github.barbeariagb.barbearia.enums.StatusAgendamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Entidade que representa a tabela 'agendamentos' no banco de dados.
 * Esta é a entidade principal que conecta clientes, barbeiros e serviços.
 */
@Entity
@Table(name = "agendamentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agendamento")
    private Long id;

    // --- Relacionamentos ---

    // Muitos agendamentos podem pertencer a UM cliente.
    // FetchType.LAZY é uma boa prática para performance, carregando o cliente apenas quando necessário.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false) // Mapeia a chave estrangeira
    private Cliente cliente;

    // Muitos agendamentos podem ser de UM barbeiro.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_barbeiro", nullable = false)
    private Barbeiro barbeiro;

    // Muitos agendamentos podem ser para UM serviço.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_servico", nullable = false)
    private Servico servico;

    // --- Campos de Data e Hora ---

    // Mapeia para: data_hora_inicio TIMESTAMP WITH TIME ZONE NOT NULL
    // OffsetDateTime é o tipo Java recomendado para colunas com fuso horário.
    @Column(name = "data_hora_inicio", nullable = false)
    private OffsetDateTime dataHoraInicio;

    @Column(name = "data_hora_fim", nullable = false)
    private OffsetDateTime dataHoraFim;

    // Mapeia para: data_criacao TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
    @Column(name = "data_criacao", nullable = false, updatable = false)
    private OffsetDateTime dataCriacao;

    // --- Outros Campos ---

    // Mapeia para: status VARCHAR(20) NOT NULL DEFAULT 'AGENDADO'
    // Usar um Enum é mais seguro e limpo do que uma String.
    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20, nullable = false)
    private StatusAgendamento status;

    // Mapeia para: observacoes TEXT
    @Lob
    @Column(name = "observacoes")
    private String observacoes;


    /**
     * Define a data de criação para a data/hora atual antes de persistir
     * a entidade pela primeira vez no banco de dados.
     */
    @PrePersist
    public void prePersist() {
        if (dataCriacao == null) {
            dataCriacao = OffsetDateTime.now();
        }
    }
}