package banc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clientes implements Comparator<Clientes>{
	
	private String nome;
	private List<ContaBancaria> conta;
	
	
	public Clientes(String nome,int conta){
		this.nome=nome;
		this.conta=new ArrayList<ContaBancaria>();
		this.conta.add(	new	ContaBancaria(conta)	);
	}
	
	public Clientes(String nome,int conta, double deposito){
		this.nome=nome;
		this.conta=new ArrayList<ContaBancaria>();
		this.conta.add(	new	ContaBancaria(conta,deposito)	);
		
	}
	

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void getContas() {
		for (ContaBancaria cb:conta) {
			System.out.println(cb);
		}
	}
		
	public void statusCliente() {
		System.out.println(	"\nNOME----------"
							+ nome
							+"\nQTD CONTAS---"
							+ conta.size());
	conta.stream().forEach(System.out::println);
	
	}
	
	public void novaConta() {
		conta.add( new ContaBancaria(conta.size()));
	}
	
	public void depositarEmconta(double valor,int codConta) {
		
		conta.get(codConta).deposito(valor);
		
		//statusCliente();
		
	}
	public void sacarEmconta(double valor,int codConta) {
		
		conta.get(codConta).saque(valor);
		//statusCliente();
		
	}

	

	@Override
	public int compare(Clientes o1, Clientes o2) {
		// TODO Auto-generated method stub
		return o1.getNome().compareTo(o2.getNome());
	}
	public int compare(Clientes o1,String nome) {
		// TODO Auto-generated method stub
		return o1.getNome().compareTo(nome);
	}

}