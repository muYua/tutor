package com.mupei.tutor.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mupei.tutor.dao.RecommendationDao;
import com.mupei.tutor.model.Recommendation;
import com.mupei.tutor.service.RecommendationService;

@Service("recommendationService")
public class RecommendationServiceImpl implements RecommendationService {
	@Autowired
	private RecommendationDao recommendationDao;
	
	@Override
	public void saveRecommendation(Recommendation data) {
		recommendationDao.save(data);
	}

	@Override
	public ArrayList<Recommendation> getAll() {
		Iterable<Recommendation> all = recommendationDao.findAll();
		return (ArrayList<Recommendation>) all;
	}

	@Override
	public void delete(Integer id) {
		recommendationDao.deleteById(id);
	}

}
