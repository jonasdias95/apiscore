package com.serasa.score.apiscore.domain.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
@Builder
@NoArgsConstructor
@Data
@Entity
@Table(name = "Pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pessoa", nullable = false)
    private Integer id;
    @Column(name = "data", nullable = false)
    private LocalDate data;
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    @Column(name = "telefone", length = 11, nullable = false)
    private String telefone;
    @Column(name = "idade", nullable = false)
    private Integer idade;
    @Column(name = "cidade", nullable = false)
    private String cidade;
    @Column(name = "score", nullable = false)
    private Integer score;
    @Column(name = "estado", nullable = false)
    private String estado;
    @Column(name = "regiao", nullable = false)
    private String regiao;

    public Pessoa(Integer id, LocalDate data, String nome, String telefone, Integer idade, String cidade, Integer score, String estado, String regiao) {
        this.id = id;
        this.data = data;
        this.nome = nome;
        this.telefone = telefone;
        this.idade = idade;
        this.cidade = cidade;
        this.score = score;
        this.estado = estado;
        this.regiao = regiao;
    }
}
