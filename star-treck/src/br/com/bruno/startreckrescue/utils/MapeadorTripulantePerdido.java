package br.com.bruno.startreckrescue.utils;

public class MapeadorTripulantePerdido extends MapeadorTripulante{

	public MapeadorTripulantePerdido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MapeadorTripulantePerdido(int x, int y, int tam) {
		super(x, y, tam);
		// TODO Auto-generated constructor stub
	}

	public String [][] verificaEixoY (String [][] mapa,int eixoX, int eixoY) {
		
		if (eixoY == getTam() && eixoX == getTam()) {
			mapa[getX()][getY()] = "x";
			mapa[getX()-1][getY()-1] = "x";
			mapa[getX()][getY()-1] = "x";
			mapa[getX()-1][getY()] = "x";
		}
		
		if (eixoY == getTam() && eixoX == 1) {
			mapa[getX()][getY()] = "x";
			mapa[getX()+1][getY()-1] = "x";
			mapa[getX()+1][getY()] = "x";
			mapa[getX()][getY()-1] = "x";
		}
		
		
		if (eixoY == 1 && eixoX == 1) {
			mapa[getX()][getY()] = "x";
			mapa[getX()+1][getY()+1] = "x";
			mapa[getX()][getY()+1] = "x";
			mapa[getX()+1][getY()] = "x";
		}
		
		if (eixoY == 1 && eixoX == getTam()) {
			mapa[getX()][getY()] = "x";
			mapa[getX()-1][getY()] = "x";
			mapa[getX()-1][getY()+1] = "x";
			mapa[getX()][getY()+1] = "x";
		}

		if (eixoY == getTam() && 1 < eixoX && eixoX < getTam()) {
			for (int i = getX()-1; i <= getX() + 1; i++) {
				for (int j = getY()-1; j <= getY(); j++) {
					mapa[i][j] = "x";
				}
			}
		}
		
		if (eixoY == 1 && 1 < eixoX && eixoX < getTam()) {
			for (int i = getX()-1; i <= getX()+1; i++) {
				for (int j = getY(); j <= getY() + 1; j++) {
					mapa[i][j] = "x";
				}
			}
		}
		return mapa;
	}
	
	public String[][] verificaEixoX(String [][] mapa,int eixoX, int eixoY) {

		if (eixoX == 1) {
			for (int i = getX(); i <= getX()+1; i++) {
				for (int j = getY()-1; j <= getY() + 1; j++) {
					mapa[i][j] = "x";
				}
			}
		}
		
		if (eixoX == getTam()) {
			for (int i = getX()-1; i <= getX(); i++) {
				for (int j = getY()-1; j <= getY() + 1; j++) {
					mapa[i][j] = "x";
				}
			}
		}
		return mapa;
	}
	
	public String[][] mostraPosicao(String [][] mapa) {
		for (int i = getX() - 1; i <= getX()+1; i++) {
			for (int j = getY() - 1; j <= getY()+1; j++) {
				mapa[i][j] = "x";
			}
		}
		
		return mapa;
	}
	
}
