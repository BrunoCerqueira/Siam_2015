package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="idPessoa")
@Table(name = "medico", schema = "siam")
@NamedQueries({		
	@NamedQuery(name="Medico.findAll", query="SELECT obj FROM Medico obj " ),
	@NamedQuery(name="Medico.findMedicoByIdConsultorio", query="SELECT obj FROM Medico obj WHERE obj.consultorio.id = :idConsultorio" )
	
	
})
public class Medico extends Pessoa{
	
	@Column(name="especialidade")
	private String especialidade;
	
	@OneToMany
	@JoinColumn(name="fk_paciente")
	private List<Paciente> paciente;
	
	@ManyToOne
	@JoinColumn(name="fk_consultorio")
	private Consultorio consultorio;

	public Consultorio getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(Consultorio consultorio) {
		this.consultorio = consultorio;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public List<Paciente> getPaciente() {
		return paciente;
	}

	public void setPaciente(List<Paciente> paciente) {
		this.paciente = paciente;
	}

	
	

}
