package io.github.barbeariagb.barbearia.repository;

import io.github.barbeariagb.barbearia.entity.Servico;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface ServicoRepository extends PagingAndSortingRepository<Servico, UUID> {
}
