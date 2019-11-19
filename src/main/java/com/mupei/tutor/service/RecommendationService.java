package com.mupei.tutor.service;

import java.util.ArrayList;

import com.mupei.tutor.model.Recommendation;

public interface RecommendationService {

	public void saveRecommendation(Recommendation data);

	public ArrayList<Recommendation> getAll();

	public void delete(Integer id);
	
}
