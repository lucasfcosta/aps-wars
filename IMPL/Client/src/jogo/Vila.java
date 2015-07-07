package jogo;

import java.io.Serializable;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Vila implements Jogada {
	protected int comida;
	protected int madeira;
	protected Muralha muralha;
	protected int pontosDeVida;
	protected int soldados;

	public Vila() {
		this.comida = 0;
		this.madeira = 0;
		this.muralha = new Muralha();
		this.pontosDeVida = 100;
	}
	
	public int getSoldados() {
		return soldados;
	}

	public void decrementarSoldados(int soldados) {
		this.soldados -= soldados;
	}
	
	public void incrementarSoldados(int soldados) {
		this.soldados += soldados;
	}
	
	public int getComida() {
		return comida;
	}

	public void decrementarComida(int comida) {
		this.comida -= comida;
	}
	
	public void incrementarComida(int comida) {
		this.comida += comida;
	}

	public int getMadeira() {
		return madeira;
	}

	public void decrementarMadeira(int madeira) {
		this.madeira -= madeira;
	}
	
	public void incrementarMadeira(int madeira) {
		this.madeira += madeira;
	}

	public Muralha getMuralha() {
		return muralha;
	}

	public void setMuralha(Muralha muralha) {
		this.muralha = muralha;
	}

	public int getPontosDeVida() {
		return pontosDeVida;
	}

	public void decrementarPontosDeVida(int pontosDeVida) {
		this.pontosDeVida -= pontosDeVida;
	}
}
