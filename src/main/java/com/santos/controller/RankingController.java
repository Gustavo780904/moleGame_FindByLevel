package com.santos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santos.domain.Ranking;
import com.santos.service.RankingService;

@RestController
@RequestMapping("/ranking")
public class RankingController {

	@Autowired
	RankingService service;
	@CrossOrigin
	@GetMapping
	public List<Ranking> allFromList() {
		return service.allFromList();
	}	
//	@PostMapping
//	public Ranking newScore(@RequestBody Ranking score) {
//		return service.newScore(score);
//	}
}
