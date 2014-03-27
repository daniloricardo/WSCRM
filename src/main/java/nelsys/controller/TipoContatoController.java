package nelsys.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nelsys.model.Atendimento;
import nelsys.model.Pessoa;
import nelsys.model.Tipocontato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nelsys.repository.AtendimentoRepository;
import nelsys.repository.PessoaRepository;
import nelsys.repository.TipoContatoRepository;

import com.thoughtworks.xstream.XStream;

@Controller
public class TipoContatoController {

	@Autowired
	TipoContatoRepository tipoContatoRepository;
	
	@RequestMapping(value="tipocontato")
	public void clientes(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		PrintWriter writer = response.getWriter();
		
		writer.print("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		List<Tipocontato> lista = tipoContatoRepository.lista();
		XStream stream = new XStream();
		stream.alias("tipocontato", Tipocontato.class);
		String xml = stream.toXML(lista);
		writer.print(xml);
		
	}
	
}
