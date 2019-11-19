package com.mupei.tutor.dao;

import org.springframework.data.repository.CrudRepository;

import com.mupei.tutor.model.Recommendation;

public interface RecommendationDao  extends CrudRepository<Recommendation, Integer> {

}
