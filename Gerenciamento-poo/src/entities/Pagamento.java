package entities;

public class Pagamento {
	private double valor;
	private String conta;
	private String agencia;
	private taxas tx;
	
	public Pagamento() {
	}
	
	
	public Pagamento(double valor, String conta, String agencia, taxas tx) {
		this.valor = valor;
		this.conta = conta;
		this.agencia = agencia;
		this.tx = tx;
	}


	public double getValor() {
		return valor - getTx(valor);
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
	
	public double getTx(double valor) {
		double tx = taxas.tax(valor);
		return tx;	
	}
	
}
