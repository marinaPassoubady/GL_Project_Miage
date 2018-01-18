package com.parisdescartes.scrib.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;


@Entity
public class Article {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message="Le titre est obligatoire.")
	private String titre;
	
	@Lob
	@Column(columnDefinition="TEXT")
	@NotEmpty(message="Une description est obligatoire")
	private String description;
	
	private String dateCreation;
	
	@ManyToOne
	private User auteur;

	@ManyToOne
	private Theme theme;
	
	@ManyToMany
	private List<User> voteurs;
	
	private int votes = 0;
	
	public int getId() {
		return id;
	}
	public Article setId(int id) {
		this.id = id;
		return this;
	}
	public String getTitre() {
		return titre;
	}
	public Article setTitre(String titre) {
		this.titre = titre;
		return this;
	}
	public String getDescription() {
		return description;
	}
	public Article setDescription(String description) {
		this.description = description;
		return this;
	}
	public String getDateCreation() {
		return dateCreation;
	}
	public Article setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
		return this;
	}
	
	public Article setAuteur(User auteur) {
		this.auteur = auteur;
		return this;
	}
	public User getAuteur() {
		return auteur;
	}
	
	public Theme getTheme() {
		return theme;
	}
	
	public Article setTheme(Theme theme) {
		this.theme = theme;
		return this;
	}
	
	public Article setVotes(int votes) {
		this.votes = votes;
		return this;
	}
	public int getVotes() {
		return votes;
	}
	public Article incVotes(int offset) {
		votes += offset;
		return this;
	}
	
	public List<User> getVoteurs() {
		return voteurs;
	}
	
	public Article setVoteurs(List<User> voteurs) {
		this.voteurs = voteurs;
		return this;
	}
}
