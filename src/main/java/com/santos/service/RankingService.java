package com.santos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santos.domain.Ranking;
import com.santos.repository.RankingRepository;

@Service
public class RankingService {
	@Autowired
	RankingRepository repository;

	public List<Ranking> allFromList() {
		return repository.findAll();
	}
	public List<Ranking> allByLevel(String level) {
		return repository.findTop5ByLevelOrderByScoreDescId(level);
	}
	@Transactional(readOnly = true)
	public Page<Ranking> findyByLevel(String level, PageRequest pageRequest) {
		return repository.findyByLevel(level, pageRequest);
	}
	
	
	public Ranking newScore(Ranking score) {
		return repository.save(score);
	}
}
