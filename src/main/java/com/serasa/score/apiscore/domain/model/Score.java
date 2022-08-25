package com.serasa.score.apiscore.domain.model;

import lombok.*;

import javax.persistence.*;
@Data
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Score")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_score", nullable = false)
    private Integer id;
    @Column(name = "descricao", nullable = false)
    private String descricao;
    @Column(name = "inicial", nullable = false)
    private Integer inicial;
    @Column(name = "final", nullable = false)
    private Integer ifinal;

}
