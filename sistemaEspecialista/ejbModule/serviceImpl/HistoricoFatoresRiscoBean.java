package serviceImpl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import repository.HistoricoFatoresRiscoRepository;
import service.HistoricoFatoresRiscoService;
import entity.HistoricoFatoresRisco;

@Stateless
public class HistoricoFatoresRiscoBean implements HistoricoFatoresRiscoService {

	@EJB
	HistoricoFatoresRiscoRepository historicoFatoresRiscoRepository;
	@Override
	public HistoricoFatoresRisco retornaHistorico(Long idPessoa) {
		return historicoFatoresRiscoRepository.retornaHistoricoByIdPessoa(idPessoa);
			}

}
