package entities;

public class taxaParaEstudantes implements taxas{
	
	public double tax(double valor) {
		if(valor >= 400) {
			return valor * 0.1;
		}
		else {
			return 0;
		}
	}
}
