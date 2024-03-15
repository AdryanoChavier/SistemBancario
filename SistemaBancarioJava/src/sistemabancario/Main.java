package sistemabancario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {static GerenciadoraClientes gerClientes;
static GerenciadoraContas gerContas;

public static void main(String[] args) {

	inicializaSistemaBancario(); //criar algumas contas e clientes fictícios

	Scanner sc = new Scanner(System.in);
	boolean continua = true;

	while(continua) {

		printMenu();

		int opcao = sc.nextInt();

		switch(opcao) {
		//Consultar por um cliente
		case 1:
			System.out.println("Digite o ID do cliente: ");
			int idCliente = sc.nextInt();
			Cliente cliente = gerClientes.pesquisaCliente(idCliente);

			if(cliente != null)
				System.out.println(cliente.toString());
			else
				System.out.println("Cliente não encontrado");
			pulalinha();
			break;

		//Consultar por uma conta corrente
		case 2:
			System.out.println("Digite o OD da conta: ");
			int idConta = sc.nextInt();
			ContaCorrente conta = gerContas.pesquisaConta(idConta);

			if(conta != null)
				System.out.println(conta.toString());
			else
				System.out.println("Conta não encontrado");
			pulalinha();
			break;

		//Ativar um cliente
		case 3:
			System.out.println("Digite o ID do cliente: ");
			int idCliente2 = sc.nextInt();
			Cliente cliente2 = gerClientes.pesquisaCliente(idCliente2);

			if(cliente2 != null) {
				cliente2.setAtivo(true);
				System.out.println("Cliente ativado com sucesso!");
			} else {
				System.out.println("Cliente não encontrado");
			}
			pulalinha();
			break;

		//Desativar um cliente
		case 4:
			System.out.println("Digite o ID do cliente: ");
			int idCliente3 = sc.nextInt();
			Cliente cliente3 = gerClientes.pesquisaCliente(idCliente3);

			if(cliente3 != null) {
				cliente3.setAtivo(false);
				System.out.println("Cliente desativado com sucesso!");
			} else {
				System.out.println("Cliente não encontrado");
			}
			pulalinha();
			break;

		//Sair
		case 5:
			continua = false;
			System.out.println("############ Sistema encerado, até logo ############");
			pulalinha();
			break;
		}
	}
}

private static void pulalinha() {
	System.out.println("\\n");

}

private static void printMenu() {
	System.out.println("Escolha o que você deseja fazer? \\n");
	System.out.println("1) Consultar um cliente");
	System.out.println("2) Consultar uma conta corrente");
	System.out.println("3) Ativar um clinete");
	System.out.println("4) Desativar um clinete");
	System.out.println("5) Sair");
	System.out.println();
}

private static void inicializaSistemaBancario() {
	//criando lista vazia de contas e clientes
	List<ContaCorrente> contasDoBanco = new ArrayList<>();
	List<Cliente> clientesDoBanco = new ArrayList<>();

	//criando e inserindo duas contas na lista de contas correntes do bacno
	ContaCorrente conta01 = new ContaCorrente(1, 0, true);
	ContaCorrente conta02 = new ContaCorrente(2, 0, true);
	contasDoBanco.add(conta01);
	contasDoBanco.add(conta02);

	//criando dois clientes e associando as contas criadas acima a eles
	Cliente cliente01 = new Cliente(1, "Joao da Silva", 20, "joaodasilva@gmail.com", conta01.getId(), true);
	Cliente cliente02 = new Cliente(2, "Maria da Silva", 26, "mariadasilva@gmail.com", conta02.getId(), true);

	//inserindo os clientes criados na lista de clientes do banco
	clientesDoBanco.add(cliente01);
	clientesDoBanco.add(cliente02);

	gerClientes = new GerenciadoraClientes(clientesDoBanco);
	gerContas = new GerenciadoraContas(contasDoBanco);
}

}