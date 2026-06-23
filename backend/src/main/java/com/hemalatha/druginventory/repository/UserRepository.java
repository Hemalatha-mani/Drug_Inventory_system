package com.hemalatha.druginventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hemalatha.druginventory.entity.User;

public interface UserRepository
extends JpaRepository<User,Long>{
    User findByUsernameAndPassword(
        String username,
        String password);

}