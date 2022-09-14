package entities;

import java.util.ArrayList;

public class Atividades {
	String id;
	String descricao;
	String dataComeco;
	String dataFim;
	String horaComeco;
	String horaFim;
	Usuario responsavel;
	ArrayList<Usuario> profissionaisEnvolv;
	
	public Atividades() {
		
	}

	public Atividades(String id, String descricao, String dataComeco, String dataFim, String horaComeco, String horaFim) {
		this.id = id;
		this.descricao = descricao;
		this.dataComeco = dataComeco;
		this.dataFim = dataFim;
		this.horaComeco = horaComeco;
		this.horaFim = horaFim;
		profissionaisEnvolv = new ArrayList<>();
	}
	
	public void addProfissional(Usuario p) {
		profissionaisEnvolv.add(p);
		p.setAtividadeVinculada(this);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDataComeco() {
		return dataComeco;
	}

	public void setDataComeco(String dataComeco) {
		this.dataComeco = dataComeco;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public String getHoraComeco() {
		return horaComeco;
	}

	public void setHoraComeco(String horaComeco) {
		this.horaComeco = horaComeco;
	}

	public String getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(String horaFim) {
		this.horaFim = horaFim;
	}
	
	public Usuario getResponsavel() {
		return responsavel;
	}
	
	public void setResponsavel(Usuario responsavel) {
		this.addProfissional(responsavel);
		this.responsavel= responsavel;
	}
	
	
	
	
	
}
