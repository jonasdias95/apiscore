package com.serasa.score.apiscore.service;

import com.serasa.score.apiscore.feature.ScenarioFactory;
import com.serasa.score.apiscore.repository.AfinidadeRepository;
import com.serasa.score.apiscore.repository.ScoreRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
public class ScoreServiceTest {
    @InjectMocks
    private ScoreSevice scoreSevice;
    @Mock
    private ScoreRepository scoreRepository;
    @Test
    @DisplayName("Deve salvar score com sucesso")
    void deveSalvarAfinadadeSucesso(){
        scoreSevice.salvarScore(ScenarioFactory.retornaScoreDTO());
        verify(scoreRepository).save(any());
    }
    @Test
    @DisplayName("Deve salvar score com erro")
    void deveSalvarScoreErro(){
        doThrow(DataIntegrityViolationException.class).when(scoreRepository).save(any());
        assertThrows(DataIntegrityViolationException.class,
                ()-> scoreSevice.salvarScore(ScenarioFactory.retornaScoreDTOInvalido()));
    }
}
