package nelsys.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Parecer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idparecer;
	private int idatendimento;
	private String idtipocontato;
	private String idworkflow;
	private String idworkflowitem;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtentradafase;
	private String idusuario;
	private String idfasedestino;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtinicioparecer;
	private String dsparecer;
	private String idtipoatendimento;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtfinalparecer;
	private String idfase;
	private String idusuarioproximocontato;
	private String dtproximocontato;
	private String nmpessoacontato;
	
	public void setNmpessoacontato(String nmpessoacontato) {
		this.nmpessoacontato = nmpessoacontato;
	}
	public String getNmpessoacontato() {
		return nmpessoacontato;
	}
	public int getIdparecer() {
		return idparecer;
	}
	public void setIdparecer(int idparecer) {
		this.idparecer = idparecer;
	}
	public int getIdatendimento() {
		return idatendimento;
	}
	public void setIdatendimento(int idatendimento) {
		this.idatendimento = idatendimento;
	}
	public String getIdtipocontato() {
		return idtipocontato;
	}
	public void setIdtipocontato(String idtipocontato) {
		this.idtipocontato = idtipocontato;
	}
	public String getIdworkflow() {
		return idworkflow;
	}
	public void setIdworkflow(String idworkflow) {
		this.idworkflow = idworkflow;
	}
	public String getIdWorkflowitem() {
		return idworkflowitem;
	}
	public void setIdWorkflowitem(String idworkflowitem) {
		this.idworkflowitem = idworkflowitem;
	}
	public Date getDtentradafase() {
		return dtentradafase;
	}
	public void setDtentradafase(Date dtentradafase) {
		this.dtentradafase = dtentradafase;
	}
	public String getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}
	public String getIdfasedestino() {
		return idfasedestino;
	}
	public void setIdfasedestino(String idfasedestino) {
		this.idfasedestino = idfasedestino;
	}
	public Date getDatainicioparecer() {
		return dtinicioparecer;
	}
	public void setDatainicioparecer(Date dtinicioparecer) {
		this.dtinicioparecer = dtinicioparecer;
	}
	public String getDsparecer() {
		return dsparecer;
	}
	public void setDsparecer(String dsparecer) {
		this.dsparecer = dsparecer;
	}
	public String getIdtipoatendimento() {
		return idtipoatendimento;
	}
	public void setIdtipoatendimento(String idtipoatendimento) {
		this.idtipoatendimento = idtipoatendimento;
	}
	public Date getDtfinalparecer() {
		return this.dtfinalparecer;
	}
	public void setDtfinalparecer(Date dtfinalparecer) {
		this.dtfinalparecer = dtfinalparecer;
	}
	public String getIdfase() {
		return idfase;
	}
	public void setIdfase(String idfase) {
		this.idfase = idfase;
	}
	public String getIdusuarioproximocontato() {
		return idusuarioproximocontato;
	}
	public void setIdusuarioproximocontato(String idusuarioproximocontato) {
		this.idusuarioproximocontato = idusuarioproximocontato;
	}
	public String getDtproximocontato() {
		return this.dtproximocontato;
	}
	public void setDtproximocontato(String dtproximocontato) {
		this.dtproximocontato = dtproximocontato;
	}
	
	public String dataFormatada(String data){
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	return format.format(data);
	}
}
