package example.topic;


public enum EnumTipoOperacao {
	OFERTA_COMPRA("Oferta de compra",1),
	OFERTA_VENDA("Oferta de venda",2);
	private String descricao;
	private Integer id;
	
	private EnumTipoOperacao(String descricao , Integer id){
		this.descricao = descricao;
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public EnumTipoOperacao recuperarTipoById(Integer id){
		for(EnumTipoOperacao to: EnumTipoOperacao.values()){
			if(to.getId().equals(id)){
				return to;
			}
		}
		return null;
	}

}
