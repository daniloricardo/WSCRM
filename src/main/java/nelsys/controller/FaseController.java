package nelsys.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nelsys.model.Atendimento;
import nelsys.model.Fase;
import nelsys.model.Pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nelsys.repository.AtendimentoRepository;
import nelsys.repository.FaseRepository;
import nelsys.repository.PessoaRepository;

import com.thoughtworks.xstream.XStream;

@Controller
public class FaseController {

	@Autowired
	FaseRepository faseRepository;
	
	@RequestMapping(value="fase")
	public void clientes(HttpServletRequest request, HttpServletResponse response,String idfase) throws IOException{
		
		System.out.println("idfase: "+idfase);
		PrintWriter writer = response.getWriter();
		
		writer.print("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		Fase fase = faseRepository.findById(idfase);
		XStream stream = new XStream();
		stream.alias("fase", Fase.class);
		String xml = stream.toXML(fase);
		writer.print(xml);
		
	}
	
}
