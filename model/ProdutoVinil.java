package model;

public class ProdutoVinil extends Produto {

	private int rpm;

	public ProdutoVinil(int id, String titulo, int quantidade, int rpm) {
		super(id, titulo, quantidade);
		this.rpm = rpm;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("RPM: " + this.rpm);
	}

}
