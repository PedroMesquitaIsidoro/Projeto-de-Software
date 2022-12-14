package functions;

import java.util.Scanner;

import entities.Conta;
import entities.Pesquisador;
import entities.Professor;
import entities.Projeto;
import entities.Usuario;

public class PaymentsFunctions {
	public void pagamentos(Conta conta, Usuario usuarioAgora) {
		if(usuarioAgora instanceof Professor | usuarioAgora instanceof Pesquisador ) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Digite o id do projeto:");
			String id = sc.nextLine();
			String numeroAgencia = null;
			String numeroConta = null;
			Projeto projeto = null;
			
			for(Projeto proj : conta.getProjetos()) {
				if(proj.getId().equals(id)) {
					projeto = proj;
				}
			}
			
			if(projeto != null) {
				try {
					System.out.printf("Valor da bolsa: %.2f", projeto.getValorBolsa());
					System.out.println("\nDigite o numero da agencia:");
					numeroAgencia = sc.nextLine();
					System.out.println("Digite o numero da conta:");
					numeroConta = sc.nextLine();
					projeto.fazerPagamento(projeto.getValorBolsa(), numeroConta, numeroAgencia);
					System.out.println("Pagamento Feito");		
				}
				catch(java.util.InputMismatchException e) {
					System.out.println("Entrada invalida");
					pagamentos(conta, usuarioAgora);
				}
				
			}
			else {
				System.out.println("Id nao encontrado");
			}
		}
		else {
			System.out.println("Voce nao tem permissao para realizar pagamentos, apenas professores e pesquisadores");
		}
	}
	
	public void mostrarPagamentos(Conta conta) {
		Scanner sc = new Scanner(System.in);
		Projeto projeto = null;
		System.out.println("Digite o id do projeto que deseja verificar o pagamento:");
		String id = sc.nextLine();
		for(Projeto pro : conta.getProjetos()) {
			if(pro.getId().equals(id)) {
				projeto = pro;
			}
		}
		
		if(projeto!= null) {
			System.out.println(projeto.getPagamento());
		}
		else {
			System.out.println("Id nao encontrado");
		}
	}
}
