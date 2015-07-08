package jogo;

import java.util.Random;

import org.apache.log4j.chainsaw.Main;

import rede.AtorJogador;
import rede.AtorNetGames;
import rede.Estado;


public class Jogo {

	private Jogador jogador1;
	private Jogador jogador2;
	private AtorJogador atorJogador;
	private boolean jogadorDaVezRendeuSe;
	private boolean jogadorDaVezEhVencedor;

	public Jogo(AtorJogador atorJogador) {	
		this.atorJogador = atorJogador;
	}
	
	public Jogador getJogador1() {
		return jogador1;
	}

	public void setJogador1(Jogador jogador1) {
		this.jogador1 = jogador1;
	}

	public Jogador getJogador2() {
		return jogador2;
	}

	public void setJogador2(Jogador jogador2) {
		this.jogador2 = jogador2;
	}

	public void criarJogador(String nome, boolean jogadorLocal) {
		if (jogador1 == null) {
			jogador1 = new Jogador(nome, jogadorLocal);
		} else if (jogador2 == null) {
			jogador2 = new Jogador(nome, jogadorLocal);
		}
	}
	
	public Jogador getJogadorLocal(){
		return jogador1.isJogadorLocal() ? jogador1 : jogador2;
	}
	
	public Jogador getJogadorRemoto(){
		return jogador1.isJogadorLocal() ? jogador2 : jogador1;
	}
	
	public Estado getEstado(){
		Estado estado = new Estado(jogador1.getVila(), jogador2.getVila(), jogadorDaVezRendeuSe, jogadorDaVezEhVencedor);
		return estado;
	}
	
	public boolean setEstado(Estado estado){
		jogador1.setVila(estado.getVila1());
		jogador2.setVila(estado.getVila2());
		
		if(estado.isVencedor()){
			atorJogador.avisarPerdedor();
			return false;
		}
		
		if(estado.isRendeuSe()){
			atorJogador.avisarRendeuSe();
			return false;
		}

		return true;
	}
	
	public boolean atacar(){
		Vila vilaLocal = getJogadorLocal().getVila();
		int quantSoldados = vilaLocal.getSoldados();
		if(quantSoldados > 0){
			int dano = this.calcularDano(quantSoldados);
			Vila vilaAdversaria = getJogadorRemoto().getVila();
			
			Muralha muralha = vilaAdversaria.getMuralha();
			int vidaMuralha = muralha.getPontosDeVida();
			
			if(vidaMuralha > 0){
				if(vidaMuralha >= dano){
					muralha.decrementarPontosDeVida(dano);
				} else {
					vilaAdversaria.decrementarPontosDeVida(dano - vidaMuralha);
					muralha.decrementarPontosDeVida(vidaMuralha);
				}
			} else {
				vilaAdversaria.decrementarPontosDeVida(dano);
			}
			vilaLocal.decrementarSoldados(quantSoldados);
			this.verificarVencedor();
			return true;
		}
		
		return false;
	}

	public boolean construirTropas() {
		Vila vilaLocal = getJogadorLocal().getVila();
		int comidaDisponivel = vilaLocal.getComida();
		if(comidaDisponivel > 0){
			int tropasPossiveis = this.calcularTropasPossiveis(comidaDisponivel);
			if(tropasPossiveis > 0){
				vilaLocal.incrementarSoldados(tropasPossiveis);
				vilaLocal.decrementarComida(comidaDisponivel);
				return true;
			}
		}
		
		return false;
	}

	public boolean fortalecerMuralha() {
		int regenera = 2;
		int custa = 6;
		Vila vila = getJogadorLocal().getVila();
		Muralha muralha = vila.getMuralha();
		int delay = muralha.getDelayReconstrucao();
		if(delay == 0){
			if(this.calcularFortalecerMuralhaPossivel(vila.getMadeira())){
				muralha.incrementarPontosDeVida(regenera);
				vila.decrementarMadeira(custa);
				return true;
			}
		}
		return false;
	}

	public boolean gerarRecursos() {
		Vila vila = getJogadorLocal().getVila();
		int quantMadeira = this.gerarDistribuicao(1, 10);
		int quantComida = 10-quantMadeira;
		vila.incrementarMadeira(quantMadeira);
		if(quantComida > 0){
			vila.incrementarComida(quantComida);
		}
		
		return true;
	}

	public void renderSe() {
		this.jogadorDaVezRendeuSe = true;
	}
	
	private int calcularDano(int quant){
		int mult = this.gerarDistribuicao(1,2);
		return quant*mult;
	}
	
	private int calcularTropasPossiveis(int quant){
		int custo = 1;
		return quant/custo;
	}
	
	private void verificarVencedor(){
		Jogador jogador1 = this.getJogador1();
		if(jogador1.getVila().getPontosDeVida() <= 0){
			this.atorJogador.avisarVencedor();
			this.jogadorDaVezEhVencedor = true;
		}
	}
	
	private boolean calcularFortalecerMuralhaPossivel(int quant){
		int custo = 1;
		return quant >= custo;
	}
	
	private int gerarDistribuicao(int min, int max){
		return new Random().nextInt(max - min + 1) + min;
		
	}
}
