package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "resumo", schema = "siam")
public class Resumo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idresumo")
	private Long id;

	@Column(name = "descricao")
	private String descricaoResumo;

	@Column(name = "data_resumo")
	private Date data;

	@OneToOne
	@JoinColumn(name = "id_consulta")
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
