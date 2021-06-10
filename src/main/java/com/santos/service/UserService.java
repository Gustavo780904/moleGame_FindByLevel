package com.santos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santos.domain.User;
import com.santos.repository.UserRepository;
@Service
public class UserService {
	@Autowired
	private UserRepository repository;

	public List<User> getAll() {
		return repository.findAll();
	}
//	@Transactional(readOnly = true)
//	public Page<User> findAllPaged(PageRequest pageRequest) {
//		return repository.findAll(pageRequest);
//	}
	public User insert(User user) {
		return repository.save(user);
	}
	public User getById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ListaNaoEncontradaException(id));
	}
	public User deleteAll() {
		repository.deleteAll();
		return (User) repository.findAll();
	}
}
