package io.github.barbeariagb.barbearia.repository;

import io.github.barbeariagb.barbearia.entity.Servico;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ServicoRepository extends PagingAndSortingRepository<Servico, Long> {
    Optional<Servico> findById(Long id);

    Servico save(Servico servico);

    boolean existsById(Long id);

    void deleteById(Long id);

    List<Servico> findAll();
}
