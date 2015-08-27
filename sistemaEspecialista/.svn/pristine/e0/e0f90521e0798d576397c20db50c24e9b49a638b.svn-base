package serviceImpl;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import repository.PessoaRepository;
import service.PessoaService;
import entity.Pessoa;

@Stateless
@LocalBean
public class PessoaBean implements PessoaService {

	@EJB
	PessoaRepository pessoaRepository = new PessoaRepository();

	@Override
	public Pessoa buscarPessoaPorSenha(String senha) {
		return pessoaRepository.findBySenha(senha);

	}

	@Override
	public Pessoa buscarPessoaPorLogin(String nome, String senha) {
		return pessoaRepository.findByLogin(nome, senha);

	}
	

}
