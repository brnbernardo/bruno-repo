package br.com.bruno.startreckrescue.controle;
import br.com.bruno.startreckrescue.coordenada.Coordenada;
import br.com.bruno.startreckrescue.utils.MapeadorTripulanteProximo;



public class TripulanteProximo implements SalaComando{

	@Override
	public String[][] mapeiaPosicao(String [][] mapa, Coordenada c, int eixoX, int eixoY) {
		
		int x = eixoX - 1;
		int y = eixoY - 1;
		
		int tam = mapa.length;
		
		SalaComando sala = new TripulantePerdido();
		mapa = sala.mapeiaPosicao(mapa, c, eixoX, eixoY);
		
		if (verificaCasosEspeciais(c, tam)) {
			MapeadorTripulanteProximo mapeadorProximo = new MapeadorTripulanteProximo(tam, c);
			return mapeadorProximo.mostraPosicaoEspecial(mapa);
		}
		
		MapeadorTripulanteProximo mapeador = new MapeadorTripulanteProximo(x, y, tam, c);
		
		if (eixoX == tam || eixoX == 1) {
			return mapeador.verificaEixoX(mapa, eixoX, eixoY);
		}
		
		if (eixoY == tam || eixoY == 1) {
			return mapeador.verificaEixoY(mapa, eixoX, eixoY);
		}
		
		return mapeador.mostra(mapa, eixoX, eixoY);
	}
	
	public boolean verificaCasosEspeciais(Coordenada c, int tam) {
		if ((c.getX() == tam  && c.getY() == tam) || (c.getX() == 1 && c.getY() == 1) || 
				(c.getX() == tam && c.getY() == 1) || (c.getX() == 1 && c.getY() == tam)) {
			return true;
		}
		return false;
	}
	
}
