package br.com.dgdc.modelo;

public class Memoria {
	
	//padrao SINGLETON
	private static final Memoria instancia = new Memoria();
	
	private String textoAtual = "";
	
	private Memoria() {
		// TODO Auto-generated constructor stub
	}
	
	public static Memoria getInstancia() {
		return instancia;
	}
	
	public String getTextoAtual() {
		return textoAtual.isEmpty() ? "0" : textoAtual;
	}
	
	public void setTextoAtual(String textoAtual) {
		this.textoAtual = textoAtual;
	}

}
