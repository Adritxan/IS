package es.deusto.ingenieria.is.search.touringproblem.formulation;

import es.deusto.ingenieria.is.search.formulation.Problem;
import es.deusto.ingenieria.is.search.formulation.State;
import es.deusto.ingenieria.is.search.xml.StateXMLReader;

public class TravelingSalesmanProblem extends Problem {
	
	//Constructor del problema del tour problem
	public TravelingSalesmanProblem() {
		super();
		this.createOperators();
	}

	/*
	 * Metodo que crea un nuevo objeto MapReader que envia
	 * por parametro el archivo xml que vamos a leer
	 * y devuelve el estado que crea un EnviromentMap
	 */
	public State gatherInitialPercepts() {
		StateXMLReader stateXMLReader = new MapReader("data/tourProblem1.xml"); 								
		return stateXMLReader.getState();
	}	
	
	
	/*FinalState se consigue cuando la lista de citiesVisited tiene los mismos elementos que la lista de cities 
	* y ademas el ultimo de citiesVisited es la city Z
	*/
	public boolean isFinalState(State state){
		EnvironmentMap environment = (EnvironmentMap)state;
		
		//COMMENT: ¿que pasaria si se cambia la ciudad final de nombre y o posicion en el XML? Esta comparacion
		//No funciona.
		if(environment.getCitiesVisited().equals(environment.getCities()) 
				&& environment.getCitiesVisited().get(environment.getCitiesVisited().size()-1).equals(new City("Z",15,5)))
			return true;
		else
			return false;
	}
	
	/*Metodo que calcula la distancia total recorrida hasta el momento con las ciudades 
	 * almacenadas en la lista parcial*/
	public double calcularDistanciaTotal(State state){
		  double totalDistance=0,distance=0;
		  City city1=null;
		  City city2=null;
		  EnvironmentMap environment = (EnvironmentMap) state;
		  
		  for(int i=0; i<environment.getCitiesVisited().size()-1;i++){
		   city1 = environment.getCitiesVisited().get(i);
		   city2 = environment.getCitiesVisited().get(i+1);
		   distance = Math.sqrt((Math.pow(city1.getX()-city2.getX(), 2))+(Math.pow(city1.getY()-city2.getY(), 2)));
		   totalDistance = totalDistance + distance;
		  } 
		  return totalDistance;
		 }
	
	/*Crea los operadores necesarios para asignarlos a la instancia del problema*/
	
	//COMMENT: Esta creacion esta mal ya que pasando null el operador no funcionara.
	private void createOperators(){
		this.addOperator(new AddCity(null));
		System.out.println("Entra en el createOperators");
	}	
}
