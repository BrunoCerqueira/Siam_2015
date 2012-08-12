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
@Table(name="peso", schema="siam")
@NamedQueries({
	@NamedQuery(name = "Peso.findPesos", query = "SELECT obj FROM Peso obj where obj.historicoFatoresRisco.paciente.id = :id"),
	@NamedQuery(name = "Peso.findUltimaMedicao", query = "SELECT obj FROM Peso obj " +
			"WHERE obj.historicoFatoresRisco.paciente.id = :id " +
			"AND obj.data = (SELECT MAX(obj2.data) FROM Peso obj2 WHERE  obj2.historicoFatoresRisco.paciente.id = :id)")
})
	

public class Peso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idpeso")
	private Long id;
	
	@Column(name="valor")
	private int valor;
	
	@Column(name="data_peso")
	private Date data;
	
	@ManyToOne
	@JoinColumn(name = "id_historico_riscos")
	private HistoricoFatoresRisco historicoFatoresRisco;
	
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
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
	public HistoricoFatoresRisco getHistoricoFatoresRisco() {
		return historicoFatoresRisco;
	}
	public void setHistoricoFatoresRisco(HistoricoFatoresRisco historicoFatoresRisco) {
		this.historicoFatoresRisco = historicoFatoresRisco;
	}
	

}
