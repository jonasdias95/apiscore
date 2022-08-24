package com.serasa.score.apiscore.service;

import com.serasa.score.apiscore.domain.dto.PessoaDTO;
import com.serasa.score.apiscore.domain.model.Afinidade;
import com.serasa.score.apiscore.domain.model.Pessoa;
import com.serasa.score.apiscore.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;
    public void salvarPessoa(PessoaDTO pessoaDTO){
        try {
            var pessoa =Pessoa.builder()
                    .data(LocalDate.now())
                    .nome(pessoaDTO.getNome())
                    .idade(pessoaDTO.getIdade())
                    .telefone(pessoaDTO.getTelefone())
                    .cidade(pessoaDTO.getCidade())
                    .estado(pessoaDTO.getEstado())
                    .regiao(pessoaDTO.getRegiao())
                    .score(pessoaDTO.getScore())
                    .build();
            pessoaRepository.save(pessoa);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
