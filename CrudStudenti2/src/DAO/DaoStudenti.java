package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connessione.Connessione;
import controlli.Controlli;
import interfacce.IStudenti;
import modelli.BeanStudenti;

public class DaoStudenti extends Connessione implements IStudenti{
	Connection connessione;
	PreparedStatement preparedst;
	Statement st;
	ResultSet setdirecord;
	String sql;
	Controlli controllo = new Controlli();
	
	@Override
	public BeanStudenti  creaStudente(String matricola, String nome, String cognome, String citta, String dn) {
		BeanStudenti beanstudente = new BeanStudenti();
		beanstudente.setNome(nome);
		beanstudente.setCognome(cognome);
		beanstudente.setDatanascita(dn);
		beanstudente.setCitta(citta);
		beanstudente.setMatricola(Integer.parseInt(matricola));

		return beanstudente;
		
	}

	@Override
	public void salvaStudente(BeanStudenti studente) {
		connessione=connetti();
		sql="INSERT INTO studenti (matricola,nome,cognome,citta,dn) VALUE(?,?,?,?,?)";
		try {
			preparedst=connessione.prepareStatement(sql);
			preparedst.setInt(1, studente.getMatricola());
			preparedst.setString(2, studente.getNome());
			preparedst.setString(3,studente.getCognome());
			preparedst.setString(4, studente.getCitta());
			// ottienne data inglese convertita da italiano
			//String stringdting=controllo.dataItaToIng(studente.getDatanascita());
			//
			preparedst.setString(5, studente.getDatanascita());
			preparedst.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet listaStudenti() {
		connessione=connetti();
		sql="SELECT * FROM studenti";
		try {
			st=connessione.createStatement();
			setdirecord=st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return setdirecord;
	}

}
