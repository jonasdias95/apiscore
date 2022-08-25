package com.serasa.score.apiscore.service;

import com.serasa.score.apiscore.domain.dto.AfinidadeDTO;
import com.serasa.score.apiscore.domain.dto.PessoaDTO;
import com.serasa.score.apiscore.domain.model.Afinidade;
import com.serasa.score.apiscore.domain.model.Pessoa;
import com.serasa.score.apiscore.repository.AfinidadeRepository;
import com.serasa.score.apiscore.repository.PessoaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
@Slf4j
@Service
public class AfinidadeSevice {

    @Autowired
    private AfinidadeRepository afinidadeRepository;
    public void salvarAfinidade(AfinidadeDTO afinidadeDTO){
        try {
            var afinidade = Afinidade.builder()
                    .regiao(afinidadeDTO.getRegiao())
                    .estados(afinidadeDTO.getEstados().toArray(size -> new String[size]))
                    .build();
            afinidadeRepository.save(afinidade);
        }catch (Exception e){
            log.error("Falha ao salvar dados de afinidade!", e.getMessage());
            e.printStackTrace();
            throw e;
        }

    }

}
