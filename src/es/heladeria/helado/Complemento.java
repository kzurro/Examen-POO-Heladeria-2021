package es.heladeria.helado;

import java.util.ArrayList;
import java.util.List;

import com.github.extras.Extra;

public class Complemento extends IngredienteImpl {

	public static final List<Ingrediente> EXTRAS;// = Arrays.asList(new Complemento("Virutas de Chocolate", .5f), new
													// Complemento("Galletitas", .8f));

	static {
		EXTRAS = new ArrayList<Ingrediente>();

		Complemento complemento = new Complemento("Virutas de Chocolate", .5f);
		Complemento complemento2 = new Complemento("Galletitas", .8f);
		// ComplementoExterno complemento3 = new
		// ComplementoExterno(Extra.EXTRAS[0].getDescription(),
		// Extra.EXTRAS[0].getPrice());
		EXTRAS.add(complemento);
		EXTRAS.add(complemento2);
		// EXTRAS.add(complemento3);
		for (int i = 0; i < Extra.EXTRAS.length; i++) {
			ComplementoExterno complementoExterno = new ComplementoExterno(Extra.EXTRAS[i].getDescription(),
					Extra.EXTRAS[i].getPrice());
			EXTRAS.add(complementoExterno);
		}

	}

	public Complemento(String descripcion, float precio) {
		super(descripcion, precio);
	}

}
