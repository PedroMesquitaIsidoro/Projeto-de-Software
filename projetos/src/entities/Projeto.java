package entities;

import java.util.ArrayList;

public class Projeto {
	
	private Integer id;
	private String descricao;
	private String dataInicio;
	private String dataFim;
	private String coordenador;
	
	public Projeto() {
		
	}
	
	public Projeto(Integer id, String descricao, String dataInicio, String dataFim, String coordenador) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.coordenador = coordenador;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDataInicio() {
		return dataInicio;
	}
	
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public String getDataFim() {
		return dataFim;
	}
	
	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}
	
	public String coordenador() {
		return coordenador;
	}
	
	public void setcoordenador(String coordenador) {
		this.coordenador = coordenador;
	}
	

	
	public String toString() {
		return "\nIdentificacao: " + id + "\n" +
				"Descricao: " + descricao +  "\n" +
				"dataInicio: " + dataInicio + "\n" + 
				"dataFim: " + dataFim + "\n" + 
				"Coordenador: " + coordenador + "\n";
				
	}
	
	
	

}
