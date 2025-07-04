package io.github.barbeariagb.barbearia.controller;

import io.github.barbeariagb.barbearia.entity.Cliente;
import io.github.barbeariagb.barbearia.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Essencial: Define que esta classe é um controller REST e retorna JSON
@RequestMapping("/api/clientes") // URL base para todos os endpoints de cliente
public class ClienteController {

    @Autowired
    private ClienteService service;

    // Endpoint para LISTAR TODOS os clientes (GET /api/clientes)
    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodos() {
        List<Cliente> clientes = service.listarTodos();
        return ResponseEntity.ok(clientes);
    }

    // Endpoint para BUSCAR UM cliente por ID (GET /api/clientes/{id})
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(cliente -> ResponseEntity.ok(cliente)) // Se encontrar, retorna 200 OK com o cliente
                .orElse(ResponseEntity.notFound().build()); // Se não, retorna 404 Not Found
    }

    // Endpoint para CRIAR um novo cliente (POST /api/clientes)
    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente) {
        Cliente novoCliente = service.salvar(cliente);
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED); // Retorna 201 Created
    }

    // Endpoint para ATUALIZAR um cliente (PUT /api/clientes/{id})
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente clienteDetails) {
        return service.buscarPorId(id)
                .map(clienteExistente -> {
                    clienteExistente.setNome(clienteDetails.getNome());
                    clienteExistente.setTelefone(clienteDetails.getTelefone());
                    clienteExistente.setEmail(clienteDetails.getEmail());
                    clienteExistente.setDataNascimento(clienteDetails.getDataNascimento());
                    Cliente clienteAtualizado = service.salvar(clienteExistente);
                    return ResponseEntity.ok(clienteAtualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para DELETAR um cliente (DELETE /api/clientes/{id})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build(); // Retorna 404 se o cliente não existe
        }
        service.deletar(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content, indicando sucesso
    }
}
