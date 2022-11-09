package entities;

public class Pagamento {
	private double valor;
	private String conta;
	private String agencia;
	
	public Pagamento() {
	}
	
	
	public Pagamento(double valor, String conta, String agencia) {
		this.valor = valor;
		this.conta = conta;
		this.agencia = agencia;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	public String getConta() {
		return conta;
	}


	public void setConta(String conta) {
		this.conta = conta;
	}


	public String getAgencia() {
		return agencia;
	}


	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	
	public String toString() {
		return "Agencia: " + getAgencia() +
				"\nConta: " + getConta() +
				"\nValor: " + getValor();
	}
	
	
}
