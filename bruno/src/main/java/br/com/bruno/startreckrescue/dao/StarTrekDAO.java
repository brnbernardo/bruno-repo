package br.com.bruno.startreckrescue.dao;

import java.io.Serializable;

import br.com.bruno.startreckrescue.model.Coordenada;
import br.com.bruno.startreckrescue.model.TripulanteEncontrado;
import br.com.bruno.startreckrescue.model.TripulantePerdido;
import br.com.bruno.startreckrescue.model.TripulanteProximo;
import br.com.bruno.startreckrescue.util.Auxi;

public class StarTrekDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Coordenada coordenada;

	public StarTrekDAO() {

		/*if (coordenada == null) {
			coordenada = new Coordenada(Auxi.geraAleatorio(),
					Auxi.geraAleatorio());
		}*/

	}

	
	
/*	public static Coordenada getCoordenada() {
		return coordenada;
	}

	public static void geraCoordenada() {
		coordenada = new Coordenada(Auxi.geraAleatorio(),
				Auxi.geraAleatorio());
	}*/

	public boolean encontraTripulante(String[][] mapaDaRegiao, int eixoX,
			int eixoY) {

		if (coordenada == null) {
			coordenada = new Coordenada(Auxi.geraAleatorio(),
					Auxi.geraAleatorio());
		}
		
		if (eixoX == coordenada.getX() && eixoY == coordenada.getY()) {
			// new Classe que pinta o X
			coordenada.setSala(new TripulanteEncontrado());
			coordenada.setMapa(coordenada.getSala().mapeiaPosicao(mapaDaRegiao,
					coordenada, eixoX, eixoY));
			coordenada = new Coordenada(Auxi.geraAleatorio(),
					Auxi.geraAleatorio());
			return true;
		} else if (verificaTripulanteProximo(eixoX, eixoY)) { // fazer uma
			// sala = new TripulanteProximo();
			coordenada.setSala(new TripulanteProximo());
			coordenada.setMapa(coordenada.getSala().mapeiaPosicao(mapaDaRegiao,
					coordenada, eixoX, eixoY));
			return false;
		} else {
			// sala = new TripulantePerdido();
			coordenada.setSala(new TripulantePerdido());
			coordenada.setMapa(coordenada.getSala().mapeiaPosicao(mapaDaRegiao,
					coordenada, eixoX, eixoY));
			return false;
		}
	}

	public boolean verificaTripulanteProximo(int eixoX, int eixoY) {

		int diferencaEixoX = Math.abs(coordenada.getX() - eixoX);
		int diferencaEixoY = Math.abs(coordenada.getY() - eixoY);

		if (diferencaEixoX <= 1 && diferencaEixoY <= 1) {
			return true;
		}

		return false;

	}
	
	public void setX(){
		coordenada.setX(Auxi.geraAleatorio());
	}
	
	public void setY(){
		coordenada.setY(Auxi.geraAleatorio());
	}

}
