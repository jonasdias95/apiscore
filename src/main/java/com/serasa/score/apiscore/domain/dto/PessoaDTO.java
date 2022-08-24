package com.serasa.score.apiscore.domain.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PessoaDTO {

    private String nome;
    private String telefone;
    private Integer idade;
    private String cidade;
    private String estado;
    private Integer score;
    private String regiao;
}
