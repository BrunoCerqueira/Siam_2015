package repository;



import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import entity.Medico;
import entity.Paciente;

@Stateless
public class PacienteRepository extends repository<Medico>{
	
	
	public void salva(Paciente paciente){
		entityManager.persist(paciente);
	}
	
	@SuppressWarnings("unchecked")
	public List<Paciente> retornaPacientesPorMedico(Long idMedico){
		Query query = entityManager.createNamedQuery("Paciente.findByIdMedico");
		query.setParameter("idMedico",idMedico);
		List<Paciente> pacientes = (List<Paciente>)query.getResultList();
		return pacientes;
	}

	public List<Paciente> retornarPacientesPorNome(String nome) {
		Query query = entityManager.createNamedQuery("Paciente.findByName");
		query.setParameter("nome",nome);
		List<Paciente> pacientes = (List<Paciente>)query.getResultList();
		return pacientes;
		
		
	}
	

}