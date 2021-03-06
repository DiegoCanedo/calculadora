package br.com.dgdc.visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Calculadora extends JFrame{
 
	public Calculadora() {
		
		organizarLayout();
		
		setSize(232,322);
		//setUndecorated(true);
		this.getContentPane().setBackground(Color.black);
		setDefaultCloseOperation(EXIT_ON_CLOSE); //fecha o processo quando fechar a janela
		setLocationRelativeTo(null); //valor null centraliza a janela
		setVisible(true);
	}
	
	private void organizarLayout() {
		setLayout(new BorderLayout());
		
		Display display = new Display();
		display.setPreferredSize(new Dimension(233,60));
		add(display, BorderLayout.NORTH);
		
		Teclado teclado = new Teclado();
		add(teclado, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		new Calculadora();
	}
}

