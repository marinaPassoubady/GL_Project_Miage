package com.example.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.entities.Categorie;

@Repository("categorieRepository")
public interface CategorieRepository extends JpaRepository<Categorie, Integer>{

}
