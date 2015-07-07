package rede;

import jogo.Vila;
import br.ufsc.inf.leobr.cliente.Jogada;

public class Estado implements Jogada {

	private Vila vila1;
	private Vila vila2;
	
	public Estado(Vila vila1, Vila vila2) {
		super();
		this.vila1 = vila1;
		this.vila2 = vila2;
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

}
