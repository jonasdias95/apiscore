package com.serasa.score.apiscore.repository;

import com.serasa.score.apiscore.domain.model.Afinidade;
import com.serasa.score.apiscore.domain.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {
}
