package managedBean;

public class RegrasTelaPaciente {
	
	/**
	 * exibir historico detalhado do paciente através de graficos
	 */
	private Boolean isExibirHistoricoPaciente = Boolean.FALSE;

	/**
	 * Controla exibição da pesquisa de pacientes
	 */
	private Boolean isExibirPesquisaPaciente = Boolean.FALSE;
	
	/**
	 * Exibir a suite de paciente (área especifica de um determinado paciente)
	 */
	private Boolean isExibirSuitePaciente = Boolean.FALSE;
	
	/**
	 * Controla a exibição ou não dos gráficos de paciente
	 */
	private Boolean isExibirDadosPaciente = Boolean.FALSE;

	
	public void resetarValores(){
		isExibirDadosPaciente = Boolean.FALSE;
		isExibirSuitePaciente = Boolean.FALSE;
		isExibirPesquisaPaciente = Boolean.FALSE;
		isExibirHistoricoPaciente = Boolean.FALSE;
	}
	public void exibirDadosPaciente(){
		isExibirDadosPaciente = Boolean.TRUE;
		isExibirSuitePaciente = Boolean.FALSE;
		isExibirPesquisaPaciente = Boolean.FALSE;
		isExibirHistoricoPaciente = Boolean.FALSE;
	}
	public void exibirSuitePaciente(){
		isExibirDadosPaciente = Boolean.FALSE;
		isExibirSuitePaciente = Boolean.TRUE;
		isExibirPesquisaPaciente = Boolean.FALSE;
		isExibirHistoricoPaciente = Boolean.FALSE;
	}
	public void exibirPesquisaPaciente(){
		isExibirDadosPaciente = Boolean.FALSE;
		isExibirSuitePaciente = Boolean.FALSE;
		isExibirPesquisaPaciente = Boolean.TRUE;
		isExibirHistoricoPaciente = Boolean.FALSE;
	}
	public void exibirHistoricoPaciente(){
		isExibirDadosPaciente = Boolean.FALSE;
		isExibirSuitePaciente = Boolean.FALSE;
		isExibirPesquisaPaciente = Boolean.FALSE;
		isExibirHistoricoPaciente = Boolean.TRUE;
	}
	public Boolean getIsExibirHistoricoPaciente() {
		return isExibirHistoricoPaciente;
	}
	public Boolean getIsExibirPesquisaPaciente() {
		return isExibirPesquisaPaciente;
	}
	public Boolean getIsExibirSuitePaciente() {
		return isExibirSuitePaciente;
	}
	public Boolean getIsExibirDadosPaciente() {
		return isExibirDadosPaciente;
	}
	
	
	

	
}
