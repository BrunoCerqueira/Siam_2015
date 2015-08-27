package repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import entity.Medico;

@Stateless
public class MedicoRepository extends repository<Medico> {
	
	@SuppressWarnings("unchecked")
	public List<Medico> retornaAll(){
		Query query = getEntityManager().createNamedQuery("Medico.findAll");
		List<Medico> medicos = (List<Medico>)query.getResultList();
		return medicos;
		
	}
	@SuppressWarnings("unchecked")
	public List<Medico> retornaMedicosByIdConsultorio(Long idConsultorio){
		Query query = getEntityManager().createNamedQuery("Medico.findMedicoByIdConsultorio");
		query.setParameter("idConsultorio", idConsultorio);
		List<Medico> medicos = (List<Medico>)query.getResultList();
		return medicos;
		
	}

}
