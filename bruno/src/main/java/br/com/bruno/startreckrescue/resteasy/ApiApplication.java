package br.com.bruno.startreckrescue.resteasy;

import java.util.Set;
import java.util.HashSet;

import javax.ws.rs.core.Application;

public class ApiApplication extends Application {
	@Override
	public Set<Class<?>> getClasses(){
		Set<Class<?>> s = new HashSet<Class<?>>();
		s.add(StarTrekResource.class);
		
		return s;
	}
}
