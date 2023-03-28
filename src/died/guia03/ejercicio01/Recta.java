package died.guia03.ejercicio01;

import java.util.Objects;

public class Recta {
	private Punto p1;
	private Punto p2;
	
	public Recta(Punto p1, Punto p2) {
		super();
		this.p1 = p1;
		this.p2 = p2;
	}

	public Recta() {
		super();
		this.p1 = new Punto(0,0);
		this.p2 = new Punto(1,1);
	}

	public float pendiente() {
		return (this.p2.getY() - this.p1.getY())/(this.p2.getX() - this.p1.getX());
	}

	public boolean paralelas(Recta otraRecta) {
		return Float.floatToIntBits(this.pendiente()) == Float.floatToIntBits(otraRecta.pendiente());
	}

	@Override
	public int hashCode() {
		return Objects.hash(p1, p2);
	}

	@Override
	public boolean equals(Object otraRecta) {
		if (this == otraRecta)
			return true;
		if (otraRecta == null)
			return false;
		if (getClass() != otraRecta.getClass())
			return false;
		Recta other = (Recta) otraRecta;
		Recta aux = new Recta(this.p1, other.p2);
		return Float.floatToIntBits(this.pendiente()) == Float.floatToIntBits(aux.pendiente())
				&& Float.floatToIntBits(other.pendiente()) == Float.floatToIntBits(aux.pendiente());
	}
}
