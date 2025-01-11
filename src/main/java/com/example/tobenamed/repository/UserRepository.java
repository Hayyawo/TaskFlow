package com.example.tobenamed.repository;

import com.example.tobenamed.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
