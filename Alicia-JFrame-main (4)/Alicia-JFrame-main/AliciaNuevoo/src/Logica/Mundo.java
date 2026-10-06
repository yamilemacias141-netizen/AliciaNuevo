package Logica;
import java.util.ArrayList;

public class Mundo 
{
	private ArrayList <Personaje>losPersonajes=new ArrayList<>();
	
	public Mundo()
	{
		
	}
	public void agregarPersonajes(Personaje p)
	{
		losPersonajes.add(p);
	}
	
	public ArrayList<Personaje> personajesLindos()
	{
		ArrayList<Personaje> lindos = new ArrayList<>();
		for (Personaje p:losPersonajes)
		{
			if (p.esLindo() == true)
			{
				lindos.add(p);
			}
			
		}
		return lindos;
	}
	
	
	
	public boolean  hayPersonajesNormales()
	{
		for (Personaje p:losPersonajes)
		{
			if (p.esNormal()==true)
			{
				return true;
			}
	
		}
		return false;
	}
	
	public int personajesEnMaravilla()
	{
		int cantidad = 0;
	    for (Personaje p:losPersonajes)
		{
			if(p.estaEnElMundoMaravilla())
			{
				cantidad++;
			}
		}
	    return cantidad;
	}
	
	public Personaje personajeMasLoco()
	{
		Personaje masLoco = losPersonajes.get(0);
		for(Personaje p:losPersonajes)
		{
			if(p.getNivelLocura() > masLoco.getNivelLocura())
			{
				masLoco = p;
			}
		}
		return masLoco;
	}
	
	public boolean hayMasNormales()
	{
		int lindos = 0;
		int normales = 0;
		
		for(Personaje p:losPersonajes)
		{
			if(p.esLindo())
			{
				lindos++;
			}
			if(p.esNormal())
			{
				normales++;
			}
		}
		if(normales > lindos)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int cuantosPersonajesLindos()
	{
		int cantidad = 0;
		for (Personaje p: losPersonajes)
		{
			if(p.esLindo())
			{
				cantidad++;
			}
		}
		return cantidad;
	}
	
	public ArrayList<Personaje> personajesNormales()
	{
		ArrayList<Personaje> normales = new ArrayList<>();
		for ( Personaje p: losPersonajes)
		{
			if(p.esNormal())
			{
				normales.add(p);
			}
		}
		return normales;
	}
	
	public ArrayList<Personaje> getPersonajes()
	{
		return losPersonajes;
	}

		
	
	

}
