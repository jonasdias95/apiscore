package com.serasa.score.apiscore.domain.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AfinidadeDTO {
    private String regiao;
    private List<String> estados;

}
