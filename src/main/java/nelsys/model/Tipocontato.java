package nelsys.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Tipocontato {

	@Id
	private String idtipocontato;
	private String cdchamada;
	private String nmtipocontato;
	public String getIdtipocontato() {
		return idtipocontato;
	}
	public void setIdtipocontato(String idtipocontato) {
		this.idtipocontato = idtipocontato;
	}
	public String getCdchamada() {
		return cdchamada;
	}
	public void setCdchamada(String cdchamada) {
		this.cdchamada = cdchamada;
	}
	public String getNmtipocontato() {
		return nmtipocontato;
	}
	public void setNmtipocontato(String nmtipocontato) {
		this.nmtipocontato = nmtipocontato;
	}
	
	
	
}
