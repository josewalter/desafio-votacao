package com.dbserver.votacao.votacao.service;

import com.dbserver.votacao.votacao.model.Cliente;
import com.dbserver.votacao.votacao.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvarCliente(Cliente cliente) {
        /*
        for (int i = 0; i < cliente.getCpf().length(); i++) {
            try {
                cliente.getCpf().getBytes(String.valueOf(i)).toString();
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
            cliente.getNomeCliente().chars().toString();
        }
       */
        clienteRepository.save(cliente);
        System.out.println("O cliente" + cliente + ", foi salva com sucesso!!");
        return cliente;
    }

    public List<Cliente> getAll(){
        return clienteRepository.findAll();
    }
}
