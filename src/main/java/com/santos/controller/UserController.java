package com.santos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santos.domain.Ranking;
import com.santos.domain.User;
import com.santos.service.RankingService;
import com.santos.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	RankingService rankingService;

	@CrossOrigin
	@GetMapping
	public List<User> findAll() {
		return userService.getAll();

	}
	
	
	@CrossOrigin
	@GetMapping("/{level}")
	public List<Ranking> findByLevel(@PathVariable String level) {
		return rankingService.allByLevel(level);

	}

	@CrossOrigin
	@GetMapping("{/id}")
	public User findById(@PathVariable Long id) {
		return userService.getById(id);
	}

	@CrossOrigin
	@PostMapping
	public User newUser(@RequestBody User user) {
		return userService.insert(user);
	}

	@CrossOrigin
	@PostMapping("/{id}/score")
	public Ranking AddScores(@PathVariable Long id, @RequestBody Ranking score) {
		User scores = userService.getById(id);
		scores.addScore(score);
		return rankingService.newScore(score);
	}
}
