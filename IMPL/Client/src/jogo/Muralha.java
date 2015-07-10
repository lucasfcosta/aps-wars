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
		if(this.pontosDeVida <= 0){
			this.pontosDeVida = 0;
			this.delayReconstrucao = 4;
		}
	}
	
	public void incrementarPontosDeVida(int pontosDeVida) {
		this.pontosDeVida += pontosDeVida;
	}

	public int getDelayReconstrucao() {
		return delayReconstrucao;
	}

	public void decrementarDelay() {
		if(this.delayReconstrucao > 0){
			this.delayReconstrucao -= 1;
		}
	}

}
