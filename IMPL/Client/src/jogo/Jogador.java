package jogo;

public class Jogador {
	
	private String nome;
	
	private boolean vez;

	public String getNome() {
		return nome;
	}

	public Jogador(String nome) {
		super();
		this.nome = nome;
		vez = false;
	}
	
	public void tomarVez(){
		vez = true;
	}
	
	public void passarVez(){
		vez = false;
	}
	
	public boolean ehVez(){
		return vez;
	}

}
