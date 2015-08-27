package serviceImpl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import repository.PacienteRepository;
import service.PacienteService;
import entity.Paciente;

@Stateless
public class PacienteBean implements PacienteService {
	
	@EJB
	PacienteRepository pacienteRepository;
	@Override
	public List<Paciente> retornaPacientesPorIdMedico(Long idMedico) {
		return pacienteRepository.retornaPacientesPorMedico(idMedico);
		
		 
	}
	public List<Paciente> retornarPacientesPorNome(String nome){
		return pacienteRepository.retornarPacientesPorNome(nome);
	}

}
