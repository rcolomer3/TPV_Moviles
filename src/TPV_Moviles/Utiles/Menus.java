package TPV_Moviles.Utiles;

import javax.swing.JOptionPane;

public class Menus {

	/**
	 * Menu de operaciones
	 * 
	 * @param op
	 *            Muestra las distintas opciones para hacer operaciones
	 * @param titulo
	 *            Introduccion del menu de operaciones
	 * @return Nos retorna a la opcion marcada
	 */

	// Menu Botones

	public static int menuop(String[] op, String titulo) { // Menu de
															// Operaciones
		int confirmado = JOptionPane.showOptionDialog(null, titulo, "Menu Operaciones",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, op[0]);

		return confirmado;

	}

	// Menu Botones

	public static int submenuop(String[] opc, String mensaje) { // Submenu de
																// Operaciones
		int confirmado = JOptionPane.showOptionDialog(null, mensaje, "Submenu Operaciones",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opc, opc[0]);

		return confirmado;

	}

	// Menu Combobox

	public static String menuCbox(String[] opciones, String titulo, String mensaje) {
		String operacion = "";

		Object seleccion = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE, null,
				opciones, opciones[0]);

		if (seleccion == null) {
			JOptionPane.showMessageDialog(null, "Saliendo de la aplicacion");
			System.exit(0);
		} else
			operacion = seleccion.toString();

		return operacion;
	}

	// Configurar Fecha

	public static String ConfigurarFecha() {
		String operacion = "";

		Object seleccion = JOptionPane.showInputDialog(null, "Seleccione el formato de fecha deseado", "Formato Fecha",
				JOptionPane.QUESTION_MESSAGE, null, new Object[] { "dd/mm/yyyy", "mm/dd/yyyy", "yyyy/mm/dd",
						"dd-mm-yyyy", "mm-dd-yyyy", "yyyy-mm-dd" }, "dd/mm/yyyy");

		if (seleccion == null) {
			JOptionPane.showMessageDialog(null, "Saliendo de la aplicacion");
			System.exit(0);
		} else {
			operacion = seleccion.toString();
			if (operacion.equals("dd/mm/yyyy"))
				operacion = "1";
			if (operacion.equals("mm/dd/yyyy"))
				operacion = "2";
			if (operacion.equals("yyyy/mm/dd"))
				operacion = "3";
			if (operacion.equals("dd-mm-yyyy"))
				operacion = "4";
			if (operacion.equals("mm-dd-yyyy"))
				operacion = "5";
			if (operacion.equals("yyyy-mm-dd"))
				operacion = "6";
		}
		return operacion;
	}

	// Configurar Decimal
	public static String ConfigurarDecimal() {
		String opci[] = { "1 Decimal", "2 Decimals", "3 Decimals" };
		String cadena = "";

		int confirmado = JOptionPane.showOptionDialog(null, "Seleccione el formato de moneda deseado",
				"Submenu Operaciones", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opci,
				opci[1]);

		cadena = "" + (confirmado + 1);
		return cadena;

	}

	// Configurar Formato Moneda (La libra es Alt + 156
	public static char ConfigurarMoneda() {
		String opci[] = { "Libra £", "Euro €", "Dollar $" };
		char moneda = ' ';

		int confirmado = JOptionPane.showOptionDialog(null, "Seleccione el formato de moneda deseado",
				"Submenu Operaciones", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opci,
				opci[1]);

		if (confirmado == 0)
			moneda = '£';
		if (confirmado == 1)
			moneda = '€';
		if (confirmado == 2)
			moneda = '$';

		return moneda;
	}

	// Menu Apariencia

	public static int menuApariencia() {
		int resp = 0;
		int theme = 0;
		String[] tipo = { "Metal", "GTK", "CDE/Motif", "Ninbus", "Volver" };
		do {
			resp = JOptionPane.showOptionDialog(null, "Seleccione el tipo de apariencia deseado", "Submenu Operaciones",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, tipo, tipo[0]);

			switch (resp) {

			case 0:
				Themes.apariencia(theme = 0);
				break;

			case 1:
				Themes.apariencia(theme = 1);
				break;

			case 2:
				Themes.apariencia(theme = 2);
				break;

			case 3:
				Themes.apariencia(theme = 3);
				break;

			case 4:
				break;
			}

		} while (resp < 4);
		return resp;
	}

	/**
	 * Pide Continuar
	 * 
	 * @param deseaseguirop
	 *            Muestra un mensaje para saber si queremos continuar realizando
	 *            operaciones
	 * @param seleccionar
	 *            Muestra las opciones para continuar
	 * @return Nos retorna a la funcion si continuamos y sino nos retorna al
	 *         menu de operaciones
	 */
	public static int deseaseguir(String deseaseguirop, String[] seleccionar) { // Pide
																				// Continuar
		int continuar = JOptionPane.showOptionDialog(null, deseaseguirop, "Menu Continuar",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { seleccionar[0],
						seleccionar[1], seleccionar[2] }, null);

		return continuar;

	}

	// Menu Generic
	public static String genericMenu(Object vMenu[], String s) {
		// Menu de opciones con combo-box
		String op = "";
		Object seleccion = JOptionPane.showInputDialog(null, s, "Menu", JOptionPane.QUESTION_MESSAGE, null, vMenu,
				"vMenu[0]");
		if (seleccion == null) {
			System.exit(0);
		} else
			op = (String) seleccion;
		return op;
	}

	public static int menuOrdenar(int i, String titulo) {
		String s = "";
		int respuesta;
		if (i == 1)
			s = s + "Ordenar";
		else if (i == 2)
			s = s + "MaxMin";

		String[] op = { "DNI", "Edad", "Nombre", "Antiguedad","FechaContrac", "FechaNac",  "SueldoFijo", "SueldoHoras",
				"Volver" };
		respuesta = JOptionPane.showOptionDialog(null, titulo, s, 0, JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
		return respuesta;
	}
	
	public static int menuOrdenarET(int i, String titulo) {
		String s = "";
		int respuesta;
		if (i == 1)
			s = s + "Ordenar";
		else if (i == 2)
			s = s + "MaxMin";

		String[] op = { "DNI", "Edad", "Nombre", "Antiguedad","FechaContrac", "FechaNac",  "SueldoTemp", "FechaBaja",
				"Volver" };
		respuesta = JOptionPane.showOptionDialog(null, titulo, s, 0, JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
		return respuesta;
	}
	
	public static int menuOrdenarEH(int i, String titulo) {
		String s = "";
		int respuesta;
		if (i == 1)
			s = s + "Ordenar";
		else if (i == 2)
			s = s + "MaxMin";

		String[] op = { "DNI", "Edad", "Nombre", "FechaContrac", "FechaNac",  "PrecioHora", "HorasTrabajadas", "SueldoHoras",
				"Volver" };
		respuesta = JOptionPane.showOptionDialog(null, titulo, s, 0, JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
		return respuesta;
	}

	public static int GuardarSalirSiNo(int i) {// Menu crear, modificar,
												// imprimir, eliminar...
		String s = "";
		int resp2;
		if (i == 0)
			s = s + "Aviso";

		String[] op1 = { "Guardar", "Salir sin guardar" };
		resp2 = JOptionPane.showOptionDialog(null, "¿Quieres guardar antes de salir?", s, 0,
				JOptionPane.QUESTION_MESSAGE, null, op1, op1[0]);
		return resp2;
	}

	public static int menuPpal(int i) {
		String s = "";
		int resp2;
		if (i == 0)
			s = s + "Seleccione el empleado que quiera consultar";

		String[] op = { "Empleados Fijos", "Empleados Temporales", "Empleados por horas", "Salir" };
		resp2 = JOptionPane.showOptionDialog(null, "Pulsa la operacion elegida", s, 0, JOptionPane.QUESTION_MESSAGE,
				null, op, op[0]);
		return resp2;
	}

	public static String ConfigurarGuardado() {
		String s = "";
		Object seleccion = JOptionPane.showInputDialog(null, "Seleccione con que tipo de fichero desea trabajar:",
				"Selector de opciones", JOptionPane.QUESTION_MESSAGE, null, new Object[] { "JSON", "TXT", "XML" },
				"JSON");

		if (seleccion == null) {
			JOptionPane.showMessageDialog(null, "Saliendo de la aplicacion", "Saliendo ...",
					JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		} else if (seleccion == "JSON") {
			s = "1";
		} else if (seleccion == "TXT") {
			s = "2";
		} else if (seleccion == "XML") {
			s = "3";
		}
		return s;
	}
        
        public static String ConfigurarAbrir() {
		String s = "";
		Object seleccion = JOptionPane.showInputDialog(null, "Seleccione con que tipo de fichero desea trabajar:",
				"Selector de opciones", JOptionPane.QUESTION_MESSAGE, null, new Object[] { "JSON", "TXT", "XML" },
				"JSON");

		if (seleccion == null) {
			JOptionPane.showMessageDialog(null, "Saliendo de la aplicacion", "Saliendo ...",
					JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		} else if (seleccion == "JSON") {
			s = "1";
		} else if (seleccion == "TXT") {
			s = "2";
		} else if (seleccion == "XML") {
			s = "3";
		}
		return s;
	}

}