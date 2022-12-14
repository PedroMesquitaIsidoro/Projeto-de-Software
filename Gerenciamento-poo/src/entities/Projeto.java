package entities;

import java.util.ArrayList;

public class Projeto {
	
	private String id;
	private String descricao;
	private String dataHoraInicio;
	private String dataHoraFim;
	private Usuario coordenador;
	private ArrayList<Atividade> atividades = new ArrayList<Atividade>();
	private Double valorBolsa;
	private String periodoBolsa;
	private String status;
	private ArrayList<Pagamento> pagamentos = new ArrayList<Pagamento>();
	private  ArrayList<Usuario> envolvidosInProjeto = new ArrayList<Usuario>();
	
	
	public Projeto() {
		
	}
	
	public Projeto(String id, String descricao, String dataHoraInicio, String dataHoraFim, Usuario coordenador,
			ArrayList<Usuario> envolvidosProjeto, Double valorBolsa, String periodoBolsa, 
			String status) {
		this.id = id;
		this.descricao = descricao;
		this.dataHoraInicio = dataHoraInicio;
		this.dataHoraFim = dataHoraFim;
		this.coordenador = coordenador;
		this.valorBolsa = valorBolsa;
		this.periodoBolsa = periodoBolsa;
		this.status = "EM PROCESSO DE CRIACAO";
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
		Pagamento pagamentos = new Pagamento(valor, numeroConta, numeroAgencia, new taxaParaEstudantes());
		this.getPagamento().add(pagamentos);
		}
	
	public void EnvolvidosInProjeto(Usuario usuario) {
		envolvidosInProjeto.add(usuario);
	  }
	  
	  public ArrayList<Usuario> getEnvolvidosInProjeto() {
		  return envolvidosInProjeto;
	  }
	  
	  public void addAtividades(Atividade atividade) {
		atividades.add(atividade);
	  }
	  
	  public ArrayList<Atividade> getAtividades() {
		  return atividades;
	  }
	  
	public String toString() {
		return "\n id: " + this.getId() + "\n descricao: " + this.getDescricao() + "\nData e hora inicio: "
				+ this.getDataHoraInicio() + "\nData e hora fim: " + this.getDataHoraFim() + "\nCoordenador: "
				+ this.getCoordenador().getEmail() + "\nBolsa: " + this.getValorBolsa() + "\nPeriodo da bolsa:"
				+ this.getPeriodoBolsa() + "\nStatus: " + this.getStatus();
	}
	
	public void chamaPrint() {
		print(envolvidosInProjeto);
	}
	
	public void print(ArrayList<Usuario> envolvidosInProjeto) {
		for(Usuario usu : envolvidosInProjeto) {
			String nome = usu.getNome();
			System.out.println(nome);
			String email = usu.getEmail();
			System.out.println(email);
			System.out.println("-----");
		}
	}
	public void chamarPrintAtividades() {
		printAtv(atividades);
	}
	
	public void printAtv(ArrayList<Atividade> atividades) {
		System.out.println("Atividade: ");
		System.out.println("-----");
		for(Atividade atv : atividades) {
			String id = atv.getId();
			String descricao = atv.getDescricao();
			String responsavel = atv.getResponsavel();
			String tarefas = atv.getTarefas();
			System.out.println(id);
			System.out.println(descricao);
			System.out.println(responsavel);
			System.out.println(tarefas);
			atv.chamaPrint();
			System.out.println("-----");
		}
	}
	
	

}
