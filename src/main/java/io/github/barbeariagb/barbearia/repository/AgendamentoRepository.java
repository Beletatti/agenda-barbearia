package io.github.barbeariagb.barbearia.repository;

import io.github.barbeariagb.barbearia.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
