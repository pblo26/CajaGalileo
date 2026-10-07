package es.iesgalileo.dam.caja;

public class CajaGalileo {

	static final double IVA_HOSTELERIA = 0.1; // ambito de clase _ fuera de cualquier metodo para ser alcanzables desde cualquier sitio de la clase CajaGalileo
	
	static final double DESCUENTO_SOCIO = 0.05; // ambito de clase _ fuera de cualquier metodo para ser alcanzables desde cualquier sitio de la clase CajaGalileo
	
	
	public static void main(String[] args) { // ambito de metodo local
		
		String nombreProducto = "Colacao"; // ambito local de metodo
		
		var unidadesVendidas = 2; // ambito local de metodo
		
		double precioUnitario = 1.69; // ambito local de metodo
		
		var socio = false; // ambito local de metodo
		
		char categoriaProducto = "B"; // ambito local de metodo
		
		

	}

}
