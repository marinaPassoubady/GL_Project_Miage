package com.parisdescartes.scrib.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
@PropertySource("dateformat.properties")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	@NotEmpty(message="Veuillez renseigner un nom !")
	private String nom;
	
	@NotEmpty(message="Veuillez renseigner un prénom !")
	private String prenom;
	
	@NotEmpty(message="Veuillez renseigner un email !")
	@Email(message="Un emai est obligatoire.")
	private String email;
	
	@NotEmpty(message="Un mot de passe est obligatoire.")
	private String password;
	
	@Value("${dateformat}")
	private String dateFormat;
	
	@Transient
	@NotEmpty(message="La confirmation du mot de passe est nécessaire.")
	private String confirm;
	String dateInscription =  new SimpleDateFormat("dd/MM/yyyy").format(new Date());

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
	
	@Override
	public boolean equals(Object obj) {
		return ((obj instanceof User) && ((User)obj).id == id); 
	}
	
	@Override
	public int hashCode() {
		return ((Integer)id).hashCode();
	}
	
}
