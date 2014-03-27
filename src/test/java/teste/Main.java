package teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
	
	public static void main(String[] args) throws ParseException {
		Date data = new Date();
		System.out.println(data);
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println(format.format("2013-11-01 13:48:01"));
		
		
	}

}
