package com.dacn.logicsticservice.repository;

import com.dacn.logicsticservice.model.WeightRank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WeightRankRepository extends JpaRepository<WeightRank, Integer> {

    @Query(value = "select * from weightrank where weightmin < ?1 and weightmax >= ?1", nativeQuery = true)
    WeightRank getWeightRankByWeight(float weight);
}
