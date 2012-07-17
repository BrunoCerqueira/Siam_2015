package repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import entity.Peso;

@Stateless
public class PesoRepository extends repository {

	@SuppressWarnings("unchecked")
	public List<Peso> retornaPesosById(Long idPaciente) {
		List<Peso> pesos;

		Query query = getEntityManager().createNamedQuery("Peso.findPesos");
		query.setParameter("id", idPaciente);

		pesos = (List<Peso>) query.getResultList();

		return pesos;

	}

	public Peso retornaUltimaMedicao(Long idPaciente){
		Peso peso = null;
		try{
		Query query = getEntityManager().createNamedQuery("Peso.findUltimaMedicao");
		query.setParameter("id", idPaciente);
		peso = (Peso) query.getSingleResult();
		}
		catch(NoResultException e){
			peso = null;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return peso;
	}
}
