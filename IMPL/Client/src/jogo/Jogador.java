package jogo;

public class Jogador {
	private Vila vila;
	private String nome;
	private boolean jogadorLocal;
	private boolean vencedor;
	
	public boolean isVencedor() {
		return vencedor;
	}

	public void setVencedor(boolean vencedor) {
		this.vencedor = vencedor;
	}

	public boolean isJogadorLocal() {
		return jogadorLocal;
	}

	public Jogador(String nome, boolean jogadorLocal) {
		vila = new Vila();
		this.nome = nome;
		this.jogadorLocal = jogadorLocal;
	}
	
	public Vila getVila() {
		return vila;
	}

	public void setVila(Vila vila) {
		this.vila = vila;
	}

	public String getNome() {
		return nome;
	}
}
