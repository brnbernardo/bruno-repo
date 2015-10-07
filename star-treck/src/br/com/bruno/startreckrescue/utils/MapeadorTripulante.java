package br.com.bruno.startreckrescue.utils;


public abstract class MapeadorTripulante {

	private int x;
	private int y;
	private int tam;
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getTam() {
		return tam;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setTam(int tam) {
		this.tam = tam;
	}

	public MapeadorTripulante(int tam) {
		super();
		this.tam = tam;
	}

	public MapeadorTripulante(int x, int y, int tam) {
		this.x = x;
		this.y = y;
		this.tam = tam;
	}


	public MapeadorTripulante() {
	}
	
	public abstract String [][] verificaEixoY (String [][] mapa,int eixoX, int eixoY);
	
	public abstract String[][] verificaEixoX(String [][] mapa,int eixoX, int eixoY);
	
	public abstract String[][] mostraPosicao(String [][] mapa);
	
}
