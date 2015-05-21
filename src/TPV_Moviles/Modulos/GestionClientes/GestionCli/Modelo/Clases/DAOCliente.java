package TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases;

import javax.swing.JOptionPane;

import TPV_Moviles.Clases.Fecha;
import TPV_Moviles.Librerias.Funciones;
import TPV_Moviles.Librerias.Validate;

public class DAOCliente {

	public static Fecha introFecha(String mensaje) {

		String fecha = "", resultado = "";
		int dia = 0, mes = 0, anyo = 0;
		Fecha f = null;
		boolean interruptor = true;

			do {
				// msjfecha = "Introduce la fecha";
			fecha = mensaje;
			interruptor = Validate.validafecha(fecha);
			f = Fecha.muestraFecha(fecha);
			dia = f.ValidaDia();
			mes = f.ValidaMes();
			anyo = f.ValidaAnyo();

		} while ((dia == -1) || (mes == -1) || (anyo == -1));

		return f;
	}
        
        public static Fecha sacaFecha (String fecha) {
            int dia, mes, anyo;
            
            dia = Fecha.dia(fecha);
            mes = Fecha.mes(fecha);
            anyo = Fecha.anyo(fecha);
            
            Fecha f = new Fecha(fecha, dia, mes, anyo);
            return f;
        }
        

	public static int CompararFechas(Fecha f, Fecha f2) {
		String resultado = "";
		int val = 0;

		// f = Core_generico.introFecha("Introduccion", "Introduce la fecha 1");
		// f2 = Core_generico.introFecha("Introduccion",
		// "Introduce la fecha 2");

		val = f2.compararFechas(f);

		if (val == 1) {
			resultado = "La fecha introducida es mayor a la de otra";
			Funciones.resultado(resultado);
		}
		if (val == 0) {
			resultado = "La fecha introducida es igual a la de otra";
			Funciones.resultado(resultado);
		}
		if (val == -1) {
			resultado = "La fecha introducida es menor a la de otra";
			Funciones.resultado(resultado);
		}
		return val;
	}

	public static String pedirNombre(String nombre) {
        
            boolean correcto;
            
            correcto = Validate.validaNombre(nombre);
            
            if (correcto == false) {
                nombre = "-1";
            }
            return nombre;
        }
        
        public static String pedirApellidos (String apellidos) {
            
            boolean correcto;
            
            correcto = Validate.validaNombre(apellidos);
            
             if (correcto == false) {
                apellidos = "-1";
            }
            return apellidos;
        }
        
        public static String pedirDNI (String dni) {
            
            boolean correcto = true;
            correcto = Validate.validaDNI(dni);
            
            if (correcto == false) {
                dni = "-1";
            }
            return dni;
        }
        
        public static String pedirTelefono (String telefono) {
            
            boolean correcto = true;
            
            correcto = Validate.validaTelefono(telefono);
            
            if (correcto == false) {
		telefono = "-1";
            }
            return telefono;
        }
        
        public static String pedirINT(int i) {

		boolean correcto = true;
		String dato = "";

		if (i == 1) {
			do {
				dato = Funciones.pedirString("Introduce nombre del empleado:", "Nombre");
				correcto = Validate.validaNombre(dato);
				if (correcto == false)
					JOptionPane.showMessageDialog(null, "No ha introducido el nombre correctamente", "Informaci�n",
							JOptionPane.INFORMATION_MESSAGE);
			} while (correcto == false);

		} else if (i == 2) {
			do {
				dato = Funciones.pedirString("Introduce los apellidos del empleado:", "Apellidos");
				correcto = Validate.validaNombre(dato);
				if (correcto == false)
					JOptionPane.showMessageDialog(null, "No ha introducido los apellidos correctamente", "Informaci�n",
							JOptionPane.INFORMATION_MESSAGE);
			} while (correcto == false);

		} else if (i == 3) {
			do {
				dato = Funciones.pedirString("Introduce el DNI del empleado:", "DNI");
				correcto = Validate.validaDNI(dato);
				if (correcto == false)
					JOptionPane.showMessageDialog(null, "El DNI es incorrecto", "Informaci�n",
							JOptionPane.INFORMATION_MESSAGE);
			} while (correcto == false);

		} else if (i == 4) {
			do {
				dato = Funciones.pedirString("Introduce el telefono del empleado:", "Telefono");
				correcto = Validate.validaTelefono(dato);
				if (correcto == false)
					JOptionPane.showMessageDialog(null, "No ha introducido el telefono correctamente", "Informaci�n",
							JOptionPane.INFORMATION_MESSAGE);
			} while (correcto == false);

		} else if (i == 5) {
			do {
				dato = Funciones.pedirString("Introduce la direcci�n del empleado:", "Direcci�n");
				correcto = Validate.validaNombre(dato);
				if (correcto == false)
					JOptionPane.showMessageDialog(null, "No ha introducido la direcci�n correctamente", "Informaci�n",
							JOptionPane.INFORMATION_MESSAGE);
			} while (correcto == false);

		} else if (i == 6) {
			do {
				dato = Funciones.pedirString("Introduce su localidad:", "Localidad");
				correcto = Validate.validaNombre(dato);
				if (correcto == false)
					JOptionPane.showMessageDialog(null, "No ha introducido la localidad correctamente", "Informaci�n",
							JOptionPane.INFORMATION_MESSAGE);
			} while (correcto == false);

		} else if (i == 7) {
			do {
				dato = Funciones.pedirString("Introduce su c�digo postal:", "C�digo Postal");
				correcto = Validate.validaCP(dato);
				if (correcto == false)
					JOptionPane.showMessageDialog(null, "No ha introducido c�digo postal correctamente", "Informaci�n",
							JOptionPane.INFORMATION_MESSAGE);
			} while (correcto == false);

		} else if (i == 8) {
			do {
				dato = Funciones.pedirString("Introduce el email del empleado:", "eMail");
				correcto = Validate.validaEmail(dato);
				if (correcto == false)
					JOptionPane.showMessageDialog(null, "No ha introducido el email correctamente", "Informaci�n",
							JOptionPane.INFORMATION_MESSAGE);
			} while (correcto == false);

		} else if (i == 9) {
			do {
				dato = Funciones.pedirString("Introduce el CIF del empleado:", "CIF");
				correcto = Validate.validaCIF(dato);
				if (correcto == false)
					JOptionPane.showMessageDialog(null, "No ha introducido el CIF correctamente", "Informaci�n",
							JOptionPane.INFORMATION_MESSAGE);
			} while (correcto == false);

		}

		return dato;
	}
}