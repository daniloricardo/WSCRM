package nelsys.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Atendimento {

	@Id
	private int idatendimento;
	@Temporal(TemporalType.DATE)
	private Date dtatendimento;
	private String idtipoatendimento;
	private String stencerrado;
	private String idusuario;
	private String cdchamada;
	@Temporal(TemporalType.TIME)
	private Date dtentradafase;
	private String idfase;
	private String dtproximoatendimento;
	@OneToOne
	@JoinColumn(name="idpessoa",referencedColumnName="idpessoa")
	private Pessoa idpessoa;
	private String idusuarioinicial;
	@Temporal(TemporalType.DATE)
	private Date dtultimaatualizacao;
	@Temporal(TemporalType.DATE)
	private Date dtencerramento;
	public int getIdatendimento() {
		return idatendimento;
	}
	public void setIdatendimento(int idatendimento) {
		this.idatendimento = idatendimento;
	}
	public Date getDtatendimento() {
		return dtatendimento;
	}
	public void setDtatendimento(Date dtatendimento) {
		this.dtatendimento = dtatendimento;
	}
	public String getIdtipoatendimento() {
		return idtipoatendimento;
	}
	public void setIdtipoatendimento(String idtipoatendimento) {
		this.idtipoatendimento = idtipoatendimento;
	}
	public String getStencerrado() {
		return stencerrado;
	}
	public void setStencerrado(String stencerrado) {
		this.stencerrado = stencerrado;
	}
	public String getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}
	public String getCdchamada() {
		return cdchamada;
	}
	public void setCdchamada(String cdchamada) {
		this.cdchamada = cdchamada;
	}
	public Date getDtentradafase() {
		return dtentradafase;
	}
	public void setDtentradafase(Date dtentradafase) {
		this.dtentradafase = dtentradafase;
	}
	public String getIdfase() {
		return idfase;
	}
	public void setIdfase(String idfase) {
		this.idfase = idfase;
	}
	public String getDtproximoatendimento() {
		return dtproximoatendimento;
	}
	public void setDtproximoatendimento(String dtproximoatendimento) {
		this.dtproximoatendimento = dtproximoatendimento;
	}
	public Pessoa getIdpessoa() {
		return idpessoa;
	}
	public void setIdpessoa(Pessoa idpessoa) {
		this.idpessoa = idpessoa;
	}
	public String getIdusuarioinicial() {
		return idusuarioinicial;
	}
	public void setIdusuarioinicial(String idusuarioinicial) {
		this.idusuarioinicial = idusuarioinicial;
	}
	public Date getDtultimaatualizacao() {
		return dtultimaatualizacao;
	}
	public void setDtultimaatualizacao(Date dtultimaatualizacao) {
		this.dtultimaatualizacao = dtultimaatualizacao;
	}
	public Date getDtencerramento() {
		return dtencerramento;
	}
	public void setDtencerramento(Date dtencerramento) {
		this.dtencerramento = dtencerramento;
	}
	
	
	
	
}
