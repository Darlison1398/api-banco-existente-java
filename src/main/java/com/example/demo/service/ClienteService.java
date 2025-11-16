package com.example.demo.service;

import com.example.demo.model.ClienteModel;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteModel registrarCliente(ClienteModel clienteModel){
        ClienteModel cliende = clienteRepository.save(clienteModel);
        return  cliende;
    }
}
