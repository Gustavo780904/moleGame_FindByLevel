package com.santos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santos.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
