package example.topic;


public enum EnumEmpresa {
	MICROSOFT("Microsoft",1),
	GOOGLE("Google",2),
	APPLE("Apple",3);
	private String descricao;
	private Integer id;
	
	private EnumEmpresa(String descricao , Integer id){
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
	
	public EnumEmpresa recuperarTipoById(Integer id){
		for(EnumEmpresa to: EnumEmpresa.values()){
			if(to.getId().equals(id)){
				return to;
			}
		}
		return null;
	}

}
