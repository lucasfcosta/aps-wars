package jogo;

import gui.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import rede.AtorRede;

public class AtorJogador {
	private Jogo jogo;
	private String nome = "Gambiarra";

	private AtorRede atorRede;
	private MainWindow mainWindow;

	public AtorJogador() {
		super();
		this.mainWindow = new MainWindow(this);
		atorRede = new AtorRede(this);
	}
	
	public MainWindow getMainWindow() {
		return mainWindow;
	}
	
	public void conectar() {
		atorRede.conectar(nome, "localhost");
	}

	public void iniciarPartida() {
		atorRede.iniciarPartidaRede();
	}

	public void iniciarPartidaRede(boolean comecoFalando) {
		String nomeOutroJogador = atorRede.obterNomeAdversario();
		jogo = new Jogo();

		if (comecoFalando) {
			jogo.criarParticipante(this.nome);
			jogo.criarParticipante(nomeOutroJogador);
			this.getMainWindow().showDialog("É sua vez, comece falando...");
		} else {
			jogo.criarParticipante(nomeOutroJogador);
			jogo.criarParticipante(this.nome);
			this.getMainWindow().showDialog("Espere o outro falar...");
		}

	}

	public void receberMensagemRede(String mensagem) {
		this.getMainWindow().showDialog("Mensagem recebida: "+mensagem);
		jogo.trataMensagem(mensagem);
	}
	
	public boolean enviarMensagem(String mensagem){
		if (atorRede.ehMinhaVez()){
			boolean tratou = this.jogo.trataMensagem(mensagem);
			if (tratou){
				atorRede.enviarJogada(mensagem);
			}else{
				this.getMainWindow().showDialog("Ocorreu um erro na ordenação de mensagens");
			}
			return tratou;
		}else{
			return false;
		}
		
		
	}

}