package com.example.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.entities.Theme;

@Repository("themeRepository")
public interface ThemeRepository extends JpaRepository<Theme, Integer>{

}
