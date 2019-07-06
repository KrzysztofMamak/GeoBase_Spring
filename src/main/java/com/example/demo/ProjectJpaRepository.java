package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectJpaRepository extends JpaRepository<Project, Long> {
	
	Project findByNumber(int number);
}
