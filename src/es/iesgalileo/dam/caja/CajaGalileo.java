// BLOQUE 1º: DECLARACIÓN DE CABECERA	*	Indica el paquete (`package`) donde se ubica la clase y las clases externas importadas (`import`)
package es.iesgalileo.dam.caja;

// BLOQUE 4º: COMENTARIOS Y DOCUMENTACIÓN	*	Textos de aclaración (`//`, `/* */`) y bloques Javadoc (`/** */`) destinados al programador y que el compilador ignora.

/** APP para la caja de la cafeteria del ies galileo, calcula el importe final basandose en las unidades vendidas y el precio unitario, teniendo en cuenta si es socio y aplicando iva...
 * @author PABLO MARTÍN VALLEJO / DAM 1º VESPERTINO
 * @version 1.0
 */

public class CajaGalileo {
	


	
	// BLOQUE 5º: DECLARACIONES DE MIEMBROS	*	Atributos y constantes de clase (`static final`), definidos fuera de los métodos para ser accesibles por la clase.
	
	static final double IVA_HOSTELERIA = 0.1; // ambito de clase _ fuera de cualquier metodo para ser alcanzables desde cualquier sitio de la clase CajaGalileo
	static final double DESCUENTO_SOCIO = 0.05; // ambito de clase _ fuera de cualquier metodo para ser alcanzables desde cualquier sitio de la clase CajaGalileo
	
	// BLOQUE 2º: PUNTO DE ENTRADA	*	El método obligatorio por el que la máquina virtual inicia la ejecución: `public static void main(String[] args)`
	
	/**
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) { // ambito de metodo local
		

		// BLOQUE 3º: PUNTO DE ENTRADA	*	Instrucciones y sentencias: Las órdenes ejecutables (declaraciones locales, cálculos, estructuras condicionales, salidas por consola) que van dentro del `main`.
		
		String nombreProducto = "Colacao";	 // ambito local de metodo
		var unidadesVendidas = 2; 			// ambito local de metodo, var porque es evidente el tipo de variable segun el valor
		String precioTexto = "1.69";
		double precioUnitario = Double.parseDouble(precioTexto); 		// ambito local de metodo
		var esSocio = true;				 // ambito local de metodo, var porque es evidente el tipo de variable segun el valor
		char categoriaProducto = 'B';		 // ambito local de metodo
		
		
		
		double subtotal = unidadesVendidas * precioUnitario;
		
		
		double descuento = 0.0;
		
		
		if (esSocio) {

			descuento = subtotal * DESCUENTO_SOCIO;
			
		}
		
		double totalDescontado = subtotal - descuento;
		
		double total = totalDescontado * (1 + IVA_HOSTELERIA);
		
		double cuotaIVA = total - totalDescontado;
		
		// 	double totalEnUnaLinea = ((unidadesVendidas * precioUnitario) - (esSocio ? (unidadesVendidas * precioUnitario * DESCUENTO_SOCIO) : 0.0)) * (1 + IVA_HOSTELERIA);
		
		/* 
		Calculo manual previo de FASE 3º
		 
		 caso 1:
		 	
		 	
		 	1º subtotal: 2 * 1,69 = 3,38€
		 	
		 	2º descuento se queda en %0 0.00
		 	
		 	3º total descontado: 3,38€
		 	
		 	4º total con iva %10: 3,38 * 1,10 = 3,718€
		 	
		 
		 caso 2:
		 
		 
		 	1º subtotal: 2 * 1,69 = 3,38€
		 	
		 	2º descuento se queda en %5: 3,38 * 0.05 = 0,169€
		 	
		 	3º total descontado: 3,38 - 0,169 = 3,211€
		 	
		 	4º total con iva %10: 3,211 * 1,10 = 3,5321€		 
		 */
		
		
		System.out.println("_-_-_ COMPROBACIÓN FASE 3 _-_-_");
		
		System.out.printf("Producto: %s %d .ud a %f %n %n", nombreProducto, unidadesVendidas, precioUnitario);

		System.out.printf("¿Es socio? %b %n %n", esSocio);

		
		System.out.printf("Total calculado por el programa: %f € %n %n", total);

		System.out.printf("Total esperado pago en mano: %.2f € %n %n", total);

		System.out.println("_-_-_ COMPROBACIÓN FASE 4 _-_-_");
		
		System.out.printf("Tique: %d x %s -> subtotal %.2f | descuento socio: -%.2f € | IVA: +%.2f € | TOTAL: %.2f € %n", unidadesVendidas, nombreProducto, subtotal, descuento, cuotaIVA, total);
		
		

		
	}

}
