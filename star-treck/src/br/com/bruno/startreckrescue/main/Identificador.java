package br.com.bruno.startreckrescue.main;
import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.bruno.startreckrescue.coordenada.Coordenada;
public class Identificador {

	public static void main(String[] args) {

		String malha[][] = new String[10][10];

		Coordenada coordenada = new Coordenada(geraAleatorio(), geraAleatorio());

		boolean retorno = true;
		int count = 0;
		int eixoX;
		int eixoY;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {
			do {
				try {
					System.out.println();
					System.out.println("Digite os eixos com numeros entre 1 e 10: " + "\n");
	
					do  {
						System.out.println("Digite o eixo x: ");
						eixoX = in.nextInt();
					} while (!verificaRange(eixoX, in));
					
					do {
						System.out.println("Digite o eixo y: ");
						eixoY = in.nextInt();
					} while (!verificaRange(eixoY, in));
					
					retorno = coordenada.encontraTripulante(malha, eixoX, eixoY);
					
				} catch (InputMismatchException e) {
					  e.printStackTrace();
					  System.err.println("Entre com um valor inteiro");
					} 
				
				count++;
				
				mostraMapa(coordenada.getMapa());
				
			} while (!retorno);
				coordenada.setX(geraAleatorio());
				coordenada.setY(geraAleatorio());
		}
		
		System.out.println("Todos os tripulantes foram encontrados com " + count + " sinalizadores!");


	}

	private static boolean verificaRange(int eixoX, Scanner in) {
		if (eixoX < 1 || eixoX > 10) {
			return false;
		}
		return true;
	}

	private static void mostraMapa(String[][] malha) {

		System.out.format("     ");
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
		}
	}

	private static int geraAleatorio() {
		int numero = 1 + (int) (Math.random() * 10);
		int aleatorio = Math.round(numero);
		return aleatorio;
	}

}
