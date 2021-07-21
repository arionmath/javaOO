package aplicacao;

import java.util.ArrayList;
import java.util.Scanner;
import banc.Clientes;

public abstract class Decisao {

	public static void sacar(Scanner sc, ArrayList<Clientes> listaClientes) {
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

	public static void Deposito(Scanner sc, ArrayList<Clientes> listaClientes) {
		int codigo;
		double quantia;
		String nomeCliente;
		System.out.println("Digite a quantia em reais");
		quantia = sc.nextDouble();
		System.out.println("Digite o codigo da conta");
		codigo = sc.nextInt();
		System.out.println("Digite o nome do cliente em quest�o (POSSIVEL BUG DO BUFFERED corrigido)");
		sc.nextLine();
		nomeCliente = sc.nextLine();
		puxarCliente(nomeCliente, listaClientes).depositarEmconta(quantia, codigo);

	}

	public static void novaConta(Scanner sc, ArrayList<Clientes> listaClientes) {
		System.out.println("Agora Digite o nome do titular da conta");
		sc.nextLine();
		String nome = sc.nextLine();

		puxarCliente(nome, listaClientes).novaConta();

	}

	public static void adicionar(Scanner sc, ArrayList<Clientes> listaClientes) {
		System.out.println("\n\n");
		System.out.println("O cliente deseja fazer algum deposito inicial? s/n");
		char decisao = sc.next().charAt(0);

		if (decisao == 's' || decisao == 'S') {
			String nome;
			String cod;
			double entrada;
			System.out.println("Digite o nome completo ");
			sc.nextLine();
			nome = sc.nextLine();
			System.out.println("Digite o cpf somente numeros + 0 no final");
			// A conta vai ser o CPF + um digito esse digito ser� o numero da conta
			cod = sc.next();
			System.out.println("Digite o valor de entrada");
			entrada = sc.nextDouble();

			Clientes a = new Clientes(nome, cod, entrada);

			listaClientes.add(a);

		} else {
			String nome;
			String cod;
			System.out.println("Digite o nome completo ");
			sc.nextLine();
			nome = sc.nextLine();
			System.out.println("Digite o cpf somente numeros");
			cod = sc.next();

			Clientes a = new Clientes(nome, cod);

			listaClientes.add(a);

		}

	}

	public static void mostrarTudo(ArrayList<Clientes> listaClientes) {
		for (Clientes c : listaClientes)
			c.statusCliente();
	}

	private static Clientes puxarCliente(String nome, ArrayList<Clientes> listaClientes){

		for (Clientes c : listaClientes) {
			if (c.getNome().equalsIgnoreCase(nome))
				return c;

		}
		System.out.println("------------USUARIO N�O ENCONTRADO--------------");
		return null;
		// Vou percorrer a lista at� achar o objetivo
		// Depois de achar, farei o m�todo
		// O que vai identificar o cliente ser� seu nome, nenhum c�digo
		// Se terminar o if e n�o tiver retornado nenhum Cliente (c) quer dizer que
		// nenhum cliente com aquele nome foi encontrado
	}

}
