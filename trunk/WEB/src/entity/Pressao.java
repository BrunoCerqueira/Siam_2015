package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "pressao", schema = "siam")
@NamedQueries({
	@NamedQuery(name = "Pressao.findPressao", query = "SELECT obj FROM Pressao obj WHERE obj.historicoFatoresRisco.paciente.id = :id"),
	@NamedQuery(name = "Pressao.findUltimaMedicao", query = "SELECT obj FROM Pressao obj " +
			"WHERE obj.historicoFatoresRisco.paciente.id = :id " +
			"AND obj.data = (SELECT MAX(obj2.data) FROM Pressao obj2 WHERE  obj2.historicoFatoresRisco.paciente.id = :id)")
})
public class Pressao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idpressao")
	private Long id;
	
	@Column(name="valor_sistolica")
	private Integer valorSistolica;
	
	@Column(name="valor_diastolica")
	private Integer valorDiastolica;
	
	
	@Column(name="data_pressao")
	private Date data;
	
	@ManyToOne
	@JoinColumn(name = "fk_hist_fator_risc")
	private HistoricoFatoresRisco historicoFatoresRisco;
	
	
	public HistoricoFatoresRisco getHistoricoFatoresRisco() {
		return historicoFatoresRisco;
	}
	public void setHistoricoFatoresRisco(HistoricoFatoresRisco historicoFatoresRisco) {
		this.historicoFatoresRisco = historicoFatoresRisco;
	}
	
	public Integer getValorSistolica() {
		return valorSistolica;
	}
	public void setValorSistolica(Integer valorSistolica) {
		this.valorSistolica = valorSistolica;
	}
	public Integer getValorDiastolica() {
		return valorDiastolica;
	}
	public void setValorDiastolica(Integer valorDiastolica) {
		this.valorDiastolica = valorDiastolica;
	}

	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	

}
