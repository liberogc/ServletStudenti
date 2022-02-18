package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connessione.Connessione;
import interfacce.ILogin;

public class DaoLogin extends Connessione implements ILogin  {
	Connection connesso;
	Statement statement;
	PreparedStatement pst;
	ResultSet rs;
	String sql;
	
	
	
	@Override
	public Boolean verificaLogin(String ut, String pw) {
		connesso=connetti();
		sql="SELECT * FROM login WHERE user=? and pw=?";
		Boolean trovato=null;
		try {
			pst =connesso.prepareStatement(sql);
			pst.setString(1, ut);
			pst.setString(2, pw);
			rs=pst.executeQuery();
			trovato=rs.next();
			connesso.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return trovato;
	}

}
