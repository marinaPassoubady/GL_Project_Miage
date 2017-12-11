package com.example.project.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Article {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String titre;
	private String description,
	dateCreation = new Date().toString();
	
	@ManyToOne
	private User auteur;

	@ManyToOne
	private Theme theme;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	public void setAuteur(User auteur) {
		this.auteur = auteur;
	}
	public User getAuteur() {
		return auteur;
	}
	
	public Theme getTheme() {
		return theme;
	}
	
	public void setTheme(Theme theme) {
		this.theme = theme;
	}
}
