package serviceImpl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import repository.PressaoRepository;
import service.PressaoService;
import entity.Pressao;

@Stateless
public class PressaoBean implements PressaoService{
	
	@EJB
	PressaoRepository pressaoRepository;

	@Override
	public Pressao retornaUltimaMedicao(Long idPessoa) {
		return pressaoRepository.getUltimaMedicao(idPessoa);
		
	}
	
	

}
