package repository;



import javax.ejb.Stateless;

import entity.Paciente;

@Stateless
public class PacienteRepository extends repository{
	
	
	public void salva(Paciente paciente){
		entityManager.persist(paciente);
	}
	

}
