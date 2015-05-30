package TPV_Moviles.Clases;

import java.util.ArrayList;

import TPV_Moviles.Clases.Dummies;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.Clientes;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.Singletons;
import TPV_Moviles.Modulos.GestionProductos.Modelo.Clases.Productos;
import TPV_Moviles.Modulos.GestionProductos.Modelo.Clases.SingletonsPro;

public class Config {

	private static String numdecimal;
	private static char moneda;
	private static String formatfecha;
	private static String guardar;
        private static String abrir;
	private static String apariencia;

	public Config() {

		numdecimal = "2"; // per defecte 2 decimals .00
		moneda = '€'; // per defecte .00 €
		formatfecha = "4"; // per defecte dd-mm-yyyy
		guardar = "2"; // per defecte es guarda en formato TXT
		apariencia = "1";
                abrir = "2"; // per defecte s'obri en formato TXT

		Singletons.efi = new ArrayList<Clientes>();
		SingletonsPro.pro = new ArrayList<Productos>();
		
		//Dummies.cargar_datosDummies();
	}

	public String toString() {
		return "Configuracion " + "\n" + "numdecimal=" + numdecimal + "\n" + " moneda=" + moneda + "\n"
				+ " formatfecha=" + formatfecha + " apariencia=" + apariencia;
	}

	public static String Apariencia() {
		return apariencia;
	}
	
	public void setApariencia(String apariencia) {
		Config.apariencia = apariencia;
	}
	
	public static String getNumdecimal() {
		return numdecimal;
	}

	public static void setNumdecimal(String numdecimal) {
		Config.numdecimal = numdecimal;
	}

	public static char getMoneda() {
		return moneda;
	}

	public static void setMoneda(char moneda) {
		Config.moneda = moneda;
	}

	public static String getFormatfecha() {
		return formatfecha;
	}

	public static void setFormatfecha(String formatfecha) {
		Config.formatfecha = formatfecha;
	}

	public static String getGuardar() {
		return guardar;
	}

	public void setGuardar(String guardar) {
		Config.guardar = guardar;
	}
        
        public static String getAbrir() {
		return abrir;
	}

	public void setAbrir(String abrir) {
		Config.abrir = abrir;
	}
}