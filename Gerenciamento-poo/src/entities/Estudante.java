package entities;

public class Estudante extends Usuario {
	
	private String tipo; // graduacao, mestrado ou doutorado

	public Estudante() {
		super();	
	}
	
	public Estudante(String nome, String email, String senha, String tipo) {
		super(nome, email, senha);
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "\nNome: " + getNome() +
				  "\nEmail: " + getEmail() +
				  "\nProjetos envolvidos: " + getProjetosEnvolvido() +
				  "\nAtividades envolvidas: " + getAtividadesEnvolvida()+
				  "\nTipo: " + getTipo();
	}
	
	
	
}
