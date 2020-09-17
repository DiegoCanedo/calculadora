package br.com.dgdc.visao;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.com.dgdc.modelo.Memoria;

public class Teclado extends JPanel implements ActionListener {

	private final Color COR_CINZA_ESCURO = new Color(68, 68, 68);
	private final Color COR_CINZA_CLARO = new Color(99, 99, 99);
	private final Color COR_LARANJA = new Color(242, 163, 60);

	public Teclado() {

		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints cons = new GridBagConstraints();

		setLayout(layout);

		cons.weightx = 1;
		cons.weighty = 1;
		cons.fill = GridBagConstraints.BOTH;

		// botao ocupando 3 espacos
		cons.gridwidth = 3;
		adicionarBotao("AC", COR_CINZA_ESCURO, cons, 0, 0);
//		adicionarBotao("+/-", COR_CINZA_ESCURO, cons, 1,0);
//		adicionarBotao("%", COR_CINZA_ESCURO, cons, 2,0);

		// botao voltando a ocupar 1 espaco
		cons.gridwidth = 1;
		adicionarBotao("/", COR_LARANJA, cons, 3, 0);

		adicionarBotao("7", COR_CINZA_CLARO, cons, 0, 1);
		adicionarBotao("8", COR_CINZA_CLARO, cons, 1, 1);
		adicionarBotao("9", COR_CINZA_CLARO, cons, 2, 1);
		adicionarBotao("X", COR_LARANJA, cons, 3, 1);

		adicionarBotao("4", COR_CINZA_CLARO, cons, 0, 2);
		adicionarBotao("5", COR_CINZA_CLARO, cons, 1, 2);
		adicionarBotao("6", COR_CINZA_CLARO, cons, 2, 2);
		adicionarBotao("-", COR_LARANJA, cons, 3, 2);

		adicionarBotao("1", COR_CINZA_CLARO, cons, 0, 3);
		adicionarBotao("2", COR_CINZA_CLARO, cons, 1, 3);
		adicionarBotao("3", COR_CINZA_CLARO, cons, 2, 3);
		adicionarBotao("+", COR_LARANJA, cons, 3, 3);

		cons.gridwidth = 2;
		adicionarBotao("0", COR_CINZA_CLARO, cons, 0, 4);
		cons.gridwidth = 1;
		adicionarBotao(".", COR_CINZA_CLARO, cons, 2, 4);
		adicionarBotao("=", COR_LARANJA, cons, 3, 4);

	}

	private void adicionarBotao(String texto, Color cor, GridBagConstraints cons, int x, int y) {

		Botao botao = new Botao(texto, cor);
		botao.addActionListener(this);
		cons.gridx = x;
		cons.gridy = y;

		add(botao, cons);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() instanceof JButton)
		{
			//vai pegar o texto do botao
			JButton botao = (JButton) e.getSource();
			Memoria.getInstancia().processarComando(botao.getText());
		}
		
		
	}
}
