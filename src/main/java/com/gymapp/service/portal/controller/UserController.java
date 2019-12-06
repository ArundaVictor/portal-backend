package com.gymapp.service.portal.controller;

import com.gymapp.service.portal.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gymapp.service.portal.repository.UserRepository;
import com.gymapp.service.portal.model.User;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("user-controller")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping(value = "/list", produces = { "application/json" })
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @RequestMapping(method=RequestMethod.GET)
    public Page<User> getAllUsers(Pageable pageable) {
        return userService.getAllUsers(pageable);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping(value = "/users/count", produces = { "application/json" })
    public ResponseEntity<Long> countUsers() {
        return ResponseEntity.ok(userService.count());
    }


    @PostMapping(value = "/users", produces = { "application/json" })
    public ResponseEntity<User> createUser( @RequestBody User user)
            throws URISyntaxException {
        user = userService.save(user);
        String uri = "/user-controller/users/".concat(String.valueOf(user.getId()));
        return ResponseEntity.created(new URI(uri)).body(user);
    }

    @GetMapping(value = "/users/get/{userUuid}")
    public ResponseEntity<User> findByUuid(@PathVariable("userUuid") String userUuid) {
        return ResponseEntity.ok(userService.findByUuid(userUuid));
    }

    @PutMapping(value = "/users/{id}", produces = { "application/json" })
    public ResponseEntity<User> update(@PathVariable("id") Long id, @RequestBody User user) {
        user.setId(id);
        return ResponseEntity.ok(userService.save(user));
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }


}


