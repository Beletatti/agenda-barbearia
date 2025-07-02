package io.github.barbeariagb.barbearia.repository;

import io.github.barbeariagb.barbearia.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AgendamentoRepository extends JpaRepository<Agendamento, UUID> {
}
