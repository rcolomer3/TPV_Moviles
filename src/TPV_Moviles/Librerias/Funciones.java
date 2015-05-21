package TPV_Moviles.Librerias;

import TPV_Moviles.Clases.Fecha;
import java.util.Random;
import javax.swing.JOptionPane;

public class Funciones {

    /**
     * Pedir numero Float
     *
     * Nos muestra una ventana donde introduciremos el numero
     *
     * @return Nos retornara el numero float despues de realizar la operacion
     * marcada
     */
    public static float pedirFloat(String msgfloat) { // Pedir Float
        float num = 0.0f;
        String s = "";
        boolean correcto = true;

        do {

            try { // entrada datos

                s = JOptionPane.showInputDialog(null, msgfloat, "Introduccion", JOptionPane.QUESTION_MESSAGE);

                if (s == null) {
					// JOptionPane.showMessageDialog(null,
                    // "Saliendo de la aplicaci�n", "Saliendo",
                    // JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);// al usuario pulsar cancelar o cerrar la
                    // ventana del showinputdialog, acaba la
                    // ejecuci�n
                } else {
                    num = Float.parseFloat(s);
                    correcto = true;
                }
            }// fi try
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No has introducido un numero", "Error", JOptionPane.ERROR_MESSAGE);
                correcto = false;
            }
        } while (correcto == false);
        return num;

    }

    /**
     * Pedir numero Integer
     *
     * Nos muestra una ventana donde introduciremos el numero
     *
     * @return Nos retornara el numero int despues de realizar la operacion
     * marcada
     */
    public static int pedirInt(String msgInt) { // Pedir Integer
        int num = 0;
        String s = "";
        boolean correcto = true;

        do {

            try { // entrada datos

                s = JOptionPane.showInputDialog(null, msgInt, "Introduccion", JOptionPane.QUESTION_MESSAGE);

                if (s == null) {
					// JOptionPane.showMessageDialog(null,
                    // "Saliendo de la aplicaci�n", "Saliendo",
                    // JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);// al usuario pulsar cancelar o cerrar la
                    // ventana del showinputdialog, acaba la
                    // ejecuci�n
                } else {
                    num = Integer.parseInt(s);
                    correcto = true;
                }
            }// fi try
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No has introducido un numero", "Error", JOptionPane.ERROR_MESSAGE);
                correcto = false;
            }
        } while (correcto == false);
        return num;
    }

    /**
     * Pedir letra Char
     *
     * Nos muestra una ventana donde introduciremos una letra o serie de letras
     *
     * @return Nos retornara la letra o letras despues de realizar la operacion
     * marcada
     */
    public static char pedirChar(String msgChar) { // Pedir Character

        char letr = ' ';
        String letra = "";
        boolean correcto = true;

        do {
            try {
                letra = JOptionPane.showInputDialog(null, msgChar, "letra", JOptionPane.QUESTION_MESSAGE);
                if (letra == null) {
                    JOptionPane.showMessageDialog(null, "Saliendo de la aplicaci�n", "Saliendo",
                            JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);// al usuario pulsar cancelar o cerrar la
                    // vtna del showinputdialog, acaba la
                    // ejecuci�n
                } else {
                    letr = letra.charAt(0);
                    correcto = true;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No has introducido una letra", "Error", JOptionPane.ERROR_MESSAGE);
                correcto = false;
            }
        } while (correcto == false);

        return letr;
    }

    /**
     * Pedir String
     *
     * Nos muestra una ventana donde introduciremos un dato
     *
     * @return Nos retornara un dato despues de realizar la operacion marcada
     */
    public static String pedirString(String msgStrg, String msgStrg1) { // Pedir
        // String

        String s = "";
        boolean correcto = true;

        do {
            s = JOptionPane.showInputDialog(null, msgStrg, "Introducci�n", JOptionPane.QUESTION_MESSAGE);

            if (s == null) {
				// JOptionPane.showMessageDialog(null,
                // "Saliendo de la aplicaci�n", "Saliendo",
                // JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);// al usuario pulsar cancelar o cerrar la ventana
                // del showinputdialog, acaba la ejecuci�n
            }
        } while (correcto == false);
        return s;
    }

    // Pedir fecha
    public static String pedirFecha(String mensaje) {

        String fecha = "";
        boolean correcto = true;

        do {
            fecha = mensaje;
            correcto = Validate.validafecha(fecha);

            if (fecha == null) {
                JOptionPane.showMessageDialog(null, "La fecha introducida no es valida", "Informacion",
                        JOptionPane.INFORMATION_MESSAGE);
				// JOptionPane.showMessageDialog(null,
                // "Saliendo de la aplicaci�n", "Saliendo",
                // JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);// al usuario pulsar cancelar o cerrar la ventana
                // del showinputdialog, acaba la ejecuci�n
            }
        } while (correcto == false);
		//JOptionPane.showMessageDialog(null, "La fecha introducida es valida", "Informacion",
        //JOptionPane.INFORMATION_MESSAGE);
        return fecha;
    }

    /**
     * Mensaje resultado
     *
     * @param resultado Nos mostrara el mensaje del resultado junto el resultado
     * obtenido en la operaci�n
     */
    public static void resultado(String resultado) { // Mensaje de resultado
        JOptionPane.showMessageDialog(null, resultado);
    }

    /**
     * Mensaje Salir
     *
     * @param salir Nos mostrara un mensaje de saliendo de la aplicaci�n cuando
     * nosotros cerremos dicho programa
     */
    public static void salir(String salir) { // Saliendo de la aplicaci�n
        JOptionPane.showMessageDialog(null, salir);
    }

    public static Fecha getFechaAleatoria() {

        String cad;
        int dia = 0, mes = 0, anyo = 0, i = 0;
        Random r = new Random();
        while (i < 3) {
            if (i == 0) {
                dia = r.nextInt(28);
                if ((dia > 0) && (dia < 29)) {
                    i++;
                }
            }
            if (i == 1) {
                mes = r.nextInt(12);
                if ((mes > 0) && (mes < 13)) {
                    i++;
                }
            }
            if (i == 2) {
                anyo = r.nextInt(2015);
                if ((anyo > 1950) && (anyo < 2016)) {
                    i++;
                }
            }
        }
        cad = +dia + "-" + mes + "-" + anyo;
        Fecha f = new Fecha(cad, dia, mes, anyo);

        return f;
    }

    public static String getCadenaAleatoria1(int longitud) {
        String cadenaAleatoria = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while (i < longitud) {
            char c = (char) r.nextInt(255);
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                cadenaAleatoria += c;
                i++;
            }
        }
        return cadenaAleatoria;
    }

    public static String getCadenaAleatoria2(int longitud) {
        String cadenaAleatoria = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while (i < longitud) {
            char c = (char) r.nextInt(255);
            if (c >= '0' && c <= '9') {
                cadenaAleatoria += c;
                i++;
            }
        }
        return cadenaAleatoria;
    }

    public static String getCadenaAleatoriaDNI() {
        String cadenaAleatoria = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while (i < 8) {
            char c = (char) r.nextInt(255);
            if (c >= '0' && c <= '9') {
                cadenaAleatoria += c;
                i++;
            }
        }
        String dniLetra = "TRWAGMYFPDXBNJZSQVHLCKE";

        return cadenaAleatoria + dniLetra.charAt(Integer.parseInt(cadenaAleatoria) % 23);
    }

    public static String getCadenaAleatoria(int longitud) {
        String cadenaAleatoria = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while (i < longitud) {
            char c = (char) r.nextInt(255);
            if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) {
                cadenaAleatoria += c;
                i++;
            }
        } 
        return cadenaAleatoria;
    }
}
