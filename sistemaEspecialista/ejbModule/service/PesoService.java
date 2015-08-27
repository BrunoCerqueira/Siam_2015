package service;

import java.util.List;

import javax.ejb.Local;

import entity.Peso;

@Local
public interface PesoService {
	
	public List<Peso> retornaPesosById(Long idPaciente);
	public Peso retornaUltimaMedicao(Long id);

}
