package repository;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import entity.Pessoa;

@Stateless
public class PessoaRepository extends repository {

	public Pessoa findBySenha(String senha) {
		Pessoa p = null;
		try {
			Query query = getEntityManager().createNamedQuery(
					"Pessoa.findPessoaPorSenha");
			query.setParameter("senha", senha);

			p = (Pessoa) query.getSingleResult();
		} catch (NoResultException e) {
			p = null;
		} catch (RuntimeException e) {
			e.printStackTrace();
	

		}
		return p;
	}
	
	
	
	public Pessoa findByLogin(String nome, String senha) {
		Pessoa p = null;
		try {
			Query query = getEntityManager().createNamedQuery(
					"Pessoa.findPessoaPorLogin");
			query.setParameter("senha", senha);
			query.setParameter("nome", nome);
			p = (Pessoa) query.getSingleResult();
		} catch (NoResultException e) {
			p = null;
		} catch (RuntimeException e) {
			e.printStackTrace();
	

		}
		return p;
	}
}