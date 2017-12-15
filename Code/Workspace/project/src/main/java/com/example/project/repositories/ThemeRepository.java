package com.example.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.entities.Theme;
import com.example.project.entities.User;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Integer>{
	List<Theme> findByAuteur(User user);
}
