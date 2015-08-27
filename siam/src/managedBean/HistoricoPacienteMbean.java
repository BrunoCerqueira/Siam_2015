package managedBean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import service.HistoricoFatoresRiscoService;
import service.PacienteService;
import service.PesoService;
import service.PressaoService;
import entity.HistoricoFatoresRisco;
import entity.Paciente;
import entity.Peso;
import entity.Pressao;

@ManagedBean
@SessionScoped
public class HistoricoPacienteMbean extends BaseBean {

	@EJB
	HistoricoFatoresRiscoService historicoFatoresRiscoService;

	@EJB
	PressaoService pressaoService;

	@EJB
	PesoService pesoService;
	
	@EJB
	private PacienteService pacienteService;
	private Paciente pacientePesquisa;
	private List<Paciente> pacientes;

	private RegrasTelaPaciente regrasTelaPaciente;
	
	private LineChartModel graficoLinearPesos;
	private BarChartModel graficoBarrasPesos;
	private LineChartModel graficoLinearPressao;
	private BarChartModel graficoBarrasPressao;
	
	private HistoricoFatoresRisco historicoFatoresRisco;
	private Pressao ultimaPressao;
	private String pressaoAtual;
	private Peso ultimoPeso;

	@PostConstruct
	public void init() {
		pacientePesquisa = new Paciente();
		
		regrasTelaPaciente =   new RegrasTelaPaciente();
		
		
		
		
	}
public void pesquisar(){
	pacientes = pacienteService.retornarPacientesPorNome(pacientePesquisa.getNome());
	
}
public String teste(){
	return "historicoPaciente";
}
public void editar(Paciente paciente){
	setPacientePesquisa(paciente);
	regrasTelaPaciente.exibirSuitePaciente();
}

public LineChartSeries gerarDadosBarraPeso(){
	
	
	LineChartSeries pesosBarra = new LineChartSeries();
	for (Peso p : pacientePesquisa.getHistoricoFatoresRisco().getPeso()) {
		String data = p.getData().toString().substring(0, 10);
		String ano = data.substring(0,4);
		String mes = data.substring(5,7);
		String dia = data.substring(8,10);
		
		String dataFormatada = dia+"/"+mes+"/"+ano;
		pesosBarra.set(dataFormatada, p.getValor());

	}
	return pesosBarra;
}
public ChartSeries gerarDadosBarraPressao(){
	
	
	ChartSeries pressaoBarra = new ChartSeries();
	for (Pressao pre : pacientePesquisa.getHistoricoFatoresRisco().getPressao()) {
		String data = pre.getData().toString().substring(0, 10);
		String ano = data.substring(0,4);
		String mes = data.substring(5,7);
		String dia = data.substring(8,10);
		String dataFormatada = dia+"/"+mes+"/"+ano;
		pressaoBarra.set(dataFormatada, pre.getValorSistolica());
		
	}
	return pressaoBarra;
}
private LineChartModel construirGraficoLinearPeso(){
	LineChartModel graficoLinear = new LineChartModel();
	ChartSeries pesosBarra = gerarDadosBarraPeso();
	graficoLinear.addSeries(pesosBarra);
	graficoLinear.setAnimate(Boolean.TRUE);
	Axis yAxis = graficoLinear.getAxis(AxisType.Y);
    yAxis.setMin(0); 
    yAxis.setMax(200);
 
    
    Axis xAxis = graficoLinear.getAxis(AxisType.X);
    xAxis.setMin(0); 
    xAxis.setMax(200);
   
    xAxis.setTickAngle(45);
    graficoLinear.setAnimate(Boolean.TRUE);
	return graficoLinear;
}
private LineChartModel construirGraficoLinearPressao(){
	LineChartModel graficoLinear = new LineChartModel();
	ChartSeries pesosBarra = gerarDadosBarraPressao();
	graficoLinear.addSeries(pesosBarra);
	graficoLinear.setAnimate(Boolean.TRUE);
	Axis yAxis = graficoLinear.getAxis(AxisType.Y);
    yAxis.setMin(0); 
    yAxis.setMax(200);
 
    
    Axis xAxis = graficoLinear.getAxis(AxisType.X);
    xAxis.setMin(0); 
    xAxis.setMax(200);
   
    xAxis.setTickAngle(45);
    graficoLinear.setAnimate(Boolean.TRUE);
	return graficoLinear;
}
private BarChartModel construirGraficoBarraPesagem(){
	
	BarChartModel graficoBarra = new BarChartModel();
	ChartSeries pesosBarra = gerarDadosBarraPeso();
	graficoBarra.addSeries(pesosBarra);
	Axis yAxis = graficoBarra.getAxis(AxisType.Y);
    yAxis.setMin(0); 
    yAxis.setMax(200);
    yAxis.setLabel("Peso");
    
    Axis xAxis = graficoBarra.getAxis(AxisType.X);
    xAxis.setMin(0); 
    xAxis.setMax(200);
    xAxis.setLabel("Data da Pesagem");
 
	return graficoBarra;
}
private BarChartModel construirGraficoBarraPressao(){
	BarChartModel graficoBarra = new BarChartModel();
	ChartSeries pressaoBarra = gerarDadosBarraPressao();
	graficoBarra.addSeries(pressaoBarra);
	Axis xAxis = graficoBarra.getAxis(AxisType.X);
	 xAxis.setMin(0);
	    xAxis.setMax(200);
	    xAxis.setLabel("Data de medição");
	    xAxis.setTickAngle(45);
	   
	      
	    Axis  yAxis = graficoBarra.getAxis(AxisType.Y);
	    yAxis.setLabel("Pressão"); 
	    yAxis.setMax(20);
	    
	return graficoBarra;
}
public void construirGraficosPaciente(){

	ultimaPressao = pressaoService.retornaUltimaMedicao(pacientePesquisa.getHistoricoFatoresRisco().getId());
	pressaoAtual = ultimaPressao.getValorSistolica().toString()+"/"+ultimaPressao.getValorDiastolica().toString();
	ultimoPeso = pesoService.retornaUltimaMedicao(pacientePesquisa.getHistoricoFatoresRisco().getId());
	graficoBarrasPesos = construirGraficoBarraPesagem();
	graficoBarrasPressao = construirGraficoBarraPressao();    
	graficoLinearPesos = construirGraficoLinearPeso();
	graficoLinearPressao = construirGraficoLinearPressao();
	regrasTelaPaciente.exibirDadosPaciente();
}
	

	public HistoricoFatoresRisco getHistoricoFatoresRisco() {
		return historicoFatoresRisco;
	}

	
	public String getPressaoAtual() {
		return pressaoAtual;
	}

	public void setPressaoAtual(String pressaoAtual) {
		this.pressaoAtual = pressaoAtual;
	}

	public Peso getUltimoPeso() {
		return ultimoPeso;
	}

	public void setUltimoPeso(Peso ultimoPeso) {
		this.ultimoPeso = ultimoPeso;
	}


	public void setHistoricoFatoresRisco(
			HistoricoFatoresRisco historicoFatoresRisco) {
		this.historicoFatoresRisco = historicoFatoresRisco;
	}

//	public CartesianChartModel getGraficoLinearPesos() {
//		return graficoLinearPesos;
//	}

	

	public BarChartModel getGraficoBarrasPesos() {
		return graficoBarrasPesos;
	}
	public void setGraficoBarrasPesos(BarChartModel graficoBarrasPesos) {
		this.graficoBarrasPesos = graficoBarrasPesos;
	}
//	
//	public CartesianChartModel getGraficoLinearPressao() {
//		return graficoLinearPressao;
//	}
//	public void setGraficoLinearPressao(CartesianChartModel graficoLinearPressao) {
//		this.graficoLinearPressao = graficoLinearPressao;
//	}
//	public void setGraficoLinearPesos(CartesianChartModel graficoLinearPesos) {
//		this.graficoLinearPesos = graficoLinearPesos;
//	}
	public BarChartModel getGraficoBarrasPressao() {
		return graficoBarrasPressao;
	}
	public void setGraficoBarrasPressao(BarChartModel graficoBarrasPressao) {
		this.graficoBarrasPressao = graficoBarrasPressao;
	}
//	public void setGraficoLinearPesos(LineChartModel graficoLinearPesos) {
//		this.graficoLinearPesos = graficoLinearPesos;
//	}
	public Pressao getUltimaPressao() {
		return ultimaPressao;
	}

	public void setUltimaPressao(Pressao ultimaPressao) {
		this.ultimaPressao = ultimaPressao;
	}

	public Paciente getPacientePesquisa() {
		return pacientePesquisa;
	}

	public void setPacientePesquisa(Paciente pacientePesquisa) {
		this.pacientePesquisa = pacientePesquisa;
	}
	public List<Paciente> getPacientes() {
		return pacientes;
	}
	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	public LineChartModel getGraficoLinearPesos() {
		return graficoLinearPesos;
	}
	public void setGraficoLinearPesos(LineChartModel graficoLinearPesos) {
		this.graficoLinearPesos = graficoLinearPesos;
	}
	public LineChartModel getGraficoLinearPressao() {
		return graficoLinearPressao;
	}
	public void setGraficoLinearPressao(LineChartModel graficoLinearPressao) {
		this.graficoLinearPressao = graficoLinearPressao;
	}
	public RegrasTelaPaciente getRegrasTelaPaciente() {
		return regrasTelaPaciente;
	}
	public void setRegrasTelaPaciente(RegrasTelaPaciente regrasTelaPaciente) {
		this.regrasTelaPaciente = regrasTelaPaciente;
	}



}
