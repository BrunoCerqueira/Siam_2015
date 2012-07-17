package service;

import javax.ejb.Local;

import entity.Pessoa;


@Local
public interface  PessoaService {
	
	

	public Pessoa buscarPessoaPorSenha(String senha);
	public Pessoa buscarPessoaPorLogin(String nome, String senha);

}
