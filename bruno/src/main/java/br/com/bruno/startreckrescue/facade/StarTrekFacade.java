package br.com.bruno.startreckrescue.facade;

import java.io.Serializable;

import br.com.bruno.startreckrescue.dao.StarTrekDAO;



public class StarTrekFacade implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private StarTrekDAO starTrekDAO = new StarTrekDAO();

	public boolean encontraTripulante(String [][] mapaDaRegiao, int eixoX, int eixoY){
		return starTrekDAO.encontraTripulante(mapaDaRegiao, eixoX, eixoY);
	}
	
	public void setX(){
		starTrekDAO.setX();
	}
	
	public void setY(){
		starTrekDAO.setY();
	}
	
}
