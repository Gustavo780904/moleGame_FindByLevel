package com.santos.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public <U> Optional<? extends U> delete(Long id) {
		return repository.findById(id).map((Function<? super User, ? extends U>) record -> {
			repository.deleteById(id);
			return null;
		});
	}
//				.map(record -> {
//		               repository.deleteById(id);
//		               return ResponseEntity.ok().build();
//		           }).orElse(ResponseEntity.notFound().build());
//		}
//	}
}
