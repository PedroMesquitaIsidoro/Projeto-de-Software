package entities;

import java.util.ArrayList;

public abstract class Usuario {
	
	private String nome;
	private String email;
	private String senha;
	private ArrayList<Atividade> atividadesEnvolvida =  new ArrayList<>();
	private ArrayList<Projeto> projetosEnv = new ArrayList<>();
	
	public Usuario() {
		
	}
	
	public Usuario(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void addAtividadesEnvolvidas(Atividade atividade) {
		atividadesEnvolvida.add(atividade);
	  }
	
	public ArrayList<Atividade> getAtividadesEnvolvidas(){
		return atividadesEnvolvida;
	}

	  public void projetoEnvolvidos(Projeto projeto) {
		  projetosEnv.add(projeto);
	  }
	  
	  public ArrayList<Projeto> getProjetoEnvolvidos() {
		  return projetosEnv;
	  }
	  
	  public abstract String toString();
	  
	  public void chamaprintUsuarioprojetos() {
		  printUsuarioprojetos(projetosEnv);
	  }
	  public void printUsuarioprojetos(ArrayList<Projeto> projetoEnv) {
			System.out.println("Projetos envolvidos:");
			for(Projeto pro : projetoEnv) {
				String id = pro.getId();
				double bolsa = pro.getValorBolsa();
				String cord = pro.getCoordenador().getEmail();
				System.out.println(id);
				System.out.println(bolsa);
				System.out.println(cord);
				System.out.println("------");
			}
		}
	  
	  public void chamaprintUsuarioatividade() {
		  printUsuarioAtividade(atividadesEnvolvida);
	  }
	  
	  public void printUsuarioAtividade(ArrayList<Atividade> atividadesEnvolvida) {
			System.out.println("Atividades envolvidas:");
			for(Atividade atv : atividadesEnvolvida) {
				String id = atv.getId();
				String responsavel = atv.getResponsavel();
				String tarefas = atv.getTarefas();
				System.out.println(id);
				System.out.println(responsavel);
				System.out.println(tarefas);
				System.out.println("------");
			}
		}
}
