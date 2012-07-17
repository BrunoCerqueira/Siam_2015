package serviceImpl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import entity.Pressao;

import repository.PressaoRepository;
import service.PressaoService;

@Stateless
public class PressaoBean implements PressaoService{
	
	@EJB
	PressaoRepository pressaoRepository;

	@Override
	public Pressao retornaUltimaMedicao(Long idPessoa) {
		return pressaoRepository.getUltimaMedicao(idPessoa);
		
	}
	
	

}
