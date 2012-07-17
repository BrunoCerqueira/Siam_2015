package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;



public class Resumo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="descricao_resumo")
	private String descricaoResumo;
	
	@Column(name="data_resumo")
	private Date data;
	
	@OneToOne
	@JoinColumn(name="idconsulta")
	private Consulta consulta;
	
	
	
	public Consulta getConsulta() {
		return consulta;
	}
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricaoResumo() {
		return descricaoResumo;
	}
	public void setDescricaoResumo(String descricaoResumo) {
		this.descricaoResumo = descricaoResumo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	

}
