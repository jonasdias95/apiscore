package com.serasa.score.apiscore.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
@Table(name = "Afinidade")
public class Afinidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_afinidade", nullable = false)
    private Integer id;

    @Column(name = "regiao", nullable = false)
    private String regiao;

    @Column(name = "estado", nullable = false)
    private String estado;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_score")
    private Score score;

}
