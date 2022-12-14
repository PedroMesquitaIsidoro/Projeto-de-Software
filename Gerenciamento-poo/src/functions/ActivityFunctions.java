package functions;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Atividade;
import entities.Conta;
import entities.Usuario;

public class ActivityFunctions {
	
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
		
		try {
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
		}
		catch(java.util.InputMismatchException e) {
			System.out.println("Entrada invalida");
			addNovaAtividade(conta);
		}
	    
	    System.out.println("Digite as tarefas da atividade:");
	    String tarefas = sc.nextLine();
	  //arrumar o construtor de atividade dps do almoço
	    new Atividade.AtividadeBuilder()
	    	.id(id)
	    	.descricao(descricao)
	    	.dataHoraInicio(dataHoraInicio)
	    	.dataHoraFim(dataHoraFim)
	    	.responsavel(emailResponsavel)
	    	.envolvidos(participantes)
	    	.tarefas(tarefas);
	    atividades = conta.getAtividades();
	    Atividade atividade = new Atividade(id, descricao , dataHoraInicio, dataHoraFim, emailResponsavel,
	    	 tarefas);
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
			try {
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
									atividade.addEnvolvidos(usuario);
									usuario.addAtividadesEnvolvidas(atividade);
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
			catch(java.util.InputMismatchException e) {
				System.out.println("Entrada invalida");
				atualizarAtividade(conta);
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
			atividade.chamaPrint();
		}
		else {
			System.out.println("id nao encontrado");
		}	
	}
	
	public Usuario procurarUsuario(Conta conta, String emailParticipante ) { // funcao pra buscar usuario
		for(Usuario usu : conta.getUsuarios()) {
			if(usu.getEmail().equals(emailParticipante)) {
				return usu;
			}
		}
		return null;
	}

}
