package br.com.convergencia.testejavar1.service.impl;

import br.com.convergencia.testejavar1.entity.Cpf;
import br.com.convergencia.testejavar1.entity.dtos.CpfDTO;
import br.com.convergencia.testejavar1.entity.dtos.StatusCpfDTO;
import br.com.convergencia.testejavar1.entity.enums.StatusEnum;
import br.com.convergencia.testejavar1.exceptions.InvalidCpfException;
import br.com.convergencia.testejavar1.repository.CpfRepository;
import br.com.convergencia.testejavar1.service.CpfService;
import br.com.convergencia.testejavar1.util.CpfValidator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CpfServiceImpl implements CpfService {

    private final CpfRepository cpfRepository;

    public CpfServiceImpl(CpfRepository cpfRepository) {
        this.cpfRepository = cpfRepository;
    }

    @Override
    public CpfDTO saveCpf(CpfDTO cpf) {

        consultCPF(cpf.getCpf());

        this.cpfRepository.save(Cpf.builder()
                .cpf(cpf.getCpf())
                .status(StatusEnum.ATIVO)
                .build());
        return cpf;
    }

    @Override
    public StatusCpfDTO findStatusCpf(String cpf) {

        Optional<Cpf> byCpf = this.cpfRepository.findByCpf(cpf);

        if (byCpf.isEmpty() || !CpfValidator.isValid(cpf))
            throw new InvalidCpfException("CPF inválido!");

        return new StatusCpfDTO(cpf, byCpf.get().getStatus());
    }

    private void consultCPF(String cpf) {

        Optional<Cpf> byCpf = this.cpfRepository.findByCpf(cpf);

        if (!CpfValidator.isValid(cpf)) {
            throw new InvalidCpfException("CPF invalido!");
        }

        if (byCpf.isPresent()) {
            throw new InvalidCpfException("CPF já cadastrado!");
        }

    }
}
