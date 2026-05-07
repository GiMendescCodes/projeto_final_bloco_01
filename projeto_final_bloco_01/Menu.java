package projeto_final_bloco_01;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.ProdutoController;
import model.ProdutoCd;
import model.ProdutoVinil;
import util.Cores;
import model.Produto;

public class Menu {

	private static Scanner leia = new Scanner(System.in);
	private static ProdutoController produtoController = new ProdutoController();

	public static void main(String[] args) {

		int opcao;

		while (true) {

			System.out.println(Cores.TEXT_RED + Cores.ANSI_WHITE_BACKGROUND);
			System.out.println("╔════════════════════════════════════════════════════╗");
			System.out.println("║             E-COMMERCE LOJA VINIL/CD               ║");
			System.out.println("╠════════════════════════════════════════════════════╣");
			System.out.println("║   1 ➜ Cadastrar Produto                            ║");
			System.out.println("║   2 ➜ Listar Todos os Produtos                     ║");
			System.out.println("║   3 ➜ Atualizar Produto                            ║");
			System.out.println("║   4 ➜ Excluir Produto                              ║");
			System.out.println("║   0 ➜ Sair                                         ║");
			System.out.println("╚════════════════════════════════════════════════════╝");

			try {
				opcao = leia.nextInt();
				leia.nextLine();
			} catch (InputMismatchException e) {
				opcao = -1;
				System.out.println("Digite um número inteiro!");
				leia.nextLine();
			}

			if (opcao == 0) {
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				cadastrarProduto();
				break;

			case 2:
				listarProdutos();
				break;

			case 3:
				atualizarProduto();
				break;

			case 4:
				deletarProduto();
				break;

			default:
				System.out.println("Opção inválida!");
			}
		}
	}

	private static void listarProdutos() {
		produtoController.listarTodas();
	}

	private static void cadastrarProduto() {
		try {
			System.out.print("ID: ");
			int id = leia.nextInt();
			leia.nextLine();

			System.out.print("Título: ");
			String titulo = leia.nextLine();

			System.out.print("Quantidade: ");
			int quantidade = leia.nextInt();

			System.out.print("Tipo (1-CD / 2-Vinil): ");
			int tipo = leia.nextInt();

			switch (tipo) {
			case 1 -> {
				System.out.print("Número de faixas: ");
				int numeroFaixas = leia.nextInt();

				produtoController.cadastrar(new ProdutoCd(id, titulo, quantidade, numeroFaixas));
			}

			case 2 -> {
				System.out.print("RPM: ");
				int rpm = leia.nextInt();

				produtoController.cadastrar(new ProdutoVinil(id, titulo, quantidade, rpm));
			}

			default -> System.out.println("Tipo inválido!");
			}

		} catch (InputMismatchException e) {
			System.out.println("\nErro: digite apenas números onde solicitado.");
			leia.nextLine();
		}
	}

	private static void atualizarProduto() {
		try {
			System.out.print("Digite o ID do produto: ");
			int id = leia.nextInt();
			leia.nextLine();

			Produto produto = produtoController.buscarNaCollection(id);

			if (produto != null) {

				String titulo = produto.getTitulo();
				int quantidade = produto.getQuantidade();

				System.out.printf("Título atual: %s\nNovo título (ENTER para manter): ", titulo);
				String entrada = leia.nextLine();
				titulo = entrada.isEmpty() ? titulo : entrada;

				System.out.printf("Quantidade atual: %d\nNova quantidade (ENTER para manter): ", quantidade);
				entrada = leia.nextLine();

				try {
					quantidade = entrada.isEmpty() ? quantidade : Integer.parseInt(entrada);
				} catch (NumberFormatException e) {
					System.out.println("Quantidade inválida! Mantendo valor atual.");
				}

				if (produto instanceof ProdutoCd) {
					int numeroFaixas = ((ProdutoCd) produto).getNumeroFaixas();

					System.out.printf("Número de faixas atual: %d\nNovo valor: ", numeroFaixas);
					entrada = leia.nextLine();

					try {
						numeroFaixas = entrada.isEmpty() ? numeroFaixas : Integer.parseInt(entrada);
					} catch (NumberFormatException e) {
						System.out.println("Valor inválido! Mantendo valor atual.");
					}

					produtoController.atualizar(new ProdutoCd(id, titulo, quantidade, numeroFaixas));

				} else if (produto instanceof ProdutoVinil) {
					int rpm = ((ProdutoVinil) produto).getRpm();

					System.out.printf("RPM atual: %d\nNovo RPM: ", rpm);
					entrada = leia.nextLine();

					try {
						rpm = entrada.isEmpty() ? rpm : Integer.parseInt(entrada);
					} catch (NumberFormatException e) {
						System.out.println("RPM inválido! Mantendo valor atual.");
					}

					produtoController.atualizar(new ProdutoVinil(id, titulo, quantidade, rpm));
				}

			} else {
				System.out.printf("\nProduto de ID %d não encontrado!\n", id);
			}

		} catch (InputMismatchException e) {
			System.out.println("\nErro: entrada inválida.");
			leia.nextLine();
		}
	}

	private static void deletarProduto() {

		System.out.println("Digite o id do produto: ");
		int id = leia.nextInt();
		leia.nextLine();

		System.out.println("\nTem certeza que deseja excluir esse produto (S/N): ");
		String confirmacao = leia.nextLine();

		if (confirmacao.equalsIgnoreCase("s")) {
			produtoController.deletar(id);
		} else {
			System.out.println("\nOperação cancelada.");
		}
	}

	public static void sobre() {
		System.out.println("Projeto Loja de Vinil/CD");
	}
}