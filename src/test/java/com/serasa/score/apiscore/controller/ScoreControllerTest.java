package com.serasa.score.apiscore.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.serasa.score.apiscore.domain.dto.PessoaDTO;
import com.serasa.score.apiscore.feature.ScenarioFactory;
import com.serasa.score.apiscore.service.AfinidadeSevice;
import com.serasa.score.apiscore.service.PessoaService;
import com.serasa.score.apiscore.service.ScoreSevice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertTrue;

@WebMvcTest(ScoreController.class)
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class ScoreControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private PessoaService pessoaService;
    @MockBean
    private AfinidadeSevice afinidadeSevice;
    @MockBean
    private ScoreSevice scoreSevice;

    @Test
    @DisplayName("GET por pessoas deve retornar lista com HTTP code 200")
    void deveRetornarPessoasComSucesso() throws Exception {
        when(pessoaService.buscarPessoas()).thenReturn(ScenarioFactory.retornaListaPessoa());
        MvcResult result = mockMvc.perform(get("/serasa/pessoa"))
                .andDo(print()).andExpect(status().isOk()).andReturn();
    }
    @Test
    @DisplayName("GET por pessoa por id deve retornar com HTTP code 200")
    void deveRetornarPessoaComSucesso() throws Exception {
        when(pessoaService.buscarPessoaPorId(any())).thenReturn(ScenarioFactory.retornaListaPessoaPorId());
        MvcResult result = mockMvc.perform(get("/serasa/pessoa/{id}","1"))
                .andDo(print()).andExpect(status().isOk()).andReturn();
    }
    @Test
    @DisplayName("GET por pessoas deve retornar lista com HTTP code 204")
    void deveRetornarPessoasComVazio() throws Exception {
        when(pessoaService.buscarPessoas()).thenThrow(RuntimeException.class);
        MvcResult result = mockMvc.perform(get("/serasa/pessoa"))
                .andDo(print()).andExpect(status().isNoContent()).andReturn();
    }
    @Test
    @DisplayName("GET por pessoa por id deve retornar lista com HTTP code 204")
    void deveRetornarPessoaVazio() throws Exception {
        when(pessoaService.buscarPessoaPorId(any())).thenThrow(RuntimeException.class);
        MvcResult result = mockMvc.perform(get("/serasa/pessoa/{id}","1"))
                .andDo(print()).andExpect(status().isNoContent()).andReturn();
    }
    @Test
    @DisplayName("POST deve salvar pessoa com HTTP code 201")
    void postSalvarPessoa(){
//        objectMapper.writeValueAsString()
    }
}
