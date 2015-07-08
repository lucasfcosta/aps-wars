package rede;

import gui.InterfaceGrafica;
import jogo.Jogo;

public class AtorJogador {
	private Jogo jogo;
	private String nome;

	private AtorNetGames atorNetGames;
	private InterfaceGrafica interfaceGrafica;

	public AtorJogador() {
		this.interfaceGrafica = new InterfaceGrafica(this);
		this.getInterfaceGrafica().desabilitarBotoesJogada();
		this.showNameQuestion();
		atorNetGames = new AtorNetGames(this);
	}

	private void showNameQuestion() {
		this.nome = this.getInterfaceGrafica().showNameQuestion();
		if (this.nome.isEmpty()) {
			this.nome = "An�nimo";
		}
	}

	public InterfaceGrafica getInterfaceGrafica() {
		return interfaceGrafica;
	}

	public void conectar() {
		atorNetGames.conectar(nome, "localhost");
	}

	public void iniciarPartida() {
		atorNetGames.iniciarPartidaRede();
	}

	public void iniciarPartidaRede(boolean comecoFalando) {
		interfaceGrafica.desabilitarIniciarPartida();
		String nomeOutroJogador = atorNetGames.obterNomeAdversario();
		jogo = new Jogo(this);

		if (comecoFalando) {
			jogo.criarJogador(this.nome, true);
			jogo.criarJogador(nomeOutroJogador, false);
			this.getInterfaceGrafica().showDialog(
					"Jogo iniciado!\nVoc� come�a jogando.");
			this.getInterfaceGrafica().atualizarNomeJogador1(this.nome, true);
			this.getInterfaceGrafica().atualizarNomeJogador2(nomeOutroJogador,
					false);
			interfaceGrafica.habilitarBotoesJogada();
		} else {
			jogo.criarJogador(nomeOutroJogador, false);
			jogo.criarJogador(this.nome, true);
			interfaceGrafica
					.showDialog("Jogo iniciado!\nAguarde a jogada de seu advers�rio.");
			this.getInterfaceGrafica().atualizarNomeJogador1(nomeOutroJogador,
					false);
			this.getInterfaceGrafica().atualizarNomeJogador2(this.nome, true);
		}

	}

	public void receberEstado(Estado estado) {
		interfaceGrafica.atualizarInterface(estado);
		if (!jogo.setEstado(estado)) {
			interfaceGrafica.desabilitarBotoesJogada();
		} else {
			interfaceGrafica.habilitarBotoesJogada();
		}
	}

	public void enviarEstado() {
		interfaceGrafica.desabilitarBotoesJogada();
		atorNetGames.enviarEstado(jogo.getEstado());
	}

	public void atacar() {
		if (atorNetGames.ehMinhaVez()) {
			if (jogo.atacar()) {
				this.enviarEstado();
				interfaceGrafica.atualizarInterface(jogo.getEstado());
			} else {
				interfaceGrafica.showDialog("N�o � possivel atacar.");
			}
		} else {
			interfaceGrafica.showDialog("N�o � sua vez.");
		}
	}

	public void construirTropas() {
		if (atorNetGames.ehMinhaVez()) {
			if (jogo.construirTropas()) {
				this.enviarEstado();
				interfaceGrafica.atualizarInterface(jogo.getEstado());
			} else {
				interfaceGrafica.showDialog("N�o � possivel construir tropas.");
			}
		} else {
			interfaceGrafica.showDialog("N�o � sua vez.");
		}
	}

	public void fortalecerMuralha() {
		if (atorNetGames.ehMinhaVez()) {
			if (jogo.fortalecerMuralha()) {
				this.enviarEstado();
				interfaceGrafica.atualizarInterface(jogo.getEstado());
			} else {
				interfaceGrafica
						.showDialog("N�o � possivel fortalecer a muralha.");
			}
		} else {
			interfaceGrafica.showDialog("N�o � sua vez.");
		}
	}

	public void gerarRecursos() {
		if (atorNetGames.ehMinhaVez()) {
			jogo.gerarRecursos();
			this.enviarEstado();
			interfaceGrafica.atualizarInterface(jogo.getEstado());
		} else {
			interfaceGrafica.showDialog("N�o � sua vez.");
		}
	}

	public void renderSe() {
		if (atorNetGames.ehMinhaVez()) {
			this.getInterfaceGrafica().showDialog(
					"Voc� se rendeu.\nO jogo acabou.");
			jogo.renderSe();
			this.enviarEstado();
			interfaceGrafica.atualizarInterface(jogo.getEstado());
		} else {
			interfaceGrafica.showDialog("N�o � sua vez.");
		}
	}

	public void avisarVencedor() {
		this.getInterfaceGrafica().showDialog(
				"Parab�ns! Voc� � o vencedor!\nO jogo acabou.");
		interfaceGrafica.desabilitarBotoesJogada();
	}
	
	public void avisarRendeuSe() {
		this.getInterfaceGrafica().showDialog(
				"O outro jogador se rendeu.\nParab�ns! Voc� � o vencedor!\nO jogo acabou.");
		interfaceGrafica.desabilitarBotoesJogada();
	}
	
	public void avisarPerdedor() {
		this.getInterfaceGrafica().showDialog(
				"Voc� perdeu :(\nO jogo acabou.");
		interfaceGrafica.desabilitarBotoesJogada();
	}

	public void desconectar() {
		atorNetGames.desconectar();
	}
}