package jogo;

import java.text.DecimalFormat;
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
	private String ultimaAcao;

	public Jogo(AtorJogador atorJogador) {	
		this.atorJogador = atorJogador;
	}
	
	public void zerarVilas(){
		this.jogador1.setVila(new Vila());
		this.jogador2.setVila(new Vila());
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
		Muralha muralhaLocal = this.getJogadorLocal().getVila().getMuralha();
		muralhaLocal.decrementarDelay();
		Estado estado = new Estado(jogador1.getVila(), jogador2.getVila(), jogadorDaVezRendeuSe, jogadorDaVezEhVencedor, ultimaAcao);
		return estado;
	}
	
	public Estado getEstadoNovaPartida(){
		Estado estado = new Estado(jogador1.getVila(), jogador2.getVila(), false, false, "Um novo jogo foi iniciado.");
		estado.setNovoJogo(true);
		return estado;
	}
	
	public boolean setEstado(Estado estado){
		jogador1.setVila(estado.getVila1());
		jogador2.setVila(estado.getVila2());
		
		Muralha muralhaLocal = this.getJogadorLocal().getVila().getMuralha();
		muralhaLocal.decrementarDelay();
		
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
			String tipoAtaque = this.getStringTipoAtaque(quantSoldados, dano);
			this.setUltimaAcao("$1 atacou $2 e causou "+dano+" de dano.\nO ataque foi "+tipoAtaque+".");
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
				this.setUltimaAcao("$1 construiu "+tropasPossiveis+" tropas.");
				return true;
			}
		}
		
		
		return false;
	}

	public boolean fortalecerMuralha() {
		int custa = 15;
		Vila vila = getJogadorLocal().getVila();
		int regenera = this.calcularFortalecerMuralhaPossivel(vila);
		Muralha muralha = vila.getMuralha();
		int delay = muralha.getDelayReconstrucao();
		if(delay == 0){
			if(regenera > 0){
				muralha.incrementarPontosDeVida(regenera);
				vila.decrementarMadeira(custa);
				this.setUltimaAcao("$1 fortaleceu sua muralha em "+regenera+" pontos.");
				return true;
			}
		}
		return false;
	}

	public boolean coletarRecursos() {
		Vila vila = getJogadorLocal().getVila();
		int quantMadeira = this.gerarDistribuicaoInteiro(1, 10);
		int quantComida = 10-quantMadeira;
		vila.incrementarMadeira(quantMadeira);
		if(quantComida > 0){
			vila.incrementarComida(quantComida);
		}
		
		this.setUltimaAcao("$1 gerou "+quantMadeira+" unidades de madeira e "+quantComida+" unidades de comida.");
		return true;
	}

	public void renderSe() {
		this.jogadorDaVezRendeuSe = true;
	}
	
	private int calcularDano(int quant){
		float mult = this.gerarDistribuicaoFloat(0.5f,1.5f);
		float calc = mult*quant;
		DecimalFormat df = new DecimalFormat("#");
		int ret = Integer.parseInt(df.format(calc));
		ret = 100;
		return ret;
	}
	
	private int calcularTropasPossiveis(int quant){
		int custo = 1;
		return quant/custo;
	}
	
	private void verificarVencedor(){
		Jogador jogadorRemoto = this.getJogadorRemoto();
		if(jogadorRemoto.getVila().getPontosDeVida() <= 0){
			this.atorJogador.avisarVencedor();
			this.jogadorDaVezEhVencedor = true;
		}
	}
	
	private int calcularFortalecerMuralhaPossivel(Vila vila){
		int custo = 15;
		int maximo = 100;
		int regenera = 25;
		int muralhaPontosDeVida = vila.getMuralha().getPontosDeVida();
		if(vila.getMadeira() >= custo){
			if(muralhaPontosDeVida == maximo){
				return 0;
			}
			
			if(muralhaPontosDeVida+regenera > maximo){
				return maximo - muralhaPontosDeVida;
			}
			
			return regenera;
		}

		return 0;
	}
	
	private int gerarDistribuicaoInteiro(int min, int max){
		return new Random().nextInt(max - min + 1) + min;
	}
	
	private float gerarDistribuicaoFloat(float min, float max){
		return new Random().nextFloat() * (max - min) + min;
	}
	
	public String getUltimaAcao() {
		return ultimaAcao;
	}

	public void setUltimaAcao(String ultimaAcao) {
		ultimaAcao = ultimaAcao.replace("$1", this.getJogadorLocal().getNome());
		ultimaAcao = ultimaAcao.replace("$2", this.getJogadorRemoto().getNome());
		this.ultimaAcao = "<html>"+ultimaAcao+"</html>";
	}
	
	public String getStringTipoAtaque(int quantSoldados, int dano){
		if(quantSoldados > dano){
			return "ineficiente";
		} else if(quantSoldados < dano){
			return "super-eficiente";
		}
		
		return "eficiente";
	}
}
