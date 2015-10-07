package br.com.bruno.startreckrescue.utils;

import br.com.bruno.startreckrescue.coordenada.Coordenada;

public class MapeadorTripulanteProximo extends MapeadorTripulante{

	private Coordenada coordenada;
	
	public MapeadorTripulanteProximo() {
	}

	public MapeadorTripulanteProximo(int x, int y, int tam) {
		super(x, y, tam);
	}

	public MapeadorTripulanteProximo(int x, int y, int tam,
			Coordenada coordenada) {
		super(x, y, tam);
		this.coordenada = coordenada;
	}
	
	public MapeadorTripulanteProximo(int tam, Coordenada coordenada) {
		super(tam);
		this.coordenada = coordenada;
	}
	
	public Coordenada getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}

	@Override
	public String[][] verificaEixoY(String[][] mapa, int eixoX, int eixoY) {
		if (getCoordenada().getX() > eixoX && getCoordenada().getY() < eixoY && eixoY == getTam()) {
			for (int i = getX()-1; i <= getX(); i++) {
				for (int j = getY()-1; j <= getY(); j++) {
					mapa[i][j] = "!";
				}
			}
		}
		return mapa;
	}

	@Override
	public String[][] verificaEixoX(String[][] mapa, int eixoX, int eixoY) {
		
		if (eixoX == 1 && getCoordenada().getX() == eixoX && getCoordenada().getY() < eixoY && eixoY == getTam()) {
			for (int i = getX(); i <= getX()+1; i++) {
				for (int j = getY()-1; j <= getY(); j++) {
					mapa[i][j] = "!";
				}
			}
		}
		
		if (eixoX == 1 && getCoordenada().getX() == eixoX && getCoordenada().getY() > eixoY && eixoY == 1) { 
			for (int i = getX(); i <= getX()+1; i++) {
				for (int j = getY(); j <= getY()+1; j++) {
					mapa[i][j] = "!";
				}
			}
		}
		
		if (eixoX == 1 && getCoordenada().getX() == eixoX && getCoordenada().getY() > eixoY) { 
			for (int i = getX(); i <= getX()+1; i++) {
				for (int j = getY(); j <= getY()+1; j++) {
					mapa[i][j] = "!";
				}
			}
		}
		
		if (eixoX == 1 && getCoordenada().getX() == eixoX && getCoordenada().getY() < eixoY) { 
			for (int i = getX(); i <= getX()+1; i++) {
				for (int j = getY()-1; j <= getY(); j++) {
					mapa[i][j] = "!";
				}
			}
		}
		return mapa;
	}

	
	public String[][] mostra(String[][] mapa, int eixoX, int eixoY) {
		
		if (getCoordenada().getX() < eixoX && getCoordenada().getY() < eixoY) {
			for (int i = getX()-1; i <= getX(); i++) {
				for (int j = getY()-1; j <= getY(); j++) {
					mapa[i][j] = "!";
				}
			}
				
		}
		
		
		if (getCoordenada().getX() > eixoX && getCoordenada().getY() < eixoY) {
			
			for (int i = getX(); i <= getX() + 1; i++) {
				for (int j = getY() - 1; j <= getY(); j++) {
					mapa[i][j] = "!";
				}
			}
			
		}
		
		
		if (getCoordenada().getX() < eixoX && getCoordenada().getY() > eixoY) {
			
			for (int i = getX() - 1; i <= getX(); i++) {
				for (int j = getY(); j <= getY() + 1; j++) {
					mapa[i][j] = "!";
				}
			}
			
		}
		
		if (getCoordenada().getX() > eixoX && getCoordenada().getY() > eixoY) {
			
			for (int i = getX(); i <= getX() + 1; i++) {
				for (int j = getY(); j <= getY() + 1; j++) {
					mapa[i][j] = "!";
				}
			}
		} 
		
		
		if (getCoordenada().getX() == eixoX) {
			for (int i = getX()-1; i <= getX() + 1; i++) {
				for (int j = getCoordenada().getY()-1; j <= getCoordenada().getY(); j++) {
					mapa[i][j] = "!";
				}
			}
		}
		
		
		if (getCoordenada().getY() == eixoY) {
			for (int i = getX()-1; i <= getX(); i++) {
				for (int j = getY() - 1; j <= getY() + 1; j++) {
					mapa[i][j] = "!";
				}
			}
		}
		return mapa;
	}

	public String[][] mostraPosicaoEspecial(String[][] mapa) {
		
		if (getCoordenada().getX() == getTam()  && getCoordenada().getY() == getTam()) {
			for (int i = getTam() - 2; i <= getTam() - 1; i++) {
				for (int j = getTam() - 2; j<= getTam() - 1; j++) {
					mapa[i][j] = "!";
				}
			}
		}
		
		if (getCoordenada().getX() == 1 && getCoordenada().getY() == 1) {
			for (int i = getCoordenada().getX() - 1; i <= getCoordenada().getX(); i++) {
				for (int j = getCoordenada().getY() - 1; j <= getCoordenada().getY(); j++) {
					mapa[i][j] = "!";
				}
			}
		}
		
		if (getCoordenada().getX() == getTam() && getCoordenada().getY() == 1) {
			for (int i = getTam()-2; i <= getTam()-1; i++) {
				for (int j = getCoordenada().getY() - 1; j <= getCoordenada().getY(); j++) {
					mapa[i][j] = "!";
				}
			}
		}
		
		if (getCoordenada().getX() == 1 && getCoordenada().getY() == getTam()) {
			for (int i = getCoordenada().getX() - 1; i <= getCoordenada().getX(); i++) {
				for (int j = getTam() - 2; j <= getTam() - 1; j++) {
					mapa[i][j] = "!";
				}
			}
		}
		return mapa;
	}

	@Override
	public String[][] mostraPosicao(String[][] mapa) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
