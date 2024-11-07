package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface jpaRepo extends JpaRepository<mysqldatabase, Long> {
    Optional<mysqldatabase> findByBookname(String bookname);
}
