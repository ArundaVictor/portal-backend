package com.gymapp.service.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gymapp.service.portal.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByEmail(String email);
}
