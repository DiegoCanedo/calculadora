package br.com.dgdc.visao;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class Botao extends JButton {

	public Botao(String texto, Color backGroundColor, Color foreGroundColor) {
		setText(texto);
		setFont(new Font("courier", Font.PLAIN, 25));
		setLayout(new FlowLayout(FlowLayout.CENTER));

		setOpaque(true);
		setBackground(backGroundColor);
		
		setForeground(foreGroundColor);
		setBorder(BorderFactory.createStrokeBorder(new BasicStroke(0.2f)));
	}
	
	
}
