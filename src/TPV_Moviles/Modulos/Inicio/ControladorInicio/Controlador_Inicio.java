/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPV_Moviles.Modulos.Inicio.ControladorInicio;

import TPV_Moviles.Clases.Config;
import TPV_Moviles.Librerias.FileUploader;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Controlador.Controlador_Cli;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.BLL.BLLBD;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.Clientes;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.Singletons;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.DAO.DAOGrafico;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.ModificarCli;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.interfaz_Clientes;
import TPV_Moviles.Modulos.GestionProductos.Controlador.Controlador_Pro;
import TPV_Moviles.Modulos.GestionProductos.Modelo.Clases.SingletonsPro;
import TPV_Moviles.Modulos.GestionProductos.Vista.Ventana_Prod;
import TPV_Moviles.Modulos.Inicio.Vista.SobreNosotros;
import TPV_Moviles.Modulos.Inicio.Vista.Ventana_Inicio;
import TPV_Moviles.Modulos.Login.BLL.LoginBLL;
import TPV_Moviles.Modulos.Login.Controlador_Login.Controlador_Login;
import TPV_Moviles.Modulos.Login.Vista.Login;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
public class Controlador_Inicio implements ActionListener, MouseListener {

    public enum Accion {

        //Acciones de la ventana Inicio
        _MENU_PROD,
        _MENU_COMPRAS,
        _MENU_PAGER,
        _MENU_CONFIG,
        _SIGN_IN,
        _MENU_SOBRE,
        _BTN_VOLVER_SOBRE,
        _SALIR,
        _MIPERFIL,
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

        if (i == 0) { //Pestaña Pager en Ventana_Inicio
            Singletons.menuPpal = (Ventana_Inicio) menuPpal;
        }

        if (i == 1) { //Pestaña Gestion Clientes
            Singletons.PagerCli = (interfaz_Clientes) menuPpal;
            new Controlador_Cli(new interfaz_Clientes(), 2).iniciar(2);
        }

        if (i == 2) { //Pestaña Configuracion en Ventana_Inicio
            Singletons.config = (Ventana_Inicio) menuPpal;
        }

        if (i == 3) { //Pestaña Gestion Productos
            SingletonsPro.PagerPro = (Ventana_Prod) menuPpal;
            new Controlador_Pro(new Ventana_Prod(), 2).iniciar(2);
        }

        if (i == 4) { //Pestaña Gestion Compras

        }

        if (i == 5) { //Pestaña Sign In
            Singletons.log = (Login) menuPpal;
            new Controlador_Login(new Login(), 0).iniciar(0);
        }
        
        if (i == 6) { //Pestaña sobre Nosotros
            Singletons.sobre = (SobreNosotros) menuPpal;
        }

    }

    public void iniciar(int i) {

        if (i == 0) { //Ventana_Empleados

            Singletons.menuPpal.setVisible(true);
            Singletons.menuPpal.setResizable(false);
            Singletons.menuPpal.setTitle("Tu Tienda Movil");
            Singletons.menuPpal.setLocationRelativeTo(null);
            Singletons.menuPpal.setSize(900, 651); //ancho x alto
            Image icono = Toolkit.getDefaultToolkit().getImage("src/TPV_Moviles/Img/logo.png");
            Singletons.menuPpal.setIconImage(icono);

            Singletons.menuPpal.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    JOptionPane.showMessageDialog(null, "Saliendo de la aplicacion");
                    System.exit(0);
                }
            });

            LoginBLL _tipoUsua = new LoginBLL();
            String usu = Singletons.log.txtUsuario.getText();
            Singletons.tipoUsuario = _tipoUsua.TipoUsuarioBLL(usu);

            if (Singletons.conectado.equals("no")) {
                Singletons.menuPpal.MenuCli.setVisible(false);
                Singletons.menuPpal.fotoppal.setVisible(false);
                Singletons.menuPpal.nomppal.setVisible(false);
                Singletons.menuPpal.salir.setVisible(false);

            } else if (Singletons.tipoUsuario.equals("Cliente") && (Singletons.conectado.equals("si"))) {

                Singletons.menuPpal.MenuCli.setVisible(false);
                Singletons.menuPpal.MenuSign.setVisible(false);
                Singletons.menuPpal.menuSobre.setVisible(false);
                Singletons.menuPpal.salir.setVisible(true);
                Singletons.menuPpal.salir.setText("Salir");

                Clientes clien = DAOGrafico.ObtenerClienteLogeado();
                Singletons.menuPpal.nomppal.setVisible(true);
                Singletons.PintaNombre = clien.getUsuario();
                Singletons.menuPpal.nomppal.setText(Singletons.PintaNombre);
                FileUploader.leer_imag(9);

            } else if (Singletons.tipoUsuario.equals("Administrador") && (Singletons.conectado.equals("si"))) {

                Singletons.menuPpal.MenuCli.setVisible(true);
                Singletons.menuPpal.MenuSign.setVisible(false);
                Singletons.menuPpal.menuSobre.setVisible(false);
                Singletons.menuPpal.salir.setVisible(true);
                Singletons.menuPpal.salir.setText("Salir");

                Clientes clien = DAOGrafico.ObtenerClienteLogeado();
                Singletons.menuPpal.nomppal.setVisible(true);
                Singletons.PintaNombre = clien.getUsuario();
                Singletons.menuPpal.nomppal.setText(Singletons.PintaNombre);
                FileUploader.leer_imag(9);

            } else {
                Singletons.menuPpal.MenuSign.setVisible(false);
            }

            Singletons.menuPpal.MenuPager.setActionCommand("_MENU_PAGER");
            Singletons.menuPpal.MenuPager.addActionListener(this);

            Singletons.menuPpal.menuProd.setActionCommand("_MENU_PROD");
            Singletons.menuPpal.menuProd.addActionListener(this);

            Singletons.menuPpal.entrarIni.setActionCommand("_SIGN_IN");
            Singletons.menuPpal.entrarIni.addActionListener(this);

            Singletons.menuPpal.nomppal.setName("_MIPERFIL");
            Singletons.menuPpal.nomppal.addMouseListener(this);

            Singletons.menuPpal.salir.setName("_SALIR");
            Singletons.menuPpal.salir.addMouseListener(this);
            
            Singletons.menuPpal.menuAqui.setActionCommand("_MENU_SOBRE");
            Singletons.menuPpal.menuAqui.addActionListener(this);
            
        }
        
        if (i == 1) {
            Singletons.sobre.setVisible(true);
            Singletons.sobre.setResizable(false);
            Singletons.sobre.setTitle("Sobre Nosotros");
            Singletons.sobre.setLocationRelativeTo(null);
            Singletons.sobre.setSize(935, 640); //ancho x alto
            Image icono = Toolkit.getDefaultToolkit().getImage("src/TPV_Moviles/Img/logo.png");
            Singletons.sobre.setIconImage(icono);

            Singletons.sobre.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    JOptionPane.showMessageDialog(null, "Saliendo de la aplicacion");
                    System.exit(0);
                }
            });
            
            Singletons.sobre.btnVolverNos.setActionCommand("_BTN_VOLVER_SOBRE");
            Singletons.sobre.btnVolverNos.addActionListener(this);
        }

        // Opciones de configuracion
        Singletons.config.aparienciaMetal.setActionCommand(
                "_aparienciaMetal");
        Singletons.config.aparienciaMetal.addActionListener(
                this);

        Singletons.config.aparienciaGTK.setActionCommand(
                "_aparienciaGTK");
        Singletons.config.aparienciaGTK.addActionListener(
                this);

        Singletons.config.aparienciaNimbus.setActionCommand(
                "_aparienciaNimbus");
        Singletons.config.aparienciaNimbus.addActionListener(
                this);

        Singletons.config.Euro.setActionCommand(
                "_euro");
        Singletons.config.Euro.addActionListener(
                this);

        Singletons.config.Libra.setActionCommand(
                "_libra");
        Singletons.config.Libra.addActionListener(
                this);

        Singletons.config.Dolar.setActionCommand(
                "_dolar");
        Singletons.config.Dolar.addActionListener(
                this);

        Singletons.config.fecha4.setActionCommand(
                "_fecha4");
        Singletons.config.fecha4.addActionListener(
                this);

        Singletons.config.fecha5.setActionCommand(
                "_fecha5");
        Singletons.config.fecha5.addActionListener(
                this);

        Singletons.config.fecha6.setActionCommand(
                "_fecha6");
        Singletons.config.fecha6.addActionListener(
                this);

        Singletons.config.fecha1.setActionCommand(
                "_fecha1");
        Singletons.config.fecha1.addActionListener(
                this);

        Singletons.config.fecha2.setActionCommand(
                "_fecha2");
        Singletons.config.fecha2.addActionListener(
                this);

        Singletons.config.fecha3.setActionCommand(
                "_fecha3");
        Singletons.config.fecha3.addActionListener(
                this);

        Singletons.config.decimal1.setActionCommand(
                "_decimal1");
        Singletons.config.decimal1.addActionListener(
                this);

        Singletons.config.decimal2.setActionCommand(
                "_decimal2");
        Singletons.config.decimal2.addActionListener(
                this);

        Singletons.config.decimal3.setActionCommand(
                "_decimal3");
        Singletons.config.decimal3.addActionListener(
                this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        switch (Accion.valueOf(ae.getActionCommand())) {

            //Configuracion del Menu
            case _MENU_PAGER:
                new Controlador_Inicio(new interfaz_Clientes(), 1).iniciar(0);
                Singletons.PagerCli.setVisible(true);
                Singletons.menuPpal.dispose();
                break;

            case _MENU_CONFIG:
                new Controlador_Inicio(new Ventana_Inicio(), 2).iniciar(0);
                break;

            case _MENU_PROD:
                new Controlador_Inicio(new Ventana_Prod(), 3).iniciar(0);
                SingletonsPro.PagerPro.setVisible(true);
                Singletons.menuPpal.dispose();
                break;

            case _SIGN_IN:
                new Controlador_Inicio(new Login(), 5).iniciar(0);
                Singletons.log.setVisible(true);
                Singletons.menuPpal.dispose();
                break;
                
            case _MENU_SOBRE:
                new Controlador_Inicio(new SobreNosotros(), 6).iniciar(1);
                Singletons.menuPpal.dispose();
                Singletons.sobre.setVisible(true);
                break;
                
            case _BTN_VOLVER_SOBRE:
                new Controlador_Inicio(new Ventana_Inicio(),0).iniciar(0);
                Singletons.sobre.dispose();
                Singletons.menuPpal.setVisible(true);
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

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (Accion.valueOf(e.getComponent().getName())) {

            case _SALIR:
                LoginBLL _tipoUsuar = new LoginBLL();
                String u = Singletons.log.txtUsuario.getText();
                Singletons.tipoUsuario = _tipoUsuar.TipoUsuarioBLL(u);

                if ((Singletons.tipoUsuario.equals("Administrador")) || (Singletons.tipoUsuario.equals("Cliente"))) {
                    Singletons.conectado = "no";
                    JOptionPane.showMessageDialog(null, "Gracias por su visita");
                    Singletons.menuPpal.dispose();
                    System.exit(0);
                }
                break;

            case _MIPERFIL:
                LoginBLL _tipoUsuario = new LoginBLL();
                String usua = Singletons.log.txtUsuario.getText();
                Singletons.tipoUsuario = _tipoUsuario.TipoUsuarioBLL(usua);

                if ((Singletons.tipoUsuario.equals("Cliente")) && (Singletons.conectado.equals("si"))) {
                    BLLBD cli = new BLLBD();
                    cli.listarClienteBLL();
                    Singletons.menuPpal.dispose();
                    new Controlador_Cli(new ModificarCli(), 1).iniciar(1);
                }
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        switch (Accion.valueOf(e.getComponent().getName())) {

            case _SALIR:
                Singletons.menuPpal.salir.setForeground(Color.white);
                break;
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

        switch (Accion.valueOf(e.getComponent().getName())) {

            case _SALIR:
                Singletons.menuPpal.salir.setForeground(Color.orange);
                break;
        }
    }
}
