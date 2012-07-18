package serviceImpl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import entity.Medico;
import repository.MedicoRepository;
import service.MedicoService;

@Stateless
public class MedicoBean implements MedicoService{

	@EJB
	MedicoRepository medicoRepository;
	
	@Override
	public List<Medico> retornaMedicos() {
		
		return medicoRepository.retornaAll();
	}

	@Override
	public List<Medico> retornaMedicosByConsultorio(Long idConsultorio) {
		
		return medicoRepository.retornaMedicosByIdConsultorio(idConsultorio);
	}

}
