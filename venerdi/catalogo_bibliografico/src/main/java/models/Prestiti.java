package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Prestiti {

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	//private Utente lastname;
	private String d_prestito;
	private String d_resp;
	private String d_rese;
	
	@ManyToOne
	@JoinColumn(name="utente_n_card")
	private Utente n_card;
	
	public Prestiti () {
		
	}

	public Prestiti(Utente lastname, String d_prestito, String d_resp, String d_rese, Utente n_card) {
		super();
		//this.lastname = lastname;
		this.d_prestito = d_prestito;
		this.d_resp = d_resp;
		this.d_rese = d_rese;
//		this.n_card = n_card;
	}

//	public Utente getLastname() {
//		return lastname;
//	}
//
//	public void setLastname(Utente lastname) {
//		this.lastname = lastname;
//	}

	public String getD_prestito() {
		return d_prestito;
	}

	public void setD_prestito(String d_prestito) {
		this.d_prestito = d_prestito;
	}

	public String getD_resp() {
		return d_resp;
	}

	public void setD_resp(String d_resp) {
		this.d_resp = d_resp;
	}

	public String getD_rese() {
		return d_rese;
	}

	public void setD_rese(String d_rese) {
		this.d_rese = d_rese;
	}

//	public Utente getN_card() {
//		return n_card;
//	}
//
//	public void setN_card(Utente n_card) {
//		this.n_card = n_card;
//	}
//	
	
}
