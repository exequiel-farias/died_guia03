package died.guia03.ejercicio01;

import java.util.Objects;

public class Punto {
	private float x;
	private float y;
	
	public Punto(float x, float y) {
		super();
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object otroPunto) {
		if (this == otroPunto)
			return true;
		if (otroPunto == null)
			return false;
		if (getClass() != otroPunto.getClass())
			return false;
		Punto other = (Punto) otroPunto;
		return Float.floatToIntBits(x) == Float.floatToIntBits(other.x)
				&& Float.floatToIntBits(y) == Float.floatToIntBits(other.y);
	}
}
