package com.example.project.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	@NotEmpty(message="Le nom est obligatoire.")
	private String nom;
	
	@NotEmpty(message="Le prénom est obligatoire.")
	private String prenom;
	
	@NotEmpty(message="Le mail doit être renseigné.")
	@Email(message="Votre email n'est pas valide.")
	private String email;
	
	@NotEmpty(message="Le mot de passe est obligatoire.")
	private String password;
	
	@Transient
	@NotEmpty(message="La confirmation du mot de passe doit être renseigné.")
	private String confirm;
	String dateInscription =  new Date().toString();

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirm() {
		return confirm;
	}
	
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	public String getDateInscription() {
		return dateInscription;
	}
	public void setDateInscription(String dateInscription) {
		this.dateInscription = dateInscription;
	}
}
