package aplicacao;

import java.util.ArrayList;
import java.util.Scanner;
import banc.Clientes;

public abstract class Decisao {
	
	
	public static void sacar(Scanner sc, ArrayList<Clientes> listaClientes) throws Exception {
		String nome = null;
		int codigo;
		double quantia;
		
		System.out.println("Agora Digite o nome do titular da conta");
		sc.nextLine();
		nome = sc.nextLine();
		System.out.println("Digite o codigo da conta a ser sacada");
		codigo = sc.nextInt();
		System.out.println("Digite a quantia em reais para ser sacado");
		quantia = sc.nextDouble();
		
		puxarCliente(nome, listaClientes).sacarEmconta(quantia, codigo);
		
		
	}
	
	
		public static void Deposito(Scanner sc, ArrayList<Clientes> listaClientes) throws Exception {
		int codigo;
		double quantia;
		String nomeCliente;
		System.out.println("Digite a quantia em reais");
		quantia = sc.nextDouble();
		System.out.println("Digite o codigo da conta");
		codigo = sc.nextInt();
		System.out.println("Digite o nome do cliente em questão (POSSIVEL BUG DO BUFFERED corrigido)");
		sc.nextLine();
		nomeCliente = sc.nextLine();		

		puxarCliente(nomeCliente,listaClientes).depositarEmconta(quantia, codigo);
			}
	
	
	public static void novaConta(Scanner sc, ArrayList<Clientes> listaClientes) throws Exception {
		System.out.println("Agora Digite o nome do titular da conta");
		sc.nextLine();
		String nome = sc.nextLine();
		puxarCliente(nome, listaClientes).novaConta();
		
	}
	
	

			
	public static void adicionar(Scanner sc,ArrayList<Clientes> listaClientes) {
		System.out.println("\n\n");
		System.out.println("O cliente deseja fazer algum deposito inicial? s/n");
		char decisao = sc.next().charAt(0);
		
			if (decisao=='s'||decisao=='S') {
				String nome;
				int cod;
				double entrada;
				System.out.println("Digite o nome completo ");
				sc.nextLine();
				nome = sc.nextLine();
				System.out.println("Digite o cpf somente numeros + 0 no final");
				//A conta vai ser o CPF + um digito esse digito será o numero da conta
				cod = sc.nextInt();
				System.out.println("Digite o valor de entrada");
				entrada = sc.nextDouble();
				
				Clientes a = new Clientes(nome, cod, entrada);
				
				listaClientes.add(a);
				
			}else {
				String nome;
				int cod;
				System.out.println("Digite o nome completo ");
				sc.nextLine();
				nome = sc.nextLine();
				System.out.println("Digite o cpf somente numeros + 0 no final");
				cod = sc.nextInt();
				
				Clientes a = new Clientes(nome, cod);
				
				listaClientes.add(a);
				
			}
			
			
			
			
	}
	
	public static void mostrarTudo(ArrayList<Clientes> listaClientes) {
		for(Clientes c : listaClientes) c.statusCliente();
	}
	
	
	private static Clientes puxarCliente(String nome,ArrayList<Clientes> listaClientes) throws Exception {
		
		for (Clientes c : listaClientes) {
			if (c.getNome().equalsIgnoreCase(nome)) 	return c;
			
			}throw new Exception("------------USUARIO NÃO ENCONTRADO--------------");
		
		//Vou percorrer a lista até achar o objetivo
		//Depois de achar, farei o método
		// O que vai identificar o cliente será seu nome, nenhum código
		//Se terminar o if e não tiver retornado nenhum Cliente (c) quer dizer que nenhum cliente com aquele nome foi encontrado
	}

}
