package com.serasa.score.apiscore.repository;

import com.serasa.score.apiscore.domain.model.Afinidade;
import com.serasa.score.apiscore.domain.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AfinidadeRepository extends JpaRepository<Afinidade, Integer> {
    List<Afinidade> findByRegiao(String regiao);
}
