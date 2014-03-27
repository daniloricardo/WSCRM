package nelsys.conexao;
import java.lang.*;   
import java.nio.file.Paths;
import java.sql.*;   
import java.io.*;   

import javax.swing.*;   


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.sql.*;  
import java.util.List;
import java.util.Properties;
public class AbreConexaoSE {  




	private static String  user;
	private static String senha;
	private static String URL = "jdbc:sqlserver://DANILORICARDO:53918;databaseName=ATIMAKY;instance=SQLEXPRESS" +
			";user=" + user + ";password=" + senha + ";";
	private static Connection conexao;
	public static ResultSet rs;
	public static String status = "";

	public static  SessionFactory Conectar() throws IOException   
	{   
		SessionFactory sf = null;
		try   
		{
			String caminho = Thread.currentThread().getContextClassLoader().getResource("hibernate.properties").getPath();
			String caminhoJAR = Paths.get("").toAbsolutePath().normalize().toString()+"\\hibernate.properties";
			File file1 = new File(caminho);				        

			Properties properties = new Properties(); 
			FileInputStream stream = null;  
			stream = new FileInputStream(file1);  
			properties.load(stream); 
			String propertiesURL = properties.getProperty("hibernate.connection.url");
			String propertiesUser = properties.getProperty("hibernate.connection.username");
			String propertiesSenha = properties.getProperty("hibernate.connection.password");

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");   
							
			Connection c = DriverManager.getConnection(propertiesURL, user, senha);  
			
			System.out.println("Conexao OK");   
			Statement st = c.createStatement();
			
			
			if(c != null){
				status = "sucesso";
			}
			else{
				status = "erro";
			}
				
			/*ResultSet rs = st.executeQuery("Select * from Produto where NmProduto like'%"+ s+"%'");   
						while (rs.next()){   
							String pNome = rs.getString("NmProduto");   
							System.out.println( " NOME: " + pNome); 
							if(!rs.next())
							{
								System.out.print("n�o encontrado");
							}

			 */

			//st.close();   
			//conexao.close(); 


		}
		catch (Exception e){   
			e.printStackTrace();
			status = e.getMessage();

		}
		
		return sf;
	}
	public void ExecuteSql(String Sql)
	{
		try{
			Statement st = conexao.createStatement();
			rs = st.executeQuery(Sql);   
			/*	while (rs.next()){   
							String pNome = rs.getString("NmProduto");   
							System.out.println( " NOME: " + pNome); 
			 */		

		}


		catch (Exception e)
		{

		}

	}
	public void ExecuteCreate(String Sql)
	{
		try{
			Statement st = conexao.createStatement();
			int i = st.executeUpdate(Sql);   
			System.out.println("rows: "+ i);

			/*	while (rs.next()){   
							String pNome = rs.getString("NmProduto");   
							System.out.println( " NOME: " + pNome); 
			 */		

		}


		catch (Exception e)
		{

		}

	}

	public void ExecuteInsert(String Sql) throws SQLException{
		PreparedStatement pp = conexao.prepareStatement(Sql);
		pp.execute();
	}

	public static void setUser(String user) {
		AbreConexaoSE.user = user;
	}
	public static String getUser() {
		return user;
	}
	public static void setSenha(String senha) {
		AbreConexaoSE.senha = senha;
	}
	public static String getSenha() {
		return senha;
	}

	public static void setConexao(Connection conexao) {
		conexao = conexao;
	}
	public static Connection getConexao() {
		return conexao;
	}
}



