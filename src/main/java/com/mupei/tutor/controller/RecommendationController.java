package com.mupei.tutor.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mupei.tutor.model.Recommendation;
import com.mupei.tutor.service.RecommendationService;
import com.mupei.tutor.vo.Json;

@CrossOrigin
@RestController
@RequestMapping("/recommendation")
@ResponseBody
public class RecommendationController {
	@Autowired
	private RecommendationService recommendationService;
	
	@PostMapping("/addRecommendation")
	public Json addRecommendation(@ModelAttribute Recommendation data) {
		Json json = new Json();
		try {
			recommendationService.saveRecommendation(data);
			json.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			json.setSuccess(false);
		}
		return json;
	}
	
	@GetMapping("/getRecommendations")
	public Json getRecommendations() {
		Json json = new Json();
		try {
			ArrayList<Recommendation> all = recommendationService.getAll();
			json.setObj(all);
			json.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			json.setSuccess(false);
		}
		return json;
	}
	
	@DeleteMapping("/deleteRecommendation")
	public Json deleteRecommendation(@RequestParam Integer id) {
		Json json = new Json();
		try {
			recommendationService.delete(id);
			json.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			json.setSuccess(false);
		}
		return json;
	}
}
