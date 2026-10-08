package es.iesgalileo.dam.caja;


public class CajaGalileo {
	
	
	static final double IVA_HOSTELERIA = 0.1; // ambito de clase _ fuera de cualquier metodo para ser alcanzables desde cualquier sitio de la clase CajaGalileo
	static final double DESCUENTO_SOCIO = 0.05; // ambito de clase _ fuera de cualquier metodo para ser alcanzables desde cualquier sitio de la clase CajaGalileo
	
	
	public static void main(String[] args) { // ambito de metodo local
		
		
		String nombreProducto = "Colacao";	 // ambito local de metodo
		var unidadesVendidas = 2; 			// ambito local de metodo, var porque es evidente el tipo de variable segun el valor
		double precioUnitario = 1.69; 		// ambito local de metodo
		var esSocio = false;				 // ambito local de metodo, var porque es evidente el tipo de variable segun el valor
		char categoriaProducto = 'B';		 // ambito local de metodo
		
		/* Facil, código raya por raya
		
		double subtotal = unidadesVendidas * precioUnitario;
		
		
		double descuento = 0.0;
		
		if (esSocio) {

			descuento = subtotal * DESCUENTO_SOCIO;
			
		}
		
		
		double totalDescontado = subtotal - descuento;
		double total = totalDescontado * (1 + IVA_HOSTELERIA);
		
		*/
		
		double totalEnUnaLinea = ((unidadesVendidas * precioUnitario) - (esSocio ? (unidadesVendidas * precioUnitario * DESCUENTO_SOCIO) : 0.0)) * (1 + IVA_HOSTELERIA);

		/* ^^ Explicación precedencia de operadores ^^
		
		esto me ha costado entenderlo, de la mejor manera que lo he entendido es "traducir" el codigo raya por raya (facil) a oneliner
		
			1º parentesis internos: (unidadeVendidas * precioUnitario) se ponen los parentesis para que se multiplique antes que la resta de la operación, en el codigo facil sería el subtotal.
			
			2º operador ternario ? : evalua la condión booleana esSocio para decidir si resta el descuento o aplica 0.0 si es facil, en el codigo facil seria el if.
			
			3º resta: calcula el descuento, sería en el codigo facil el totalDescontado.
			
			4º multiplicación exterior: calculamos el iva, sería en el codigo facil la variable total.
				
		*/
		
		/* Calculo manual previo
		 
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
		
		System.out.printf("Producto: %s %d .ud a %f %n", nombreProducto, unidadesVendidas, precioUnitario);

		System.out.printf("¿Es socio? %b %n", esSocio);

		
		System.out.printf("Total calculado por el programa: %f € %n", totalEnUnaLinea);

		System.out.printf("Total esperado pago en mano: %.2f € %n", totalEnUnaLinea);



		
	}

}
