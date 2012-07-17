package serviceImpl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import repository.PesoRepository;
import service.PesoService;
import entity.Peso;

@Stateless
public class PesoBean implements PesoService {

	@EJB
	PesoRepository pesoRepository = new PesoRepository();
	@Override
	public List<Peso> retornaPesosById(Long idPaciente) {
		return pesoRepository.retornaPesosById(idPaciente);
		
		
	}
	@Override
	public Peso retornaUltimaMedicao(Long id) {
		
		return pesoRepository.retornaUltimaMedicao(id);
	}

}
