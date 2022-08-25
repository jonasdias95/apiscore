package com.serasa.score.apiscore.domain.model;

import lombok.*;

import javax.persistence.*;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Afinidade")
public class Afinidade {

    @Id
    @Column(name = "regiao", nullable = false)
    private String regiao;

    @Column(name = "estados", nullable = false)
    private String [] estados;


}
