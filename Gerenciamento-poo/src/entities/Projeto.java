package entities;

import java.util.ArrayList;

public class Projeto {
	
	private String id;
	private String descricao;
	private String dataHoraInicio;
	private String dataHoraFim;
	private Usuario coordenador;
	private ArrayList<Usuario> envolvidosProjeto;
	private ArrayList<Atividade> atividades;
	private Double valorBolsa;
	private String periodoBolsa;
	private String status;
	private ArrayList<Pagamento> pagamentos = new ArrayList<Pagamento>();
	
	
	public Projeto() {
		
	}
	
	public Projeto(String id, String descricao, String dataHoraInicio, String dataHoraFim, Usuario coordenador,
			ArrayList<Usuario> envolvidosProjeto,  ArrayList<Atividade> atividades, Double valorBolsa, String periodoBolsa, 
			String status) {
		this.id = id;
		this.descricao = descricao;
		this.dataHoraInicio = dataHoraInicio;
		this.dataHoraFim = dataHoraFim;
		this.coordenador = coordenador;
		this.valorBolsa = valorBolsa;
		this.periodoBolsa = periodoBolsa;
		this.status = "EM PROCESSO DE CRIACAO";
		this.atividades = atividades;
		this.envolvidosProjeto = envolvidosProjeto;
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

	public String getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void setDataHoraInicio(String dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}

	public String getDataHoraFim() {
		return dataHoraFim;
	}

	public void setDataHoraFim(String dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}

	public Usuario getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(Usuario coordenador) {
		this.coordenador = coordenador;
	}
	
	public void setEnvolvidosProjeto(ArrayList<Usuario> envolvidosProjeto) {
		this.envolvidosProjeto = envolvidosProjeto;
	}

	public ArrayList<Usuario> getEnvolvidosProjeto() {
		return envolvidosProjeto;
	}

	public ArrayList<Atividade> getAtividades() {
		return atividades;
	}
	
	public void setAtividades(ArrayList<Atividade> atividades) {
		this.atividades = atividades;
	}

	public Double getValorBolsa() {
		return valorBolsa;
	}

	public void setValorBolsa(Double valorBolsa) {
		this.valorBolsa = valorBolsa;
	}

	public String getPeriodoBolsa() {
		return periodoBolsa;
	}

	public void setPeriodoBolsa(String periodoBolsa) {
		this.periodoBolsa = periodoBolsa;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setPagamento(ArrayList<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}
	
	public ArrayList<Pagamento> getPagamento(){
		return pagamentos;
	}
	
	public void fazerPagamento(double valor, String numeroConta, String numeroAgencia) {
		Pagamento pagamentos = new Pagamento(valor, numeroConta, numeroAgencia );
		this.getPagamento().add(pagamentos);
		}
	
	public String toString() {
		return "\n id: " + this.getId() + "\n descricao: " + this.getDescricao() + "\nData e hora inicio: "
				+ this.getDataHoraInicio() + "\nData e hora fim: " + this.getDataHoraFim() + "\nCoordenador: "
				+ this.getCoordenador() + "\nParticipantes: " + this.getEnvolvidosProjeto() + "\nAtividades: "
				+ this.getAtividades() + "\nBolsa: " + this.getValorBolsa() + "\nPeriodo da bolsa:"
				+ this.getPeriodoBolsa();
	}
	
	
	
	
	
	
	

}
