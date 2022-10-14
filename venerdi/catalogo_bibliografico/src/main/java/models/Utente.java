package models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Utente {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String lastname;
	private String d_birth;
	private long n_card;
	
	@OneToMany(mappedBy= "n_card")
	private Set <Prestiti> prestito;
	
	public Utente() {
		
	}

	public Utente(String name, String lastname, String d_birth, long n_card, Set <Prestiti> prestito) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.d_birth = d_birth;
		this.n_card = n_card;
		this.prestito = prestito;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getD_birth() {
		return d_birth;
	}

	public void setD_birth(String d_birth) {
		this.d_birth = d_birth;
	}

	public long getN_card() {
		return n_card;
	}

	public void setN_card(long n_card) {
		this.n_card = n_card;
	}

//	public Prestiti getPrestito() {
//		return prestito;
//	}
//
//	public void setPrestito(Prestiti prestito) {
//		this.prestito = prestito;
//	}
//	
//	

}
