// BLOQUE 1º: DECLARACIÓN DE CABECERA	*	Indica el paquete (`package`) donde se ubica la clase y las clases externas importadas (`import`)
package es.iesgalileo.dam.caja;


import java.math.BigDecimal; 
import java.math.RoundingMode; 


// BLOQUE 4º: COMENTARIOS Y DOCUMENTACIÓN	*	Textos de aclaración (`//`, `/* */`) y bloques Javadoc (`/** */`) destinados al programador y que el compilador ignora.

/** APP para la caja de la cafeteria del ies galileo, calcula el importe final basandose en las unidades vendidas y el precio unitario, teniendo en cuenta si es socio y aplicando iva... usando big decimal
 * @author PABLO MARTÍN VALLEJO / DAM 1º VESPERTINO
 * @version 2.0 con reto ampliacion big decimal
 */

public class CajaGalileo {
	


	
	// BLOQUE 5º: DECLARACIONES DE MIEMBROS	*	Atributos y constantes de clase (`static final`), definidos fuera de los métodos para ser accesibles por la clase.
	
	static final double IVA_HOSTELERIA = 0.1; // ambito de clase _ fuera de cualquier metodo para ser alcanzables desde cualquier sitio de la clase CajaGalileo
	static final double DESCUENTO_SOCIO = 0.05; // ambito de clase _ fuera de cualquier metodo para ser alcanzables desde cualquier sitio de la clase CajaGalileo
	
	static final BigDecimal IVA_HOSTELERIA_BD = new BigDecimal("0.10");
    static final BigDecimal DESCUENTO_SOCIO_BD = new BigDecimal("0.05");
	
	// BLOQUE 2º: PUNTO DE ENTRADA	*	El método obligatorio por el que la máquina virtual inicia la ejecución: `public static void main(String[] args)`
	
	/**
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) { // ambito de metodo local
		

		// BLOQUE 3º: PUNTO DE ENTRADA	*	Instrucciones y sentencias: Las órdenes ejecutables (declaraciones locales, cálculos, estructuras condicionales, salidas por consola) que van dentro del `main`.
		
		final String nombreProducto = "Colacao";	 // ambito local de metodo
		final var unidadesVendidas = 2; 			// ambito local de metodo, var porque es evidente el tipo de variable segun el valor
		final String precioTexto = "1.69";
		final double precioUnitario = Double.parseDouble(precioTexto); 		// ambito local de metodo
		final var esSocio = true;				 // ambito local de metodo, var porque es evidente el tipo de variable segun el valor
		final char categoriaProducto = 'B';		 // ambito local de metodo
		
		
		
		double subtotal = unidadesVendidas * precioUnitario;
		final double descuento = esSocio ? subtotal * DESCUENTO_SOCIO : 0.0;
		double totalDescontado = subtotal - descuento;
		double total = totalDescontado * (1 + IVA_HOSTELERIA);
		double cuotaIVA = total - totalDescontado;
		
		
		final BigDecimal precioUnitarioBD = new BigDecimal(precioTexto); // en bigdecimal nunca se usa double porque genera decimas, se usa o string o int
		final BigDecimal unidadesVendidasBD = new BigDecimal(unidadesVendidas);

		
		final BigDecimal subtotalBD = unidadesVendidasBD.multiply(precioUnitarioBD);
		
		final BigDecimal descuentoBD = esSocio ? subtotalBD.multiply(DESCUENTO_SOCIO_BD) : BigDecimal.ZERO;
		
		final BigDecimal totalDescontadoBD = subtotalBD.subtract(descuentoBD);
		final BigDecimal cuotaIVABD = totalDescontadoBD.multiply(IVA_HOSTELERIA_BD);
		final BigDecimal totalBD = totalDescontadoBD.add(cuotaIVABD).setScale(2, RoundingMode.HALF_UP);
		
		
		
		
		
		
		System.out.println("_-_-_ COMPROBACIÓN FASE 3 _-_-_");
		
		System.out.printf("Producto: %s %d .ud a %f %n %n", nombreProducto, unidadesVendidas, precioUnitario);

		System.out.printf("¿Es socio? %b %n %n", esSocio);

		
		System.out.printf("Total calculado por el programa: %f € %n %n", total);

		System.out.printf("Total esperado pago en mano: %.2f € %n %n", total);

		System.out.println("_-_-_ COMPROBACIÓN FASE 4 _-_-_");
		
		System.out.printf("Tique: %d x %s -> subtotal %.2f | descuento socio: -%.2f € | IVA: +%.2f € | TOTAL: %.2f € %n", unidadesVendidas, nombreProducto, subtotal, descuento, cuotaIVA, total);
		
		System.out.println("_-_-_ COMPROBACIÓN FASE RETO BIG DECIMAL _-_-_");
		
		System.out.printf("subtotal bd: %s € | descuento bd: %s € | IVA bd: %s € | TOTAL EXACTO: %s € %n", subtotalBD, descuentoBD, cuotaIVABD, totalBD);
		
		// demostracion imprecision al no usar BigDecimal
		
		System.out.println("_-_-_ DEMOSTRACIÓN DE IMPRECISIÓN IEEE-754 _-_-_");
        
        double sumaDouble = 0.0;
        BigDecimal sumaBD = BigDecimal.ZERO;
        final BigDecimal incrementoBD = new BigDecimal("0.10");

        // Sumar 0.10 € 100 veces consecutivas
        for (int i = 0; i < 100; i++) {
            sumaDouble += 0.10;
            sumaBD = sumaBD.add(incrementoBD);
        }

        System.out.printf("Sumar 0.10 € 100 veces con double:     %.17f € %n", sumaDouble);
        System.out.printf("Sumar 0.10 € 100 veces con BigDecimal: %s € %n", sumaBD);
		
	}

}
