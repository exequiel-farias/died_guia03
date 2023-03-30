package died.guia03.ejercicio03;

import died.guia03.ejercicio02.Temperatura;

public class Registro {
	private String ciudad;
	private Temperatura[] historico;
	private int indiceActual = 0;
	
	public Registro() {
		super();
		this.ciudad = "-";
		this.historico = new Temperatura[30];
	}
	
	public Registro(String ciudad) {
		super();
		this.ciudad = ciudad;
		this.historico = new Temperatura[30];
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public void imprimir() {
		System.out.println("TEMPERATURA REGISTRADAS EN : "+this.ciudad);
		for(int i=0;i < this.indiceActual;i++) System.out.println((i+1) + " " + this.historico[i].toString());
	}
	
	public void agregar(Temperatura t) {
		if(this.indiceActual < this.historico.length) {
			this.historico[this.indiceActual] = t;
			this.indiceActual++;
		}
	}
	
	public double mediaAsCelcius() {
		double sum = 0;
		for(int i=0; i < this.indiceActual; i++) sum += this.historico[i].asCelcius();
		double media = sum / this.indiceActual;
		return media;
	}
	
	public double mediaAsFahrenheit() {
		double sum = 0;
		for(int i=0; i < this.indiceActual; i++) sum += this.historico[i].asFahrenheit();
		double media = sum / this.indiceActual;
		return media;
	}
	
	public Temperatura maximo() {
		return maximo(this.historico[0],1);
	}
	
	private Temperatura maximo(Temperatura max, int indice) {
		if(indice == this.indiceActual - 1) 
			return (this.historico[indice].asCelcius() > max.asCelcius()) ? this.historico[indice] : max;
		else {
			if(this.historico[indice].asCelcius() > max.asCelcius()) return maximo(this.historico[indice], indice+1);
			else return maximo(max, indice+1);
		}
	}
}
