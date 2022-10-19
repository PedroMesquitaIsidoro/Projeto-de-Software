package entities;

import java.util.ArrayList;

public class Conta {
	
	private ArrayList<Usuario> usuarios = new ArrayList<>();
	private ArrayList<Projeto> projetos = new ArrayList<>();
	private ArrayList<Atividade> atividades = new ArrayList<>();
	
	public Conta() {
		
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public ArrayList<Projeto> getProjetos() {
		return projetos;
	}

	public ArrayList<Atividade> getAtividades() {
		return atividades;
	}
	
	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void setProjetos(ArrayList<Projeto> projetos) {
		this.projetos = projetos;
	}

	public void setAtividades(ArrayList<Atividade> atividades) {
		 this.atividades = atividades;
	}
	
}
