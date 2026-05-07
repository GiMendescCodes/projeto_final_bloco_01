package model;

public class ProdutoCd extends Produto {

	private int numeroFaixas;

	public ProdutoCd(int id, String titulo, int quantidade, int numeroFaixas) {
		super(id, titulo, quantidade);
		this.numeroFaixas = numeroFaixas;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Número de faixas: " + this.numeroFaixas);
	}
}