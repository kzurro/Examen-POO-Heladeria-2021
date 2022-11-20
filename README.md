# Examen Fundamentos Java 4 (17-12-2021)

Vamos a crear algunas partes del código de una aplicación para servir helados.  

Durante todo el examen se debe observar la guía de estilo marcada en el curso y las buenas prácticas de programación recogidas en la [guía docente del curso], de lo contrario **podría ser penalizado hasta con un 10% de la nota**.  

Para poder realizar el examen es necesario usar el proyecto alojado en este repositorio. Haga un fork de este proyecto, póngalo con **visibilidad privado** y compruebe que está el repositorio correctamente en local. No siga hasta que haya puesto el repositorio en privado.  


**Los puntos evaluables, y ponderados con el valor entre paréntesis, son**:

1. (1 punto) Todo el código que implemente pertenecerá al paquete `es.heladeria.helado` excepto el que contenga el `main` que estará en la clase `es.heladeria.App`.
1. (1 punto) Cree la clase `CopaHelado` que podrá tener un ingrediente base y hasta tres (3) complementos. Se pide que el tipo de la variable para los complementos sea un array que no se pueda reasignar una vez asignado. El número máximo de complementos permitidos en la aplicación podrá modificarse en un futuro con solo un cambio.
1. (1 punto) La clase `CopaHelado` debe tener al menos un constructor por defecto y un constructor que admita un ingrediente base.
1. (1 puntos) El ingrediente base debe tener el método `getSabor()` que devolverá un `String` con el sabor del helado usado como base.
1. (2 puntos) Los ingredientes y complementos deberán tener el método `getDescripcion()` que devolverá un `String` con la descripción. También tendrán el método `getPrecio()` con el valor de cada ingrediente/complemento.
   > *NOTA: Las clases creadas irán mejorando el diseño a lo largo del examen para admitir librerias que permitan servir complementos externos, etc.*  
1. (1 puntos) Cree una constante con los siguientes objetos como complementos, pero no puede estar en el archivo con el `main`:
   > Descripción: `Virutas de chocolate`, Precio: `0,5€`  
     Descripción: `Galletitas`, Precio: `0,8€`  
1. (4 puntos) Para crear una copa de helado se puede utilizar cualquier base de cualquier sabor. Todas cuestan dos euros (2€), pero habrá una base por defecto que será de sabor `"Vainilla"`:  
    * (1 punto) Cree un helado con la base por defecto.
    * (2 punto) Intente añadirle cuatro (4) complementos creando un método con el nombre `addComplemento`. Éste método devolverá `true` si se ha añadido el complemento o `false` si no se ha podido (por ejemplo, por ya tener el máximo). Todos los complementos que añada procederán de la constante creada en el punto anterior.
    * (1 punto) Imprima por pantalla el resultado de irle añadiendo complementos y la copa de helado resultante. Debe quedarle este resultado:
```
Añadido Virutas de chocolate
Añadido Virutas de chocolate
Añadido Galletitas
NO añadido Galletitas
Copa de Helado de Vainilla con Virutas de chocolate, Virutas de chocolate y Galletitas
```
  > *NOTA: Tenga en cuenta el formato exacto usado: "Helado de {sabor base}[ con {enumeración de complementos, en su caso, separados por comas si hay más de dos y con una 'y' entre los dos últimos si hay mas de uno}]. El ejemplo muestra dos complementos de virutas y uno de galletitas*
8. (3 puntos) Ahora aprovecharemos complementos externos de la clase `com.github.extras.Extra`. Realice los cambios necesarios para instanciar complementos de esa clase. Hay una constante en la clase `Extra` con todos los complementos, añádalos a su constante de complementos y repita la prueba del punto anterior para ver el siguiente resultado:
```
Añadido Virutas de chocolate
Añadido Galletitas
Añadido Lemon
NO añadido Caramel
Copa de Helado de Vainilla con Virutas de chocolate, Galletitas y Lemon
```
9. (3 puntos) Se quiere que se puedan añadir ingredientes base también como complementos. Los ingredientes base realmente son bolas de helado de un sabor y se quiere que su descripción sea `"Bola de {sabor}"`. Para diferenciar los ingredientes que sirven como base de los complementos, ambos tendrán un método llamado `sirveComoBase` que devolverá `true` en caso de servir como base y `false` en caso contrario. No se puede asignar como base un ingrediente que no sirva como base, en ese caso se usaría  automáticamente la base por defecto. Repita la primera prueba usando una base distinta (`"Nata"`) y en un complemento un ingrediente base (`"Chocolate"`). El resultado por consola será:  
```
Copa de Helado de Nata con Bola de Chocolate y Caramel
```
10. (2 puntos) Se quiere que el **orden natural** de las copas de helado sea por precio descendente.
1. (3 puntos) Haga un comparador que ordene las copas de helado de la siguiente forma:
    1. por número de complementos de más a menos  
    1. si hay el mismo número de complementos se usará su orden natural  
```
Orden natural:
Copa de Helado de Nata con Bola de Chocolate y Caramel
Copa de Helado de Vainilla con Virutas de chocolate, Galletitas y Lemon

Orden con comparador:
Copa de Helado de Vainilla con Virutas de chocolate, Galletitas y Lemon
Copa de Helado de Nata con Bola de Chocolate y Caramel
```
12. (4 puntos) Se necesita que las descripciones y los precios sean de interfaces distintas, de esta forma, el tipo `CopaHelado` también tendrá el método `getPrecio()` que calcule el precio de cada helado en función de la suma de sus ingredientes y complementos.
1. (4 puntos) Por otra parte cree el método `imprimirCuenta` que imprimirá por consola cada producto que haya en una colección de helados, ingredientes o complementos que se le pase como argumento y usará los métodos de las interfaces anteriores para emitir un listado, incluyendo el total como el siguiente:  
```
--- Resumen de cuenta ---
Copa de Helado de Vainilla con Virutas de chocolate, Galletitas y Lemon: 3,50€
Caramel: 0,30€
Total 2 productos: 3,80
```
  
> *NOTA: Fíjese en las posiciones decimales y en el separador decimal usado*  

<hr>

### Entrega de examen
Acuérdese de hacer un **commit con el mensaje `Entrega examen`** con el último estado a guardar. Éste commit debe tener solo los ficheros necesarios, añadir binarios por ejemplo será considerado una mala práctica penalizable. Compruebe que su commit está subido a su fork y contiene los ficheros actualizados a final de examen.  

