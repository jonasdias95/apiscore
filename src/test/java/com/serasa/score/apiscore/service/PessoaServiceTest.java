package com.serasa.score.apiscore.service;

import com.serasa.score.apiscore.configuration.exception.NoContentException;
import com.serasa.score.apiscore.configuration.exception.NotFoundException;
import com.serasa.score.apiscore.domain.model.Pessoa;
import com.serasa.score.apiscore.feature.ScenarioFactory;
import com.serasa.score.apiscore.repository.AfinidadeRepository;
import com.serasa.score.apiscore.repository.PessoaRepository;
import com.serasa.score.apiscore.repository.ScoreRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class PessoaServiceTest {
    @InjectMocks
    private PessoaService pessoaService;
    @Mock
    private PessoaRepository pessoaRepository;
    @Mock
    private AfinidadeSevice afinidadeSevice;
    @Mock
    private AfinidadeRepository afinidadeRepository;
    @Mock
    private ScoreSevice scoreSevice;
    @Mock
    private ScoreRepository scoreRepository;

    @Test
    @DisplayName("Deve salvar pessoa com sucesso")
    void deveSalvarPessoaSucesso(){
        when(afinidadeRepository.findByRegiao(anyString())).thenReturn(ScenarioFactory.retornaRegioesAfinidade());
        when(scoreRepository.findAll()).thenReturn(ScenarioFactory.retornaListaScore());
        pessoaService.salvarPessoa(ScenarioFactory.retornaPessoaRequestDTO());
        verify(pessoaRepository).save(any());
    }
    @Test
    @DisplayName("Deve salvar pessoa com erro, não tem regiao ou score cadastrados! ")
    void deveSalvarAfinadadeErro(){
        assertThrows(NotFoundException.class,
                ()-> pessoaService.salvarPessoa(ScenarioFactory.retornaPessoaRequestDTO()));
    }
    @Test
    @DisplayName("Deve buscar pessoa por id com sucesso")
    void deveBuscarPessoaPorIdSucesso(){
        when(afinidadeRepository.findByRegiao(anyString())).thenReturn(ScenarioFactory.retornaRegioesAfinidade());
        when(scoreRepository.findAll()).thenReturn(ScenarioFactory.retornaListaScore());
        when(pessoaRepository.findById(anyInt())).thenReturn(ScenarioFactory.retronarPessoaPorID());
        assertDoesNotThrow(()->pessoaService.buscarPessoaPorId(anyInt()));
    }
    @Test
    @DisplayName("Deve buscar pessoa por id com NoContentException")
    void deveBuscarPessoaPorIdNoContentException(){
        when(pessoaRepository.findById(anyInt())).thenReturn(Optional.empty());
        assertThrows(NoContentException.class,
                ()->pessoaService.buscarPessoaPorId(anyInt()));
    }
    @Test
    @DisplayName("Deve buscar lista de pessoas com NoContentException")
    void deveBuscarPessoasNoContentException(){
        when(afinidadeRepository.findByRegiao(anyString())).thenReturn(ScenarioFactory.retornaRegioesAfinidade());
        when(scoreRepository.findAll()).thenReturn(ScenarioFactory.retornaListaScore());
        when(pessoaRepository.findAll()).thenReturn(new ArrayList<>());
        assertThrows(NoContentException.class,
                ()->pessoaService.buscarPessoas());
    }
    @Test
    @DisplayName("Deve buscar lista de pessoas com sucesso")
    void deveBuscarPessoasSucesso(){
        when(afinidadeRepository.findByRegiao(anyString())).thenReturn(ScenarioFactory.retornaRegioesAfinidade());
        when(scoreRepository.findAll()).thenReturn(ScenarioFactory.retornaListaScore());
        when(pessoaRepository.findAll()).thenReturn(ScenarioFactory.retornaListaPessoas());
        assertDoesNotThrow(()->pessoaService.buscarPessoas());
    }
}
