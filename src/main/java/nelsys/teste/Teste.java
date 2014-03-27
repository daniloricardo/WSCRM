package nelsys.teste;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import nelsys.conexao.AbreConexaoSE;


public class Teste {

	
	public static void main(String[] args) throws ParseException, IOException {
		String caminho = Thread.currentThread().getContextClassLoader().getResource("hibernate.properties").getPath();
		String local = Paths.get("").toAbsolutePath().normalize().toString();
		String local2 = "";
		System.out.println(local);
	}
	public static String conversao(String data){
		data = data.substring(0,10);
		data = data.substring(8,10) + "/"+ data.substring(5,7)+ "/"+ data.substring(0,4);
		System.out.println(data);
		return data;
	}
	

}
