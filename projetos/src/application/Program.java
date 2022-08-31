package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Projeto;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		List<Projeto> list = new ArrayList<>();
		
		int opcao = 1;
		while(opcao != 0)
		{
		
			System.out.printf("Digite o que deseja:\n"
					+ "[1] Criar projeto\n"
					+ "[2] Remover projeto\n"
					+ "[3] Listar projetos cadastrados"
					+ "[0] Sair do programa\n");
			
			
			opcao = sc.nextInt();
			switch(opcao) {
			
				case 1:
						System.out.println("Quantos projetos voce deseja criar?");
						int n = sc.nextInt();
					
						for(int i = 0; i < n; i++) {
							System.out.printf("Criando Projeto %d: \n", i + 1);
							System.out.println("Digite o id do projeto: ");
							Integer id = sc.nextInt();
							System.out.println("Digite uma descricao do projeto: ");
							sc.nextLine();
							String descricao = sc.nextLine();
							System.out.println("Digite a data de inicio do projeto: ");
							String dataInicio = sc.nextLine();
							System.out.println("Digite a data que o projeto finaliza: ");
							String dataFim = sc.nextLine();
							System.out.println("Digite o nome do coordenador do projeto: ");
							String coordenador = sc.nextLine();
							Projeto proj = new Projeto(id, descricao, dataInicio, dataFim, coordenador);
							list.add(proj);	
							
						}
						
						System.out.println("\nProjeto(s) criado(s) com sucesso");
						for(Projeto proj : list) {
							 System.out.println(proj);
						}
						break;
						
				
				case 2:
						System.out.println("Digite o id do projeto que voce deseja remover:\n");
						int id = sc.nextInt();
						Integer pos = positionId(list, id);
						if(pos == -1) {
							System.out.println("O id nao existe");
						}
						else
						{
							System.out.println(pos);
							list.remove(pos);
						}
						
						
					break;
				
				case 3:
					
					for(Projeto proj : list) {
						 System.out.println(proj);
					}
						
				}
		}
		
		
		sc.close();

	}
	
	public static int positionId(List<Projeto> list, int id) {
		for(int i =0 ; i < list.size(); i++) {
			if(list.get(i).getId() == id) {
				return i;
			}
		}
		return -1;
		
	}

}
