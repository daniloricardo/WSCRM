package nelsys.controller;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import nelsys.conexao.AbreConexaoSE;
import nelsys.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

@Controller
public class ValidaLoginController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@SuppressWarnings("static-access")
	@RequestMapping("login")
	public void login(HttpServletRequest request,HttpServletResponse response) throws IOException, ParserConfigurationException, SAXException, SQLException{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String inputLine;
		StringBuffer resp = new StringBuffer();
		while((inputLine = reader.readLine()) != null){
			resp.append(inputLine);
		}
		reader.close();
		System.out.println(resp.toString());
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = (Document) db.parse(new ByteArrayInputStream(resp.toString().getBytes()));
		Element elementUser = (Element) doc.getElementsByTagName("login").item(0);
		Element elementPass = (Element) doc.getElementsByTagName("senha").item(0);
		System.out.println("user: "+elementUser.getTextContent());
		System.out.println("pass: "+elementPass.getTextContent());
		String user = elementUser.getTextContent();
		String pass = elementPass.getTextContent();
		AbreConexaoSE con = new AbreConexaoSE();
		con.setUser(user);
		con.setSenha(pass);
		con.Conectar();
		String idusario = "";
		idusario = usuarioRepository.selecionaUsuarioPorLogin(user).getIdusuario();
		
		PrintWriter writer = response.getWriter();
		writer.print("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		String xml = "<mensagem>";
		xml += "<status>"+con.status+"</status>";
		xml += "<idusuario>"+idusario+"</idusuario>";
		xml += "</mensagem>";
		writer.print(xml);
		
	}

}
