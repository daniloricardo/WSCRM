package nelsys.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {
	@Id
	private String idusuario;
	private String nmusuario;
	private String nmlogin;
	private String stativo;
	
	public void setStativo(String stativo) {
		this.stativo = stativo;
	}
	public String getStativo() {
		return stativo;
	}
	public String getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}
	public String getNmusuario() {
		return nmusuario;
	}
	public void setNmusuario(String nmusuario) {
		this.nmusuario = nmusuario;
	}
	public String getNmlogin() {
		return nmlogin;
	}
	public void setNmlogin(String nmlogin) {
		this.nmlogin = nmlogin;
	}
	
	

}
