package repository;



import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import entity.Paciente;

@Stateless
public class PacienteRepository extends repository{
	
	
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
	

}
