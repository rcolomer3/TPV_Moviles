package TPV_Moviles.Clases;

import java.util.Date;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import TPV_Moviles.Ppal;

public class Fecha implements Serializable {

    private String fecha;
    private int dia;
    private int mes;
    private int anyo;

    private SimpleDateFormat formato = new SimpleDateFormat("dd-mm-yyyy");

    public Fecha(String fecha, int dia, int mes, int anyo) {
        this.fecha = fecha;
        this.dia = dia;
        this.mes = mes;
        this.anyo = anyo;
    }

    public Fecha(String fecha1) {
        this.fecha = fecha1; //To change body of generated methods, choose Tools | Templates.
    }

    public String toStringFecha() {
        String cad = null;

        if (Ppal.conf == null) {
            cad = this.dia + "-" + this.mes + "-" + this.anyo;
        } else {

            if (Config.getFormatfecha().equals("1")) {
                cad = dia + "/" + mes + "/" + anyo;
            } else if (Config.getFormatfecha().equals("2")) {
                cad = mes + "/" + dia + "/" + anyo;
            } else if (Config.getFormatfecha().equals("3")) {
                cad = anyo + "/" + mes + "/" + dia;
            } else if (Config.getFormatfecha().equals("4")) {
                cad = dia + "-" + mes + "-" + anyo;
            } else if (Config.getFormatfecha().equals("5")) {
                cad = mes + "-" + dia + "-" + anyo;
            } else if (Config.getFormatfecha().equals("6")) {
                cad = anyo + "-" + mes + "-" + dia;
            }
        }

        return cad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public int ValidaDia() {
        GregorianCalendar calendar = new GregorianCalendar();
        int dias[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (calendar.isLeapYear(this.anyo)) {
            dias[2] = 29;
        }

        if ((this.dia >= 1) && (this.dia <= dias[this.mes])) {
            return this.dia;
        } else {
            return -1;
        }
    }

    public int ValidaMes() {
        if ((this.mes >= 1) && (this.mes <= 12)) {
            return this.mes;
        } else {
            return -1;
        }
    }

    public int ValidaAnyo() {
        if ((this.anyo >= 1920) && (this.anyo <= 2020)) {
            return this.anyo;
        } else {
            return -1;
        }
    }

    public String fechaactual() {
        Calendar fecha = new GregorianCalendar();
        return formato.format(fecha);
    }

    public int diaactual() {
        Calendar fecha = new GregorianCalendar();
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        return dia;
    }

    public int anyoactual() {
        Calendar fecha = new GregorianCalendar();
        int anyo = fecha.get(Calendar.YEAR);
        return anyo;
    }

    public int mesactual() {
        Calendar fecha = new GregorianCalendar();
        int mes = fecha.get(Calendar.MONTH);
        return mes + 1;
    }

    public Calendar deStringToCalendar(/**
             * String fecha
             */
            ) {
        Date fechaDate = new Date();
        Calendar fechaCalendar = new GregorianCalendar();
        try {
            fechaDate = formato.parse(this.fecha);
            fechaCalendar.setTime(fechaDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return fechaCalendar;
    }

    public static String deCalendartoString(Calendar cal) {
        return (cal.getTime().toString());
    }

    public int restaFechas() { // Calcular Edad
        int resultado = 0;
        Calendar f = Calendar.getInstance(); // obtenemos fecha sistema
        int Adia = f.get(Calendar.DATE);
        int Ames = f.get(Calendar.MONTH) + 1;
        int Aanyo = f.get(Calendar.YEAR);

        if (Aanyo > this.anyo) {
            resultado = Aanyo - this.anyo;
        } else if (Aanyo < this.anyo) {
            resultado = -1;
        }

        if (Ames < this.mes) {
            resultado = resultado - 1;
        } else if (Ames == this.mes) {
            if (Adia < this.dia) {
                resultado = resultado - 1;
            }
        }

        return resultado;
    }

    public int restaFechas2(Fecha f1) { // Resta fechas general
        int anyo1 = 0;
        int anyo2 = 0;
        Calendar fecha1 = this.deStringToCalendar();
        Calendar fecha2Calen = f1.deStringToCalendar();

        anyo1 = fecha1.get(Calendar.YEAR);
        anyo2 = fecha2Calen.get(Calendar.YEAR);

        return (anyo2 - anyo1);
    }

    public int compararFechas(Fecha f2) {
        int val = 0;
        boolean correcto = true;
		// 1 mayor
        // 0 igual
        // -1 menor
        do {
            correcto = true;
            try {
                if (this.anyo == f2.anyo) {
                    if (this.mes == f2.mes) {
                        if (this.dia > f2.dia) {
                            val = 1; // La fecha sera mayor que la que estamos
                            // comparando
                        } else if (this.dia == f2.dia) {
                            val = 0; // La fechas son iguales
                        } else {
                            val = -1;// La fecha es menor
                        }
                    } else if (this.mes < f2.mes) {
                        val = -1;// La fecha es menor
                    } else {
                        val = 1;// La fecha es mayor
                    }
                } else if (this.anyo > f2.anyo) {
                    val = 1; // La fecha sera mayor que la que estamos
                    // comparando
                } else {
                    val = -1;// La fecha es menor
                }
            } catch (Exception e) {
                correcto = false;
                e.printStackTrace();
            }
        } while (correcto == false);
        return val;
    }

    public static int dia(String fecha) {

        int dia = 0;
        String[] fecha1 = fecha.split("-");

        dia = Integer.parseInt(fecha1[0]);

        return dia;
    }

    public static int mes(String fecha) {

        int mes = 0;
        String[] fecha1 = fecha.split("-");

        mes = Integer.parseInt(fecha1[1]);

        return mes;
    }

    public static int anyo(String fecha) {

        int anyo = 0;
        String[] fecha1 = fecha.split("-");

        anyo = Integer.parseInt(fecha1[2]);

        return anyo;
    }

    public static Fecha muestraFecha(String fecha) {

        int dia = 0, mes = 0, anyo = 0;
        Fecha f = null;

        dia = Fecha.dia(fecha);
        mes = Fecha.mes(fecha);
        anyo = Fecha.anyo(fecha);

        f = new Fecha(fecha, dia, mes, anyo);

        return f;
    }

    public int compararFechaSystem() {
        Calendar c1 = Calendar.getInstance();
        int val = 0, dia = 0, mes = 0, anyo = 0;
        dia = c1.get(Calendar.DATE);
        mes = c1.get(Calendar.MONTH) + 1;
        anyo = c1.get(Calendar.YEAR);
        boolean correcto = true;
		// 1 mayor
        // 0 igual
        // -1 menor
        do {
            correcto = true;
            try {
                if (this.anyo == anyo) {
                    if (this.mes == mes) {
                        if (this.dia > dia) {
                            val = 1; // La fecha sera mayor que la que estamos
                            // comparando
                        } else if (this.dia == dia) {
                            val = 0; // La fechas son iguales
                        } else {
                            val = -1;// La fecha es menor
                        }
                    } else if (this.mes < mes) {
                        val = -1;// La fecha es menor
                    } else {
                        val = 1;// La fecha es mayor
                    }
                } else if (this.anyo > anyo) {
                    val = 1; // La fecha sera mayor que la que estamos
                    // comparando
                } else {
                    val = -1;// La fecha es menor
                }
            } catch (Exception e) {
                correcto = false;
                e.printStackTrace();
            }
        } while (correcto == false);
        return val;
    }
}
