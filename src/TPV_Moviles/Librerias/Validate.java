package TPV_Moviles.Librerias;

import javax.swing.JOptionPane;

public class Validate {

	// validar email
	public static boolean validaEmail(String email) {

		return email
				.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}

	// validar nombre, apellidos, localidad ...
	public static boolean validaNombre(String nombre) {

		return nombre.matches("[a-zA-ZÀ-ÖØ-öø-ÿ]+\\.?(( |\\-)[a-zA-ZÀ-ÖØ-öø-ÿ]+\\.?)*");
	}

	// validar DNI
	public static boolean validaDNI(String dNI) {
		boolean val = true;
		String dni2 = "", caracteres = "TRWAGMYFPDXBNJZSQVHLCKET";
		int dni = 0, modulo = 0;
		try {
			for (int i = 0; i < 8; i++)
				dni2 += dNI.charAt(i);
			char letra = dNI.charAt(8);
			dni = Integer.parseInt(dni2);
			modulo = dni % 23;
			char let = caracteres.charAt(modulo);
			if (let == letra)
				val = true;
			else
				val = false;
		} catch (Exception e) {
			val = false;
		}
		return val;
	}

	// validar edad
	public static boolean validaEdad(String edad) {
		return edad.matches("^[0-9]{1,2}$");
	}

	// validar Codigo Postal
	public static boolean validaCP(String cP) {
		return cP.matches("^([1-9]{2}|[0-9][1-9]|[1-9][0-9])[0-9]{3}$");
	}

	// validar telefono
	public static boolean validaTelefono(String telefono) {
		return telefono
				.matches("0{0,2}([\\+]?[\\d]{1,3} ?)?([\\(]([\\d]{2,3})[)] ?)?[0-9][0-9 \\-]{6,}( ?([xX]|([eE]xt[\\.]?)) ?([\\d]{1,5}))?");
	}
        
        // validar telefono
	public static boolean validaReferencia(String referencia) {
		return referencia
				.matches("0{0,2}([\\+]?[\\d]{1,3} ?)?([\\(]([\\d]{2,3})[)] ?)?[0-9][0-9 \\-]{6,}( ?([xX]|([eE]xt[\\.]?)) ?([\\d]{1,5}))?");
	}

	// validar contrase�a
	public static boolean validaContrasenya(String contrasenya) {
		return contrasenya.matches("(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$");
	}

	// validar CIF
	public static boolean validaCIF(String cIF) {
		return cIF.matches("^[a-zA-Z]{1}[0-9]{8}$");
	}

	// validar fecha
	public static boolean validafecha(String fecha) {
		return fecha.matches("(0[1-9]|[12][0-9]|3[01])[-/.](0[1-9]|1[012])[-/.](19|20)\\d\\d");
	}

	// funcion para validar un numero entero
	public static int validaint(int i) {
		int a = 0;
		String s;
		String cad = "";
		if (i == 1)
			cad = "un numero";
		else if (i == 2)
			cad = "otro numero";
		else if (i == 3)
			cad = "una posicion";

		boolean correcto = true;

		do {
			try {
				s = JOptionPane.showInputDialog(null, "Dame " + cad, "Num int", JOptionPane.QUESTION_MESSAGE);
				if (s == null) {
					JOptionPane.showMessageDialog(null, "Saliendo de la aplicacion", "Saliendo",
							JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);// al usuario pulsar cancelar o cerrar la
									// vtna del showinputdialog, acaba la
									// ejecuci�n
				} else {
					a = Integer.parseInt(s);
					correcto = true;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "No has introducido un numero entero", "Error",
						JOptionPane.ERROR_MESSAGE);
				correcto = false;
			}
		} while (correcto == false);
		return a;
	}

}