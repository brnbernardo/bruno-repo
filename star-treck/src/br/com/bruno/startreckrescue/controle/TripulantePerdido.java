package br.com.bruno.startreckrescue.controle;
import br.com.bruno.startreckrescue.coordenada.Coordenada;
import br.com.bruno.startreckrescue.utils.MapeadorTripulante;
import br.com.bruno.startreckrescue.utils.MapeadorTripulantePerdido;


public class TripulantePerdido implements SalaComando{

	@Override
	public String[][] mapeiaPosicao(String [][] mapa, Coordenada c, int eixoX, int eixoY) {

		int x = eixoX - 1;
		int y = eixoY - 1;
		int tam = mapa.length;
		
		MapeadorTripulante mapeador = new MapeadorTripulantePerdido(x, y, tam);
		
		if (eixoY == tam || eixoY == 1) {
			return mapeador.verificaEixoY(mapa, eixoX, eixoY);
		}
		
		if (eixoX == 1 || eixoX == tam) {
			return mapeador.verificaEixoX(mapa, eixoX, eixoY);
		}
		
		return mapeador.mostraPosicao(mapa);
	}

}
