package jogo;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Muralha implements Jogada {
	protected int pontosDeVida;
	protected int delayReconstrucao;

	public int getPontosDeVida() {
		return pontosDeVida;
	}

	public void decrementarPontosDeVida(int pontosDeVida) {
		this.pontosDeVida -= pontosDeVida;
	}
	
	public void incrementarPontosDeVida(int pontosDeVida) {
		this.pontosDeVida += pontosDeVida;
	}

	public int getDelayReconstrucao() {
		return delayReconstrucao;
	}

	public void setDelayReconstrucao(int delayReconstrucao) {
		this.delayReconstrucao = delayReconstrucao;
	}

}
