//package com.dbserver.votacao.votacao.controller;
//
//import com.dbserver.votacao.votacao.model.Cliente;
//import com.dbserver.votacao.votacao.model.Sessao;
//import com.dbserver.votacao.votacao.service.SessaoService;
//import com.dbserver.votacao.votacaoutil.ValidacaoCpf;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping
//public class SessaoController {
//    @Autowired
//    private SessaoService sessaoService;
//
//    @ResponseBody
//    @PostMapping("/sessoes")
//    public ResponseEntity<Cliente> salvarSessao(@RequestBody @Valid  Cliente cliente) throws Exception {
//
//        if (cliente == null) {
//            throw new Exception("Cliente não pode ser NULL");
//        }
//
//        if (cliente.getIdCliente() == null && sessaoService.salvarSessao(cliente.getCpf()) != null){
//           throw new Exception("status: UNABLE_TO_VOTE" + cliente.getCpf());
//        }
//
//        if (!ValidacaoCpf.isCPF(cliente.getCpf())) {
//            throw new Exception("CPF : " + cliente.getCpf() + "status: UNABLE_TO_VOTE");
//            return new  ResponseEntity<Cliente>(cliente, HttpStatus.NOT_FOUND);
//        }else {
//            cliente = sessaoService.salvarSessao();
//            return new  ResponseEntity<Cliente>(cliente, HttpStatus.OK);
//        }
//   }
//
//    @GetMapping("/sessoes")
//    public ResponseEntity<List<Sessao>> getAllSessao() {
//        return ResponseEntity.status(HttpStatus.OK).body(sessaoService.getAll());
//    }
//}
