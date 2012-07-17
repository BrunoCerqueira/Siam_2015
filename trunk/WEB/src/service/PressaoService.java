package service;

import javax.ejb.Local;

import entity.Pressao;

@Local
public interface PressaoService {
	
	public Pressao retornaUltimaMedicao(Long idPessoa);

}
