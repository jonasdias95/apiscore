package com.serasa.score.apiscore.feature;

import com.serasa.score.apiscore.domain.dto.AfinidadeDTO;
import com.serasa.score.apiscore.domain.dto.PessoaDTO;
import com.serasa.score.apiscore.domain.dto.PessoaRequestDTO;
import com.serasa.score.apiscore.domain.dto.ScoreDTO;
import com.serasa.score.apiscore.domain.model.Afinidade;
import com.serasa.score.apiscore.domain.model.Pessoa;
import com.serasa.score.apiscore.domain.model.Score;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class ScenarioFactory {
    public static List<PessoaDTO> retornaListaPessoa(){
        var estado = new String[1];
        return  List.of(PessoaDTO.builder()
                        .nome("teste")
                        .cidade("")
                        .estado("SP")
                        .scoreDescricao("recomendavel")
                        .estados(estado)
                .build());
    }
    public static PessoaDTO retornaListaPessoaPorId(){
        var estado = new String[1];
        return  PessoaDTO.builder()
                .nome("teste")
                .telefone("11111111")
                .idade(20)
                .scoreDescricao("recomendavel")
                .estados(estado)
                .build();
    }
    public static PessoaRequestDTO retornaPessoaRequestDTO(){
        return  PessoaRequestDTO.builder()
                .nome("teste")
                .cidade("teste")
                .telefone("111111111")
                .regiao("suldeste")
                .estado("SP")
                .idade(10)
                .score(100)
                .build();
    }
    public static PessoaRequestDTO retornaPessoaRequestDTOInvalido(){
        return  PessoaRequestDTO.builder()
                .nome("teste")
                .cidade("teste")
                .telefone("111111111")
                .regiao("suldeste")
                .estado("SP")
                .build();
    }
    public static AfinidadeDTO retornaAfinidadeDTO(){
        return  AfinidadeDTO.builder()
                .estados(List.of("SP","RJ"))
                .regiao("Suldeste")
                .build();
    }
    public static AfinidadeDTO retornaAfinidadeDTOInvalido(){
        return  AfinidadeDTO.builder().build();
    }
    public static ScoreDTO retornaScoreDTO(){
        return  ScoreDTO.builder()
                .descricao("teste")
                .ifinal(1000)
                .inicial(0)
                .build();
    }
    public static ScoreDTO retornaScoreDTOInvalido(){
        return  ScoreDTO.builder()
                .build();
    }
    public static List<Afinidade> retornaRegioesAfinidade(){
        var estado = new String[1];
        estado[0] = "SP";
        return  List.of(Afinidade.builder()
                .regiao("suldeste")
                        .estados(estado)
                .build());
    }
    public static List<Score> retornaListaScore(){
        return  List.of(Score.builder()
                        .inicial(0)
                        .ifinal(1000)
                        .descricao("teste")
                .build());
    }
    public static Optional<Pessoa> retronarPessoaPorID(){
        return Optional.of(Pessoa.builder()
                        .data(LocalDate.now())
                        .id(1)
                        .nome("jonas")
                        .idade(27)
                        .score(700)
                        .telefone("1111111")
                        .estado("SP")
                .regiao("suldeste")
                .build());
    }
    public static List<Pessoa> retornaListaPessoas(){
        return  List.of(Pessoa.builder()
                        .id(1)
                        .data(LocalDate.now())
                        .cidade("teste")
                        .estado("SP")
                        .score(1000)
                        .regiao("suldeste")
                .build());
    }
}
