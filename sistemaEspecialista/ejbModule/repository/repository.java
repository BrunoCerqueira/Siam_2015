package repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

  
public abstract class repository<T> {
	@PersistenceContext(name="siamDS")
	EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	public T salvar(T registro){
		entityManager.persist(registro);
		return registro;
	}
	public void remover(T registro){
		entityManager.remove(registro);
	}



}
