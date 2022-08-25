package com.serasa.score.apiscore.service;

import com.serasa.score.apiscore.feature.ScenarioFactory;
import com.serasa.score.apiscore.repository.AfinidadeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class AfinidadeServiceTest {
    @InjectMocks
    private AfinidadeSevice afinidadeSevice;
    @Mock
    private AfinidadeRepository afinidadeRepository;
    @Test
    @DisplayName("Deve salvar afinidade com sucesso")
    void deveSalvarAfinadadeSucesso(){
        afinidadeSevice.salvarAfinidade(ScenarioFactory.retornaAfinidadeDTO());
        verify(afinidadeRepository).save(any());
    }
    @Test
    @DisplayName("Deve salvar afinidade com erro")
    void deveSalvarAfinadadeErro(){
        doThrow(DataIntegrityViolationException.class).when(afinidadeRepository).save(any());
        assertThrows(DataIntegrityViolationException.class,
                ()-> afinidadeSevice.salvarAfinidade(ScenarioFactory.retornaAfinidadeDTO()));
    }
}
