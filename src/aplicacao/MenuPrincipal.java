package aplicacao;

import java.util.ArrayList;
import java.util.Scanner;

import banc.Clientes;

public class MenuPrincipal {
//Vou precisar criar uma lista de clientes e adiciona-los
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Clientes> listaClientes = new ArrayList<Clientes>();
		
		Clientes arion =  new Clientes("Arion", "123") ;
		listaClientes.add(0, arion );
		Clientes arion2 =  new Clientes("Mathias", "321") ;
		listaClientes.add(1, arion2 );
		listaClientes.add( new Clientes("Farias","635",1500) );
		listaClientes.add( new Clientes("Martines", "875",3000) );
		
		int i = 1;
		
		while(i == 1) {
			
			
		try {menu(listaClientes,sc);
			
		} catch (Exception e) {
			System.out.println("Tipo errado! tente novamente");
			sc.next();
		}
		
		
		
		}
		sc.close();
	}
	
	
	public static void menu(ArrayList<Clientes> listaClientes,Scanner sc) {
		
		System.out.println("\n\n--------MENU PRINCIPAL-------------");
		System.out.println(    "--------DIGITE---------------------"
				+ "\n---1 para novos clientes        ---"
				+ "\n---2 para deposito              ---"
				+ "\n---3 para criar nova conta      ---"
				+ "\n---4 para sacar                 ---"
				+ "\n---5 mostrar todos os dados     ---"
				+ "\n-----------------------------------");
		
		int escolha = sc.nextInt();
		
		
		switch (escolha) {
		case 1: 
			
			Decisao.adicionar(sc, listaClientes);			
			
			System.out.println("Opera��o concluida, cliente foi cadastrado\n");
			
		
			break;

			
			
		case 2:
			try {
				Decisao.Deposito(sc,listaClientes);
				System.out.println("Opera��o concluida");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
					
			break;
			
		case 3:
			//PRECISO ACHAR UM CLIENTE E ENTAO CRIAR UMA NOVA CONTA BANC�RIA PARA ELE
			
			/*TEM ERRO Exception in thread "main" java.lang.NullPointerException
			at aplicacao.Decisao.novaConta(Decisao.java:25)
			at aplicacao.MenuPrincipal.main(MenuPrincipal.java:31)
			at aplicacao.MenuPrincipal.main(MenuPrincipal.java:23)
			at aplicacao.MenuPrincipal.main(MenuPrincipal.java:23)*/
			try {
				Decisao.novaConta(sc, listaClientes);
				System.out.println("Opera��o concluida");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			break;
		case 4:
			
			
			try{ 
				Decisao.sacar(sc,listaClientes);
				System.out.println("Opera��o concluida");
				}
			catch(Throwable e) {e.printStackTrace();for(int i=0;i<1000000000;i++) i++;}
				
			
			break;
			
			
		case 5:
			Decisao.mostrarTudo(listaClientes);
			System.out.println("Opera��o concluida");
			break;
			
		default:
			System.out.println("Algo deu errado, tente novamente");
			break;
		}
		
	}

}
