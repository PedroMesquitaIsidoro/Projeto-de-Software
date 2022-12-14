package functions;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Atividade;
import entities.Conta;
import entities.Pesquisador;
import entities.Professor;
import entities.Projeto;
import entities.Usuario;

public class ProjectFunctions {
	
	public void addNovoProjeto(Conta conta, Usuario usuarioAtual) {
		if(usuarioAtual instanceof Professor | usuarioAtual instanceof Pesquisador ) {
		Scanner sc = new Scanner(System.in);
		Usuario coordenador = null;
		ArrayList<Projeto> projetos = new ArrayList<Projeto>();
		ArrayList<Atividade> atividades = new ArrayList<Atividade>();
		ArrayList<Usuario> participantes = new ArrayList<Usuario>();
		double bolsa = 0.0;
		System.out.println("Digite o id:");
		String id = sc.nextLine();
		
		
		
		System.out.println("Digite a descricao:");
		String descricao = sc.nextLine();
		
		System.out.println("Digite a data e hora de inicio do projeto:");
		String dataHoraInicio = sc.nextLine();
		
		System.out.println("Digite a data e hora de fim do projeto:");
		String dataHoraFim = sc.nextLine();
		
		System.out.println("Digite o email do coordenador do projeto:");
		String emailCoordenador = sc.nextLine();
		
		for(Usuario usu : conta.getUsuarios()) {
			if(usu.getEmail().equals(emailCoordenador)) {
				coordenador = usu;
				
				if(usu instanceof Professor | usu instanceof Pesquisador ) {
					coordenador = usu;
				}
				else {
					System.out.println("Este usuario nao pode ser coordenador, pois apenas professores e pesquisadores podem ser");
					addNovoProjeto(conta, usuarioAtual);
				}
			}
		}
		
		if(coordenador == null) {
			System.out.println("Email nao encontrado");
			addNovoProjeto(conta, usuarioAtual);
		}
		
		try {
			System.out.println("Adicionar participantes ao projeto");
			int opt = -1;
			
			while(opt != 0) {
				System.out.println("[1] Inserir participante");
				System.out.println("[2] Avancar");
				
				opt = sc.nextInt();
				sc.nextLine();
				
				switch(opt) {
				case 1: //inserir
					System.out.println("Digite o email do participante");
					String emailParticipante = sc.nextLine();
					Usuario usuario = procurarUsuario(conta, emailParticipante );
					if(usuario != null) {
						participantes.add(usuario);
						System.out.println("O usuario foi adicionado");
					}
					else {
						System.out.println("O email nao foi encontrado");
					}
					break;
				case 2: 
					opt = 0;
					break;		
				} // fim de add usuarios ao projeto
				
			}
		}
		catch(java.util.InputMismatchException e) {
			System.out.println("Entrada invalida");
			addNovoProjeto(conta, usuarioAtual);
		}
			
		try {
		System.out.println("Informe o valor da bolsa:");
		bolsa = sc.nextDouble();
		sc.nextLine();
		}
		catch(java.util.InputMismatchException e) {
			System.out.println("Entrada invalida");
			addNovoProjeto(conta, usuarioAtual);
		}
		
		System.out.println("Informe o tempo de duracao do projeto:");
		String duracaoProjeto = sc.nextLine();
		String status = null;
		Projeto projeto = new Projeto(id, descricao, dataHoraInicio, dataHoraFim, coordenador, participantes, bolsa, duracaoProjeto, status);
		projetos.add(projeto);
		conta.setProjetos(projetos);
		projeto.EnvolvidosInProjeto(usuarioAtual);
		
		System.out.println("Projeto Criado com sucesso");
		}
		else {
			System.out.println("Voce nao tem permissao para acessar essa tela, apenas professores e pesquisadores");
		}
		
	}
	
	public Atividade procurarAtividade(Conta conta, String idAtv) {
			
			for(Atividade atv : conta.getAtividades()) {
				if(atv.getId().equals(idAtv)) {
					return atv;
				}
			}
			
			return null;
		}
	
	public Usuario procurarUsuario(Conta conta, String emailParticipante ) { // funcao pra buscar usuario
		for(Usuario usu : conta.getUsuarios()) {
			if(usu.getEmail().equals(emailParticipante)) {
				return usu;
			}
		}
		return null;
	}
	
	public void atualizarProjeto(Conta conta, Usuario usuarioAgora) {
		if(usuarioAgora instanceof Professor | usuarioAgora instanceof Pesquisador ) {
			Scanner sc = new Scanner(System.in);
			Usuario coordenador = null;
			ArrayList<Atividade> atividades = new ArrayList<Atividade>();
			ArrayList<Usuario> participantes = new ArrayList<Usuario>();
			Projeto projetoAgora = null;
			System.out.println("Digite o id do projeto:");
			String id = sc.nextLine();
			
			for(Projeto pro : conta.getProjetos()) {
				if(pro.getId().equals(id)) {
					projetoAgora = pro;
				}
			}
			
			if(projetoAgora == null) {
				System.out.println("Id nao encontrado");
			}
			else {
				try {
					int opt = -1;
					while(opt != 0 ) {
						System.out.printf("TELA DE PROJETOS\n\n"
								+ "DIGITE A OPCAO DESEJADA:\n\n"
								+ "[1] ATUALIZAR ID\n"
								+ "[2] ATUALIZAR DESCRICAO\n"
								+ "[3] ATUALIAZAR DATA E HORA DE INICIO\n"
								+ "[4] ATUALIAZAR DATA E HORA DE FIM\n"
								+ "[5] ATUALIZAR COORDENADOR\n"
								+ "[6] ATUALIZAR MEMBROS DO PROJETO\n"
								+ "[7]ATUALIAR ATIVIDADES DO PROJETO\n"
								+ "[8] ATUALIZAR BOLSA\n"
								+ "[9] ATUALIZAR DURACAO BOLSA\n"
								+ "[10] SAIR\n");
						opt = sc.nextInt();
						switch(opt) {
						case 1: 
							System.out.println("digite o novo id:");
							sc.nextLine();
							String idNovo = sc.nextLine();
							projetoAgora.setId(idNovo);
							System.out.println("O id foi atualizado");
							break;
							
						case 2:
							System.out.println("digite uma nova descricao:");
							sc.nextLine();
							String descricaoNova = sc.nextLine();
							projetoAgora.setDescricao(descricaoNova);
							System.out.println("A descricao foi atualizada");
							break;
							
						case 3:
							System.out.println("digite a nova data e hora de inicio:");
							sc.nextLine();
							String dataHoraInicioNovo = sc.nextLine();
							projetoAgora.setDataHoraInicio(dataHoraInicioNovo);
							System.out.println("A data e hora de inicio foram atualizadas");
							break;
							
						case 4:
							System.out.println("digite a nova data e hora de fim:");
							sc.nextLine();
							String dataHoraFimNovo = sc.nextLine();
							projetoAgora.setDataHoraFim(dataHoraFimNovo);
							System.out.println("A data e hora de fim foram atualizadas");
							break;
							
						case 5:
							System.out.println("digite o email do novo coordenador:");
							sc.nextLine();
							String emailCoordenador = sc.nextLine();
							
							for(Usuario usu : conta.getUsuarios()) {
								if(usu.getEmail().equals(emailCoordenador)) {
									coordenador = usu;
									if(usu instanceof Professor | usu instanceof Pesquisador) {
										coordenador = usu;
									}
									else
									{
										System.out.println("Este usuario nao pode ser coordenador de projeto, pois"
												+ "nao eh professor ou pesquisador");
									}
								}
							}
							
							if(coordenador != null) {
								projetoAgora.setCoordenador(coordenador);
								System.out.println("O coordenador foi atuazlizado");
							}
							else {
								System.out.println("Email nao encontrado");
							}
							break;
							
						case 6:// INICIO DE ATUALIZAR MEMBROS
							System.out.println("ATUALIZAR MEMBROS DO PROJETO");
							
							int opt2 = -1;
							
							while(opt2 != 0) {
								System.out.println("[1] Inserir membro");
								System.out.println("[2] Voltar");
								opt2 = sc.nextInt();
								
								
								switch(opt2) {
								case 1:
									System.out.println("Insira o email do participante que deseja colocar:");
									sc.nextLine();
									String emailParticipante = sc.nextLine();
									Usuario usuario = procurarUsuario(conta, emailParticipante);
									if(usuario != null) {
										participantes.add(usuario);
										usuarioAgora.projetoEnvolvidos(projetoAgora);
										projetoAgora.EnvolvidosInProjeto(usuario);
										usuario.projetoEnvolvidos(projetoAgora);
										System.out.println("O usuario foi adicionado");
									}
									else {
										System.out.println("O email nao foi encontrado");
									}
									break;
									
								case 2:
									opt2 = 0;
									break;
								}
							}
							//projetoAgora.setEnvolvidosProjeto(participantes);
							break; // FIM DE ATUALIZAR MEMBROS
							
						case 7: // INICIO DE ATUALIZAR ATIVIDADES
							System.out.println("ATUALIZAR ATIVIDADES DO PROJETO");
							int opt3 = -1;
							while(opt3 != 0) {
								System.out.println("[1] Inserir atividade");
								System.out.println("[2] Voltar");
								opt3 = sc.nextInt();
								
								
								switch(opt3) {
								case 1:
									System.out.println("Insira o id da atividade que deseja colocar:");
									sc.nextLine();
									String idAtvNova = sc.nextLine();
									Atividade atividade = procurarAtividade(conta, idAtvNova);
									if(atividade != null) {
										projetoAgora.addAtividades(atividade);
										System.out.println("A atividade foi adicionada");
									}
									else {
										System.out.println("O id nao foi encontrado");
									}
									break;
									
								case 2:
									opt3 = 0;
									break;
								}
							}
							//projetoAgora.setAtividades(atividades);
							break; // FIM DE ATUALIZAR ATIVIDADES
							
						case 8:
							System.out.println("digite o novo valor da bolsa:");
							Double novaBolsa= sc.nextDouble();
							projetoAgora.setValorBolsa(novaBolsa);
							System.out.println("O valor da bolsa foi alterado");		
							break;
							
						case 9:
							System.out.println("digite o novo periodo de vigencia da bolsa:");
							sc.nextLine();
							String periodoNovoBolsa = sc.nextLine();
							projetoAgora.setPeriodoBolsa(periodoNovoBolsa);
							System.out.println("O periodo foi alterado com sucesso");		
							break;
							
						case 10:
							opt = 0;
							break;
						}
					}
				}
				catch(java.util.InputMismatchException e) {
					System.out.println("Entrada invalida");
					atualizarProjeto(conta, usuarioAgora);
				}
			}
		}
		else {
			System.out.println("Voce nao tem permissao para acessar essas tela, apenas professores e pesquisadores");
		}
	}
	
	public void removerProjeto(Conta conta, Usuario usuarioAtual) {
		if(usuarioAtual instanceof Professor | usuarioAtual instanceof Pesquisador ) {
			Scanner sc = new Scanner(System.in);
			Projeto projeto = null;
			System.out.println("Digite o id do projeto que voce deseja remover:");
			String id = sc.nextLine();
			
			for(Projeto proj : conta.getProjetos()) {
				if(proj.getId().equals(id)) {
					projeto = proj;
				}
			}
			
			if(projeto != null) {
				conta.getProjetos().remove(projeto);
				System.out.println("O projeto foi excluido");
			}
			else {
				System.out.println("O id nao foi encontrado");
	
			}
		}
		else {
			System.out.println("Voce nao tem permissao para acessar essas tela, apenas professores e pesquisadores");
		}
	}
	
	public void infoProjeto(Conta conta) {
		Scanner sc = new Scanner(System.in);
		Projeto projeto = null;
		System.out.println("Digite o id do projeto que voce deseja verificar as informacoes");
		String id = sc.nextLine();
		
		for(Projeto proj : conta.getProjetos()) {
			if(proj.getId().equals(id)) {
				projeto = proj;
			}
		}
		
		if(projeto != null) {
			System.out.println(projeto);
			System.out.println("Participantes:");
			projeto.chamaPrint();
			projeto.chamarPrintAtividades();
		}
		else {
			System.out.println("O id nao foi encontrado");
		}
	}
	
	public void alterarStatus(Conta conta, Usuario usuario) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o id do projeto:");
		String id = sc.nextLine();
		Projeto projeto = null;
		
		for(Projeto proj : conta.getProjetos()) {
			if(proj.getId().equals(id)) {
				projeto = proj;
				if(proj.getCoordenador() == usuario) {
					
					System.out.println("Escolha uma das opcoes de status:");
					System.out.println("[1] EM PROCESSO DE CRIACAO");
					System.out.println("[2] INICIADO");
					System.out.println("[3] EM ANDAMENTO");
					System.out.println("[4] CONCLUIDO");
					int opt = sc.nextInt();
					
					switch(opt) {
					case 1:
						proj.setStatus("EM PROCESSO DE CRIACAO");
						System.out.println("status alterado com sucesso");
						break;
						
					case 2:
						if(proj.getStatus() == "EM PROCESSO DE CRIACAO") {
							proj.setStatus("INICIADO");
							System.out.println("status alterado com sucesso");
						}
						else {
							System.out.println("Voce nao tem permissao para alterar desta forma, so pode alterar se ele estiver"
									+ "em processo de criacao anteriormente");
						}
						break;
						
					case 3:
						if(proj.getStatus() == "INICIADO") {
							proj.setStatus("EM ANDAMENTO");
							System.out.println("status alterado com sucesso");
						}
						else {
							System.out.println("Voce nao tem permissao para alterar desta forma, so pode alterar se ele estiver"
									+ "iniciado anteriormente");
						}
						break;
						
					case 4:
						if(proj.getStatus() == "EM ANDAMENTO") {
							proj.setStatus("CONCLUIDO");
							System.out.println("status alterado com sucesso");
						}
						else {
							System.out.println("Voce nao tem permissao para alterar desta forma, so pode alterar se ele estiver"
									+ "em andamento anteriormente");
						}
						break;
					default:
						System.out.println("Entrada invalida");
						alterarStatus(conta, usuario);
					}
				}
				else {
					System.out.println("Voce nao tem permissao para alterar o status do projeto, apenas o coordenador"
							+ "pode alterar");
				}
			}
		}
		if(projeto == null) System.out.println("Id nao encontrado");
	}
	
	public void verificarProjetoStatus(Conta conta) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o id do projeto que deseja olhar:");
		String id = sc.nextLine();
		String status = null;
		for(Projeto proj : conta.getProjetos()) {
			if(proj.getId().equals(id)) {
				status = proj.getStatus();
				}
		}
		System.out.printf("\nStatus: %s/n", status);
	}
}
