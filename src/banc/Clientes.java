package banc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clientes implements Comparator<Clientes>{
	
	private String nome;
	private String cpf;
	private List<ContaBancaria> conta;
	
	
	public Clientes(String nome,String cpf){
		this.setCpf(cpf);
		this.nome=nome;
		this.conta=new ArrayList<ContaBancaria>();
		this.conta.add(	new	ContaBancaria(1)	);
	}
	
	public Clientes(String nome,String cpf, double deposito){
		this.setCpf(cpf);
		this.nome=nome;
		this.conta=new ArrayList<ContaBancaria>();
		this.conta.add(	new	ContaBancaria(1,deposito)	);
		
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
							+ "\nCPF---------"
							+ cpf
							+"\nQTD CONTAS---"
							+ conta.size());
	conta.stream().forEach(System.out::println);
	
	}
	
	public void novaConta() {
		conta.add( new ContaBancaria(conta.size()+1));
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}