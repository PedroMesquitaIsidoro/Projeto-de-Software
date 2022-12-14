package entities;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import entities.Atividade.AtividadeBuilder;
import functions.ActivityFunctions;
import functions.CriarUsuario;
import functions.Login;
import functions.PaymentsFunctions;
import functions.ProjectFunctions;

public class Aplicacao {
	
	public void menu(Conta conta) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);	
		try {
			
			int opcao = 1;
			
			while(opcao != 0) {
				
				System.out.printf("SISTEMA DE GERENCIAMENTO DE PROJETOS\n\n"
						+ "DIGITE A OPCAO DESEJADA:\n\n"
						+ "[1] CRIAR NOVO USUARIO\n"
						+ "[2] LOGIN\n"
						+ "[3] SAIR DO SISTEMA\n");
				
				opcao = sc.nextInt();
				
				switch(opcao) {
				case 1: // criar novo usuario
					CriarUsuario criarUsuario = new CriarUsuario();
					criarUsuario.criarUsuario(conta);
					break;
					
				case 2: //login
					Login login = new Login();
					Usuario returnLogin = login.login(conta);
					if(returnLogin != null) {
			    		sistema(conta,returnLogin);
			    	}
			    	else if (returnLogin == null) {
			    		System.out.println("Esse email nao tem cadastro no sistema");
			    	}
					break;
					
				case 3: // sair do sistema
					opcao = 0;
					System.out.println("FECHANDO O SISTEMA");
					break;
				}
			}	
		}
		
		catch(java.util.InputMismatchException e) {
			System.out.println("\nEntrada invalida");
			menu(conta);
		}
	}

	public void sistema(Conta conta, Usuario usuario) {
		
		Scanner sc = new Scanner(System.in);
		ProjectFunctions projectFunctions = new ProjectFunctions();
		CriarUsuario criarUsuario = new CriarUsuario();
		ActivityFunctions activityFunctions = new ActivityFunctions();
		PaymentsFunctions paymentsFunctions = new PaymentsFunctions();
		try {
			int opcao = 1;
			
			while(opcao != 0) {
				System.out.printf("SISTEMA DE GERENCIAMENTO DE PROJETOS\n\n"
						+ "DIGITE A OPCAO DESEJADA:\n\n"
						+ "[1] PROJETOS\n"
						+ "[2] ATIVIDADES\n"
						+ "[3] USUARIO\n"
						+ "[4] PAGAMENTOS\n"
						+ "[5] SAIR\n");
				opcao = sc.nextInt();
				switch(opcao) {
				case 1: // TELA PROJETOS 
					int optProjeto = 1;
					while(optProjeto != 0) {
						System.out.printf("TELA DE PROJETOS\n\n"
								+ "DIGITE A OPCAO DESEJADA:\n\n"
								+ "[1] ADD NOVO PROJETO\n"
								+ "[2] ATUALIZAR PROJETO\n"
								+ "[3] REMOVER UM PROJETO\n"
								+ "[4] INFORMACOES DO PROJETO\n"
								+ "[5] ALTERAR STATUS DO PROJETO\n"
								+ "[6] VERIFICAR PROJETO POR STATUS\n"
								+ "[7] SAIR\n");
						optProjeto = sc.nextInt();
						switch(optProjeto) {
						case 1:
							projectFunctions.addNovoProjeto(conta, usuario);
							break;
							
						case 2: 
							projectFunctions.atualizarProjeto(conta, usuario);
							break;
							
						case 3:
							projectFunctions.removerProjeto(conta, usuario);
							break;
							
						case 4:
							projectFunctions.infoProjeto(conta);
							break;
							
						case 5:
							projectFunctions.alterarStatus(conta, usuario);
							break;
							
						case 6:
							projectFunctions.verificarProjetoStatus(conta);;
							break;
							
						case 7:
							optProjeto = 0;
							break;
						default:
							System.out.println("Entrada invalida");
						}
					}
					break; // FIM DA TELA DE PROJETOS
					
				case 2: // inicio da tela de atividades
					int optAtividade = 1;
					while(optAtividade != 0) {
						System.out.printf("TELA DE ATIVIDADES\n\n"
								+ "DIGITE A OPCAO DESEJADA:\n\n"
								+ "[1] ADD NOVA ATIVIDADE\n"
								+ "[2] ATUALIZAR ATIVIDADE\n"
								+ "[3] REMOVER UMA ATIVIDADE\n"
								+ "[4] INFORMACOES DA ATIVIDADE\n"
								+ "[5] SAIR\n");
						optAtividade = sc.nextInt();
						switch(optAtividade) {
						case 1:
							activityFunctions.addNovaAtividade(conta);
							break;
							
						case 2: 
							activityFunctions.atualizarAtividade(conta);
							break;
							
						case 3:
							activityFunctions.removerAtividade(conta);
							break;
							
						case 4:
							activityFunctions.infoAtividade(conta);
							break;
							
						case 5:
							optAtividade = 0;
							break;
						
						default:
							System.out.println("Entrada invalida");
						}
					}
					break; // fim da tela de atividades
					
				case 3: // inicio tela de usuario
					int optUsuario = 1;
					while(optUsuario != 0) {
						System.out.printf("TELA DE ATIVIDADES\n\n"
								+ "DIGITE A OPCAO DESEJADA:\n\n"
								+ "[1] ADD NOVO USUARIO\n"
								+ "[2] ATUALIZAR USUARIO\n"
								+ "[3] REMOVER USUARIO\n"
								+ "[4] INFORMACOES DO USUARIO\n"
								+ "[5] SAIR\n");
						optUsuario = sc.nextInt();
						switch(optUsuario) {
						case 1:
							criarUsuario.criarUsuario(conta);
							break;
							
						case 2: 
							criarUsuario.atualizarUsuario(conta);;
							break;
							
						case 3:
							criarUsuario.removerUsuario(conta);;
							break;
							
						case 4:
							criarUsuario.infoUsuario(conta);;
							break;
							
						case 5:
							optUsuario = 0;
							break;
							
						default:
							System.out.println("Entrada invalida");
						}
					}
								
					break;// fim tela de usuario
					
				case 4: //INICIO TELA DE PAGAMETNOS
					int opt5 = -1;
					while(opt5 != 0) {
						System.out.println("[1] Fazer Pagamento");
						System.out.println("[2] Mostrar Pagamentos");
						System.out.println("[3] Sair");
						
						opt5 = sc.nextInt();
						
						switch(opt5) {
						case 1:
							paymentsFunctions.pagamentos(conta, usuario);
							break;
							
						case 2:
							paymentsFunctions.mostrarPagamentos(conta);
							break;
							
						case 3:
							opt5 = 0;
							break;
						
						default:
							System.out.println("Entrada invalida");
						}
			
					}
					break; // FIM DA TELA DE PAGAMENTOS
					
				case 5:
					opcao = 0;
					System.out.println("Saindo...");
					break;
					
				default:
					System.out.println("Entrada invalida");
				}
				
			}
		}
		catch(java.util.InputMismatchException e) {
			System.out.println("Entrada invalida");
			sistema(conta, usuario);
		}
	}
}
