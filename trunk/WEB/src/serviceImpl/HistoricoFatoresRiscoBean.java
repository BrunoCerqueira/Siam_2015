package serviceImpl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import entity.HistoricoFatoresRisco;

import repository.HistoricoFatoresRiscoRepository;
import service.HistoricoFatoresRiscoService;

@Stateless
public class HistoricoFatoresRiscoBean implements HistoricoFatoresRiscoService {

	@EJB
	HistoricoFatoresRiscoRepository historicoFatoresRiscoRepository;
	@Override
	public HistoricoFatoresRisco retornaHistorico(Long idPessoa) {
		return historicoFatoresRiscoRepository.retornaHistoricoByIdPessoa(idPessoa);
			}

}
