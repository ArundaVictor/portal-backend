package com.gymapp.service.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gymapp.service.portal.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<User,Long> {

    User findByUuid(String uUid);
}
