package controlli;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Controlli {
	public String dataItaToIng(String datait) {
		String stringadataing=null;
		// oggetti di tipo formato data
		SimpleDateFormat formatoita = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatoing = new SimpleDateFormat("yyy-MM-dd");
		try {
			Date dataita=formatoita.parse(datait);
			stringadataing=formatoing.format(dataita);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stringadataing;		
	}
	
	public String dataIngToIta(String dataen) {
		String stringadataita=null;
		// oggetti di tipo formato data
		SimpleDateFormat formatoita = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatoing = new SimpleDateFormat("yyy-MM-dd");
		try {
			Date dataing=formatoing.parse(dataen);
			stringadataita=formatoita.format(dataing);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stringadataita;		
	}
}
