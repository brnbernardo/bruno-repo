package br.com.bruno.startreckrescue.util;


public class Auxi {
	public static final int size = 10;
	public static String malha[][] = new String[size][size];
	public static int count = 0;
	public static int numJogadas = 3;
	
	public static int geraAleatorio() {
		int numero = 1 + (int) (Math.random() * size);
		return (Math.round(numero));
		
	}
	 
	public static boolean verificaRange(int eixoX) {
		if (eixoX < 1 || eixoX > size) {
			return false;
		}
		else{ 
			return true;
		}
	}

	public static String exibeMapaFinal() {
		return"\n Foram uttilizados " + Auxi.count + "sinalizadores \n";
	}
	
	public static String mostraMapa(String[][] malha) {

		String r = null;
		
		System.out.format("     ");
		r = "     ";
		
		for (int i = 0; i < malha.length; i++) {
			System.out.format("%3d",i+1);
			r += String.format("%3d",i+1);
		}
		System.out.println();
		System.out.println("-------------------------------------------------------------");
		r += "\n\n-------------------------------------------------------------\n\n";
		
		for (int i = 0; i < malha.length; i++) {
			System.out.format("%3da - ", (i + 1));
			r += String.format("%3da - ", (i + 1));
			for (int j = 0; j < malha.length; j++) {
				malha[j][i] = malha[j][i] == null ? " " : malha[j][i];
				System.out.format("%-1.8s  ",malha[j][i] );
				r += String.format("%-1.8s  ",malha[j][i]);
			}
				
			System.out.println();
			r += "\n\n";
		}
		
		return r;
	}
		
		/*System.out.format("     ");
		for (int i = 0; i < malha.length; i++) {
			System.out.format("%3d",i+1);
		}
		System.out.println();
		System.out.println("-------------------------------------------------------------");
		
		for (int i = 0; i < malha.length; i++) {
			System.out.format("%3da - ", (i + 1));
			for (int j = 0; j < malha.length; j++) {
				malha[j][i] = malha[j][i] == null ? " " : malha[j][i];
				System.out.format("%-1.8s  ",malha[j][i] );
			}

			System.out.println();
		}*/
	

}
