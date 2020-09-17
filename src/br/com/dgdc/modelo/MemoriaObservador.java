package br.com.dgdc.modelo;

@FunctionalInterface
public interface MemoriaObservador {
	void valorAlterado(String novoValor);
}
