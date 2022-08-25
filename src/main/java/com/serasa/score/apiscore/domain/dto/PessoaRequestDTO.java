package com.serasa.score.apiscore.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@Builder
@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class PessoaRequestDTO {
    @NotBlank
    private String nome;
    @NotBlank
    private String telefone;
    @NotNull
    private Integer idade;
    @NotBlank
    private String cidade;
    @NotBlank
    private String estado;
    @NotNull
    private Integer score;
    @NotBlank
    private String regiao;
}
