package es.heladeria.helado;

public class IngredienteBase extends IngredienteImpl {
	private static final float PRECIO_BASE = 2f;
	private String sabor;

	public String getSabor() {
		return sabor;
	}

	protected void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public IngredienteBase(String sabor) {
		super("Bola de " + sabor, PRECIO_BASE);
		setSabor(sabor);
	}

	@Override
	public boolean sirveComoBase() {
		return true;
	}

}
