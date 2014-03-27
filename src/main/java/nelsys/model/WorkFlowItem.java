package nelsys.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="workflowitem")
public class WorkFlowItem {
	@Id
	private String idworkflowitem;
	private String idworkflow;
	private String cdordem;
	private String idfase;
	private String tpinformacao;
	private String dspergunta;
	private String dsresposta1;
	private String dsresposta2;
	private String dsresposta3;
	private String dsresposta4;
	private String dsresposta5;
	private String dsresposta6;
	private String cdordem1;
	private String cdordem2;
	private String cdordem3;
	private String cdordem4;
	private String cdordem5;
	private String cdordem6;
	private String stusuarioobrigatorio;
	private String cdproximaordem;
	
	public void setCdproximaordem(String cdproximaordem) {
		this.cdproximaordem = cdproximaordem;
	}
	public String getCdproximaordem() {
		return cdproximaordem;
	}
	public String getIdworkflowitem() {
		return idworkflowitem;
	}
	public void setIdworkflowitem(String idworkflowitem) {
		this.idworkflowitem = idworkflowitem;
	}
	public String getIdworkflow() {
		return idworkflow;
	}
	public void setIdworkflow(String idworkflow) {
		this.idworkflow = idworkflow;
	}
	public String getCdordem() {
		return cdordem;
	}
	public void setCdordem(String cdordem) {
		this.cdordem = cdordem;
	}
	public String getIdfase() {
		return idfase;
	}
	public void setIdfase(String idfase) {
		this.idfase = idfase;
	}
	public String getTpinformacao() {
		return tpinformacao;
	}
	public void setTpinformacao(String tpinformacao) {
		this.tpinformacao = tpinformacao;
	}
	public String getDspergunta() {
		return dspergunta;
	}
	public void setDspergunta(String dspergunta) {
		this.dspergunta = dspergunta;
	}
	public String getDsresposta1() {
		return dsresposta1;
	}
	public void setDsresposta1(String dsresposta1) {
		this.dsresposta1 = dsresposta1;
	}
	public String getDsresposta2() {
		return dsresposta2;
	}
	public void setDsresposta2(String dsresposta2) {
		this.dsresposta2 = dsresposta2;
	}
	public String getDsresposta3() {
		return dsresposta3;
	}
	public void setDsresposta3(String dsresposta3) {
		this.dsresposta3 = dsresposta3;
	}
	public String getDsresposta4() {
		return dsresposta4;
	}
	public void setDsresposta4(String dsresposta4) {
		this.dsresposta4 = dsresposta4;
	}
	public String getDsresposta5() {
		return dsresposta5;
	}
	public void setDsresposta5(String dsresposta5) {
		this.dsresposta5 = dsresposta5;
	}
	public String getDsresposta6() {
		return dsresposta6;
	}
	public void setDsresposta6(String dsresposta6) {
		this.dsresposta6 = dsresposta6;
	}
	public String getCdordem1() {
		return cdordem1;
	}
	public void setCdordem1(String cdordem1) {
		this.cdordem1 = cdordem1;
	}
	public String getCdordem2() {
		return cdordem2;
	}
	public void setCdordem2(String cdordem2) {
		this.cdordem2 = cdordem2;
	}
	public String getCdordem3() {
		return cdordem3;
	}
	public void setCdordem3(String cdordem3) {
		this.cdordem3 = cdordem3;
	}
	public String getCdordem4() {
		return cdordem4;
	}
	public void setCdordem4(String cdordem4) {
		this.cdordem4 = cdordem4;
	}
	public String getCdordem5() {
		return cdordem5;
	}
	public void setCdordem5(String cdordem5) {
		this.cdordem5 = cdordem5;
	}
	public String getCdordem6() {
		return cdordem6;
	}
	public void setCdordem6(String cdordem6) {
		this.cdordem6 = cdordem6;
	}
	public String getStusuarioobrigatorio() {
		return stusuarioobrigatorio;
	}
	public void setStusuarioobrigatorio(String stusuarioobrigatorio) {
		this.stusuarioobrigatorio = stusuarioobrigatorio;
	}
	
	
	
	
}
