package com.radisson.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.radisson.user.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
