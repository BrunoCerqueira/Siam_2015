package managedBean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;

import service.HistoricoFatoresRiscoService;
import service.PesoService;
import service.PressaoService;
import entity.HistoricoFatoresRisco;
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

	private Boolean isMostraGrafico = false;
	private CartesianChartModel graficoLinearPesos;
	private CartesianChartModel graficoBarrasPesos;
	private CartesianChartModel graficoLinearPressao;
	private CartesianChartModel graficoBarrasPressao;
	
	private HistoricoFatoresRisco historicoFatoresRisco;
	private Pressao ultimaPressao;
	private String pressaoAtual;
	private Peso ultimoPeso;

	@PostConstruct
	public void init() {
		isMostraGrafico = false;
		historicoFatoresRisco = historicoFatoresRiscoService
				.retornaHistorico(1L/* getId() */);
		
		ultimaPressao = pressaoService.retornaUltimaMedicao(1L/* getId() */);
		pressaoAtual = ultimaPressao.getValorSistolica().toString()+"/"+ultimaPressao.getValorDiastolica().toString();
		ultimoPeso = pesoService.retornaUltimaMedicao(1L/* getId() */);
		
		graficoLinearPesos = new CartesianChartModel();
		graficoBarrasPesos = new CartesianChartModel();
		
		graficoLinearPressao = new CartesianChartModel();
		graficoBarrasPressao = new CartesianChartModel();
		
		// INICIO --- GRAFICO LINEAR E EM BARRA DE PESO
		ChartSeries pesosBarra = new ChartSeries();
		pesosBarra.setLabel("Peso");
		LineChartSeries pesosLinear = new LineChartSeries();
		
		
		for (Peso p : historicoFatoresRisco.getPeso()) {
			String data = p.getData().toString().substring(0, 10);
			String ano = data.substring(0,4);
			String mes = data.substring(5,7);
			String dia = data.substring(8,10);
			
			String dataFormatada = dia+"-"+mes+"-"+ano;
			pesosBarra.set(dataFormatada, p.getValor());
	
		}
		pesosLinear.setData(pesosBarra.getData());
		pesosLinear.setLabel(pesosBarra.getLabel());

	

		graficoBarrasPesos.addSeries(pesosBarra);
		graficoLinearPesos.addSeries(pesosLinear);
		
		// FIM --- GRAFICO LINEAR E EM BARRA DE PESO
		
	
		//INICIO - GRAFICO LINEAR E EM BARRA DE PRESSAO
		
		
		LineChartSeries pressaoSistolicaLinear = new LineChartSeries();
		
		LineChartSeries pressaoDiastolicaLinear = new LineChartSeries();
		
		ChartSeries pressaoSistolicaBarra = new ChartSeries();
		
		ChartSeries pressaoDiastolicaBarra = new ChartSeries();
		pressaoDiastolicaLinear.setLabel("Press�o Diast�lica");
		pressaoSistolicaLinear.setLabel("Press�o Sist�lica");
		for (Pressao pre : historicoFatoresRisco.getPressao()) {
			String data = pre.getData().toString().substring(0, 10);
			String ano = data.substring(0,4);
			String mes = data.substring(5,7);
			String dia = data.substring(8,10);
			String dataFormatada = dia+"-"+mes+"-"+ano;
			pressaoSistolicaLinear.set(dataFormatada, pre.getValorSistolica());
			
		}
		
		for (Pressao pre : historicoFatoresRisco.getPressao()) {
			String data = pre.getData().toString().substring(0, 10);
			String ano = data.substring(0,4);
			String mes = data.substring(5,7);
			String dia = data.substring(8,10);
			String dataFormatada = dia+"-"+mes+"-"+ano;
			pressaoDiastolicaLinear.set(dataFormatada, pre.getValorDiastolica());
			
		}
	
		
		pressaoDiastolicaBarra.setData(pressaoDiastolicaLinear.getData());
		pressaoDiastolicaBarra.setLabel(pressaoDiastolicaLinear.getLabel());
		
		pressaoSistolicaBarra.setData(pressaoSistolicaLinear.getData());
		pressaoSistolicaBarra.setLabel(pressaoSistolicaLinear.getLabel());
		
		
		graficoLinearPressao.addSeries(pressaoSistolicaLinear);
		graficoLinearPressao.addSeries(pressaoDiastolicaLinear);
		
		graficoBarrasPressao.addSeries(pressaoSistolicaBarra);
		graficoBarrasPressao.addSeries(pressaoDiastolicaBarra);
		
		
		
		
	}

	public void mostrarGrafico() {
		isMostraGrafico = isMostraGrafico == true ? false : true;
		

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

	public Boolean getIsMostraGrafico() {
		return isMostraGrafico;
	}

	public void setIsMostraGrafico(Boolean isMostraGrafico) {
		this.isMostraGrafico = isMostraGrafico;
	}

	public void setHistoricoFatoresRisco(
			HistoricoFatoresRisco historicoFatoresRisco) {
		this.historicoFatoresRisco = historicoFatoresRisco;
	}

	public CartesianChartModel getGraficoLinearPesos() {
		return graficoLinearPesos;
	}

	public void setGraficoLinearPesos(CartesianChartModel graficoLinearPesos) {
		this.graficoLinearPesos = graficoLinearPesos;
	}

	public CartesianChartModel getGraficoBarrasPesos() {
		return graficoBarrasPesos;
	}

	public void setGraficoBarrasPesos(CartesianChartModel graficoBarrasPesos) {
		this.graficoBarrasPesos = graficoBarrasPesos;
	}

	public CartesianChartModel getGraficoLinearPressao() {
		return graficoLinearPressao;
	}

	public void setGraficoLinearPressao(CartesianChartModel graficoLinearPressao) {
		this.graficoLinearPressao = graficoLinearPressao;
	}

	public CartesianChartModel getGraficoBarrasPressao() {
		return graficoBarrasPressao;
	}

	public void setGraficoBarrasPressao(CartesianChartModel graficoBarrasPressao) {
		this.graficoBarrasPressao = graficoBarrasPressao;
	}

	public Pressao getUltimaPressao() {
		return ultimaPressao;
	}

	public void setUltimaPressao(Pressao ultimaPressao) {
		this.ultimaPressao = ultimaPressao;
	}



}
