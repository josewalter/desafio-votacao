package com.dbserver.votacao.votacao.service;

import com.dbserver.votacao.votacao.model.Cliente;
import com.dbserver.votacao.votacao.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvarCliente(Cliente cliente) {

        clienteRepository.save(cliente);
        System.out.println("O cliente" + cliente + ", foi salva com sucesso!!");
        return cliente;
    }

    public List<Cliente> getAll(){
        return clienteRepository.findAll();
    }
}
