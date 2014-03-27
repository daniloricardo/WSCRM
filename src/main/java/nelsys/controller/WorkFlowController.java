package nelsys.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nelsys.model.Pessoa;
import nelsys.model.Usuario;
import nelsys.model.WorkFlowItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nelsys.repository.PessoaRepository;
import nelsys.repository.UsuarioRepository;
import nelsys.repository.WorkFlowItemRepository;

import com.thoughtworks.xstream.XStream;

@Controller
public class WorkFlowController {

	@Autowired
	WorkFlowItemRepository workFlowItemRepository;
	
	@RequestMapping(value="workflow")
	public void clientes(HttpServletRequest request, HttpServletResponse response,String idworkflow,String idfase) throws IOException{
		System.out.println("request workflow = idworkflow: "+idworkflow+ " idfase: "+idfase);
		PrintWriter writer = response.getWriter();
		
		writer.print("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		List<WorkFlowItem> lista = workFlowItemRepository.listaProximo(idworkflow, idfase);
		XStream stream = new XStream();
		stream.alias("workflow", WorkFlowItem.class);
		String xml = stream.toXML(lista);
		writer.print(xml);
		
	}
	@RequestMapping(value="workflowporordem")
	public void workflowporordem(HttpServletRequest request,HttpServletResponse response,String idworkflow,String cdordem,String tipo) throws IOException{
		System.out.println("POR ORDEM: request workflow = idworkflow: "+idworkflow+ " idfase: "+cdordem+
				" tipo: "+tipo);
		PrintWriter writer = response.getWriter();
		writer.print("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		WorkFlowItem lista; 
		if("D".equals(tipo)){
		lista = (WorkFlowItem) workFlowItemRepository.localizaPorWorkFlowEOrdem(idworkflow, cdordem);
		}
		else{
		lista = (WorkFlowItem) workFlowItemRepository.localizaPorWorkFlowEOrdemB(idworkflow, cdordem);	
		}
		XStream stream = new XStream();
		stream.alias("workflow", WorkFlowItem.class);
		String xml = stream.toXML(lista);
		writer.print(xml);
		
	}
	
}
