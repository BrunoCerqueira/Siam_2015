package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "paciente", schema = "siam")
@NamedQueries({		
	@NamedQuery(name="Paciente.findByIdMedico", query="SELECT obj FROM Paciente obj WHERE obj.medico.id = :idMedico" )
	
	
})
public class Paciente extends Pessoa {
	
	@Column(name="nome_pai")
	private String nomePai;
	
	@Column(name="nome_mae")
	private String nomeMae;
	
	@Column(name="altura")
	private Integer altura;

	@ManyToOne
	@JoinColumn(name="idconvenio")
	private Convenio convenio;
	
	@ManyToOne
	@JoinColumn(name="fk_medico")
	private Medico medico;
	
	@OneToOne
	@JoinColumn(name="fk_fator_risc")
	private HistoricoFatoresRisco historicoFatoresRisco;

	
	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Convenio getConvenio() {
		return convenio;
	}

	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	public HistoricoFatoresRisco getHistoricoFatoresRisco() {
		return historicoFatoresRisco;
	}

	public void setHistoricoFatoresRisco(
			HistoricoFatoresRisco historicoFatoresRisco) {
		this.historicoFatoresRisco = historicoFatoresRisco;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	
}
