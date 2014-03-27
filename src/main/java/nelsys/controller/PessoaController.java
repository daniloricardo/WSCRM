package nelsys.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nelsys.model.Pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nelsys.repository.PessoaRepository;

import com.thoughtworks.xstream.XStream;

@Controller
public class PessoaController {

	@Autowired
	PessoaRepository pessoaRepository;
	
	@RequestMapping(value="clientes")
	public void clientes(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		PrintWriter writer = response.getWriter();
		
		writer.print("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		List<Pessoa> lista = pessoaRepository.lista();
		XStream stream = new XStream();
		stream.alias("pessoa", Pessoa.class);
		String xml = stream.toXML(lista);
		writer.print(xml);
		
	}
	
}
