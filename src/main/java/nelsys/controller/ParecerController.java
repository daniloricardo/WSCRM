package nelsys.controller;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import nelsys.model.Parecer;
import nelsys.model.Pessoa;
import nelsys.repository.AtendimentoRepository;
import nelsys.repository.ParecerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.sun.imageio.plugins.common.InputStreamAdapter;
import com.thoughtworks.xstream.XStream;

@Controller
public class ParecerController {

	@Autowired
	ParecerRepository parecerRepository;
	@Autowired
	AtendimentoRepository atendimentoRepository;
	
	@RequestMapping(value="parecer")
	public void clientes(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		int idatendimento = Integer.parseInt(request.getParameter("idatendimento"));
		PrintWriter writer = response.getWriter();
		System.out.println("idatendimento: "+idatendimento);
		writer.print("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		List<Parecer> lista = parecerRepository.listaPorId(idatendimento);
		XStream stream = new XStream();
		stream.alias("parecer", Parecer.class);
		String xml = stream.toXML(lista);
		writer.print(xml);
		
	}
	@RequestMapping(value="InsereParecer")
	public void insereParecer(HttpServletRequest request, HttpServletResponse response) throws IOException, ParserConfigurationException, SAXException{
		System.out.println("chegou... ");
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(request.getInputStream()));
		String inputLine;
		StringBuffer resp = new StringBuffer();
		while((inputLine = bufferedReader.readLine()) != null){
			resp.append(inputLine);
		}
		bufferedReader.close();
		System.out.println(resp.toString());
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		final Document doc = db.parse(new ByteArrayInputStream(resp.toString().getBytes()));
		final NodeList parecerNode = doc.getElementsByTagName("parecer");
		Element element = (Element) parecerNode.item(0);
		Node node = element;
		Element edsparecer = (Element) doc.getElementsByTagName("dsparecer").item(0);
		String dsparecer = edsparecer.getTextContent();
		Element edtproximocontato = (Element) doc.getElementsByTagName("dtproximocontato").item(0);
		String dtproximocontato = edtproximocontato.getTextContent();
		Element eidatendimento = (Element) doc.getElementsByTagName("idatendimento").item(0);
		String idatendimento = eidatendimento.getTextContent();
		Element eidfase = (Element) doc.getElementsByTagName("idfase").item(0);
		String idfase = eidfase.getTextContent();
		Element eidproximafase = (Element) doc.getElementsByTagName("idproximafase").item(0);
		String idproximafase = eidproximafase.getTextContent();
		Element eidtipoatendimento = (Element) doc.getElementsByTagName("idtipoatendimento").item(0);
		String idtipoatendimento = eidtipoatendimento.getTextContent();
		Element eidtipocontato = (Element) doc.getElementsByTagName("idtipocontato").item(0);
		String idtipocontato = eidtipocontato.getTextContent();
		Element eidusuario = (Element) doc.getElementsByTagName("idusuario").item(0);
		String idusario = eidusuario.getTextContent();
		Element eidusuarioParecer = (Element) doc.getElementsByTagName("idusuarioparecer").item(0);
		String idusarioparecer = eidusuarioParecer.getTextContent();
		Element eidworkflow = (Element) doc.getElementsByTagName("idworkflow").item(0);
		String idworkflow = eidworkflow.getTextContent();
		Element eidworkflowitem = (Element) doc.getElementsByTagName("idworkflowitem").item(0);
		String idworkflowitem = eidworkflowitem.getTextContent();
		Element enmpessoacontato = (Element) doc.getElementsByTagName("nmpessoacontato").item(0);
		String nmpessoacontato = enmpessoacontato.getTextContent();
		System.out.println(dsparecer);
		System.out.println(idatendimento+" atendimento(Integer): "+Integer.parseInt(idatendimento));
		System.out.println(idtipocontato);
		System.out.println(idtipoatendimento);
		System.out.println(idworkflow);
		System.out.println(nmpessoacontato);
		System.out.println("IdUsuario: "+idusario);
		Parecer parecer = new Parecer();
		parecer.setIdatendimento(Integer.parseInt(idatendimento));
		parecer.setDsparecer(dsparecer);
		parecer.setIdtipocontato(idtipocontato);
		parecer.setNmpessoacontato(nmpessoacontato);
		parecer.setIdtipoatendimento(idtipoatendimento);
		Date data = new Date();
		parecer.setDtentradafase(data);
		parecer.setDtfinalparecer(data);
		parecer.setDatainicioparecer(data);
		parecer.setDtproximocontato(dtproximocontato);
		parecer.setIdusuario(idusarioparecer);
		parecer.setIdusuarioproximocontato(idusario);
		parecer.setIdworkflow(idworkflow);
		parecer.setIdWorkflowitem(idworkflowitem);
		parecer.setIdfase(idfase);
		parecer.setIdfasedestino(idproximafase);
		parecerRepository.insereParecer(parecer);
		atendimentoRepository.atualizaAtendimento(parecer);
	}
}
