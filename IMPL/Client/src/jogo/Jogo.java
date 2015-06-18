package jogo;
import java.util.ArrayList;
import java.util.List;

public class Jogo {

	private List<String> mensagens;

	private Jogador participanteCriador;

	private Jogador participanteConvidado;

	public Jogo() {
		mensagens = new ArrayList<String>();
	}

	/**
	 * Cria um participante na sala.
	 * 
	 * @param nome
	 */
	public void criarParticipante(String nome) {
		if (participanteCriador == null) {
			participanteCriador = new Jogador(nome);
			participanteCriador.tomarVez();
		} else if (participanteConvidado == null) {
			participanteConvidado = new Jogador(nome);
			participanteConvidado.passarVez();
		}
	}

	public boolean trataMensagem(String mensagem) {
		
		if (participanteCriador.ehVez()) {
			mensagens.add("[" + participanteCriador.getNome() + "]: " + mensagem + "\n");
			participanteCriador.passarVez();
			participanteConvidado.tomarVez();
			return true;
		} else if (participanteConvidado.ehVez()) {
			mensagens.add("[" + participanteConvidado.getNome() + "]: "+ mensagem + "\n");
			participanteConvidado.passarVez();
			participanteCriador.tomarVez();
			return true;
		}
		return false;

	}

	/**
	 * Informa a �ltima mensagem da lista de mensagens.
	 * 
	 * @return
	 */
	public String informaUltimaMensagem() {
		return mensagens.get(mensagens.size() - 1);
	}

}
