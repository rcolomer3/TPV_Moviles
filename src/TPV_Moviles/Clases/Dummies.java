package TPV_Moviles.Clases;

import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.Clientes;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.Singletons;

public class Dummies {

	public static void cargar_datosDummies() {
		
		Clientes ef = new Clientes("Raul", "Colomer", "48607190W", "665538067", new Fecha ("14-03-1993", 14, 03, 1993), new Fecha ("01-01-2011", 01, 01, 2011), "raul", "1234", "rcolomer3@gmail.com", 1, "Administrador", null, 100.00f);
		Singletons.efi.add(ef);
		
	}
}
