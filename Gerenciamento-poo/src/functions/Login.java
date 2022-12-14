package functions;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Conta;
import entities.Usuario;

public class Login {
	
	public Usuario login(Conta conta) {
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
	    		try {
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
		    			
		    		default:
		    			System.out.println("Entrada invalida");
		    			login(conta);
		    		}
	    		}
	    		catch(java.util.InputMismatchException e) {
	    			System.out.println("Entrada invalida");
	    			login(conta);
	    		}
	    		
	    	}
	    }
		return usuario;
	}
	
	public void recuperarSenha(Usuario usuar) {
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Digite uma nova senha:");
			String novaSenha = sc.nextLine();
			usuar.setSenha(novaSenha);
			System.out.println("Senha alterada com sucesso");
			
		}

}
