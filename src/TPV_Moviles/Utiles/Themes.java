package TPV_Moviles.Utiles;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Themes {

	/**
     * Cambia la apariencia de la aplicacion.
     *
     * @param apariencia : un int que indica la apariencia seleccionada.
     */
    public static void apariencia(int apariencia) {
        try {
            switch (apariencia) {
                case 0:// Metal
                    UIManager.setLookAndFeel(UIManager
                            .getCrossPlatformLookAndFeelClassName());
                    break;

                case 1:// GTK - WINDOWS
                    UIManager.setLookAndFeel(UIManager
                            .getSystemLookAndFeelClassName());
                    break;

                case 2:// CDE/Motif
                    UIManager
                            .setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                    break;

                case 3:// Nimbus
                    UIManager
                            .setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                    break;

            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			JOptionPane.showMessageDialog(null,
                    "No pudo cargarse la apariencia deseada\n" + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}

