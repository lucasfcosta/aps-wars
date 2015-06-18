package rede;

import jogo.AtorJogador;
import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoJogandoException;

public class AtorRede implements OuvidorProxy {

	private AtorJogador atorJogador;
	private Proxy proxy;
	private boolean isMyTurn = false;

	public AtorRede(AtorJogador atorJogador) {
		super();
		this.atorJogador = atorJogador;
		proxy = Proxy.getInstance();
		proxy.addOuvinte(this);
	}

	/**
	 * Conecta o jogo ao servidor.
	 * 
	 * @param nome
	 * @param servidor
	 */
	public void conectar(String nome, String servidor) {
		try {
			proxy.conectar(servidor, nome);
		} catch (Exception e) {
			atorJogador.getMainWindow().showDialog(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Inicia uma partida entre cliente e servidor. Através dessa partida os
	 * participantes do chat irão trocar mensagens.
	 */
	public void iniciarPartidaRede() {
		try {
			proxy.iniciarPartida(2);
		} catch (NaoConectadoException e) {
			atorJogador.getMainWindow().showDialog(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void iniciarNovaPartida(Integer posicao) {
		isMyTurn = posicao == 1 ? true : false;
		atorJogador.iniciarPartidaRede(isMyTurn);
	}

	public void enviarJogada(String mensagem) {

		Mensagem msg = new Mensagem(mensagem);
		try {
			proxy.enviaJogada(msg);
			isMyTurn = false;
		} catch (NaoJogandoException e) {
			atorJogador.getMainWindow().showDialog(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void receberJogada(Jogada jogada) {
		Mensagem msg = (Mensagem) jogada;
		atorJogador.receberMensagemRede(msg.getMensagem());
		isMyTurn = true;
	}

	public void desconectar() {
		try {
			proxy.desconectar();
		} catch (NaoConectadoException e) {
			atorJogador.getMainWindow().showDialog(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void finalizarPartidaComErro(String message) {
		atorJogador.getMainWindow().showDialog(message);

	}

	@Override
	public void tratarConexaoPerdida() {
		atorJogador.getMainWindow().showDialog(
				"A conexão com o servidor foi perdida!");

	}

	@Override
	public void tratarPartidaNaoIniciada(String message) {
		atorJogador.getMainWindow().showDialog(
				"Não foi possível iniciar a conversa");
	}

	@Override
	public void receberMensagem(String msg) {
		// TODO Auto-generated method stub

	}

	public String obterNomeAdversario() {
		String nome = "";
		if (isMyTurn) {
			nome = proxy.obterNomeAdversario(2);
		} else {
			nome = proxy.obterNomeAdversario(1);
		}

		return nome;
	}

	public boolean ehMinhaVez() {
		return isMyTurn;
	}

}
