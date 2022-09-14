package entities;

public class Usuario {
	
	private String email;
	private String senha;
	private String nome;
	private String funcao;
	boolean ehCoordenador;
	boolean ehVinculadoProjeto;
	Projeto projetoVinculado;
	
	public Usuario() {
		
	}
	
	public Usuario(String email, String senha, String nome, String funcao) {
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.funcao = funcao;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	public boolean EhCoordenador() {
		return ehCoordenador;
	}
	
	public void setEhCoordenador(boolean ehCoordenador) {
		this.ehCoordenador = ehCoordenador;
	}
	
	public boolean EhVinculado() {
		return ehVinculadoProjeto;
	}
	
	public void setEhVinculador(boolean ehVinculadoPorjeto) {
		this.ehVinculadoProjeto = ehVinculadoProjeto;
	}
	
	public Projeto getProjetoVinculado() {
		return projetoVinculado;
	}
	
	 public void setProjetoVinculado(Projeto projetoVinculado) {
	        this.projetoVinculado.adcUsuario(this);
	        setEhVinculador(true);
	    }

	
}
