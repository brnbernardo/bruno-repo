package br.com.bruno.startreckrescue.model;

import br.com.bruno.startreckrescue.util.Auxi;

public class Coordenada {

	private SalaComando sala;
	
	private String [][] mapa;
	private int x;
	private int y;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public String[][] getMapa() {
		return mapa;
	}
	
	public void setMapa(String[][] mapa) {
		this.mapa = mapa;
	}
	
	public Coordenada(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public SalaComando getSala() {
		return sala;
	}
	public void setSala(SalaComando sala) {
		this.sala = sala;
	}
	
	
//	public boolean encontraTripulante(String [][] mapaDaRegiao, int eixoX, int eixoY){
//		if(eixoX == this.getX() && eixoY == this.getY()) {
//			//new Classe que pinta o X
//			sala = new TripulanteEncontrado();
//			this.setMapa(sala.mapeiaPosicao(mapaDaRegiao, this, eixoX, eixoY));
//			return true;
//		} else if(verificaTripulanteProximo(eixoX, eixoY)) { //fazer uma
//			sala = new TripulanteProximo();
//			this.setMapa(sala.mapeiaPosicao(mapaDaRegiao, this, eixoX, eixoY)); 
//			return false;
//		} else {
//			sala = new TripulantePerdido();
//			this.setMapa(sala.mapeiaPosicao(mapaDaRegiao, this, eixoX, eixoY));
//			return false;
//		}
//	}
//	
//	private boolean verificaTripulanteProximo (int eixoX, int eixoY) {
//		
//		int diferencaEixoX = Math.abs(getX() - eixoX);
//		int diferencaEixoY = Math.abs(getY() - eixoY);
//		
//		
//		if(diferencaEixoX <= 1 && diferencaEixoY <= 1 ) {
//			return true;
//		}
//		
//		return false;
//		
//	}
	
}
