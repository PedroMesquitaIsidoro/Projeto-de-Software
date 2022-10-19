package entities;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Aplicacao {
	
	public void menu(Conta conta) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

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
				criarUsuario(conta);
				break;
				
			case 2: //login
				login(conta);
				break;
				
			case 3: // sair do sistema
				opcao = 0;
				System.out.println("FECHANDO O SISTEMA");
				break;
			}
		}
		
		sc.close();
	}
	
	public void criarUsuario(Conta conta) {
		Scanner sc = new Scanner(System.in);
		
		Usuario usuario = null;	
		ArrayList<Usuario> usuarios = new ArrayList<>();
		ArrayList<Projeto> projetoEnvolvidos = new ArrayList<>();
		ArrayList<Atividade> atividadeEnvolvidas = new ArrayList<>();
		
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
			}
			usuario = new Profissional(nome, email, senha, tipoProfissional);
			
			break; // fim de cadastrar profissional
			
		case 5:
			System.out.println("Do que voce eh tecnico?:");
			String tipoTecnico = sc.nextLine();
			usuario = new Tecnico(nome, email, senha, tipoTecnico);
			break;
		}
		
		System.out.println("Insira os projetos em que esteja envolvido:");
		int opcaoProjeto = -1;
		
		while(opcaoProjeto !=0) {
			
			System.out.printf("[1] Add projeto\n"
					+ "[2] Sair\n");
			opcaoProjeto = sc.nextInt();
			
			switch(opcaoProjeto) {
			case 1:
				System.out.println("Digite o id do projeto que voce esta associado:");
				sc.nextLine();
				String id = sc.nextLine();
				Projeto projeto = procurarProjeto(id, conta);
				
				if(projeto != null) {
					projetoEnvolvidos.add(projeto);
					System.out.println("O projeto foi add com sucesso");
				}
				else {
					System.out.println("Id nao encontrado");
				}
				opcaoProjeto = 0;
				
				break;
				
			case 2:
			opcaoProjeto = 0;
			break;
			}
			
		}
		usuario.setProjetosEnvolvido(projetoEnvolvidos);
		//
		System.out.println("Insira as atividades em que esteja envolvido:");
		int opcaoAtv = -1;
		while(opcaoAtv !=0) {
			
			System.out.printf("[1] Add Atividade\n"
					+ "[2] Sair\n");
			opcaoAtv = sc.nextInt();
			
			switch(opcaoAtv) {
			case 1:
				System.out.println("Digite o id da atividade que voce esta associado:");
				sc.nextLine();
				String idAtv = sc.nextLine();
				Atividade atividade = procurarAtividade(idAtv, conta);
				
				if(atividade != null) {
					atividadeEnvolvidas.add(atividade);
					System.out.println("A atividade foi add com sucesso");
				}
				else {
					System.out.println("Id nao encontrado");
				}
				opcaoAtv = 0;
				
				break;
				
			case 2:
			opcaoAtv = 0;
			break;
			}
		usuario.setAtividadesEnvolvida(atividadeEnvolvidas);
			
		usuarios = conta.getUsuarios();
		usuarios.add(usuario);
		conta.setUsuarios(usuarios);
		System.out.println("Cadastro feito");
		menu(conta);
		
		sc.close();
	}
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
	
	public void login(Conta conta) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite seu e-mail:");
		String email = sc.nextLine();
		System.out.println("Digite sua senha:");
		String senha = sc.nextLine();
		
	    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	    
	    Usuario usuario = null;
	    
	    for(Usuario usu : conta.getUsuarios()) {
	    	
	    	if(usu.getEmail().equals(email) && usu.getSenha().equals(senha)) {
	    		usuario = usu;
	    	}
	    	
	    	else if(usu.getEmail().equals(email)) {
	    		System.out.println("A senha esta errada. Deseja recuperar a senha?");
	    		System.out.println("[1] Sim");
	    		System.out.println("[2] Nao");
	    		int optRecupera = sc.nextInt();
	    		switch(optRecupera) {
	    		case 1:
	    			recuperarSenha(usu);
	    			break;
	    			
	    		case 2:
	    			break;
	    		}
	    	}
	    	
	    	if(usuario != null) {
	    		sistema(conta, usuario);
	    	}
	    	else if (usuario == null) {
	    		System.out.println("Esse email nao tem cadastro no sistema");
	    	}
	    }

	}
	
	public void recuperarSenha(Usuario usuar) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite uma nova senha:");
		String novaSenha = sc.nextLine();
		usuar.setSenha(novaSenha);
		System.out.println("Senha alterada com sucesso");
		
	}
	
	public void sistema(Conta conta, Usuario usuario) {
		//System.out.println("Entrei nessa poha");
		
		Scanner sc = new Scanner(System.in);
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
						addNovoProjeto(conta);
						break;
						
					case 2: 
						atualizarProjeto(conta);
						break;
						
					case 3:
						removerProjeto(conta);
						break;
						
					case 4:
						infoProjeto(conta);
						break;
						
					case 5:
						alterarStatus(conta, usuario);
						break;
						
					case 6:
						verificarProjetoStatus(conta);
						break;
						
					case 7:
						optProjeto = 0;
						break;
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
						addNovaAtividade(conta);
						break;
						
					case 2: 
						atualizarAtividade(conta);
						break;
						
					case 3:
						removerAtividade(conta);
						break;
						
					case 4:
						infoAtividade(conta);
						break;
						
					case 5:
						optAtividade = 0;
						break;
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
						criarUsuario(conta);
						break;
						
					case 2: 
						atualizarUsuario(conta);
						break;
						
					case 3:
						removerUsuario(conta);
						break;
						
					case 4:
						infoUsuario(conta);
						break;
						
					case 5:
						optUsuario = 0;
						break;
					}
				}
				
				
				break;// fim tela de usuario
				
			case 4: //INICIO TELA DE PAGAMETNOS
				int opt5 = -1;
				while(opt5 != 0) {
					System.out.println("[1] Pagamentos");
					System.out.println("[2] Mostrar Pagamentos");
					System.out.println("[3] Sair");
					
					opt5 = sc.nextInt();
					
					switch(opt5) {
					case 1:
						pagamentos(conta);
						break;
						
					case 2:
						break;
						
					case 3:
						opt5 = 0;
						break;
					}
		
				}
				break; // FIM DA TELA DE PAGAMENTOS
				
			case 5:
				opcao = 0;
				System.out.println("Saindo...");
				break;
			}
			
		}
	}
	
	public void addNovoProjeto(Conta conta) {
		Scanner sc = new Scanner(System.in);
		Usuario coordenador = null;
		ArrayList<Projeto> projetos = new ArrayList<Projeto>();
		ArrayList<Atividade> atividades = new ArrayList<Atividade>();
		ArrayList<Usuario> participantes = new ArrayList<Usuario>();
		
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
				}
			}
		}
		
		if(coordenador == null) {
			System.out.println("Email nao encontrado");

		}
		
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
		System.out.println("Adicionar atividades ao projeto");
		int opt1 = -1;
		
		while(opt1 != 0) {
			System.out.println("[1] Inserir atividade");
			System.out.println("[2] Avancar");
			
			opt1 = sc.nextInt();
			sc.nextLine();
			
			switch(opt1) {
			case 1: //inserir
				System.out.println("Digite o id da atividade");
				String idAtv = sc.nextLine();
				Atividade atividade = procurarAtividade(conta, idAtv);
				if(atividade != null) {
					atividades.add(atividade);
					System.out.println("A atividade foi adicionada");
				}
				else {
					System.out.println("O id nao foi encontrado");
				}
				break;
			case 2: 
				opt1 = 0;
				break;	
				}
			}
		System.out.println("Informe o valor da bolsa:");
		Double bolsa = sc.nextDouble();
		sc.nextLine();
		
		System.out.println("Informe o tempo de duracao do projeto:");
		String duracaoProjeto = sc.nextLine();
		String status = null;
		Projeto projeto = new Projeto(id, descricao, dataHoraInicio, dataHoraFim, coordenador, participantes, atividades,
				bolsa, duracaoProjeto, status);
		projetos.add(projeto);
		conta.setProjetos(projetos);
		
		System.out.println("Projeto Criado com sucesso");
		
	}
	
	public Usuario procurarUsuario(Conta conta, String emailParticipante ) { // funcao pra buscar usuario
		for(Usuario usu : conta.getUsuarios()) {
			if(usu.getEmail().equals(emailParticipante)) {
				return usu;
			}
		}
		return null;
	}
	
	public Atividade procurarAtividade(Conta conta, String idAtv) {
		
		for(Atividade atv : conta.getAtividades()) {
			if(atv.getId().equals(idAtv)) {
				return atv;
			}
		}
		
		return null;
	}
	// atualizar projeto ######################################################################################
	public void atualizarProjeto(Conta conta) {
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
					projetoAgora.setEnvolvidosProjeto(participantes);
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
								atividades.add(atividade);
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
					projetoAgora.setAtividades(atividades);
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
	}
	
	public void removerProjeto(Conta conta) {
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
	
	public void addNovaAtividade(Conta conta) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Usuario> participantes = new ArrayList<Usuario>();
		ArrayList<Atividade> atividades = new ArrayList<Atividade>();
		System.out.println("Digite o id da atividade");
		String id = sc.nextLine();
		
		System.out.println("Digite a descricao da atividade");
		String descricao = sc.nextLine();
		
		System.out.println("Digite a data e hora de inicio da atividade");
		String dataHoraInicio = sc.nextLine();
		
		System.out.println("Digite a data e hora de fim da atividade");
		String dataHoraFim = sc.nextLine();
		
		System.out.println("Digite o email do responsavel pela atividade");
		String emailResponsavel = sc.nextLine();
		
	    System.out.println("Adicionar participantes na atividade");
	    int opt = -1;
	    
	    while(opt != 0) {
	    	 System.out.println("[1] Add participante");
	    	 System.out.println("[2] Avancar");
	    	 
	    	 opt = sc.nextInt();
	    	 sc.nextLine();
	    	 
	    	 switch(opt) {
	    	 case 1:
	    		 System.out.println("Digite o email do participante:");
	    		 String emailParticipante = sc.nextLine();
	    		 Usuario usuario = procurarUsuario(conta, emailParticipante);
	    		 
	    		 if(usuario != null) {
	    			 participantes.add(usuario);
	    			 System.out.println("Usuario adicionado");
	    		 }
	    		 else {
	    			 System.out.println("email nao encontrado");
	    		 }
	    		 
	    		 break;
	    		 
	    	 case 2:
	    		 opt = 0;
	    		 break;
	    	 }
	    }
	    
	    System.out.println("Digite as tarefas da atividade:");
	    String tarefas = sc.nextLine();
	  //arrumar o construtor de atividade dps do almoço
	    Atividade atividade = new Atividade(id, descricao , dataHoraInicio, dataHoraFim, emailResponsavel,
	    		participantes, tarefas);
	    atividades = conta.getAtividades();
	    atividades.add(atividade);
	    conta.setAtividades(atividades);
	    System.out.println("ATIVIDADE CADASTRADA");
	}
	
	public void atualizarAtividade(Conta conta) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Atualizar atividade");
		ArrayList<Usuario> participantes = new ArrayList<Usuario>();
		Atividade atividade = null;
		Usuario usuario = null;
		
		System.out.println("Digite o id da atividade que voce deseja atualizar:");
		String idAtv = sc.nextLine();
		for(Atividade atv : conta.getAtividades()) {
			if(atv.getId().equals(idAtv)) {
				atividade = atv;
			}
		}
		if(atividade != null) {
			int opt = -1;
			while(opt !=0) {
				System.out.printf("\nTELA DE ATIVIDADES \n\n"
						+ "DIGITE A OPCAO DESEJADA:\n\n"
						+ "[1] ATUALIZAR ID\n"
						+ "[2] ATUALIZAR DESCRICAO\n"
						+ "[3] ATUALIAZAR DATA E HORA DE INICIO\n"
						+ "[4] ATUALIAZAR DATA E HORA DE FIM\n"
						+ "[5] ATUALIZAR RESPONSAVEL\n"
						+ "[6] ATUALIZAR PARTICIPANTES DA ATIVIDADE\n"
						+ "[7]ATUALIZAR TAREFA\n"
						+ "[8] SAIR\n");
				opt = sc.nextInt();
				switch(opt) {
				case 1:
					System.out.println("Digite o novo id:");
					sc.nextLine();
					String id = sc.nextLine();
					atividade.setId(id);
					System.out.println("id atualizado");
					break;
					
				case 2:
					System.out.println("Digite a nova descricao:");
					sc.nextLine();
					String descricao = sc.nextLine();
					atividade.setDescricao(descricao);
					System.out.println("Descricao atualizada");
					break;
					
				case 3:
					System.out.println("Digite a nova data e hora de inicio:");
					sc.nextLine();
					String dataHoraInicio = sc.nextLine();
					atividade.setDataHoraInicio(dataHoraInicio);
					System.out.println("Data e hora de inicio foram atualizadas");
					break;
					
				case 4:
					System.out.println("Digite a nova data e hora de fim:");
					sc.nextLine();
					String dataHoraFim = sc.nextLine();
					atividade.setDataHoraFim(dataHoraFim);
					System.out.println("Data e hora de fim foram atualizadas");
					break;
					
				case 5:
					System.out.println("Digite o novo responsavel:");
					sc.nextLine();
					String responsavel = sc.nextLine();
					atividade.setResponsavel(responsavel);
					System.out.println("Responsavel atualizado");
					break;
					
				case 6:
					System.out.println("Adicionar participantes");
					
					int opt1 = -1;
					while(opt1 != 0) {
						System.out.println("[1] Adicionar novo participantes");
						System.out.println("[2] Voltar");
						opt1 = sc.nextInt();
						
						switch(opt1) {
						case 1:
							System.out.println("Digite o email do participante que deseja inserir na atividade:");
							sc.nextLine();
							String emailParticipante = sc.nextLine();
							usuario = procurarUsuario(conta, emailParticipante);
							if(usuario != null) {
								participantes.add(usuario);
								System.out.println("Usuario adicionado com sucesso");
							}
							else {
								System.out.println("Email nao encontrado");
							}
							break;
							
						case 2:
							opt1 = 0;
							break;
						}
					}

					break;
					
				case 7:
					System.out.println("Digite a nova tarefa:");
					sc.nextLine();
					String tarefa = sc.nextLine();
					atividade.setTarefas(tarefa);
					System.out.println("Tarefa atualizada");
					break;
					
				case 8:
					opt = 0;
					break;
				}
			}
		}
		else {
			System.out.println("id nao encontrado");
		}
	}
	
	public void removerAtividade(Conta conta) {
		Scanner sc = new Scanner(System.in);
		Atividade atividade = null;
		System.out.println("Digite o id da atividade que deseja remover:");
		String id = sc.nextLine();
		
		for(Atividade atv : conta.getAtividades()) {
			if(atv.getId().equals(id)) {
				atividade = atv;
			}
		}
		
		if(atividade != null) {
			conta.getAtividades().remove(atividade);
			System.out.println("Atividade removida com sucesso");
		}
		else {
			System.out.println("id nao encontrado");
		}
	}
	
	public void infoAtividade(Conta conta) {
		Scanner sc = new Scanner(System.in);
		Atividade atividade = null;
		System.out.println("Digite o id da atividade que deseja verificar:");
		String id = sc.nextLine();
		
		for(Atividade atv : conta.getAtividades()) {
			if(atv.getId().equals(id)) {
				atividade = atv;
			}
		}
		
		if(atividade != null) {
			System.out.println(atividade.toString());
		}
		else {
			System.out.println("id nao encontrado");
		}	
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
								projetoEnvolvidos.add(projeto);
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
					usuario.setProjetosEnvolvido(projetoEnvolvidos);
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
								atividadeEnvolvidas.add(atividade);
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
					usuario.setAtividadesEnvolvida(atividadeEnvolvidas);
					break;
					
				case 6:
					opt = 0;
					break;
				}
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
			// depois da janta lembrar de fazer um toString para cada subclasse de usuario
		}
		else {
			System.out.println("Email nao encontrado");
		}
	}
	
	public void pagamentos(Conta conta) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o id do projeto:");
		String id = sc.nextLine();
		Projeto projeto = null;
		
		for(Projeto proj : conta.getProjetos()) {
			if(proj.getId().equals(id)) {
				projeto = proj;
			}
		}
		
		if(projeto != null) {
			System.out.printf("Valor: %.2f", projeto.getValorBolsa());
			
		}
		else {
			System.out.println("Id nao encontrado");
		}
	}
	

}
