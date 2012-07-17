package repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

  
public abstract class repository {
	@PersistenceContext(name="siamDS")
	EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}



}
