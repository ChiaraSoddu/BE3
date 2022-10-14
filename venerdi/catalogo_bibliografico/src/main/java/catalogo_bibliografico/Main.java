package catalogo_bibliografico;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;

import models.Catalogue;
import models.Genre;
import models.Period;

public class Main {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogo_bibliografico");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction t = em.getTransaction();

	public static void main(String[] args) {
		
		
		/*
			Creare le classi necessarie a gestire un catalogo bibliotecario. Il catalogo è formato da elementi che possono essere Libri o Riviste. Sia Libri che riviste hanno i seguenti attributi:
			- Codice ISBN (codice univoco)
			- Titolo
			- Anno pubblicazione
			- Numero pagine
			
			I libri hanno inoltre:
			- Autore
			- Genere
			
			Le riviste hanno:
			- Periodicità [SETTIMANALE, MENSILE, SEMESTRALE]
			
			Creare inoltre le classi necessarie alla gestione del prestito:
			
			L'utente è caratterizzato dai seguenti attributi:
			- Nome
			- Cognome
			- Data di nascita
			- Numero di tessera
			
			Il prestito è caratterizzato da:
			- Utente 
			- Elemento prestato (può essere un libro o una rivista)
			- Data inizio prestito
			- Data restituzione prevista (calcolata automaticamente a 30 gg dalla data inizio prestito)
			- Data restituzione effettiva
			
			
			L'archivio deve permettere le seguenti operazioni:
			- Aggiunta di un elemento del catalogo V
			- Rimozione di un elemento del catalogo dato un codice ISBN V
			- Ricerca per ISBN						X
			- Ricerca per anno pubblicazione		X
			- Ricerca per autore					X
			- Ricerca per titolo o parte di esso	X
			- Ricerca degli elementi attualmente in prestito dato un numero di tessera utente
			- Ricerca di tutti i prestiti scaduti e non ancora restituiti
		 */
		
		
		em.close();
		emf.close();
	}
	
	
	
	
	/////////////////////// AGGIUNGERE UN ELEMENTO

	public static void makeElement(String tipo, long codIsbn, String title, int year, int n_pag, Period period, Genre genre, String autore) {
		
		t.begin();
		
		Catalogue c = new Catalogue (tipo, codIsbn, title, year, n_pag, period, genre, autore);
		
		
		
		
		
		
		em.persist(c);
		
		t.commit();
		
	}
	
	////////////////////// ELIMINARE UN ELEMENTO
	
	public static void deleteElementById(long codIsbn) {
		t.begin();
		
		Query q = em.createQuery("DELETE Catalogue c WHERE c.codIsbn  = :codIsbn");
		
		q.setParameter("codIsbn", codIsbn);
		
		q.executeUpdate();
		
		
		t.commit();
		
	}
	
	
	/////////////////// TROVA ELEMENTO TRAMITE CODICE ISBN
	
	public static void findElementByCodeIsbn(long codIsbn) {
		
		Query q = em.createQuery("SELECT * FROM Catalogue  WHERE c.codIsbn LIKE :codIsbn");
		
		q.setParameter("codIsbn", codIsbn);
		
		List<Catalogue> r = q.getResultList();
		
		System.out.println("Gli elementi con codice ISBN uguale a  " + codIsbn + " sono: ");
		
		for(Catalogue c : r ) {
			System.out.println(c);
		}
		
		
	}
	
	////////////////////// TROVARE ELEMENTO TRAMITE ANNO DI PUBBLICAZIONE
	
public static void findElementByYear(int year) {
		
		Query q = em.createQuery("SELECT * FROM Catalogue  WHERE c.year LIKE :year");
		
		q.setParameter("year", year);
		
		List<Catalogue> r = q.getResultList();
		
		System.out.println("Gli elementi con codice ISBN uguale a  " + year + " sono: ");
		
		for(Catalogue c : r ) {
			System.out.println(c);
		}
		
		
	}

///////////////////// TROVA ELEMENTO TRAMITE AUTORE
	
	public static void findPersonByName(String autore) {
		
		Query q = em.createQuery("SELECT c FROM Catalogue c WHERE c.autore LIKE :autore");
		
		q.setParameter("autore", autore);
		
		List <Catalogue> r = q.getResultList();
		
		for(Catalogue c : r ) {
			System.out.println(c);
		}
		
	}
	


	

	
//////////////////////// TROVA ELEMENTO TRAMITE TITOLO
	
	public static void findElementByTitle(String title) {
//		
//		Query q = em.createQuery("SELECT c FROM Catalogue c WHERE c.title LIKE :title");
//		
//		q.setParameter("title", title );
//		
//		List <Catalogue> r = q.getResultList();
//		
//		for(Catalogue c : r ) {
//			System.out.println(c);
//		}
//		
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
		Root<Catalogue> c = cq.from(Catalogue.class);
		ParameterExpression<String> param1 = cb.parameter(String.class);
		
		Expression<String> cTitle = c.get("title");
		Predicate pd1 = cb.equal(cTitle, param1);
		
		cq.select(c.get("title")).where(pd1);
		
		Query q = em.createQuery(cq);
		q.setParameter(param1, title);
		
		List<Object[]> list = q.getResultList();
		
		for(Object[] element : list ) {
		System.out.println(element);
		}
	}
}
