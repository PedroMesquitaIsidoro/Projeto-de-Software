package functions;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Atividade;
import entities.Conta;
import entities.Estudante;
import entities.Pesquisador;
import entities.Professor;
import entities.Profissional;
import entities.Projeto;
import entities.Tecnico;
import entities.Usuario;

public class CriarUsuario {
	
	public void criarUsuario(Conta conta) {
		Scanner sc = new Scanner(System.in);
		
		Usuario usuario = null;	
		ArrayList<Usuario> usuarios = new ArrayList<>();
		ArrayList<Projeto> projetoEnvolvidos = new ArrayList<>();
		ArrayList<Atividade> atividadeEnvolvidas = new ArrayList<>();
		
		try {
			System.out.println("Digite seu nome:");
			String nome = sc.nextLine();
			System.out.println("Digite seu e-mail:");
			String email = sc.nextLine();
			System.out.println("Digite sua senha:");
			String senha = sc.nextLine();
			System.out.printf("\n\nEscolha a funcao do usuario:\n\n"
					+ "[1] Estudante\n"
					+ "[2] Pesquisador\n"
					+ "[3] Professor\n"
					+ "[4] Profissional\n"
					+ "[5] Tecnico\n");
			
			int opcao = sc.nextInt();
			sc.nextLine();
			
			switch(opcao) {
			
			case 1: // cadastrar estudante
	
				System.out.printf("\n\nEscolha o seu nivel:\n\n"
						+ "[1] Graduacao\n"
						+ "[2] Mestrado\n"
						+ "[3] Doutorado\n");
				int opcaoEstudante = sc.nextInt();
				String tipo = null;
				switch(opcaoEstudante) {
				case 1:
					tipo = "Graduacao";
					break;
					
				case 2:
					tipo = "Mestrado";
					break;
					
				case 3:
					tipo = "Doutorado";
					break;
				
				default:
					System.out.println("Entrada invalida");
					criarUsuario(conta);
				}
				
				usuario = new Estudante(nome, email, senha, tipo);	
				break; // fim de cadastrar estudante
				
			case 2: // inicio de cadastrar pesquisador
				System.out.println("Qual eh o seu tipo de pesquisa?:");
				String tipoPesquisa = sc.nextLine();
				usuario = new Pesquisador(nome, email, senha, tipoPesquisa);	
				break; // fim de cadastrar pesquisador
			
			case 3: // inicio de cadastrar professor
				System.out.printf("\n\nSelecione o seu tipo :\n\n"
						+ "[1] Auxiliar\n"
						+ "[2] Assistente\n"
						+ "[3] Adjunto\n"
						+ "[4] Associado\n"
						+ "[5] Titular\n");
				int opcaoProfessor = sc.nextInt();
				
				String tipoProfessor = null;
				switch(opcaoProfessor) {
				case 1:
					tipoProfessor = "Auxiliar";
					break;
					
				case 2:
					tipoProfessor = "Assistente";
					break;
					
				case 3:
					tipoProfessor = "Adjunto";
					break;
					
				case 4:
					tipoProfessor = "Associado";
					break;
					
				case 5:
					tipoProfessor = "Titular";
					break;
					
				default:
					System.out.println("Entrada invalida");
					criarUsuario(conta);
				}
				
				usuario = new Professor(nome, email, senha, tipoProfessor);
				break; // fim de cadastrar professor
				
			case 4: // inicio de cadastrar profissional
				
				System.out.printf("\n\nSelecione o seu tipo :\n\n"
						+ "[1] Desenvolvedor\n"
						+ "[2] Testador\n"
						+ "[3] Analista\n");
				int opcaoProfissional = sc.nextInt();
				String tipoProfissional = null;
				switch(opcaoProfissional) {
				case 1:
					tipoProfissional = "Desenvolvedor";
					break;
					
				case 2:
					tipoProfissional = "Testador";
					break;
					
				case 3:
					tipoProfissional = "Analista";
					break;
				
				default:
					System.out.println("Entrada invalida");
					criarUsuario(conta);
				}
				usuario = new Profissional(nome, email, senha, tipoProfissional);
				
				break; // fim de cadastrar profissional
				
			case 5:
				System.out.println("Do que voce eh tecnico?:");
				String tipoTecnico = sc.nextLine();
				usuario = new Tecnico(nome, email, senha, tipoTecnico);
				break;
			
			default:
				System.out.println("entrada invalida");
				criarUsuario(conta);
			}
		}
		
		catch(java.util.InputMismatchException e) {
			System.out.println("Entrada invalida");
			criarUsuario(conta);
		}
	
		usuarios = conta.getUsuarios();
		usuarios.add(usuario);
		conta.setUsuarios(usuarios);
		System.out.println("Cadastro feito");
	}
	
	public Atividade procurarAtividade(String id, Conta conta) {
		for(Atividade atv : conta.getAtividades()) {
			if(atv.getId().equals(id)) {
				return atv;
			}
		}
			return null;
	}

public Projeto procurarProjeto(String id, Conta conta) {
	for(Projeto proj : conta.getProjetos()) {
		if(proj.getId().equals(id)) {
			return proj;
		}
	}
	
	return null;
}

public void atualizarUsuario(Conta conta) {
	Scanner sc = new Scanner(System.in);
	Usuario usuario = null;	
	ArrayList<Usuario> usuarios = new ArrayList<>();
	ArrayList<Projeto> projetoEnvolvidos = new ArrayList<>();
	ArrayList<Atividade> atividadeEnvolvidas = new ArrayList<>();
	
	System.out.println("Digite seu email:");
	String email = sc.nextLine();
	
	for(Usuario usu : conta.getUsuarios()) {
		if(usu.getEmail().equals(email)) {
			usuario = usu;
		}
	}
	
	if(usuario != null) {
		try {
			int opt = -1;
			while(opt != 0) {
				System.out.printf("\nTELA Do USUARIO \n\n"
						+ "DIGITE A OPCAO DESEJADA:\n\n"
						+ "[1] ATUALIZAR EMAIL\n"
						+ "[2] ATUALIZAR SENHA\n"
						+ "[3] ATUALIAZAR NOME\n"
						+ "[4] ATUALIAZAR PROJETOS ENVOLVIDOS\n"
						+ "[5] ATUALIZAR ATIVIDADES ENVOLVIDAS\n"
						+ "[6] SAIR\n");
				opt = sc.nextInt();
				
				switch(opt) {
				case 1:
					System.out.println("Digite o novo email:");
					sc.nextLine();
					String emailNovo = sc.nextLine();
					usuario.setEmail(emailNovo);
					System.out.println("email alterado");
					break;
					
				case 2:
					System.out.println("Digite a nova senha:");
					sc.nextLine();
					String senha = sc.nextLine();
					usuario.setSenha(senha);
					System.out.println("senha alterada");
					break;
					
				case 3:
					System.out.println("Digite o novo nome:");
					sc.nextLine();
					String nome = sc.nextLine();
					usuario.setNome(nome);
					System.out.println("nome alterado");
					break;
					
				case 4:
					System.out.println("Atualizar projetos envolvidos");
					int opt1 = -1;
					while(opt1 != 0) {
						System.out.println("[1] adicionar projeto");
						System.out.println("[2] voltar");
						opt1 = sc.nextInt();
						
						switch(opt1) {
						case 1:
							System.out.println("Digite o id do projeto");
							sc.nextLine();
							String idProjeto = sc.nextLine();
							Projeto projeto = procurarProjeto(idProjeto, conta);
							if(projeto != null) {
								usuario.projetoEnvolvidos(projeto);
								projeto.EnvolvidosInProjeto(usuario);
								System.out.println("Projeto adicionado com sucesso");
							}
							else {
								System.out.println("Id nao encontrado");
							}
							break;
							
						case 2:
							opt1 = 0;
							break;
						}
					}		
					//usuario.setProjetosEnvolvido(projetoEnvolvidos);
					break; // fim de atualizar projetos envolvidos
					
				case 5: // comeco de atividaes envolvidas
					System.out.println("Atualizar atividades envolvidas");
					int opt2 = -1;
					while(opt2 != 0) {
						System.out.println("[1] adicionar atividade");
						System.out.println("[2] voltar");
						opt2 = sc.nextInt();
						
						switch(opt2) {
						case 1:
							System.out.println("Digite o id da atividade");
							sc.nextLine();
							String idAtividade = sc.nextLine();
							Atividade atividade = procurarAtividade(idAtividade, conta);
							if(atividade != null) {
								usuario.addAtividadesEnvolvidas(atividade);
								atividade.addEnvolvidos(usuario);
								System.out.println("Atividade adicionada com sucesso");
							}
							else {
								System.out.println("Id nao encontrado");
							}
							break;
							
						case 2:
							opt2 = 0;
							break;
						}
					}		
					break;
					
				case 6:
					opt = 0;
					break;
				}
			}
		}
		catch(java.util.InputMismatchException e) {
			System.out.println("Entrada invalida");
			atualizarUsuario(conta);
		}
	}
	else {
		System.out.println("Email nao encontrado");
	}
}

public void removerUsuario(Conta conta) {
	Scanner sc =  new Scanner(System.in);
	System.out.println("Digite o email do usuario deseja remover:");
	String email = sc.nextLine();
	System.out.println("Digite a senha do usuario deseja remover:");
	String senha = sc.nextLine();
	
	Usuario usuario = null;
	
	for(Usuario usu : conta.getUsuarios()) {
		if(usu.getEmail().equals(email) && usu.getSenha().equals(senha)) {
			usuario = usu;
		}
	}
	
	if(usuario != null) {
		conta.getUsuarios().remove(usuario);
		System.out.println("Usuario removido com sucesso");
	}
	else {
		System.out.println("Dados incorretos");
	}
}

public void infoUsuario(Conta conta) {
	Scanner sc = new Scanner(System.in);
	Usuario usuario = null;
	System.out.println("Digite o email do usuario que deseja ver as informacoes");
	String email = sc.nextLine();
	
	for(Usuario usu : conta.getUsuarios()) {
		if(usu.getEmail().equals(email)) {
			usuario = usu;
		}
	}
	
	if(usuario != null) {
		System.out.println(usuario);
		usuario.chamaprintUsuarioprojetos();
		usuario.chamaprintUsuarioatividade();
	}
	else {
		System.out.println("Email nao encontrado");
	}
}
	

}
