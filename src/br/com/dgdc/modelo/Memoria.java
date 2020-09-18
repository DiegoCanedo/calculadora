package br.com.dgdc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Memoria {

	// padrao SINGLETON
	private static final Memoria instancia = new Memoria();

	private final List<MemoriaObservador> observadores = new ArrayList<MemoriaObservador>();

	private TipoComando ultimaOperacaoSelecionada = null;
	private boolean substituir = false;
	private String textoAtual = "";
	private String textoBuffer = "";

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

	public void processarComando(String texto) {

		TipoComando comando = detectarTipoComando(texto);

		if (comando == null) {
			return;
		}

		if (comando == TipoComando.ZERAR) {
			zerarProps();
		} else if (comando == TipoComando.NUMERO || comando == TipoComando.VIRGULA) {
			this.textoAtual = substituir ? texto : this.textoAtual + texto;
			substituir = false;
		} else {
			substituir = true;
			textoAtual = obterResultadoOperacao();
			
			ultimaOperacaoSelecionada = comando;
			textoBuffer = textoAtual;
		}

		observadores.forEach(o -> o.valorAlterado(getTextoAtual()));
	}

	private String obterResultadoOperacao() {
		
		if(ultimaOperacaoSelecionada == null || ultimaOperacaoSelecionada == TipoComando.IGUAL)
			return textoAtual;
		
		double numeroBuffer = Double.parseDouble(textoBuffer.replace("," , "."));
		double numeroAtual = Double.parseDouble(textoAtual.replace("," , "."));
		double resultado = 0;
		
		if(ultimaOperacaoSelecionada == TipoComando.SOMA) {
			resultado = numeroBuffer + numeroAtual;
		}else if(ultimaOperacaoSelecionada == TipoComando.SUB) {
			resultado = numeroBuffer - numeroAtual;
		}else if(ultimaOperacaoSelecionada == TipoComando.MULT) {
			resultado = numeroBuffer * numeroAtual;
		}else if(ultimaOperacaoSelecionada == TipoComando.DIV) {
			resultado = numeroBuffer / numeroAtual;
		}
		
		String resultadoString = Double.toString(resultado).replace(".", ",");
		
		boolean inteiro = resultadoString.endsWith(",0");
		
		return inteiro ? 
				resultadoString.replace(",0", "") :
			     resultadoString;
		
	}

	private void zerarProps() {
		this.textoAtual = "";
		textoBuffer = "";
		substituir = false;
		ultimaOperacaoSelecionada = null;
	}

	private TipoComando detectarTipoComando(String texto) {

		if (textoAtual.isEmpty() && texto == "0")
			return null;

		try {
			Integer.parseInt(texto);
			return TipoComando.NUMERO;
		} catch (NumberFormatException e) {

			if ("AC".equals(texto)) {
				return TipoComando.ZERAR;
			} else if ("÷".equals(texto)) {
				return TipoComando.DIV;
			} else if ("x".equals(texto)) {
				return TipoComando.MULT;
			} else if ("+".equals(texto)) {
				return TipoComando.SOMA;
			} else if ("-".equals(texto)) {
				return TipoComando.SUB;
			} else if ("=".equals(texto)) {
				return TipoComando.IGUAL;
			} else if (",".equals(texto) && !textoAtual.contains(",")) {
				return TipoComando.VIRGULA;
			}

			return null;
		}
	}

}
