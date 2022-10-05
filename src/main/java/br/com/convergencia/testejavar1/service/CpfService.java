package br.com.convergencia.testejavar1.service;

import br.com.convergencia.testejavar1.entity.dtos.CpfDTO;
import br.com.convergencia.testejavar1.entity.dtos.StatusCpfDTO;

public interface CpfService {

    CpfDTO saveCpf(CpfDTO cpf);

    StatusCpfDTO findStatusCpf(String cpf);
}
