package io.github.barbeariagb.barbearia.repository;

import io.github.barbeariagb.barbearia.entity.Barbeiro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BarbeiroRepository extends JpaRepository<Barbeiro, Long> {
}
