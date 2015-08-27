package facade;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Operacao;



@Stateless
public class OfertaOperacaoService {
	
	@PersistenceContext(unitName="siamDS")
	private EntityManager entityManager;
	
	public Operacao salvarOperacao(Operacao operacao){
		entityManager.persist(operacao);
		return operacao;
	}
	@SuppressWarnings("unchecked")
	public List<Operacao> recuperarOperacoes(){
		Query query = entityManager.createQuery("SELECT o FROM Operacao o ");
		return query.getResultList();
	}
	
	
}
