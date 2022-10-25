package com.yfsanchez.fundamentos.repository;

import com.yfsanchez.fundamentos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("Select u From User u Where u.email=?1")
    Optional<User> findByUserEmail(String email);
}
