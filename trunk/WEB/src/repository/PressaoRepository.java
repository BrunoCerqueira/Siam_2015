package repository;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import entity.Pressao;

@Stateless
public class PressaoRepository extends repository{
	
	public Pressao getUltimaMedicao(Long idPessoa){
		Pressao pressao = null;
		try{
			Query query = getEntityManager().createNamedQuery("Pressao.findUltimaMedicao");
		
		
		query.setParameter("id", idPessoa);
		 pressao = (Pressao) query.getSingleResult();
		}
		catch(NoResultException e){
			pressao = null;
		}
		catch(Exception  e){
			e.printStackTrace();
		}
		return pressao;
	}

}
