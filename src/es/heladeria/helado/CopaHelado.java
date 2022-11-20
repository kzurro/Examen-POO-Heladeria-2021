package es.heladeria.helado;

public class CopaHelado implements ConDescripcion, ConPrecio, Comparable<CopaHelado> {
	private static final int COMPLEMENTOS_MAXIMO = 3;
	private static final IngredienteBase BASE_DEFAULT = new IngredienteBase("Vainilla");
	private IngredienteBase ingredienteBase;
	private final Ingrediente[] complementos;

	public IngredienteBase getIngredienteBase() {
		return ingredienteBase;
	}

	public Ingrediente[] getComplementos() {
		return complementos;
	}

	protected void setIngredienteBase(IngredienteBase ingredienteBase) {
		 if (ingredienteBase.sirveComoBase()) {
		      this.ingredienteBase = ingredienteBase;
		    } else {
		      this.ingredienteBase = BASE_DEFAULT;
		    }
		  }

	public CopaHelado() {
		this(BASE_DEFAULT);
	}

	public CopaHelado(IngredienteBase base) {
		setIngredienteBase(base);
		this.complementos = new Ingrediente[COMPLEMENTOS_MAXIMO];

	}

	public boolean addComplemento(Ingrediente ingrediente) {
		boolean anadido = false;
		int numeroDeComplementos = numeroDeComplementos();
		if (numeroDeComplementos < getComplementos().length) {
			getComplementos()[numeroDeComplementos] = ingrediente;// [0,1,2]
			anadido = true;
		}

		return anadido;

	}

	public boolean addComplemento(Ingrediente... ingredientes) {
		boolean anadido = true;

		for (Ingrediente ingrediente : ingredientes) {
			anadido = addComplemento(ingrediente);
		}

		return anadido;
	}

//	public boolean addComplemento(Ingrediente ingrediente, Ingrediente ingrediente2) {
//		boolean anadido = addComplemento(ingrediente);
//		anadido = addComplemento(ingrediente2);
//
//		return anadido;
//	}
//
//	public boolean addComplemento(Ingrediente ingrediente, Ingrediente ingrediente2, Ingrediente ingrediente3) {
//		boolean anadido = addComplemento(ingrediente);
//		anadido = addComplemento(ingrediente2);
//		anadido = addComplemento(ingrediente3);
//		return anadido;
//	}
//
//	public boolean addComplemento(Ingrediente[] ingredientes) {
//		boolean anadido = true;
//
//		for (int i = 0; i < ingredientes.length; i++) {
//			anadido = addComplemento(ingredientes[i]);
//		}
//
//		return anadido;
//	}

	public int numeroDeComplementos() {

		int numeroComplementos = 0;
		for (Ingrediente ingrediente : getComplementos()) {
			if (ingrediente != null) {
				numeroComplementos++;
			}
		}

		return numeroComplementos;
	}

	// Copa de Helado de Vainilla con Virutas de chocolate, Virutas de chocolate y
	// Galletitas

	@Override
	public String getDescripcion() {
		String complementos = "";
		int numeroComplementos = numeroDeComplementos();
		if (numeroComplementos > 0) {
			complementos += " con ";
			if (numeroComplementos == 1) {
				complementos = complementos + getComplementos()[0];
			} else {
				for (int i = 0; i < numeroComplementos - 1; i++) {
					complementos = complementos + getComplementos()[i] + ", ";

				}
			}
			if (numeroComplementos > 1) {
				complementos = complementos.substring(0, complementos.length() - 2) + " y "
						+ getComplementos()[numeroComplementos - 1];
			}
		}

		return "Copa de Helado de " + getIngredienteBase().getSabor() + complementos;
	}

	@Override
	public float getPrecio() {
		float total = getIngredienteBase().getPrecio();

		for (int i = 0; i < getComplementos().length; i++) {
			if (getComplementos()[i] != null) {
				total += getComplementos()[i].getPrecio();
			}
		}

		return total;
	}

	@Override
	public int compareTo(CopaHelado otraCopahelado) {

		return -Float.compare(getPrecio(), otraCopahelado.getPrecio());
	}

	@Override
	public String toString() {

		return getDescripcion();
	}

}
