package es.heladeria.helado;

public abstract class IngredienteImpl implements Ingrediente {

	private String descripcion;
	private float precio;

	protected void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	protected void setPrecio(float precio) {
		this.precio = precio;
	}

	public IngredienteImpl(String descripcion, float precio) {
		setDescripcion(descripcion);
		setPrecio(precio);
	}

	@Override
	public String getDescripcion() {
		return this.descripcion;
	}

	@Override
	public float getPrecio() {
		return this.precio;
	}

	@Override
	public String toString() {
		return getDescripcion();
	}

}
