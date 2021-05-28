package com.santos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
//	@GetMapping
//	public ResponseEntity<Page<User>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
//			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
//			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
//			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {
//		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
//		Page<User> list = userService.findAllPaged(pageRequest);
//		return ResponseEntity.ok().body(list);
//	}
	
//	
	@CrossOrigin
	@GetMapping("/{level}")
	public List<Ranking> findByLevel(@PathVariable String level) {
		return rankingService.allByLevel(level);
	}
//	@CrossOrigin
//	@GetMapping("/{level}")
//	public List<Ranking> listTopFiveRanking(@PathVariable String level) {
//		return rankingService.listTopFiveRanking(level);
//
//	}
	@GetMapping(value = "/findy-by-level")
	public ResponseEntity<Page<Ranking>> findyByLevel(
			@RequestParam(value = "level", defaultValue = "") String level,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Page<Ranking> list = rankingService.findyByLevel(level, pageRequest);
		return ResponseEntity.ok().body(list);
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
