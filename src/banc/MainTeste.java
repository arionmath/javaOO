package banc;

import java.util.ArrayList;
import java.util.Scanner;

import aplicacao.Decisao;

public class MainTeste {

	public static void main(String[] args) {
		System.out.println("___BANCO___");
		Scanner sc = new Scanner(System.in);
		ArrayList<Clientes> listaClientes = new ArrayList<Clientes>();
		
		Clientes arion =  new Clientes("Arion","1") ;
		listaClientes.add(0, arion );
		Clientes arion2 =  new Clientes("Mathias", "2") ;
		listaClientes.add(1, arion2 );
		listaClientes.add( new Clientes("Farias","3",1500) );
		listaClientes.add( new Clientes("Martines", "4",3000) );
		
		

		//Tenho uma lista povoada Agora vou testar os m�todos do pacote decisao 
		
		System.out.println("Tamanho: "+listaClientes.size());
		/*/for(Clientes c : listaClientes)
		{
			c.statusCliente();
			c.sacarEmconta(40, 0);
			c.statusCliente();
			c.depositarEmconta(1000, 0);
			c.statusCliente();
		}*/
		
		
		System.out.println("_____________________________");
		Decisao.mostrarTudo(listaClientes);
		System.out.println("_____________________________");
		
		Decisao.adicionar(sc, listaClientes);
		
		System.out.println("_____________________________");
		
		Decisao.Deposito(sc, listaClientes);
		
		System.out.println("_____________________________");
		
		Decisao.sacar(sc, listaClientes);
		
		System.out.println("_____________________________");
		
		Decisao.mostrarTudo(listaClientes);
		
		sc.close();
	}
	

}
