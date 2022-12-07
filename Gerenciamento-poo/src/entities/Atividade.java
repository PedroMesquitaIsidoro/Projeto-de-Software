package entities;

import java.util.ArrayList;

public class Atividade {
	
	private String id;
	private String descricao;
	private String dataHoraInicio;
	private String dataHoraFim;
	private String responsavel;
	private ArrayList<Usuario> envolvidos;
	private String tarefas;
	
	public Atividade() {
		
	}
	
	public Atividade(String id, String descricao, String dataHoraInicio, String dataHoraFim, String responsavel,
			 ArrayList<Usuario> envolvidos, String tarefas) {
		this.id = id;
		this.descricao = descricao;
		this.dataHoraInicio = dataHoraInicio;
		this.dataHoraFim = dataHoraFim;
		this.responsavel = responsavel;
		this.tarefas = tarefas;
		this.envolvidos = envolvidos;
	}
	
	public static class AtividadeBuilder{
		
		private String id;
		private String descricao;
		private String dataHoraInicio;
		private String dataHoraFim;
		private String responsavel;
		private ArrayList<Usuario> envolvidos;
		private String tarefas;
		
		public AtividadeBuilder id(String id) {
			this.id = id;
			return this;
		}
		
		public AtividadeBuilder descricao(String descricao) {
			this.descricao = descricao;
			return this;
		}
		
		public AtividadeBuilder dataHoraInicio(String dataHoraInicio) {
			this.dataHoraInicio = dataHoraInicio;
			return this;
		}
		
		public AtividadeBuilder dataHoraFim(String dataHoraFim) {
			this.dataHoraFim = dataHoraFim;
			return this;
		}
		
		public AtividadeBuilder responsavel(String responsavel) {
			this.responsavel = responsavel;
			return this;
		}
		
		public AtividadeBuilder envolvidos(ArrayList<Usuario> envolvidos) {
			this.envolvidos = envolvidos;
			return this;
		}
		
		public AtividadeBuilder tarefas(String tarefas) {
			this.tarefas = tarefas;
			return this;
		}
		
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

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public ArrayList<Usuario> getEnvolvidos() {
		return envolvidos;
	}
	
	public void setEnvolvidos(ArrayList<Usuario> envolvidos) {
		this.envolvidos = envolvidos;
	}

	public String getTarefas() {
		return tarefas;
	}

	public void setTarefas(String tarefas) {
		this.tarefas = tarefas;
	}
	
	public String toString() {
		return "\nID: " + this.getId() +
				"\nDescricao: " + this.getDescricao() +
				"\nHora e data de comeco: " + this.getDataHoraInicio() + 
				"\nHora e data de fim: " + this.getDataHoraFim() +
				"\nResponsavel: " + this.getResponsavel() +
				"\nTarefas: " + this.getTarefas() +
				"\nEnvolvidos: " + this.getEnvolvidos();	
	}
	
}
