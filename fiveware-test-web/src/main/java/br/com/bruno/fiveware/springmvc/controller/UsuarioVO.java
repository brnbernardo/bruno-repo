package br.com.bruno.fiveware.springmvc.controller;

import java.util.List;


public class UsuarioVO {

	private String nome;
	private String sexo = "M";
	private String profissao;
	private boolean fumante;

	private List<String> sexos;
	
	public UsuarioVO(){}
	
	public UsuarioVO(String nome, String sexo, String profissao, boolean fumante) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.profissao = profissao;
		this.fumante = fumante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public boolean isFumante() {
		return fumante;
	}

	public void setFumante(boolean fumante) {
		this.fumante = fumante;
	}

	public List<String> getSexos() {
		return sexos;
	}

	public void setSexos(List<String> sexos) {
		this.sexos = sexos;
	}

}
