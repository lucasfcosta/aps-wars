package rede;

import jogo.Vila;
import br.ufsc.inf.leobr.cliente.Jogada;

public class Estado implements Jogada {

	private Vila vila1;
	private Vila vila2;
	private boolean rendeuSe;
	private boolean vencedor;
	private String ultimaAcao;
	private boolean novoJogo;
	
	public Estado(Vila vila1, Vila vila2, boolean rendeuSe, boolean vencedor, String ultimaAcao) {
		super();
		this.vila1 = vila1;
		this.vila2 = vila2;
		this.rendeuSe = rendeuSe;
		this.vencedor = vencedor;
		this.setUltimaAcao(ultimaAcao);
	}

	public Vila getVila2() {
		return vila2;
	}

	public void setVila2(Vila vila2) {
		this.vila2 = vila2;
	}

	public void setVila1(Vila vila1) {
		this.vila1 = vila1;
	}

	public Vila getVila1() {
		return vila1;
	}
	
	public boolean isRendeuSe() {
		return rendeuSe;
	}

	public void setRendeuSe(boolean rendeuSe) {
		this.rendeuSe = rendeuSe;
	}

	public boolean isVencedor() {
		return vencedor;
	}

	public void setVencedor(boolean vencedor) {
		this.vencedor = vencedor;
	}

	public String getUltimaAcao() {
		return ultimaAcao;
	}

	public void setUltimaAcao(String ultimaAcao) {
		this.ultimaAcao = ultimaAcao;
	}

	public boolean isNovoJogo() {
		return novoJogo;
	}

	public void setNovoJogo(boolean novoJogo) {
		this.novoJogo = novoJogo;
	}

}
