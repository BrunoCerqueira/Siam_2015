package service;

import java.util.List;

import javax.ejb.Local;

import entity.Paciente;

@Local
public interface PacienteService {

	public List<Paciente> retornaPacientesPorIdMedico(Long idMedico);
	public List<Paciente> retornarPacientesPorNome(String nome);
}
