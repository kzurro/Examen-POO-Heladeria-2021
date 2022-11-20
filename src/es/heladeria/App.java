package es.heladeria;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import es.heladeria.helado.Complemento;
import es.heladeria.helado.ComplementoExterno;
import es.heladeria.helado.ConDescripcion;
import es.heladeria.helado.ConPrecio;
import es.heladeria.helado.CopaHelado;
import es.heladeria.helado.Ingrediente;
import es.heladeria.helado.IngredienteBase;

public class App {

	public static void main(String[] args) {
		System.out.println("INICIO EXAMEN");

		System.out.println(Complemento.EXTRAS.get(1));

		System.out.println("--------------------");

		CopaHelado heladoDefault = new CopaHelado();

		System.out.println(heladoDefault.getIngredienteBase());
		System.out.println(heladoDefault.getIngredienteBase().getPrecio());

		System.out.println("--------------------");

		System.out.println(heladoDefault.addComplemento(Complemento.EXTRAS.get(0)));
//		System.out.println(heladoDefault.addComplemento(Complemento.EXTRAS.get(0)));
//		System.out.println(heladoDefault.addComplemento(Complemento.EXTRAS.get(1)));
//		System.out.println(heladoDefault.addComplemento(Complemento.EXTRAS.get(1)));

		System.out.println(heladoDefault.addComplemento(Complemento.EXTRAS.get(0), Complemento.EXTRAS.get(0)));

		for (Ingrediente i : heladoDefault.getComplementos()) {
			System.out.println(i);
		}

		System.out.println("--------------------");

		CopaHelado helado = new CopaHelado();
		Ingrediente virutas = Complemento.EXTRAS.get(0);
		anadirCompletoEnHelado(virutas, helado);
		anadirCompletoEnHelado(virutas, helado);
		anadirCompletoEnHelado(Complemento.EXTRAS.get(1), helado);
		anadirCompletoEnHelado(Complemento.EXTRAS.get(1), helado);
		System.out.println(helado.toString());

		System.out.println("--------------------");

		CopaHelado helado2 = new CopaHelado();

		anadirCompletoEnHelado(virutas, helado2);
		anadirCompletoEnHelado(Complemento.EXTRAS.get(1), helado2);
		anadirCompletoEnHelado(Complemento.EXTRAS.get(2), helado2);
		anadirCompletoEnHelado(Complemento.EXTRAS.get(3), helado2);
		System.out.println(helado2.toString());

		System.out.println("--------------------");

		IngredienteBase nata = new IngredienteBase("Nata");
		CopaHelado heladoNata = new CopaHelado(nata);
		heladoNata.addComplemento(new IngredienteBase("Chocolate"));
		heladoNata.addComplemento(Complemento.EXTRAS.get(3));

		System.out.println(heladoNata.toString());

		System.out.println("--------------------");

		List<CopaHelado> listaHelados = new ArrayList<>();

		listaHelados.add(heladoNata);
		listaHelados.add(helado2);
		listaHelados.add(helado);
		listaHelados.add(heladoDefault);

		listaHelados.forEach(c -> System.out.println(c.toString() + " " + c.getPrecio() + "€"));

		System.out.println("--------------------");
		listaHelados.sort(null);
		System.out.println("Mostrar lista ordenada por precio descendente orden natural");

		listaHelados.forEach(c -> System.out.println(c.toString() + " " + c.getPrecio() + "€"));
		System.out.println("--------------------");
		System.out.println("Mostrar lista ordenada por Comparador");

		Comparator<CopaHelado> comparador = new Comparator<CopaHelado>() {

			@Override
			public int compare(CopaHelado o1, CopaHelado o2) {
				int comparacion = 0;
				comparacion = o2.numeroDeComplementos() - o1.numeroDeComplementos();

				if (comparacion == 0) {
					comparacion = o1.compareTo(o2);
				}

				return comparacion;
			}

		};

		listaHelados.sort(comparador);

		listaHelados.forEach(c -> System.out.println(c.toString() + " " + c.getPrecio() + "€"));

		System.out.println("--------------------");

		imprimirCuenta(listaHelados);
		
		System.out.println("--------------------");
		
		
		
		imprimirCuenta(Arrays.asList(helado2, Complemento.EXTRAS.get(3)));
		
		
		

	}

	private static <T extends ConPrecio & ConDescripcion> void imprimirCuenta(Collection<? extends T> productos) {
		System.out.println("--- Resumen de cuenta ---");

		for (T producto : productos) {
			System.out.println(producto.getDescripcion() + ": " + stringDeFloatEnCentimos(producto.getPrecio()) + "€");
		}

		System.out.println("Total " + productos.size() + " productos: " + stringDeFloatEnCentimos(calcularPrecio(productos)) + "€");

	}

	private static <T extends ConPrecio> float calcularPrecio(Collection<? extends T> productos) {
		float sumaPreciosProductos = 0f;
		for (T producto : productos) {
			sumaPreciosProductos += producto.getPrecio();

		}

		return sumaPreciosProductos;
	}

	private static void anadirCompletoEnHelado(Ingrediente ingrediente, CopaHelado helado) {
		System.out.println((helado.addComplemento(ingrediente) ? "Añadido " : "NO añadido ") + ingrediente.toString());
	}
	
	private static String stringDeFloatEnCentimos(float precio) {
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		
		return decimalFormat.format(precio);
	}

}
