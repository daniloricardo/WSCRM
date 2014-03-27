package nelsys.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nelsys.model.Pessoa;
import nelsys.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nelsys.repository.PessoaRepository;
import nelsys.repository.UsuarioRepository;

import com.thoughtworks.xstream.XStream;

@Controller
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@RequestMapping(value="usuarios")
	public void usuarios(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		PrintWriter writer = response.getWriter();
		
		writer.print("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		List<Usuario> lista = usuarioRepository.lista();
		XStream stream = new XStream();
		stream.alias("usuario", Usuario.class);
		String xml = stream.toXML(lista);
		writer.print(xml);
		
	}
	
}
