package projeto_final_bloco_01;

import java.util.Scanner;
import util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		int opcao;

		while (true) {

			System.out.println(Cores.TEXT_RED + Cores.ANSI_WHITE_BACKGROUND);
			System.out.println("╔════════════════════════════════════════════════════╗");
			System.out.println("║                                                    ║");
			System.out.println("║              E-COMMERCE LOJA VINIL                 ║");
			System.out.println("║                                                    ║");
			System.out.println("╠════════════════════════════════════════════════════╣");
			System.out.println("║                                                    ║");
			System.out.println("║   1 ➜ Cadastrar Produto             				 ║");
			System.out.println("║   2 ➜ Listar Todos os Produtos             	     ║");
			System.out.println("║   3 ➜ Atualizar Dados do Produto           	     ║");
			System.out.println("║   4 ➜ Excluir Produto                          	 ║");
			System.out.println("║   0 ➜ Sair                                      	 ║");
			System.out.println("║                                                    ║");
			System.out.println("╚════════════════════════════════════════════════════╝");
			System.out.println();
			System.out.println("Digite a opção desejada: " + Cores.TEXT_RESET);

			opcao = leia.nextInt();

			if (opcao == 0) {
				System.out.println("\nLoja de vinil!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Cadastrar produto\n\n");

				break;
			case 2:
				System.out.println("Listar todos os produtos\n\n");

				break;
			case 3:
				System.out.println("Atualizar dados do produto\n\n");

				break;
			case 4:
				System.out.println("Excluir produto\n\n");

				break;
			default:
				System.out.println("\nOpção Inválida!\n");
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Generation Brasil - generation@generation.org");
		System.out.println("github.com/conteudoGeneration");
		System.out.println("*********************************************************");

	}

}
