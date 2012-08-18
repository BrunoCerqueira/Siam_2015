package entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hist_fator_risco", schema = "siam")
@NamedQueries({
		@NamedQuery(name = "HistoricoFatoresRisco.findHistoricoByIdPessoa", 
				query = "SELECT obj FROM HistoricoFatoresRisco obj WHERE obj.paciente.id = :idPessoa")
})
public class HistoricoFatoresRisco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idhist_fator_risco")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="fk_paciente")
	private Paciente paciente;
	
	@Column(name="tabagista")
	private Boolean tabagista;
	
	@Column(name="gramas_alcool_dia")
	private Integer gramasAlcoolDia;
	
	@Column(name="gramas_fruta_dia")
	private Integer gramasFrutasDia;
	
	@Column(name="minutos_ativ_fisica")
	private Integer minutosAtividadeFisicaDia;
	
	@Column(name="colesterol")
	private Integer colesterol;
	
	@Column(name="ant_concep_oral")
	private Boolean usoAnticonceptionalOral;
	
	@Column(name="hipertensao")
	private Boolean hipertenso;

	@Column(name="diabetes")
	private Boolean diabetico;
	
	@OneToMany(mappedBy="historicoFatoresRisco" )
	private List<Peso> peso;
	
	@OneToMany(mappedBy="historicoFatoresRisco")
	private List<Pressao> pressao;
	
	@Column(name="imc")
	private Integer imc;
	
	@Column(name="dt_coleta")
	private Date dataVerificacao;
	
	
	
	
	
	
	
	public Date getDataVerificacao() {
		return dataVerificacao;
	}
	public void setDataVerificacao(Date dataVerificacao) {
		this.dataVerificacao = dataVerificacao;
	}
	public void setGramasAlcoolDia(Integer gramasAlcoolDia) {
		this.gramasAlcoolDia = gramasAlcoolDia;
	}
	public void setGramasFrutasDia(Integer gramasFrutasDia) {
		this.gramasFrutasDia = gramasFrutasDia;
	}
	public void setMinutosAtividadeFisicaDia(Integer minutosAtividadeFisicaDia) {
		this.minutosAtividadeFisicaDia = minutosAtividadeFisicaDia;
	}
	public void setColesterol(Integer colesterol) {
		this.colesterol = colesterol;
	}
	public void setImc(Integer imc) {
		this.imc = imc;
	}
	public List<Pressao> getPressao() {
		return pressao;
	}
	public void setPressao(List<Pressao> pressao) {
		this.pressao = pressao;
	}
	public String getHipertenso() {
		if (hipertenso){
			return "Sim";
		}
		else
			return "N�o";
		
	}
	public void setHipertenso(Boolean hipertenso) {
		this.hipertenso = hipertenso;
	}
	public String getDiabetico() {
		if(diabetico){
			return "Sim";
		}
		else
			return "N�o";
		
	}
	public void setDiabetico(Boolean diabetico) {
		this.diabetico = diabetico;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public String getTabagista() {
		if(tabagista){
			return "Sim";
		}
		else
			return "N�o";
		
	}
	
	public void setTabagista(Boolean tabagista) {
		
		this.tabagista = tabagista;
	}
	public int getGramasAlcoolDia() {
		return gramasAlcoolDia;
	}
	public void setGramasAlcoolDia(int gramasAlcoolDia) {
		this.gramasAlcoolDia = gramasAlcoolDia;
	}
	public int getGramasFrutasDia() {
		return gramasFrutasDia;
	}
	public void setGramasFrutasDia(int gramasFrutasDia) {
		this.gramasFrutasDia = gramasFrutasDia;
	}
	public int getMinutosAtividadeFisicaDia() {
		return minutosAtividadeFisicaDia;
	}
	public void setMinutosAtividadeFisicaDia(int minutosAtividadeFisicaDia) {
		this.minutosAtividadeFisicaDia = minutosAtividadeFisicaDia;
	}
	public int getColesterol() {
		
		return colesterol;
	}
	public void setColesterol(int colesterol) {
		this.colesterol = colesterol;
	}
	public String getUsoAnticonceptionalOral() {
		if(usoAnticonceptionalOral){
			return "Sim";
		}
		else
			return "N�o";
		
	}
	public void setUsoAnticonceptionalOral(Boolean usoAnticonceptionalOral) {
		this.usoAnticonceptionalOral = usoAnticonceptionalOral;
	}
	public List<Peso> getPeso() {
		return peso;
	}
	public void setPeso(List<Peso> peso) {
		this.peso = peso;
	}
	public int getImc() {
		
		return imc;
	}
	public void setImc(int imc) {
		this.imc = imc;
	}


}
