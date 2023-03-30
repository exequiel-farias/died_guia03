package died.guia03.ejercicio02;

public class Temperatura {
	private double grados;
	private Escala escala;

	public Temperatura() {
		super();
		this.grados = 0;
		this.escala = Escala.CELCIUS;
	}

	public Temperatura(double grados, Escala escala) {
		super();
		this.grados = grados;
		this.escala = escala;
	}

	@Override
	public String toString() {
		String escala = (this.escala == Escala.CELCIUS) ? " C°" : " F°";
		return this.grados + escala;
	}

	public double asCelcius() {
		if(this.escala == Escala.CELCIUS) return this.grados;
		return (this.grados - 32) * 5 / 9;
	}

	public double asFahrenheit() {
		if(this.escala == Escala.FAHRENHEIT) return this.grados;
		return this.grados * 9 / 5 + 32;
	}

	public void aumentar(Temperatura temperatura) {
		if(Double.doubleToLongBits(temperatura.grados) <= Double.doubleToLongBits(0.0)) return;
		if(this.escala == temperatura.escala) this.grados += temperatura.grados;
		else{
			double temp = (temperatura.escala == Escala.CELCIUS) ? temperatura.asFahrenheit() : temperatura.asCelcius();
			this.grados += temp;
		}
	}

	public void disminuir(Temperatura temperatura) {
		if(Double.doubleToLongBits(temperatura.grados) <= Double.doubleToLongBits(0.0)) return;
		if(this.escala == temperatura.escala) this.grados -= temperatura.grados;
		else{
			double temp = (temperatura.escala == Escala.CELCIUS) ? temperatura.asFahrenheit() : temperatura.asCelcius();
			this.grados -= temp;
		}
	}
}
