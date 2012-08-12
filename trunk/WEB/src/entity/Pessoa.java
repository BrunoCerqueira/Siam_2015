package entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "pessoa", schema = "siam")
@NamedQueries({		
	@NamedQuery(name="Pessoa.findPessoaPorSenha", query="SELECT obj FROM Pessoa obj WHERE obj.senha = :senha" ),
	@NamedQuery(name="Pessoa.findPessoaPorLogin", query="SELECT obj FROM Pessoa obj WHERE obj.nome = :nome and obj.senha = :senha" )
	
})
public  class Pessoa {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "cpf")
	private Long cpf;

	@Column(name = "bairro")
	private String bairro;

	@Column(name = "rua")
	private String rua;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "cep")
	private String cep;

	@Column(name = "senha")
	private String senha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
