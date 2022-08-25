package com.serasa.score.apiscore.service;

import com.serasa.score.apiscore.domain.dto.AfinidadeDTO;
import com.serasa.score.apiscore.domain.dto.ScoreDTO;
import com.serasa.score.apiscore.domain.model.Afinidade;
import com.serasa.score.apiscore.domain.model.Score;
import com.serasa.score.apiscore.repository.AfinidadeRepository;
import com.serasa.score.apiscore.repository.ScoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class ScoreSevice {

    @Autowired
    private ScoreRepository scoreRepository;
    public void salvarScore(ScoreDTO scoreDTO){
        try {
            var score = Score.builder()
                    .descricao(scoreDTO.getDescricao())
                    .inicial(scoreDTO.getInicial())
                    .ifinal(scoreDTO.getIfinal())
                    .build();
            scoreRepository.save(score);
        }catch (Exception e){
            log.error("Falha ao salvar dados de pessoa!", e.getMessage());
            e.printStackTrace();
            throw e;
        }

    }

}
