package gui;

import java.awt.Dimension;

import javax.swing.JOptionPane;

import jogo.Vila;
import rede.AtorJogador;
import rede.Estado;

public class InterfaceGrafica extends javax.swing.JFrame {
	private javax.swing.JButton atacar;
	private javax.swing.JLabel comidaJogador1;
	private javax.swing.JLabel comidaJogador2;
	private javax.swing.JButton fortalecerMuralha;
	private javax.swing.JButton coletarRecursos;
	private javax.swing.JButton construirTropas;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem iniciarPartida;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JLabel madeiraJogador1;
	private javax.swing.JLabel madeiraJogador2;
	private javax.swing.JLabel nomeJogador1;
	private javax.swing.JLabel nomeJogador2;
	private javax.swing.JButton renderSe;
	private javax.swing.JLabel soldadosJogador1;
	private javax.swing.JLabel soldadosJogador2;
	private javax.swing.JProgressBar vidaMuralha1;
	private javax.swing.JProgressBar vidaMuralha2;
	private javax.swing.JProgressBar vidaVila1;
	private javax.swing.JProgressBar vidaVila2;
	private javax.swing.JLabel ultimaAcao;
	private AtorJogador atorJogador;

	@SuppressWarnings("unchecked")
	private void initComponents() {

		jSeparator1 = new javax.swing.JSeparator();
        vidaVila1 = new javax.swing.JProgressBar();
        vidaMuralha1 = new javax.swing.JProgressBar();
        nomeJogador1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comidaJogador1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        madeiraJogador1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        soldadosJogador1 = new javax.swing.JLabel();
        renderSe = new javax.swing.JButton();
        nomeJogador2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comidaJogador2 = new javax.swing.JLabel();
        madeiraJogador2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        soldadosJogador2 = new javax.swing.JLabel();
        vidaVila2 = new javax.swing.JProgressBar();
        vidaMuralha2 = new javax.swing.JProgressBar();
        coletarRecursos = new javax.swing.JButton();
        construirTropas = new javax.swing.JButton();
        fortalecerMuralha = new javax.swing.JButton();
        atacar = new javax.swing.JButton();
        ultimaAcao = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        iniciarPartida = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("APS Wars");
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        vidaVila1.setForeground(new java.awt.Color(0, 153, 51));
        vidaVila1.setToolTipText("");
        vidaVila1.setValue(100);
        vidaVila1.setName("vidaMuralha"); // NOI18N
        vidaVila1.setString("Vida da Vila");
        vidaVila1.setStringPainted(true);

        vidaMuralha1.setForeground(new java.awt.Color(204, 0, 0));
        vidaMuralha1.setValue(100);
        vidaMuralha1.setName("vidaMuralha1"); // NOI18N
        vidaMuralha1.setString("Vida da Muralha");
        vidaMuralha1.setStringPainted(true);

        nomeJogador1.setFont(new java.awt.Font("Tahoma", 2, 48)); // NOI18N
        nomeJogador1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nomeJogador1.setText("Jogador 1");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Madeira");

        comidaJogador1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comidaJogador1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        comidaJogador1.setText("QTDC");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Comida");

        madeiraJogador1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        madeiraJogador1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        madeiraJogador1.setText("QTDM");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Soldados");

        soldadosJogador1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        soldadosJogador1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        soldadosJogador1.setText("QTDS");

        renderSe.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        renderSe.setText("Render-se");
        renderSe.setMaximumSize(new java.awt.Dimension(151, 31));
        renderSe.setMinimumSize(new java.awt.Dimension(151, 31));
        renderSe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renderSeActionPerformed(evt);
            }
        });

        nomeJogador2.setFont(new java.awt.Font("Tahoma", 2, 48)); // NOI18N
        nomeJogador2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nomeJogador2.setText("Jogador 2");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Comida");

        comidaJogador2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comidaJogador2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        comidaJogador2.setText("QTDC");

        madeiraJogador2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        madeiraJogador2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        madeiraJogador2.setText("QTDM");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Madeira");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Soldados");

        soldadosJogador2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        soldadosJogador2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        soldadosJogador2.setText("QTDS");

        vidaVila2.setForeground(new java.awt.Color(0, 153, 51));
        vidaVila2.setToolTipText("");
        vidaVila2.setValue(100);
        vidaVila2.setName("vidaMuralha"); // NOI18N
        vidaVila2.setString("Vida da Vila");
        vidaVila2.setStringPainted(true);

        vidaMuralha2.setForeground(new java.awt.Color(204, 0, 0));
        vidaMuralha2.setValue(100);
        vidaMuralha2.setName("vidaMuralha1"); // NOI18N
        vidaMuralha2.setString("Vida da Muralha");
        vidaMuralha2.setStringPainted(true);

        coletarRecursos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        coletarRecursos.setText("Coletar Recursos");
        coletarRecursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerarRecursosActionPerformed(evt);
            }
        });

        construirTropas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        construirTropas.setText("Construir Tropas");
        construirTropas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerarTropasActionPerformed(evt);
            }
        });

        fortalecerMuralha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fortalecerMuralha.setText("Fortalecer Muralha");
        fortalecerMuralha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fortalecerMuralhaActionPerformed(evt);
            }
        });

        atacar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        atacar.setText("Atacar");
        atacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atacarActionPerformed(evt);
            }
        });

        ultimaAcao.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        ultimaAcao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ultimaAcao.setText("Ainda não ocorreu nenhuma ação");
        ultimaAcao.setPreferredSize(new Dimension(265, 22));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tribalaps.png"))); // NOI18N

        jMenu2.setText("Partida");

        iniciarPartida.setText("Iniciar Partida");
        iniciarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarPartidaActionPerformed(evt);
            }
        });
        jMenu2.add(iniciarPartida);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comidaJogador2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(madeiraJogador2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(soldadosJogador2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(192, 192, 192))
                                .addComponent(vidaVila2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(vidaMuralha2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nomeJogador2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeJogador1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comidaJogador1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(madeiraJogador1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(soldadosJogador1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(192, 192, 192))
                                .addComponent(vidaVila1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(vidaMuralha1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(coletarRecursos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(construirTropas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fortalecerMuralha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(atacar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(renderSe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ultimaAcao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nomeJogador1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comidaJogador1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(madeiraJogador1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(soldadosJogador1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addComponent(vidaVila1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ultimaAcao, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vidaMuralha1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(nomeJogador2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comidaJogador2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(madeiraJogador2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(soldadosJogador2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addComponent(vidaVila2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vidaMuralha2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(renderSe, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(coletarRecursos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(construirTropas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fortalecerMuralha, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(atacar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
		
		this.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	exitButtonClicked(windowEvent);
		    }
		});
	}

	private void renderSeActionPerformed(java.awt.event.ActionEvent evt) {
		int result = JOptionPane.showConfirmDialog(this, "Você tem certez de que deseja se render?", "Fechar jogo", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			atorJogador.renderSe();
		}
	}

	private void gerarRecursosActionPerformed(java.awt.event.ActionEvent evt) {
		atorJogador.coletarRecursos();
	}

	private void gerarTropasActionPerformed(java.awt.event.ActionEvent evt) {
		atorJogador.construirTropas();
	}

	private void fortalecerMuralhaActionPerformed(java.awt.event.ActionEvent evt) {
		atorJogador.fortalecerMuralha();
	}

	private void atacarActionPerformed(java.awt.event.ActionEvent evt) {
		atorJogador.atacar();
	}

	private void iniciarPartidaActionPerformed(java.awt.event.ActionEvent evt) {
		atorJogador.iniciarPartidaPedido();
	}
	
	private void exitButtonClicked(java.awt.event.WindowEvent windowEvent) {
		int result = JOptionPane.showConfirmDialog(this, "Você tem certez de que deseja fechar?", "Fechar jogo", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			atorJogador.desconectar();
			System.exit(0);
		}
	}

	public InterfaceGrafica(AtorJogador atorJogador) {
		this.atorJogador = atorJogador;
		initComponents();
		this.setVisible(true);
	}

	public void showDialog(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}

	public String showNameQuestion() {
		return JOptionPane.showInputDialog("Escolha seu nome:");
	}

	public void atualizarInterface(Estado estado) {
		Vila vila1 = estado.getVila1();
		Vila vila2 = estado.getVila2();
		comidaJogador1.setText(String.valueOf(vila1.getComida()));
		comidaJogador2.setText(String.valueOf(vila2.getComida()));
		madeiraJogador1.setText(String.valueOf(vila1.getMadeira()));
		madeiraJogador2.setText(String.valueOf(vila2.getMadeira()));
		soldadosJogador1.setText(String.valueOf(vila1.getSoldados()));
		soldadosJogador2.setText(String.valueOf(vila2.getSoldados()));
		
		vidaVila1.setString("Vida da Vila: " + vila1.getPontosDeVida());
		vidaVila1.setValue(vila1.getPontosDeVida());
		vidaVila2.setString("Vida da Vila: " + vila2.getPontosDeVida());
		vidaVila2.setValue(vila2.getPontosDeVida());
		
		vidaMuralha1.setString("Vida da Muralha: " + vila1.getMuralha().getPontosDeVida());
		vidaMuralha1.setValue(vila1.getMuralha().getPontosDeVida());
		vidaMuralha2.setString("Vida da Muralha: " + vila2.getMuralha().getPontosDeVida());
		vidaMuralha2.setValue(vila2.getMuralha().getPontosDeVida());
		
		ultimaAcao.setText(estado.getUltimaAcao());
	}
	
	public void desabilitarBotoesJogada() {
		atacar.setEnabled(false);
		fortalecerMuralha.setEnabled(false);
		coletarRecursos.setEnabled(false);
		construirTropas.setEnabled(false);
		renderSe.setEnabled(false);
	}
	
	public void habilitarBotoesJogada() {
		atacar.setEnabled(true);
		fortalecerMuralha.setEnabled(true);
		coletarRecursos.setEnabled(true);
		construirTropas.setEnabled(true);
		renderSe.setEnabled(true);
	}
	
	public void desabilitarIniciarPartida() {
		iniciarPartida.setEnabled(false);
		jMenuBar1.setEnabled(false);
		jMenu2.setEnabled(false);
	}
	
	public void habilitarIniciarPartida() {
		iniciarPartida.setEnabled(true);
		jMenuBar1.setEnabled(true);
		jMenu2.setEnabled(true);
	}
	
	public void atualizarNomeJogador1(String str, boolean eu) {
		nomeJogador1.setText(str+(eu ? " (Eu)" : ""));
	}
	
	public void atualizarNomeJogador2(String str, boolean eu) {
		nomeJogador2.setText(str+(eu ? " (Eu)" : ""));
	}
}
