package nelsys.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Fase {

	@Id
	private String idfase;
	private String nmfase;
	private String tpfase;
	private String stencerraatendimento;
	public String getIdfase() {
		return idfase;
	}
	public void setIdfase(String idfase) {
		this.idfase = idfase;
	}
	public String getNmfase() {
		return nmfase;
	}
	public void setNmfase(String nmfase) {
		this.nmfase = nmfase;
	}
	public String getTpfase() {
		return tpfase;
	}
	public void setTpfase(String tpfase) {
		this.tpfase = tpfase;
	}
	public String getStencerraatendimento() {
		return stencerraatendimento;
	}
	public void setStencerraatendimento(String stencerraatendimento) {
		this.stencerraatendimento = stencerraatendimento;
	}
	
	
	
}
