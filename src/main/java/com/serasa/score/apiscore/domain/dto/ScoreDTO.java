package com.serasa.score.apiscore.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ScoreDTO {
    @NotBlank
    @JsonProperty("scoreDescricao")
    private String descricao;
    @NotNull
    @JsonProperty("inicial")
    private Integer inicial;
    @NotNull
    @JsonProperty("final")
    private Integer ifinal;
}
