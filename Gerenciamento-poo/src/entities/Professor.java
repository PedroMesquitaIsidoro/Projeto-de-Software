package entities;

public class Professor extends Usuario {
	
	private String type;

	public Professor() {
		super();	
	}
	
	
	
	public Professor(String nome, String email, String senha, String type) {
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
				  "\nSenha: " + getSenha() +
				  "\nProjetos envolvidos: " + getProjetosEnvolvido() +
				  "\nAtividades envolvidas: " + getAtividadesEnvolvida()+
				  "\nTipo: Professor" + 
				  "\nCargo: " + getType();
	}
	
	
	
	

}
