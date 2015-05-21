package TPV_Moviles.Librerias;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Formato {
 
	// 1 Decimal
	public static String formato1d(float num) {// 10.0f
		DecimalFormat format1 = new DecimalFormat(".0");
		return format1.format(num);
	}

	// 2 Decimales
	public static String formato2d(float num) {// 10.00f
		DecimalFormat format1 = new DecimalFormat(".00");
		return format1.format(num);
	}

	// 3 Decimales
	public static String formato3d(float num) {// 10.00f
		DecimalFormat format1 = new DecimalFormat(".000");
		return format1.format(num);
	}

	// Moneda
	public static String FormatDollar(double moneda) {
		NumberFormat coin = NumberFormat.getCurrencyInstance(Locale.US);// Dolar
		return coin.format(moneda);
	}

	public static String FormatLibra(double moneda) {
		NumberFormat coin = NumberFormat.getCurrencyInstance(Locale.UK);// Libras
		return coin.format(moneda);
	}

	public static String FormatEuro(double moneda) {
		NumberFormat coin = NumberFormat.getCurrencyInstance(Locale.FRANCE);// Euro
		return coin.format(moneda);
	}
}