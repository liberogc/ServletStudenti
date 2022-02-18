package interfacce;


import java.sql.ResultSet;

import modelli.BeanStudenti;

public interface IStudenti {
	public BeanStudenti creaStudente(String matricola,String cognome, String nome, String citta, String dn ); 
	public void salvaStudente(BeanStudenti studente);
	public ResultSet listaStudenti();
}
