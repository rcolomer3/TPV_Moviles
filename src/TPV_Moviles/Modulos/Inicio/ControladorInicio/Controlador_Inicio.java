/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPV_Moviles.Modulos.Inicio.ControladorInicio;

import TPV_Moviles.Clases.Config;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Controlador.Controlador_EF;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.Singletons;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.interfaz_Clientes;
import TPV_Moviles.Modulos.Inicio.Vista.Ventana_Empleados;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Raul
 */
public class Controlador_Inicio implements ActionListener {

    public enum Accion {

        //Acciones de la ventana Inicio
        
        _MENU_PAGER,
        _MENU_CONFIG,
        
        //Acciones de la pestaña Configuracion
        _euro,
        _dolar,
        _libra,
        _fecha4,
        _fecha5,
        _fecha6,
        _fecha1,
        _fecha2,
        _fecha3,
        _aparienciaMetal,
        _aparienciaGTK,
        _aparienciaNimbus,
        _decimal1,
        _decimal2,
        _decimal3
    }

    public Controlador_Inicio(JFrame menuPpal, int i) {

        if (i == 0) { //Pestaña Pager en Ventana_Empleados
            Singletons.menuPpal = (Ventana_Empleados) menuPpal;
        }
        
        if (i == 1) { //Pager
            Singletons.PagerEF = (interfaz_Clientes) menuPpal;
            new Controlador_EF(new interfaz_Clientes(), 2).iniciar(2);
        }

        if (i == 2) { //Pestaña Configuracion en Ventana_Empleados
            Singletons.config = (Ventana_Empleados) menuPpal;
        }
        
    }

    public void iniciar(int i) {

        if (i == 0) { //Ventana_Empleados

            Singletons.menuPpal.setVisible(true);
            Singletons.menuPpal.setResizable(false);
            Singletons.menuPpal.setTitle("Empleados");
            Singletons.menuPpal.setLocationRelativeTo(null);
            Singletons.menuPpal.setSize(610, 370); //ancho x alto
            Image icono = Toolkit.getDefaultToolkit().getImage("src/TPV/Img/trabajador.jpg");
            Singletons.menuPpal.setIconImage(icono);

            Singletons.menuPpal.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    JOptionPane.showMessageDialog(null, "Saliendo de la aplicacion");
                    System.exit(0);
                }
            });

            Singletons.menuPpal.MenuPager.setActionCommand("_MENU_PAGER");
            Singletons.menuPpal.MenuPager.addActionListener(this);

            // Opciones de configuracion
            Singletons.config.aparienciaMetal.setActionCommand("_aparienciaMetal");
            Singletons.config.aparienciaMetal.addActionListener(this);

            Singletons.config.aparienciaGTK.setActionCommand("_aparienciaGTK");
            Singletons.config.aparienciaGTK.addActionListener(this);

            Singletons.config.aparienciaNimbus.setActionCommand("_aparienciaNimbus");
            Singletons.config.aparienciaNimbus.addActionListener(this);

            Singletons.config.Euro.setActionCommand("_euro");
            Singletons.config.Euro.addActionListener(this);

            Singletons.config.Libra.setActionCommand("_libra");
            Singletons.config.Libra.addActionListener(this);

            Singletons.config.Dolar.setActionCommand("_dolar");
            Singletons.config.Dolar.addActionListener(this);

            Singletons.config.fecha4.setActionCommand("_fecha4");
            Singletons.config.fecha4.addActionListener(this);

            Singletons.config.fecha5.setActionCommand("_fecha5");
            Singletons.config.fecha5.addActionListener(this);

            Singletons.config.fecha6.setActionCommand("_fecha6");
            Singletons.config.fecha6.addActionListener(this);

            Singletons.config.fecha1.setActionCommand("_fecha1");
            Singletons.config.fecha1.addActionListener(this);

            Singletons.config.fecha2.setActionCommand("_fecha2");
            Singletons.config.fecha2.addActionListener(this);

            Singletons.config.fecha3.setActionCommand("_fecha3");
            Singletons.config.fecha3.addActionListener(this);

            Singletons.config.decimal1.setActionCommand("_decimal1");
            Singletons.config.decimal1.addActionListener(this);

            Singletons.config.decimal2.setActionCommand("_decimal2");
            Singletons.config.decimal2.addActionListener(this);

            Singletons.config.decimal3.setActionCommand("_decimal3");
            Singletons.config.decimal3.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        switch (Accion.valueOf(ae.getActionCommand())) {

            //Configuracion del Menu
            case _MENU_PAGER:
                new Controlador_Inicio(new interfaz_Clientes(), 1).iniciar(0);
                Singletons.PagerEF.setVisible(true);
                Singletons.menuPpal.dispose();
                break;

            case _MENU_CONFIG:
                new Controlador_Inicio(new Ventana_Empleados(), 2).iniciar(0);
                break;

            //Pestaña Configuracion
            case _aparienciaMetal:
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                    SwingUtilities.updateComponentTreeUI(Singletons.config);
                } catch (Exception e) {
                }
                break;

            case _aparienciaGTK:
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    SwingUtilities.updateComponentTreeUI(Singletons.config);
                } catch (Exception e) {
                }
                break;

            case _aparienciaNimbus:
                try {
                    UIManager.LookAndFeelInfo[] lafs = UIManager.getInstalledLookAndFeels();
                    for (UIManager.LookAndFeelInfo laf : lafs) {
                        if ("Nimbus".equals(laf.getName())) {
                            UIManager.setLookAndFeel(laf.getClassName());
                        }
                    }
                    SwingUtilities.updateComponentTreeUI(Singletons.config);
                } catch (Exception e) {
                }
                break;

            case _euro:
                Config.setMoneda('€');
                break;
            case _libra:
                Config.setMoneda('£');
                break;

            case _dolar:
                Config.setMoneda('$');
                break;

            // dd-mm-yyyy
            case _fecha4:
                Config.setFormatfecha("4");
                break;

            // mm-dd-yyyy
            case _fecha5:
                Config.setFormatfecha("5");
                break;

            // yyyy-mm-dd
            case _fecha6:
                Config.setFormatfecha("6");
                break;

            // dd/mm/yyyy
            case _fecha1:
                Config.setFormatfecha("1");
                break;

            // mm/dd/yyyy
            case _fecha2:
                Config.setFormatfecha("2");
                break;

            // yyyy/mm/dd
            case _fecha3:
                Config.setFormatfecha("3");
                break;

            // 0.0 
            case _decimal1:
                Config.setNumdecimal("1");
                break;

            // 0.00
            case _decimal2:
                Config.setNumdecimal("2");
                break;

            // 0.000
            case _decimal3:
                Config.setNumdecimal("3");
                break;
        }
    }
}
