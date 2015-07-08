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
			this.nome = "Anônimo";
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
					"Jogo iniciado!\nVocê começa jogando.");
			this.getInterfaceGrafica().atualizarNomeJogador1(this.nome, true);
			this.getInterfaceGrafica().atualizarNomeJogador2(nomeOutroJogador,
					false);
			interfaceGrafica.habilitarBotoesJogada();
		} else {
			jogo.criarJogador(nomeOutroJogador, false);
			jogo.criarJogador(this.nome, true);
			interfaceGrafica
					.showDialog("Jogo iniciado!\nAguarde a jogada de seu adversário.");
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
				interfaceGrafica.showDialog("Não é possivel atacar.");
			}
		} else {
			interfaceGrafica.showDialog("Não é sua vez.");
		}
	}

	public void construirTropas() {
		if (atorNetGames.ehMinhaVez()) {
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
		if (atorNetGames.ehMinhaVez()) {
			if (jogo.fortalecerMuralha()) {
				this.enviarEstado();
				interfaceGrafica.atualizarInterface(jogo.getEstado());
			} else {
				interfaceGrafica
						.showDialog("Não é possivel fortalecer a muralha.");
			}
		} else {
			interfaceGrafica.showDialog("Não é sua vez.");
		}
	}

	public void gerarRecursos() {
		if (atorNetGames.ehMinhaVez()) {
			jogo.gerarRecursos();
			this.enviarEstado();
			interfaceGrafica.atualizarInterface(jogo.getEstado());
		} else {
			interfaceGrafica.showDialog("Não é sua vez.");
		}
	}

	public void renderSe() {
		if (atorNetGames.ehMinhaVez()) {
			this.getInterfaceGrafica().showDialog(
					"Você se rendeu.\nO jogo acabou.");
			jogo.renderSe();
			this.enviarEstado();
			interfaceGrafica.atualizarInterface(jogo.getEstado());
		} else {
			interfaceGrafica.showDialog("Não é sua vez.");
		}
	}

	public void avisarVencedor() {
		this.getInterfaceGrafica().showDialog(
				"Parabéns! Você é o vencedor!\nO jogo acabou.");
		interfaceGrafica.desabilitarBotoesJogada();
	}
	
	public void avisarRendeuSe() {
		this.getInterfaceGrafica().showDialog(
				"O outro jogador se rendeu.\nParabéns! Você é o vencedor!\nO jogo acabou.");
		interfaceGrafica.desabilitarBotoesJogada();
	}
	
	public void avisarPerdedor() {
		this.getInterfaceGrafica().showDialog(
				"Você perdeu :(\nO jogo acabou.");
		interfaceGrafica.desabilitarBotoesJogada();
	}

	public void desconectar() {
		atorNetGames.desconectar();
	}
}