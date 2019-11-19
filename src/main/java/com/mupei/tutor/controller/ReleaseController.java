package com.mupei.tutor.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

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

import com.mupei.tutor.model.Release;
import com.mupei.tutor.service.ReleaseService;
import com.mupei.tutor.vo.Json;

@CrossOrigin
@RestController
@RequestMapping("/release")
@ResponseBody
public class ReleaseController {
	@Autowired
	private ReleaseService releaseService;
	
	@PostMapping("/addRelease")
	public Json addRelease(@ModelAttribute Release data) {
		Json json = new Json();
		try {
			releaseService.saveRelease(data);
			json.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			json.setSuccess(false);
		}
		return json;
	}
	
	@GetMapping("/getReleases")
	public Json getReleases(HttpServletRequest request) {
		Json json = new Json();
		try {
			ArrayList<Release> all = releaseService.getAll();
			json.setObj(all);
			json.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			json.setSuccess(false);
		}
		return json;
	}
	
	@DeleteMapping("/deleteRelease")
	public Json deleteRelease(@RequestParam Integer id) {
		Json json = new Json();
		try {
			releaseService.delete(id);
			json.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			json.setSuccess(false);
		}
		return json;
	}
}
