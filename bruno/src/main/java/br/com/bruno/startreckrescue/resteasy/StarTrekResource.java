package br.com.bruno.startreckrescue.resteasy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.bruno.startreckrescue.facade.StarTrekFacade;
import br.com.bruno.startreckrescue.util.Auxi;

@Path("star-trek")
public class StarTrekResource {
	
	private StarTrekFacade starTrekFacade;
	private Auxi aux;
	
	public StarTrekFacade getStarTrekFacade(){
		
		this.starTrekFacade = new StarTrekFacade();
		
		return this.starTrekFacade; 
	}
			
	@GET
	@Path("x/{x}/y/{y}")
	@Produces("application/json")
	public String getById(@PathParam("x") String x, @PathParam("y") String y ){
		
		String r = null;
		
		int xInt = Integer.parseInt(x);
		int yInt = Integer.parseInt(y);
		int contador = 0;
		if (aux.verificaRange(xInt) == false){
			
		}
		else if (aux.verificaRange(yInt) == false){
			
		}
		else{
			
			do {
				if (getStarTrekFacade().encontraTripulante(Auxi.malha, xInt, yInt)) {
					Auxi.mostraMapa(Auxi.malha);
					contador++;
				} else {
					Auxi.count++;
					Auxi.mostraMapa(Auxi.malha);
				}
			} while (contador < Auxi.numJogadas);
		
			/*while (getStarTrekFacade().encontraTripulante(Auxi.malha, xInt, yInt) == false){
				getStarTrekFacade().setX();
				getStarTrekFacade().setY();
			}*/
		}
		//r = Auxi.mostraMapa(Auxi.malha);
		return Auxi.exibeMapaFinal();
	}
	
	
}
