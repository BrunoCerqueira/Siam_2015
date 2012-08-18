package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "consulta", schema = "siam")
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idconsulta")
	private Long id;

	@Column(name = "tipo_consulta")
	private Long tipoConsulta;

	@Column(name = "data_consulta")
	private Date dataConsulta;

	@OneToOne
	@JoinColumn(name = "fk_paciente")
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name = "fk_medico")
	private Medico medico;

	@OneToOne
	@JoinColumn(name = "fk_resumo")
	private Resumo resumo;

	public Resumo getResumo() {
		return resumo;
	}

	public void setResumo(Resumo resumo) {
		this.resumo = resumo;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Long getId() {
		return id;

	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTipoConsulta() {
		return tipoConsulta;
	}

	public void setTipoConsulta(Long tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}

	public Date getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

}
