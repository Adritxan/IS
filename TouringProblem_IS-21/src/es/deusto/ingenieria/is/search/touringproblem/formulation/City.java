package es.deusto.ingenieria.is.search.touringproblem.formulation;

import java.util.ArrayList;

//  Clase Ciudad con los atributos nombre, lista de ciudades accesibles y la posicion mediante x e y
public class City implements Cloneable{
	
	private String name;
	private int x;
	private int y;
	private ArrayList<City> ciudadesAccesibles = new ArrayList<City>();
	
	public City(String name, int x, int y) {
		super();
		this.name = name;
		this.x = x;
		this.y = y;
	}
		
	
	// Getters and setters de los atributos de la clase
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	/*Metodo que compara las ciudades de la lista que se pasa por parametro con la ciudad actual
	 * y si no esta se inserta en esa lista*/
	public void inicializarCiudadesAccesibles(ArrayList<City> lc){
		
		for(int i=0;i<lc.size();i++){
			if(!lc.get(i).equals(this)){
				ciudadesAccesibles.add(lc.get(i));
				
			}
		}
	}
	
	//Metodo para visualizar la lista de ciudades accesibles de una ciudad
	 public String visualizarCiudades(){
		  String c="";
		  for(int i=0;i<ciudadesAccesibles.size();i++)
		   c = c + ciudadesAccesibles.get(i).name+","; 
		  return c;
		 }
	 
	//Metodo toString que devuelve un String con los datos de la ciudad 
	public String toString(){
		return "City:"+name+"   x:"+x+" 	y:"+y+" 	Ciudades Accesibles: "+visualizarCiudades();
	}
	
	//COMMENT: Revisad si hay informacion de la Ciudad que no cambia nunca de una instancia a otra
	//para simplificar el equals().
	
	//Metodo equals para comparar ciudades
	public boolean equals(Object obj){
		if(obj != null && obj instanceof City && ((City)obj).name.equals(this.name)
				&& ((City)obj).x == this.x && ((City)obj).y == this.y
				&& ((City)obj).ciudadesAccesibles.equals(ciudadesAccesibles))
			return true;
		else{
			return false;
		}
	}
	
	//Crea y devuelve una copia del objeto de la clase actual
	@SuppressWarnings("unchecked")
	public Object clone() {
		City clon = null;
		
		try {
			clon = (City) super.clone();	
			clon.ciudadesAccesibles = (ArrayList<City>)this.ciudadesAccesibles.clone();
		} catch (CloneNotSupportedException e) {
			System.err.println("% [ERROR] City.clone(): " + e.getMessage());
		}
		
		return clon;		
	}

}
