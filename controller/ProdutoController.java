package controller;

import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class ProdutoController implements repository.ProdutoRepository{
	
	private List<Produto> ListaProdutos = new ArrayList<Produto>();
	int id = 0;

	@Override
	public void listarTodas() {
		if (ListaProdutos.isEmpty()) {
			System.out.println("\nNenhum produto cadastrado.");
			return;
		}

		for (var produto : ListaProdutos) {
			produto.visualizar();
		}
	}
	@Override
	public void cadastrar(Produto produto) {
		ListaProdutos.add(produto);
		System.out.printf("O produto %d foi criada com sucesso!%n", produto.getId());
		
	}

	@Override
	public void atualizar(Produto produto) {
		var buscaProduto = buscarNaCollection(produto.getId());

		if (buscaProduto != null) {
			ListaProdutos.set(ListaProdutos.indexOf(buscaProduto), produto);
			System.out.printf("O produto de ID %d foi atualizada com sucesso!%n", produto.getId());
		} else {
			System.out.printf("O produto de ID %d não foi encontrada!%n", produto.getId());
		}
		
	}
	
	@Override
	public void procurarPorId(int id) {
		var produto = buscarNaCollection(id);

		if (produto != null) {
			produto.visualizar();
		} else {
			System.out.printf("O produto de id: %d não foi encontrada!%n", produto);
		}

	}

	@Override
	public void deletar(int id) {
		var produto = buscarNaCollection(id);

		if (produto != null) {
			if (ListaProdutos.remove(produto) == true) {
				System.out.printf("O produto de ID: %d foi deletada com sucesso!%n", id);
			}
		} else {
			System.out.printf("O produto de ID: %d não foi encontrada!%n", id);
		}
		
	}
	
	public int gerarId() {
		return ++id;
	}

	public Produto buscarNaCollection(int id) {
		for (var produto : ListaProdutos) {
			if (produto.getId() == id) {
				return produto;
			}
		}

		return null;
	}
	
}
