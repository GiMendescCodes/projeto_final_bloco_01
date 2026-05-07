package model;

public abstract class Produto {

	private int id;
	private String titulo;
	private int quantidade;

	public Produto(int id, String titulo, int quantidade) {
		this.id = id;
		this.titulo = titulo;
		this.quantidade = quantidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void visualizar() {
		System.out.println("\n***********************************************************");
		System.out.println("Dados do produto:");
		System.out.println("***********************************************************");
		System.out.println("Id do produto: " + this.id);
		System.out.println("Quantidade: " + this.quantidade);
		System.out.println("Titulo do vinil/cd: " + this.titulo);
	}

	public void visualizar(String mensagem) {
		System.out.println(mensagem);
		visualizar();
	}
}