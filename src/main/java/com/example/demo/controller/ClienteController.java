package com.example.demo.controller;

import com.example.demo.model.ClienteModel;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    public ClienteController(ClienteRepository clienteRepository, ClienteService clienteService){
        this.clienteRepository = clienteRepository;
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<ClienteModel> listaDeCliente(){
        return  clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ClienteModel clientePeloId(@PathVariable Long id){
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> createCliente(@RequestBody ClienteModel cliente){
        try {
            clienteService.registrarCliente(cliente);
            return ResponseEntity.ok("Cliente registrado com sucesso!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
