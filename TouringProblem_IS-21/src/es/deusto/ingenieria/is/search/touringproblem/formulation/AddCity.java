package es.deusto.ingenieria.is.search.touringproblem.formulation;

import es.deusto.ingenieria.is.search.formulation.Operator;
import es.deusto.ingenieria.is.search.formulation.State;

public class AddCity extends Operator{

	private City city;
	
	public AddCity(City city) {
		this.city = city;
		
		// Donde pone el 1d, tenemos que poner el coste que supone mover esa ciudad 
		//super("Add City", 1d);
	}
	
	@Override
	public boolean isApplicable(State state) {
		// TODO Auto-generated method stub
		EnvironmentMap environment = (EnvironmentMap) state;
		
		//Comprobación de si una ciudad está en la lista parcial de ciudades visitadas
		// Comprobamos tambien que el ultimo no sea END
		
		//COMMENT: Otra vez usais una constante para comparar la info de una ciudad.
		//Ademas el operador para la primera y ultima ciudad tienen que comportarse de forma
		//diferente ya que tienen que ejecutarse obligatoriamente el primero y el ultimo
		if(!environment.getCitiesVisited().contains(city)){
			if(!environment.getCitiesVisited().get(environment.getCitiesVisited().size()-1).equals(new City("Z",15,5))){
				return true;
			}else{ 
				return false;
			}
		}else{
			return false;
		}
		
	}
	
	@Override
	public State effect(State state) {
		// TODO Auto-generated method stub
		//Comprobación de si una ciudad está en la lista parcial de ciudades visitadas
		// Comprobamos tambien que el ultimo insertado no sea END
		//Si ambas se cumplen añadimos la nueva ciudad a la lista parcial de ciudades visitadas
		EnvironmentMap environment = (EnvironmentMap)((EnvironmentMap) state).clone();
		if(!environment.getCitiesVisited().contains(city))
			
			//COMMENT: Otra vez la comparacion con una constante
			if(!environment.getCitiesVisited().get(environment.getCitiesVisited().size()-1).equals(new City("Z",15,5))){
				environment.añadirciudad(city);
			}
		
		//COMMENT: Aqui teneis que calcular el coste del operador.
		return environment;
	}
}
