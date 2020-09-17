package br.com.dgdc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Memoria {
	
	//padrao SINGLETON
	private static final Memoria instancia = new Memoria();
	
	private final List<MemoriaObservador> observadores = new ArrayList<MemoriaObservador>();
	
	private String textoAtual = "";
	
	private Memoria() {
		// TODO Auto-generated constructor stub
	}
	
	public static Memoria getInstancia() {
		return instancia;
	}
	
	public void adicionarObservador(MemoriaObservador observador) {
		observadores.add(observador);
	}
	
	public String getTextoAtual() {
		return textoAtual.isEmpty() ? "0" : textoAtual;
	}
	
	public void processarComando(String valor) {
		
		if("AC".equals(valor)) {
			this.textoAtual = "";
		}else
		{
			this.textoAtual += valor;
		}
		
		observadores.forEach(o -> o.valorAlterado(getTextoAtual()));
	}

}
