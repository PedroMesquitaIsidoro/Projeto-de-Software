package apllication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Projeto;
import entities.Usuario;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Usuario> listUsuario = new ArrayList<Usuario>();
		List<Projeto> listProjeto = new ArrayList<Projeto>();
		Projeto projeto = null;
		Usuario usuario = null;
		
		int opcao = 1;
		
		while(opcao != 0) {
			System.out.printf("SISTEMA DE GERENCIAMENTO DE PROJETOS\n\n"
					+ "DIGITE A OPCAO DESEJADA:\n\n"
					+ "[1] CRIAR NOVO USUARIO\n"
					+ "[2] LOGIN\n"
					+ "[3] SAIR DO SISTEMA\n");
			
			opcao = sc.nextInt();
			
			switch(opcao) {
			
			case 1: // criar novo usuario ##########################################################################################
				
				System.out.print("Nome: \n");
				sc.nextLine();
				String nome = sc.nextLine();
				System.out.print("Email: \n");
				String email = sc.nextLine();
				System.out.print("Senha: \n");
				String senha = sc.nextLine();
				System.out.printf("\n\nEscolha a funcao do usuario:\n\n"
						+ "[1] GRADUACAO\n"
						+ "[2] MESTRADO\n"
						+ "[3] DOUTORADO\n"
						+ "[4] PROFESSOR\n"
						+ "[5] PESQUISADOR\n"
						+ "[6] DESENVOLVEDOR\n"
						+ "[7] TESTADOR\n"
						+ "[8] ANALISTA\n"
						+ "[9] TECNICO\n");
				int opFuncao = sc.nextInt();
				String varOpFuncao = null;
				switch(opFuncao) {
				
				case 1:
					varOpFuncao = "Graduacao";
					break;
					
				case 2:
					varOpFuncao = "Mestrado";
					break;
					
				case 3:
					varOpFuncao = "Doutorado";
					break;
					
				case 4:
					varOpFuncao = "Professor";
					break;
					
				case 5:
					varOpFuncao = "Pesquisador";
					break;
				
				case 6:
					varOpFuncao = "Desenvolvedor";
					break;
					
				case 7:
					varOpFuncao = "Testador";
					break;
					
				case 8:
					varOpFuncao = "Analista";
					break;
					
				case 9:
					varOpFuncao = "Tecnico";
					break;
				}
				usuario = new Usuario(email, senha, nome, varOpFuncao);
				listUsuario.add(usuario);
				System.out.println("USUARIO CRIADO COM SUCESSO\n");

				break; // fim de criar novo usuario ################################################################################
				
			case 2: // fazer login #################################################################################################
				
				System.out.println("LOGIN");
				System.out.println();
				sc.nextLine();
				System.out.println("EMAIL:");
				String eemail = sc.nextLine();
				System.out.println("SENHA:");
				String ssenha = sc.nextLine();
				int verifica = verificaUsuario(ssenha, eemail, listUsuario);
				
				if(verifica == 1) {
					System.out.println("LOGIN FEITO COM SUCESSO!");
					System.out.println("");
					usuario = buscaUsuario(eemail, listUsuario);
					telaUsuario(usuario, projeto, listProjeto);
				}
				else {
					System.out.println("SENHA/EMAIL INCORRETOS");
					System.out.println("RECUPERAR SENHA?");
					System.out.println("[1] SIM");
					System.out.println("[2] NAO");
					int recuperarSenha = sc.nextInt();
					if(recuperarSenha == 1) {
						sc.nextLine();
						System.out.println("DIGITE SEU EMAIL:");
						eemail = sc.nextLine();
						int verificaEemail = verificaEmail(eemail, listUsuario);
						if(verificaEemail == -1) {
							System.out.println("ESSE EMAIL NAO ESTA CADASTRADO NO SISTEMA.");
							System.out.println("CRIE UM NOVO USUARIO");
						}
						else {
							System.out.println("DIGITE A NOVA SENHA: ");
							ssenha = sc.nextLine();
							usuario.setSenha(ssenha);
							System.out.println("SENHA ATUALIZADA!");
						}
						
					}
					
				}
				
				break; // FIM DO LOGIN ##############################################################################################
				
			case 3:
				opcao = 0;
				break;
			}
		}
		
		sc.close();

	}
	
	public static int verificaUsuario(String senha, String email, List<Usuario> listUsuario) {
		
		for(int i = 0; i < listUsuario.size(); i++ ) {
			if(listUsuario.get(i).getEmail().equalsIgnoreCase(email) && listUsuario.get(i).getSenha().equalsIgnoreCase(senha) ) {
				return 1; // fez login com sucesso
			}
		}
	return 0; // nao fez login
}
	
	public static int verificaEmail(String email, List<Usuario> listUsuario) {
			
			for(int i = 0; i < listUsuario.size(); i++ ) {
				if(listUsuario.get(i).getEmail().equalsIgnoreCase(email)) {
					return i; // O EMAIL JA ESTA CADASTRADO 
				}
			}
		return -1; // NAO TEM CADASTRO DO EMAIL NO SISTEMA
	}
	
	public static Usuario buscaUsuario(String email, List<Usuario> listUsuario ){
        for(Usuario usuario : listUsuario){
            if(usuario.getEmail().equalsIgnoreCase(email))
                return usuario;
        }
        return null;
    }

	
	
	//#####################            tela usuario           ##################################//
	public static void telaUsuario(Usuario usuario, Projeto projeto, List<Projeto> listProjeto) {
		System.out.println("### Ola, " + usuario.getNome()+ "###");
		System.out.println();
		System.out.println();
		Scanner sc = new Scanner(System.in);
		if(usuario.getFuncao().equalsIgnoreCase("Professor") || usuario.getFuncao().equalsIgnoreCase("Pesquisador") ) {
			//Tela do coordenador do projeto
			int opt = 1;
			while(opt!=0) {
				System.out.printf("[1] VISUALIZAR INFORMACOES DE PERFIL\n"
						+ "[2] EDITAR INFORMACOES DE PERFIL\n"
						+ "[3] CRIAR PROJETO\n"
						+ "[4] MEUS PROJETOS\n"
						+ "[5] STATUS DE PROJETOS\n"
						+ "[6] BOLSAS\n"
						+ "[7] APAGAR MEU PERFIL\n"
						+ "[8] VOLTAR\n");
				opt = sc.nextInt();
				switch(opt) {
				
				case 1: // ver informacoes ########################################################################################
					System.out.println("Nome: "+ usuario.getNome());
					System.out.println(usuario.getFuncao());
					System.out.println("Email: "+ usuario.getEmail());
					System.out.println();
					break;
					
				case 2: // editar informacoes #####################################################################################
					//editarUsuario(usuario);
					
					int optt = 1;
					
					while(optt != 0) {
						System.out.printf("EDITAR INFORMACOES DE PERFIL\n"
								+ "ESCOLHA A OPCAO QUE DESEJA EDITAR\n");
						
						System.out.printf("[1] NOME\n"
								+ "[2] EMAIL\n"
								+ "[3] SENHA\n"
								+ "[4] FUNCAO\n"
								+ "[5] RETORNAR PARA PAGINA ANTERIOR\n");
						
						optt = sc.nextInt();
						
						switch(optt) {
						
						case 1:
							sc.nextLine();
							System.out.println("Digite o novo nome: ");
							String novoNome = sc.nextLine();
							usuario.setNome(novoNome);
							System.out.println("EDICAO REALIZADA COM SUCESSO");
							break;
							
						case 2:
							sc.nextLine();
							System.out.println("Digite o novo endereco de email: ");
							String novoEmail = sc.nextLine();
							usuario.setEmail(novoEmail);
							System.out.println("EDICAO REALIZADA COM SUCESSO");
							break;
							
						case 3:
							sc.nextLine();
							System.out.println("Digite uma nova senha: ");
							String novaSenha = sc.nextLine();
							usuario.setSenha(novaSenha);
							System.out.println("EDICAO REALIZADA COM SUCESSO");
							break;
							
						case 4:
							System.out.println("ESCOLHA UMA DAS FUNCOES: ");
							System.out.printf(
									"[1] GRADUACAO\n"
									+ "[2] MESTRADO\n"
									+ "[3] DOUTORADO\n"
									+ "[4] PROFESSOR\n"
									+ "[5] PESQUISADOR\n"
									+ "[6] DESENVOLVEDOR\n"
									+ "[7] TESTADOR\n"
									+ "[8] ANALISTA\n"
									+ "[9] TECNICO\n");
							int funcao = sc.nextInt();
							String varOpFuncao = null;
							
							switch(funcao) {
											
											case 1:
												varOpFuncao = "Graduacao";
												break;
												
											case 2:
												varOpFuncao = "Mestrado";
												break;
												
											case 3:
												varOpFuncao = "Doutorado";
												break;
												
											case 4:
												varOpFuncao = "Professor";
												break;
												
											case 5:
												varOpFuncao = "Pesquisador";
												break;
											
											case 6:
												varOpFuncao = "Desenvolvedor";
												break;
												
											case 7:
												varOpFuncao = "Testador";
												break;
												
											case 8:
												varOpFuncao = "Analista";
												break;
												
											case 9:
												varOpFuncao = "Tecnico";
												break;
											}
							usuario.setFuncao(varOpFuncao);		
							break;
							
						case 5:
							optt = 0;
							break;
						}
					}
					
					break;
				case 3: //Criar projeto #######################################################################################################
					System.out.println("CRIAR NOVO PROJETO");
					System.out.println();
					System.out.println("Digite o ID do projeto:");
					sc.nextLine();
					String id = sc.nextLine();
					System.out.println("Digite a descricao do projeto:");
					String descricao = sc.nextLine();
					System.out.println("Digite a data do comeco do projeto:");
					String dataComeco = sc.nextLine();
					System.out.println("Digite a hora do comeco do projeto:");
					String horaComeco = sc.nextLine();
					System.out.println("Digite a data do fim do projeto:");
					String dataFim = sc.nextLine();
					System.out.println("Digite a hora do fim do projeto:");
					String horaFim = sc.nextLine();
					System.out.println("Digite o valor da bolsa:");
					double valorBolsa = sc.nextDouble();
					projeto = new Projeto(id, descricao, dataComeco, dataFim, horaComeco, horaFim, valorBolsa);
					projeto.adcCoordenador(usuario);
					listProjeto.add(projeto);
					System.out.println("Projeto criado com sucesso");
					System.out.println();
					break;
					
							
				}
				
			}
			
		}
		else
		{
			
		}
		sc.close();
	}
	
}
