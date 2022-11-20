package es.heladeria.helado;

public interface Ingrediente extends ConDescripcion, ConPrecio {

	default boolean sirveComoBase() {
		return false;
	}

}
