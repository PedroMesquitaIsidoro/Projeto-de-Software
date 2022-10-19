package entities;

public class Profissional extends Usuario{
	private String tipo;

	public Profissional() {
		super();
	}
	
	public Profissional(String nome, String email, String senha, String tipo) {
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
				  "\nSenha: " + getSenha() +
				  "\nProjetos envolvidos: " + getProjetosEnvolvido() +
				  "\nAtividades envolvidas: " + getAtividadesEnvolvida()+
				  "\nTipo: Profissional" + 
				  "\nArea: " + getTipo();
	}
	
}
