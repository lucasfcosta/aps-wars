package rede;

import gui.InterfaceGrafica;
import jogo.Jogo;

public class AtorJogador {
	private Jogo jogo;
	private String nome;

	private AtorNetGames atorRede;
	private InterfaceGrafica interfaceGrafica;

	public AtorJogador() {
		this.interfaceGrafica = new InterfaceGrafica(this);
		this.getInterfaceGrafica().desabilitarBotoesJogada();
		this.showNameQuestion();
		atorRede = new AtorNetGames(this);
	}
	
	private void showNameQuestion(){
		this.nome = this.getInterfaceGrafica().showNameQuestion();
		if(this.nome.isEmpty()){
			this.nome = "Jogador Sem Nome";
		}
	}

	public InterfaceGrafica getInterfaceGrafica() {
		return interfaceGrafica;
	}

	public void conectar() {
		atorRede.conectar(nome, "localhost");
	}

	public void iniciarPartida() {
		interfaceGrafica.desabilitarIniciarPartida();
		atorRede.iniciarPartidaRede();
	}

	public void iniciarPartidaRede(boolean comecoFalando) {
		String nomeOutroJogador = atorRede.obterNomeAdversario();
		jogo = new Jogo();

		if (comecoFalando) {
			jogo.criarJogador(this.nome, true);
			jogo.criarJogador(nomeOutroJogador, false);
			this.getInterfaceGrafica().showDialog(
					"Jogo iniciado!\nVocê começa jogando.");
			this.getInterfaceGrafica().atualizarNomeJogador1(this.nome, true);
			this.getInterfaceGrafica().atualizarNomeJogador2(nomeOutroJogador, false);
			interfaceGrafica.habilitarBotoesJogada();
		} else {
			jogo.criarJogador(nomeOutroJogador, false);
			jogo.criarJogador(this.nome, true);
			interfaceGrafica.showDialog(
					"Jogo iniciado!\nAguarde a jogada de seu adversário.");
			this.getInterfaceGrafica().atualizarNomeJogador1(nomeOutroJogador, false);
			this.getInterfaceGrafica().atualizarNomeJogador2(this.nome, true);
		}

	}

	public void receberEstado(Estado estado) {
		if (!jogo.setEstado(estado)) {
			interfaceGrafica.showDialog("O jogo acabou!");
		}
		interfaceGrafica.habilitarBotoesJogada();
		interfaceGrafica.atualizarInterface(estado);
	}

	public void enviarEstado() {
		interfaceGrafica.desabilitarBotoesJogada();
		atorRede.enviarEstado(jogo.getEstado());
	}

	public void atacar() {
		if (atorRede.ehMinhaVez()) {
			if (jogo.atacar()) {
				this.enviarEstado();
				interfaceGrafica.atualizarInterface(jogo.getEstado());
			} else {
				interfaceGrafica.showDialog("Não é possivel atacar.");
			}
		} else {
			interfaceGrafica.showDialog("Não é sua vez.");
		}
	}

	public void construirTropas() {
		if (atorRede.ehMinhaVez()) {
			if (jogo.construirTropas()) {
				this.enviarEstado();
				interfaceGrafica.atualizarInterface(jogo.getEstado());
			} else {
				interfaceGrafica.showDialog("Não é possivel construir tropas.");
			}
		} else {
			interfaceGrafica.showDialog("Não é sua vez.");
		}
	}

	public void fortalecerMuralha() {		
		if (atorRede.ehMinhaVez()) {
			if (jogo.fortalecerMuralha()) {
				this.enviarEstado();
				interfaceGrafica.atualizarInterface(jogo.getEstado());
			} else {
				interfaceGrafica.showDialog("Não é possivel fortalecer a muralha.");
			}
		} else {
			interfaceGrafica.showDialog("Não é sua vez.");
		}
	}

	public void gerarRecursos() {
		if (atorRede.ehMinhaVez()) {
			jogo.gerarRecursos();
			this.enviarEstado();
			interfaceGrafica.atualizarInterface(jogo.getEstado());
		} else {
			interfaceGrafica.showDialog("Não é sua vez.");
		}
	}

	public void renderSe() {
		if (atorRede.ehMinhaVez()) {
			jogo.renderSe();
			this.enviarEstado();
			interfaceGrafica.atualizarInterface(jogo.getEstado());
		} else {
			interfaceGrafica.showDialog("Não é sua vez.");
		}
	}
}