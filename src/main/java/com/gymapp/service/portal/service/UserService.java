package com.gymapp.service.portal.service;

import com.gymapp.service.portal.model.User;
import com.gymapp.service.portal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    public User save(User card) {
        return userRepository.save(card);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);

    }

    public Long count() {
        return userRepository.count();
    }

    public User findByUuid(String uuid) {
        return userRepository.findByUuid(uuid);
    }
}
