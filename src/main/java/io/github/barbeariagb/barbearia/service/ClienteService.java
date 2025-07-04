package io.github.barbeariagb.barbearia.service;

import io.github.barbeariagb.barbearia.entity.Cliente;
import io.github.barbeariagb.barbearia.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Transactional(readOnly = true)
    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Cliente> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Cliente salvar(Cliente cliente) {
        // Você pode adicionar lógicas de validação aqui antes de salvar
        return repository.save(cliente);
    }

    @Transactional
    public void deletar(Long id) {
        // Adicionar verificação se o cliente existe antes de deletar seria uma boa prática
        repository.deleteById(id);
    }


}
