package com.sda.travelAgency.repository;

import com.sda.travelAgency.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {

    User findByEmail(String email);

}
