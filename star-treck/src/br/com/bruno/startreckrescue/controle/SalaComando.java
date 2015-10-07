package br.com.bruno.startreckrescue.controle;

import br.com.bruno.startreckrescue.coordenada.Coordenada;

public interface SalaComando {

	public String[][] mapeiaPosicao(String [][] mapa, Coordenada c, int eixoX, int eixoY);
	
	
}
