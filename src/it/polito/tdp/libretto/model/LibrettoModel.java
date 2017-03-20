package it.polito.tdp.libretto.model;

import java.util.*;


/**
 * Inserire in nuovo esame
 * ricercare
 * 
 * Costruttore
 * Metodi interessati
 * 
 * @author Gaspare
 *
 */
public class LibrettoModel {
	
	private List<Esame> esami;
	
	
	public LibrettoModel(){
		
		this.esami = new ArrayList<Esame>();
	}
	
	/**
	 * Aggiunge un nuovo esame all'elenco degli esami presenti,
	 * verificando che non ci sia già
	 * @param e
	 * return true se l'ha inserito, false se esistono già e quindi non aggiunge
	 */
	
	// Ci sono tre possibili modi per gestire casi anomali o eccezioni, in questo esempio uttilizziamo un boolean
	
	public boolean addEsame(Esame e){
		
		if(!esami.contains(e)){
			// Possiamo usare contains perche usa Esame.equals (leggere la documentazione puntando sul metodo contains)
			esami.add(e);
			return true;
			
		} else
			return false;
	}
	/**
	 * Ricerca se esiste un esame con il codice specificato.
	 * Se esiste lo restituisce altrimenti restituisce null
	 * 
	 * @param codice codice dell'esame da ricercare
	 * @return l'esame trovato, oppure null se non trovato
	 */
	
	public Esame trovaEsame(String codice){
		
		// 2 possibili modi per la ricerca, o scandisco la lista riga per riga oppure:
		
	//this.esami.indexOf(codice); // Non va bene perche si aspetta un Esame e non una stringa
		
		int pos = this.esami.indexOf(new Esame( codice, null, null) );
		
		if(pos == -1)
			return null;
		else
			return esami.get(pos);
		
	}
	
	

}
