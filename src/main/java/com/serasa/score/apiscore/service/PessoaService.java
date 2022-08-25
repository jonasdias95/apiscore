package com.serasa.score.apiscore.service;

import com.serasa.score.apiscore.domain.dto.PessoaDTO;
import com.serasa.score.apiscore.domain.model.Afinidade;
import com.serasa.score.apiscore.domain.model.Pessoa;
import com.serasa.score.apiscore.domain.model.Score;
import com.serasa.score.apiscore.repository.AfinidadeRepository;
import com.serasa.score.apiscore.repository.PessoaRepository;
import com.serasa.score.apiscore.repository.ScoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private AfinidadeRepository afinidadeRepository;

    @Autowired
    private ScoreRepository scoreRepository;
    public void salvarPessoa(PessoaDTO pessoaDTO){
        try {
            log.info("Iniciando pessistencia de daados da Pessoa");
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
            log.info("Finalizado a pessistencia da Pessoa com sucesso!", pessoaDTO);
        }catch (Exception e){
            log.error("Falha ao salvar dados de pessoa!", e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
    public PessoaDTO buscarPessoaPorId (Integer id){
        try {
            log.info("Iniciando a busca de pessoa por id.");
            Pessoa pessoa= pessoaRepository.findById(id).orElseThrow(()-> new RuntimeException("Não encontrado"));

            var pessoaResponse= PessoaDTO.builder()
                    .nome(pessoa.getNome())
                    .telefone(pessoa.getTelefone())
                    .idade(pessoa.getIdade())
                    .scoreDescricao(recuperarScoreDescricao(pessoa.getScore()))//TODO fazer logica
                    .estados(recuperarEstados(pessoa.getRegiao()))//TODO fazer logica
                    .build();
            log.info("Finalizado a busca de pessoa por id com sucesso.", pessoaResponse);
            return pessoaResponse;
        }catch (Exception e){
            log.error("Falha ao buscar dados de pessoa!", e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
    public List<PessoaDTO> buscarPessoas (){
        try {
            List<PessoaDTO> listapessoa = new ArrayList<>();
            List<Pessoa> list = pessoaRepository.findAll();
            for (Pessoa pessoa:list) {
                var pessoaResponse= PessoaDTO.builder()
                        .nome(pessoa.getNome())
                        .cidade(pessoa.getCidade())
                        .estado(pessoa.getEstado())
                        .scoreDescricao(recuperarScoreDescricao(pessoa.getScore()))//TODO fazer logica
                        .estados(recuperarEstados(pessoa.getRegiao()))//TODO fazer logica
                        .build();
                listapessoa.add(pessoaResponse);
            }
            if (listapessoa.isEmpty())
                throw new RuntimeException("Nunhum registro encontrado");

            return listapessoa;
        }catch (Exception e){
            log.error("Falha ao buscar dados de pessoas!", e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
    public String recuperarScoreDescricao(Integer scorePessoa){
        String descricao = "";
        var listaScore = scoreRepository.findAll();
        for (Score score : listaScore) {
            if (score.getInicial() >= scorePessoa ||
                    score.getIfinal() <= scorePessoa)
                descricao = score.getDescricao();
        }
        return descricao;
    }
    public String[] recuperarEstados(String regiao){
        var listaAfinidade= afinidadeRepository.findByRegiao(regiao);
        for (Afinidade afinidade : listaAfinidade) {
            if (afinidade.getRegiao().equals(regiao))
                return afinidade.getEstados();
        }
        return null;
    }

}
