package br.com.convergencia.testejavar1.controller;

import br.com.convergencia.testejavar1.entity.dtos.CpfDTO;
import br.com.convergencia.testejavar1.entity.dtos.StatusCpfDTO;
import br.com.convergencia.testejavar1.service.CpfService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cpf")
public class CpfController {

    private final CpfService cpfService;

    public CpfController(CpfService cpfService) {
        this.cpfService = cpfService;
    }

    @PostMapping
    public ResponseEntity<CpfDTO> saveCpf(@RequestBody CpfDTO cpf){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.cpfService.saveCpf(cpf));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<StatusCpfDTO> findStatusCpf(@PathVariable("cpf") String cpf){
        return ResponseEntity.ok(this.cpfService.findStatusCpf(cpf));
    }
}
