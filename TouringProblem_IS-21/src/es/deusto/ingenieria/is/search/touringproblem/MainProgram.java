package es.deusto.ingenieria.is.search.touringproblem;

import es.deusto.ingenieria.is.search.touringproblem.formulation.AddCity;
import es.deusto.ingenieria.is.search.touringproblem.formulation.City;
import es.deusto.ingenieria.is.search.touringproblem.formulation.EnvironmentMap;
import es.deusto.ingenieria.is.search.touringproblem.formulation.TravelingSalesmanProblem;


public class MainProgram{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*
		 * Creamos un objeto TravelinSalesmanProblem para leer mediante 
		 * la clase MapReader el arcivo xml, y mediante esto podemos crear 
		 * nuestro EnviromentMap
		 */
		TravelingSalesmanProblem tsp = new TravelingSalesmanProblem();
		EnvironmentMap environment = (EnvironmentMap)tsp.gatherInitialPercepts();
		
		
		/*
		 * Mostramos por pantalla que la lista de EnviromentMap recibe todas las ciudades
		 * del xml
		 */
		System.out.println(environment.toString());
		
		/*Ejemplo en el que anyadimos un par de ciudades para comprobar que el isApplicable y el
		 * effect funcionan*/
		AddCity ac;
		boolean test;
		EnvironmentMap nuevo;
		
		ac = new AddCity(new City("A",3,2));
		test = ac.isApplicable(environment);
		System.out.println(test);
		nuevo = (EnvironmentMap) ac.effect(environment);
		
		ac = new AddCity(new City("Z",15,5));
		test = ac.isApplicable(nuevo);
		System.out.println(test);
		nuevo = (EnvironmentMap) ac.effect(nuevo);
		
		ac = new AddCity(new City("Z",15,5));
		test = ac.isApplicable(nuevo);
		System.out.println(test);
		nuevo = (EnvironmentMap) ac.effect(nuevo);
		
		System.out.println(nuevo.getCitiesVisited().size());
		
		for(int i=0;i<nuevo.getCitiesVisited().size();i++){
			System.out.println(nuevo.getCitiesVisited().get(i).toString());
		}
		
	}

}
