package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="idPessoa")
@Table(name = "medico", schema = "siam")
public class Medico extends Pessoa{
	
	@Column(name="especialidade")
	String especialidade;
	

}
