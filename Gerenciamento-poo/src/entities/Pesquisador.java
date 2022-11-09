package entities;

public class Pesquisador extends Usuario {

	private String type;

	public Pesquisador() {
		super();
	}
	
	public Pesquisador(String nome, String email, String senha, String type) {
		super(nome, email, senha);
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "\nNome: " + getNome() +
				  "\nEmail: " + getEmail() +
				  "\nProjetos envolvidos: " + getProjetosEnvolvido() +
				  "\nAtividades envolvidas: " + getAtividadesEnvolvida()+
				  "\nTipo: Pesquisador" + 
				  "\nAssunto: " + getType();
	}
	
}
