package repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import entity.HistoricoFatoresRisco;
import entity.Peso;
import entity.Pressao;

@Stateless
public class HistoricoFatoresRiscoRepository extends repository{
	
	@SuppressWarnings("unchecked")
	public HistoricoFatoresRisco retornaHistoricoByIdPessoa(Long idPessoa){
		HistoricoFatoresRisco historico = null;
		try{
		Query query = getEntityManager().createNamedQuery("HistoricoFatoresRisco.findHistoricoByIdPessoa");
		query.setParameter("idPessoa", idPessoa);
		 historico = (HistoricoFatoresRisco) query.getSingleResult();
		 
		 Query queryPesos = getEntityManager().createNamedQuery("Peso.findPesos");
			queryPesos.setParameter("id", idPessoa);

			
			List<Peso> pesos = (List<Peso>) queryPesos.getResultList();
			historico.setPeso(pesos);
			
			Query queryPressao = getEntityManager().createNamedQuery("Pressao.findPressao");
			queryPressao.setParameter("id", idPessoa);
			List<Pressao> pressoes = queryPressao.getResultList();
			historico.setPressao(pressoes);
			
		}
		catch(NoResultException e){
			historico = null;
			
		}
		catch(Exception e ){
			e.printStackTrace();
		}
		return historico;
		
	}
	

}
