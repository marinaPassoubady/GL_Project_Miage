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
	
	public void setVotes(int votes) {
		this.votes = votes;
	}
	public int getVotes() {
		return votes;
	}
	public void incVotes(int offset) {
		votes += offset;
	}
	
	public List<User> getVoteurs() {
		return voteurs;
	}
	
	public void setVoteurs(List<User> voteurs) {
		this.voteurs = voteurs;
	}
}
