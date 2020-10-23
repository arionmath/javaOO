package banc;

public class ContaBancaria {
	
	private int numeroDeConta;
	private double saldo;
	
	
	public ContaBancaria(int numeroDeConta) {
		this.numeroDeConta = numeroDeConta;
		
	}
	public ContaBancaria(int numeroDeConta, double deposito) {
		this.numeroDeConta = numeroDeConta;
		this.saldo = deposito;
	}
	
	public void saque(double deposito) {
		saldo-=deposito;}
	
	public void deposito(double deposito) {
		saldo+=deposito;}
	
	
	public int getNumeroDeConta() {
		return numeroDeConta;
	}

	public void getSaldo() {
		System.out.println( "O saldo e de RS"+saldo);
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContaBancaria 	\nnumero da conta----------");
		builder.append(numeroDeConta);
		builder.append(					"\nsaldo-------------------");
		builder.append(saldo);
		builder.append("\n");
		
		return builder.toString();
	}
	


}
