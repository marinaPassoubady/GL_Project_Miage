package com.example.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.entities.Article;

@Repository("articleRepository")
public interface ArticleRepository extends JpaRepository<Article, Integer> {
	
}
