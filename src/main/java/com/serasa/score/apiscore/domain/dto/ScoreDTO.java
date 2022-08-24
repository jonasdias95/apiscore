package com.serasa.score.apiscore.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ScoreDTO {
    @JsonProperty("scoreDescricao")
    private String descricao;
    @JsonProperty("inicial")
    private Integer inicial;
    @JsonProperty("final")
    private Integer ifinal;
}
