package entities;

public class Tecnico extends Usuario{
	
	private String type;

	public Tecnico() {
		super();
	}
	
	public Tecnico(String nome, String email, String senha, String type) {
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
				  "\nProjetos envolvidos: " + getProjetoEnvolvidos() +
				  "\nTipo: Tecnico" + 
				  "\nCargo: " + getType();
	}
	
}
