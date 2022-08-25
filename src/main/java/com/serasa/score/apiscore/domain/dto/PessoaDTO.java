package com.serasa.score.apiscore.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@Builder
@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class PessoaDTO {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String nome;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String telefone;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer idade;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String cidade;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String estado;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer score;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String regiao;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String scoreDescricao;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String[] estados;
}
