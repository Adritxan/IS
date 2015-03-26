package es.deusto.ingenieria.is.search.touringproblem.formulation;

import java.util.ArrayList;

import es.deusto.ingenieria.is.search.formulation.State;


public class EnvironmentMap extends State implements Cloneable{
	
	 /* Atributo donde almacenamos todas las ciudades existentes en el entorno 
	 * incluyendo la inicial y la final
	 */
	private ArrayList<City> cities = new ArrayList<City>();
	
	//Lista parcial de ciudades visitadas
	private ArrayList<City> citiesVisited = new ArrayList<City>();	
	
	//Constructor de la clase que recibe por parametro una lista de ciudades
	public EnvironmentMap(ArrayList<City> cities) {
		this.cities = cities;
		inicializarCiudadesAccesibles();
		setFirstCity();
	}
	
	//Metodo que anyade la ciudad inicial a la lista parcial
	public void setFirstCity(){
		citiesVisited.add(cities.get(0));
	}
	
	public ArrayList<City> getCities() {
		return cities;
	}

	public ArrayList<City> getCitiesVisited() {
		return citiesVisited;
	}

	
	
	/*Metodo que llama al inicializarCiudadesAccesibles de la clase City para comprobar y cargar la lista
	 *  total de ciudades*/
	public void inicializarCiudadesAccesibles(){
		//System.out.println(cities.size());
		for(int i=0;i<cities.size();i++){
			cities.get(i).inicializarCiudadesAccesibles(cities);
		}
	}
	
	//Metodo que añade una ciudad a la lista parcial de ciudades visitadas
	public void añadirciudad(City c){
		citiesVisited.add(c);
	}
	
	
	/*
	 * Metodo toString que devuelve un string con todas las ciudades existentes 
	 * en la lista de ciudades
	 */
	public String toString(){
		String c="";
		for(int i=0;i<cities.size();i++)
			c = c + cities.get(i).toString()+"\n";
		return c;
	}

	//COMMENT: Aqui otra vez teneis que comparar la info que verdaderamente pueda cambiar en el entorno.
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj!=null && obj instanceof EnvironmentMap && ((EnvironmentMap)obj).cities.equals(this.cities))
			return true;
		else
			return false;
	}
	
	/*Metodo que crea una copia de un objeto*/
	@SuppressWarnings("unchecked")
	public Object clone() {
		EnvironmentMap clon = null;
		
		try {
			clon = (EnvironmentMap) super.clone();
			clon.cities = (ArrayList<City>)this.cities.clone();
			clon.citiesVisited = (ArrayList<City>)this.citiesVisited.clone();
		
		} catch (CloneNotSupportedException e) {
			System.err.println("% [ERROR] EnvironmentMap.clone(): " + e.getMessage());
		}		
		return clon;		
	}
	
	
}
