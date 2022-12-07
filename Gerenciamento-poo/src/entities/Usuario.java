package entities;

import java.util.ArrayList;

public abstract class Usuario {
	
	private String nome;
	private String email;
	private String senha;
	private ArrayList<Projeto> projetosEnvolvido = new ArrayList<>();
	private ArrayList<Atividade> atividadesEnvolvida =  new ArrayList<>();
	
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
	
	public void setProjetosEnvolvido(ArrayList<Projeto> projetosEnvolvido) {
	    this.projetosEnvolvido = projetosEnvolvido;
	  }

	  public ArrayList<Projeto> getProjetosEnvolvido() {
	    return projetosEnvolvido;
	  }

	  public void setAtividadesEnvolvida(ArrayList<Atividade> atividadesEnvolvida) {
	    this.atividadesEnvolvida = atividadesEnvolvida;
	  }

	  public ArrayList<Atividade> getAtividadesEnvolvida() {
	    return atividadesEnvolvida;
	  }
	  
	  public abstract String toString();
	  
	  /*public String toString() {
		  return "\nNome: " + this.nome +
				  "\nEmail: " + this.email +
				  "\nSenha: " + this.senha +
				  "\nProjetos envolvidos: " + this.projetosEnvolvido +
				  "\nAtividades envolvidas: " + this.atividadesEnvolvida;
	  }
	  */
}
