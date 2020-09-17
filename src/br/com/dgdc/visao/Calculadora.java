package br.com.dgdc.visao;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Calculadora extends JFrame{
 
	public Calculadora() {
		setSize(232,322);
		setDefaultCloseOperation(EXIT_ON_CLOSE); //fecha o processo quando fechar a janela
		setLocationRelativeTo(null); //valor null centraliza a janela
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Calculadora();
	}
}

