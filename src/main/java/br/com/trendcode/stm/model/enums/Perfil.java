package br.com.trendcode.stm.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Perfil implements GrantedAuthority{

	ADMIN(1, "ROLE_ADMIN"),
	FUNCIONARIO(2, "ROLE_FUNCIONARIO"),
	FORNECEDOR(3, "ROLE_FORNECEDOR"),
	CLIENTE(4, "ROLE_CLIENTE");
	
	private int codigo;
	private String descricao;
	
	private Perfil(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String getAuthority() {
		
		return this.descricao;
	}
	
}
