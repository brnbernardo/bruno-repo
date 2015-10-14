package br.com.bruno.startreckrescue.model;


public class TripulanteEncontrado implements SalaComando{

	@Override
	public String[][] mapeiaPosicao(String [][] mapa, Coordenada c, int eixoX, int eixoY) {
		// TODO Auto-generated method stub
		
		mapa[eixoX-1][eixoY-1] = "X";
		
		return mapa;
	}

}
