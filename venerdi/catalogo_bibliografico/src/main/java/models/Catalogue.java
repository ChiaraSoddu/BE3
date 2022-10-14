package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Catalogue {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	private String tipo;
	private long codIsbn;
	private String title;
	private int year;
	private int nPag;
	
	@Enumerated(EnumType.STRING)
	private Period period;
	@Enumerated(EnumType.STRING)
	private Genre genre;
	
	private String autore;
	
	public Catalogue () {
		
	}

	public Catalogue( String tipo, long codIsbn, String title, int year, int nPag, Period period, Genre genre, String autore) {
		super();
		this.tipo = tipo;
		this.codIsbn = codIsbn;
		this.title = title;
		this.year = year;
		this.nPag = nPag;
		this.period = period;
		this.genre = genre;
		this.autore = autore;
	}

	public long getCodIsbn() {
		return codIsbn;
	}

	public void setCodIsbn(long codIsbn) {
		this.codIsbn = codIsbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getnPag() {
		return nPag;
	}

	public void setnPag(int nPag) {
		this.nPag = nPag;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	
}
