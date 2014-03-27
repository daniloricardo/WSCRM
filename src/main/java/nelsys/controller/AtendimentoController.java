package nelsys.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nelsys.model.Atendimento;
import nelsys.model.Pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nelsys.repository.AtendimentoRepository;
import nelsys.repository.PessoaRepository;

import com.thoughtworks.xstream.XStream;

@Controller
public class AtendimentoController {

	@Autowired
	AtendimentoRepository atendimentoRepository;
	
	@RequestMapping(value="atendimentos")
	public void clientes(HttpServletRequest request, HttpServletResponse response,String idusuario) throws IOException{
		
		System.out.println("idusuario....: "+idusuario);
		PrintWriter writer = response.getWriter();
		
		writer.print("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		List<Atendimento> lista = atendimentoRepository.findAllPorUsuario(idusuario);
		XStream stream = new XStream();
		stream.setMode(XStream.NO_REFERENCES);
		stream.alias("atendimento", Atendimento.class);
		String xml = stream.toXML(lista);
		writer.print(xml);
		System.out.println(xml);
		
	}
	
}
