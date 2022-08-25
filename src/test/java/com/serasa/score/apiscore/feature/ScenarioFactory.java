package com.serasa.score.apiscore.feature;

import com.serasa.score.apiscore.domain.dto.PessoaDTO;

import java.util.ArrayList;
import java.util.List;

public class ScenarioFactory {
    public static List<PessoaDTO> retornaListaPessoa(){
        return  List.of(PessoaDTO.builder()
                        .nome("")
                .build());
    }
    public static PessoaDTO retornaListaPessoaPorId(){
        var estado = new String[1];
        return  PessoaDTO.builder()
                .nome("")
                .estados(estado)
                .idade(10)
                .build();
    }
}
