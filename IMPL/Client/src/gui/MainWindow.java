package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jogo.AtorJogador;

public class MainWindow extends JFrame implements ActionListener {
	AtorJogador atorJogador;
	JButton jButton;
	JButton jButtonIniciarPartida;
	JTextField jTextField;
	
	public MainWindow(AtorJogador atorJogador){
		this.atorJogador = atorJogador;
		JPanel jPanel = new JPanel();
		jPanel.setPreferredSize(new Dimension(350,350));
		this.add(jPanel);
		
		this.jTextField = new JTextField();
		jTextField.setPreferredSize(new Dimension(100,20));
		jPanel.add(jTextField);
		
		this.jButton = new JButton();
		jButton.setPreferredSize(new Dimension(100,20));
		jButton.setText("Enviar");
		jButton.addActionListener(this);
		jPanel.add(jButton);
		
		this.jButtonIniciarPartida = new JButton();
		jButtonIniciarPartida.setPreferredSize(new Dimension(100,20));
		jButtonIniciarPartida.setText("Iniciar partida");
		jButtonIniciarPartida.addActionListener(this);
		jPanel.add(jButtonIniciarPartida);
		
		this.setSize(400, 400);
		this.setVisible(true);
	}
	
	public void showDialog(String msg){
		JOptionPane.showMessageDialog(this, msg);
	}
	
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.jButton){
        	jButtonClicked();
        }
        
        if(e.getSource() == this.jButtonIniciarPartida){
        	jButtonIniciarPartidaClicked();
        }
    }
    
    private void jButtonClicked(){
    	atorJogador.enviarMensagem(this.jTextField.getText());
    }
    
    private void jButtonIniciarPartidaClicked(){
    	atorJogador.iniciarPartida();
    }
	
}
