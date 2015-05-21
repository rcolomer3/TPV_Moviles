/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPV_Moviles.Modulos.GestionClientes.GestionCli.Controlador;

import TPV_Moviles.Librerias.FileUploader;
import TPV_Moviles.Clases.JDKPConFondo;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.BLL.BLLBD;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.BLL.BLLGrafico;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.Clientes;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.Singletons;
import static TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.Singletons.AL_Clie;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.miniSimpleTableModel_Cli;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.DAO.DAOGrafico;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Pager.pagina;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.AltaEF;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.ModificarEF;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.autocomplete.AutocompleteJComboBox;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.autocomplete.StringSearchable;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.interfaz_Clientes;
import static TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.interfaz_Clientes.TABLA;
import static TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.interfaz_Clientes.buscador;
import static TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.interfaz_Clientes.panelPager;
import TPV_Moviles.Modulos.Inicio.ControladorInicio.Controlador_Inicio;
import TPV_Moviles.Modulos.Inicio.Vista.Ventana_Empleados;
import TPV_Moviles.Modulos.Login.BLL.LoginBLL;
import TPV_Moviles.Modulos.Login.Controlador_Login.Controlador_Login;
import TPV_Moviles.Modulos.Login.Vista.Login;
import TPV_Moviles.Ppal;
import TPV_Moviles.Utiles.Menus;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Raul
 */
public class Controlador_EF implements ActionListener, KeyListener, MouseListener {

    public static TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(new miniSimpleTableModel_Cli());
    private JDKPConFondo fondo = new JDKPConFondo();
    public static int modo = 1;

    public enum Accion {

        // Acciones de Alta Empleado 
        _TXT_NOMBRE,
        _TXT_APELLIDOS,
        _TXT_DNI,
        _TXT_TELEFONO,
        _TXT_FNACIMIENTO,
        _TXT_FALTA,
        _BTN_ANYADIR,
        _BTN_LIMPIAR,
        _BTN_VOLVER_LISTADO,
        _TXT_EMAIL,
        _CMB_TIPO_ALTA,
        // Acciones de Modificar Empleado
        _TXT_ModiNOMBRE,
        _TXT_ModiAPELLIDOS,
        _TXT_ModiTELEFONO,
        _TXT_ModiFNACIMIENTO,
        _TXT_ModiFALTA,
        _TXT_ModiUSUARIO,
        _TXT_ModiPASSWORD,
        _TXT_ModiEMAIL,
        _BTN_MODIFICAR_EMP,
        _BTN_CANCELAR,
        _BTN_VOLVER_ModiLISTADO,
        _BTN_CAMBIARAVATAR,
        _CMB_TIPO_Modif,
        // Acciones del Pager
        _BTN_ANTERIOR,
        _BTN_SIGUIENTE,
        _BTN_ULTIMO,
        _BTN_PRIMERO,
        _COMBOX,
        _BUSCADOR,
        _TABLA_CLICKED,
        _BTN_GUARDAR,
        _BTN_ABRIR,
        _BTN_CREAR,
        _BTN_MODIFICAR,
        _BTN_ELIMINAR,
        _BTN_INFO,
        _BTN_VOLVER,
        _BTN_EDADMINMAX,
        _BTN_EDAD_MEDIA,
        _AVATAR_MIPERFIL,
        _CERRAR
    }

    public Controlador_EF(JFrame pager, int i) {

        if (i == 0) {
            Singletons.CrearEF = (AltaEF) pager;
        }

        if (i == 1) {
            Singletons.ModificarEF = (ModificarEF) pager;
        }

        if (i == 2) {
            Singletons.PagerEF = (interfaz_Clientes) pager;
        }
    }

    public void iniciar(int i) {

        if (i == 0) { // Ventana de Alta empleado

            Singletons.CrearEF.setVisible(true);
            Singletons.CrearEF.setResizable(false);
            Singletons.CrearEF.setSize(637, 478); //ancho x alto
            Singletons.CrearEF.setTitle("Alta Nuevo Cliente");

            Singletons.CrearEF.setLocationRelativeTo(null);
            Image icono = Toolkit.getDefaultToolkit().getImage("src/TPV/Img/LogoInicio.jpg");
            Singletons.CrearEF.setIconImage(icono);

            Singletons.CrearEF.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    JOptionPane.showMessageDialog(null, "Saliendo de la aplicación");
                    System.exit(0);
                }
            });

            if (Singletons.conectado.equals("si")) {
                BLLGrafico.OcultarErroresAlta();
                Clientes clien = DAOGrafico.ObtenerClienteLogeado();

                Singletons.CrearEF.labelNomUsu.setVisible(true);

                Singletons.PintaNombre = clien.getUsuario();

                Singletons.CrearEF.labelNomUsu.setText(Singletons.PintaNombre);
                FileUploader.leer_imag(2);
            } else if (Singletons.conectado.equals("no")) {
                BLLGrafico.OcultarErroresRegistro();
            }

            Singletons.CrearEF.txtNombre.setName("_TXT_NOMBRE");
            Singletons.CrearEF.txtNombre.setActionCommand("_TXT_NOMBRE");
            Singletons.CrearEF.txtNombre.addActionListener(this);
            Singletons.CrearEF.txtNombre.addKeyListener(this);

            Singletons.CrearEF.txtApellidos.setName("_TXT_APELLIDOS");
            Singletons.CrearEF.txtApellidos.setActionCommand("_TXT_APELLIDOS");
            Singletons.CrearEF.txtApellidos.addActionListener(this);
            Singletons.CrearEF.txtApellidos.addKeyListener(this);

            Singletons.CrearEF.txtDNI.setName("_TXT_DNI");
            Singletons.CrearEF.txtDNI.setActionCommand("_TXT_DNI");
            Singletons.CrearEF.txtDNI.addActionListener(this);
            Singletons.CrearEF.txtDNI.addKeyListener(this);

            Singletons.CrearEF.txtTelefono.setName("_TXT_TELEFONO");
            Singletons.CrearEF.txtTelefono.setActionCommand("_TXT_TELEFONO");
            Singletons.CrearEF.txtTelefono.addActionListener(this);
            Singletons.CrearEF.txtTelefono.addKeyListener(this);

            Singletons.CrearEF.dcfnac.setName("_TXT_FNACIMIENTO");
            Singletons.CrearEF.dcfnac.addKeyListener(this);

            Singletons.CrearEF.dcFAlta.setName("_TXT_FALTA");
            Singletons.CrearEF.dcFAlta.addKeyListener(this);

            Singletons.CrearEF.btnAnyadir.setActionCommand("_BTN_ANYADIR");
            Singletons.CrearEF.btnAnyadir.addActionListener(this);

            Singletons.CrearEF.btnLimpiar.setActionCommand("_BTN_LIMPIAR");
            Singletons.CrearEF.btnLimpiar.addActionListener(this);

            Singletons.CrearEF.btnVolver.setActionCommand("_BTN_VOLVER_LISTADO");
            Singletons.CrearEF.btnVolver.addActionListener(this);

            Singletons.CrearEF.txtEmail.setName("_TXT_EMAIL");
            Singletons.CrearEF.txtEmail.setActionCommand("_TXT_EMAIL");
            Singletons.CrearEF.txtEmail.addActionListener(this);
            Singletons.CrearEF.txtEmail.addKeyListener(this);
            
            Singletons.CrearEF.cmbTipo.setActionCommand("_CMB_TIPO_ALTA");
            Singletons.CrearEF.cmbTipo.setName("_CMB_TIPO_ALTA");
            Singletons.CrearEF.cmbTipo.addActionListener(this);

        }

        if (i == 1) { // Ventana de Modificar Empleado

            Singletons.ModificarEF.setVisible(true);
            Singletons.ModificarEF.setResizable(false);
            Singletons.ModificarEF.setLocation(2, 30);
            Singletons.ModificarEF.setSize(708, 500); //ancho x alto
            Singletons.ModificarEF.setTitle("Modificar Cliente Registrado");
            Singletons.ModificarEF.setLocationRelativeTo(null);
            Image icono = Toolkit.getDefaultToolkit().getImage("src/TPV/Img/LogoInicio.jpg");
            Singletons.ModificarEF.setIconImage(icono);

            Singletons.ModificarEF.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    JOptionPane.showMessageDialog(null, "Saliendo de la aplicación");
                    System.exit(0);
                }
            });

            BLLGrafico.OcultarErroresModificar();
            BLLGrafico.ModificarPager();

            Clientes clien = DAOGrafico.ObtenerClienteLogeado();

            Singletons.ModificarEF.etiNomUsuario.setVisible(true);

            Singletons.PintaNombre = clien.getUsuario();

            Singletons.ModificarEF.etiNomUsuario.setText(Singletons.PintaNombre);
            FileUploader.leer_imag(1);

            Singletons.ModificarEF.txtNombre.setName("_TXT_ModiNOMBRE");
            Singletons.ModificarEF.txtNombre.setActionCommand("_TXT_ModiNOMBRE");
            Singletons.ModificarEF.txtNombre.addActionListener(this);
            Singletons.ModificarEF.txtNombre.addKeyListener(this);

            Singletons.ModificarEF.txtApellidos.setName("_TXT_ModiAPELLIDOS");
            Singletons.ModificarEF.txtApellidos.setActionCommand("_TXT_ModiAPELLIDOS");
            Singletons.ModificarEF.txtApellidos.addActionListener(this);
            Singletons.ModificarEF.txtApellidos.addKeyListener(this);

            Singletons.ModificarEF.txtTelefono.setName("_TXT_ModiTELEFONO");
            Singletons.ModificarEF.txtTelefono.setActionCommand("_TXT_ModiTELEFONO");
            Singletons.ModificarEF.txtTelefono.addActionListener(this);
            Singletons.ModificarEF.txtTelefono.addKeyListener(this);

            Singletons.ModificarEF.dcFnac.setName("_TXT_ModiFNACIMIENTO");
            Singletons.ModificarEF.dcFnac.addKeyListener(this);

            Singletons.ModificarEF.dcFalta.setName("_TXT_ModiFALTA");
            Singletons.ModificarEF.dcFalta.addKeyListener(this);

            Singletons.ModificarEF.txtUsuario.setName("_TXT_ModiUSUARIO");
            Singletons.ModificarEF.txtUsuario.setActionCommand("_TXT_ModiUSUARIO");
            Singletons.ModificarEF.txtUsuario.addActionListener(this);
            Singletons.ModificarEF.txtUsuario.addKeyListener(this);

            Singletons.ModificarEF.txtPassword.setName("_TXT_ModiPASSWORD");
            Singletons.ModificarEF.txtPassword.setActionCommand("_TXT_ModiPASSWORD");
            Singletons.ModificarEF.txtPassword.addActionListener(this);
            Singletons.ModificarEF.txtPassword.addKeyListener(this);

            Singletons.ModificarEF.txtEmail.setName("_TXT_ModiEMAIL");
            Singletons.ModificarEF.txtEmail.setActionCommand("_TXT_ModiEMAIL");
            Singletons.ModificarEF.txtEmail.addActionListener(this);
            Singletons.ModificarEF.txtEmail.addKeyListener(this);

            Singletons.ModificarEF.btnModificar.setActionCommand("_BTN_MODIFICAR_EMP");
            Singletons.ModificarEF.btnModificar.addActionListener(this);

            Singletons.ModificarEF.btnCancelar.setActionCommand("_BTN_CANCELAR");
            Singletons.ModificarEF.btnCancelar.addActionListener(this);

            Singletons.ModificarEF.btnVolver.setActionCommand("_BTN_VOLVER_ModiLISTADO");
            Singletons.ModificarEF.btnVolver.addActionListener(this);

            Singletons.ModificarEF.btnCambiarAvatar.setActionCommand("_BTN_CAMBIARAVATAR");
            Singletons.ModificarEF.btnCambiarAvatar.addActionListener(this);

            Singletons.ModificarEF.cmbTipoUser.setActionCommand("_CMB_TIPO_Modif");
            Singletons.ModificarEF.cmbTipoUser.setName("_CMB_TIPO_Modif");
            Singletons.ModificarEF.cmbTipoUser.addActionListener(this);
        }

        if (i == 2) { //Ventana del pager

            Singletons.PagerEF.setLocationRelativeTo(null);
            Singletons.PagerEF.setTitle("Empleados fijos");
            Singletons.PagerEF.setResizable(false);
            Container content = Singletons.PagerEF.getContentPane();
            content.setLayout(new BorderLayout());
            //content.add(fondo, BorderLayout.CENTER);

            panelPager.setOpaque(false);
            panelPager.setVisible(true);

            Singletons.PagerEF.setSize(819, 715); // //ancho x alto
            Image icono = Toolkit.getDefaultToolkit().getImage("src/TPV/Img/LogoInicio.jpg");
            Singletons.PagerEF.setIconImage(icono);

            Singletons.PagerEF.TABLA.setModel(new miniSimpleTableModel_Cli());
            ((miniSimpleTableModel_Cli) Singletons.PagerEF.TABLA.getModel()).cargar();
            Singletons.PagerEF.TABLA.setFillsViewportHeight(true);
            Singletons.PagerEF.TABLA.setRowSorter(Singletons.sorter);

            pagina.inicializa();
            pagina.initLinkBox();

            Singletons.PagerEF.contFiltrar.setText(String.valueOf(Singletons.AL_Clie.size()));

            Singletons.PagerEF.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    JOptionPane.showMessageDialog(null, "Saliendo de la aplicacion");
                    System.exit(0);
                }
            });

            List<String> myWords = new ArrayList<String>();
            for (int k = 0; k <= AL_Clie.size() - 1; k++) {
                myWords.add(AL_Clie.get(k).getDni());
            }

            StringSearchable searchable = new StringSearchable(myWords);
            Singletons.combo = new AutocompleteJComboBox(searchable);
            buscador.setLayout(new java.awt.BorderLayout());
            buscador.add(Singletons.combo);

            Singletons.combo.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    comboActionPerformed(evt);
                }
            });

            Clientes clie = DAOGrafico.ObtenerClienteLogeado();

            Singletons.PagerEF.etiNombreUsu.setVisible(true);

            Singletons.PagerEF.txtCerrar.setVisible(true);
            Singletons.PagerEF.txtCerrar.setText("Cerrar sesión");

            Singletons.PintaNombre = clie.getUsuario();

            Singletons.PagerEF.etiNombreUsu.setText(Singletons.PintaNombre);
            Singletons.PagerEF.labelAvatar.setVisible(true);
            FileUploader.leer_imag(0);

            Singletons.PagerEF.ANTERIOR.setActionCommand("_BTN_ANTERIOR");
            Singletons.PagerEF.ANTERIOR.addActionListener(this);

            Singletons.PagerEF.SIGUIENTE.setActionCommand("_BTN_SIGUIENTE");
            Singletons.PagerEF.SIGUIENTE.addActionListener(this);

            Singletons.PagerEF.ultimo.setActionCommand("_BTN_ULTIMO");
            Singletons.PagerEF.ultimo.addActionListener(this);

            Singletons.PagerEF.primero.setActionCommand("_BTN_PRIMERO");
            Singletons.PagerEF.primero.addActionListener(this);

            Singletons.PagerEF.jComboBox1.setActionCommand("_COMBOX");
            Singletons.PagerEF.jComboBox1.addActionListener(this);

            Singletons.PagerEF.buscador.setName("_BUSCADOR");
            Singletons.PagerEF.buscador.setActionCommand("_BUSCADOR");
            Singletons.PagerEF.buscador.addActionListener(this);
            Singletons.PagerEF.buscador.addKeyListener(this);

            Singletons.PagerEF.TABLA.setName("_TABLA_CLICKED");
            Singletons.PagerEF.TABLA.addMouseListener(this);
            Singletons.PagerEF.TABLA.addKeyListener(this);

            Singletons.PagerEF.btnCrear.setActionCommand("_BTN_CREAR");
            Singletons.PagerEF.btnCrear.setName("_BTN_CREAR");
            Singletons.PagerEF.btnCrear.addActionListener(this);
            Singletons.PagerEF.btnCrear.addMouseListener(this);

            Singletons.PagerEF.btnModificar.setActionCommand("_BTN_MODIFICAR");
            Singletons.PagerEF.btnModificar.setName("_BTN_MODIFICAR");
            Singletons.PagerEF.btnModificar.addActionListener(this);
            Singletons.PagerEF.btnModificar.addMouseListener(this);

            Singletons.PagerEF.btnEliminar.setActionCommand("_BTN_ELIMINAR");
            Singletons.PagerEF.btnEliminar.setName("_BTN_ELIMINAR");
            Singletons.PagerEF.btnEliminar.addActionListener(this);
            Singletons.PagerEF.btnEliminar.addMouseListener(this);

            Singletons.PagerEF.btnInfo.setActionCommand("_BTN_INFO");
            Singletons.PagerEF.btnInfo.setName("_BTN_INFO");
            Singletons.PagerEF.btnInfo.addActionListener(this);
            Singletons.PagerEF.btnInfo.addMouseListener(this);

            Singletons.PagerEF.btnVolver.setActionCommand("_BTN_VOLVER");
            Singletons.PagerEF.btnVolver.addActionListener(this);

            Singletons.PagerEF.btnGuardar.setActionCommand("_BTN_GUARDAR");
            Singletons.PagerEF.btnGuardar.setName("_BTN_GUARDAR");
            Singletons.PagerEF.btnGuardar.addActionListener(this);
            Singletons.PagerEF.btnGuardar.addMouseListener(this);

            Singletons.PagerEF.btnAbrir.setActionCommand("_BTN_ABRIR");
            Singletons.PagerEF.btnAbrir.setName("_BTN_ABRIR");
            Singletons.PagerEF.btnAbrir.addActionListener(this);
            Singletons.PagerEF.btnAbrir.addMouseListener(this);

            Singletons.PagerEF.btnEdad.setActionCommand("_BTN_EDADMINMAX");
            Singletons.PagerEF.btnEdad.addActionListener(this);

            Singletons.PagerEF.btnMedia.setActionCommand("_BTN_EDAD_MEDIA");
            Singletons.PagerEF.btnMedia.addActionListener(this);

            Singletons.PagerEF.etiNombreUsu.setName("_AVATAR_MIPERFIL");
            Singletons.PagerEF.etiNombreUsu.addMouseListener(this);

            Singletons.PagerEF.txtCerrar.setName("_CERRAR");
            Singletons.PagerEF.txtCerrar.addMouseListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        switch (Accion.valueOf(ae.getActionCommand())) {

            case _BTN_ANTERIOR:
                pagina.currentPageIndex -= 1;
                pagina.initLinkBox();
                break;

            case _BTN_SIGUIENTE:
                pagina.currentPageIndex += 1;
                pagina.initLinkBox();
                break;

            case _BTN_ULTIMO:
                pagina.currentPageIndex = pagina.maxPageIndex;
                pagina.initLinkBox();
                break;

            case _BTN_PRIMERO:
                pagina.currentPageIndex = 1;
                pagina.initLinkBox();
                break;

            case _COMBOX:
                pagina.itemsPerPage = Integer.parseInt(Singletons.PagerEF.jComboBox1.getSelectedItem().toString());
                pagina.currentPageIndex = 1;
                pagina.initLinkBox();
                break;

            case _BTN_CREAR:
                LoginBLL _tipoUsu = new LoginBLL();
                String usuario = Singletons.log.txtUsuario.getText();
                Singletons.tipoUsuario = _tipoUsu.TipoUsuarioBLL(usuario);

                if (Singletons.tipoUsuario.equals("Administrador")) {
                    Singletons.PagerEF.dispose();
                    new Controlador_EF(new AltaEF(), 0).iniciar(0);
                } else if (Singletons.tipoUsuario.equals("user")) {
                    Singletons.PagerEF.btnCrear.setEnabled(false);
                }
                break;

            case _BTN_MODIFICAR:
                LoginBLL _tipoUsua = new LoginBLL();
                String usu = Singletons.log.txtUsuario.getText();
                Singletons.tipoUsuario = _tipoUsua.TipoUsuarioBLL(usu);

                if (Singletons.tipoUsuario.equals("Administrador")) {
                    if (Singletons.e != null) {
                        Singletons.PagerEF.dispose();
                        new Controlador_EF(new ModificarEF(), 1).iniciar(1);
                    }
                } else if (Singletons.tipoUsuario.equals("user")) {
                    Singletons.PagerEF.btnModificar.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(null, "No hay un empleado seleccionado", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
                break;

            case _BTN_ELIMINAR:
                LoginBLL _tipoUsuario = new LoginBLL();
                String usua = Singletons.log.txtUsuario.getText();
                Singletons.tipoUsuario = _tipoUsuario.TipoUsuarioBLL(usua);

                if (Singletons.tipoUsuario.equals("Administrador")) {
                    if (Singletons.e != null) {
                        BLLGrafico.EliminarPager();
                    }
                } else if (Singletons.tipoUsuario.equals("user")) {
                    Singletons.PagerEF.btnEliminar.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(null, "No hay un empleado seleccionado", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
                break;

            case _BTN_INFO:
                if (Singletons.e != null) {
                    BLLGrafico.InformacionEFPager();
                } else {
                    JOptionPane.showMessageDialog(null, "No hay un empleado seleccionado", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
                break;

            case _BTN_VOLVER:
                Singletons.PagerEF.dispose();
                new Controlador_Inicio(new Ventana_Empleados(), 0).iniciar(0);
                break;

            case _BTN_GUARDAR:
                Ppal.conf.setGuardar(Menus.ConfigurarGuardado());
                BLLGrafico.GuardarAPeticionUsuario();
                break;

            case _BTN_ABRIR:
                Ppal.conf.setAbrir(Menus.ConfigurarAbrir());
                BLLGrafico.AbrirAPeticionUsuario();
                break;

            case _TXT_NOMBRE:
                BLLGrafico.pideNombre();
                break;

            case _TXT_APELLIDOS:
                BLLGrafico.pideApellidos();
                break;

            case _TXT_DNI:
                BLLGrafico.pideDNI();
                break;

            case _TXT_TELEFONO:
                BLLGrafico.pideTelefono();
                break;

            case _TXT_FNACIMIENTO:
                BLLGrafico.pideFNacimiento();
                break;

            case _TXT_FALTA:
                BLLGrafico.pideFAlta();
                break;

            case _BTN_ANYADIR:
                BLLGrafico.guardarEmpleadoEF();
                break;

            case _BTN_LIMPIAR:
                BLLGrafico.LimpiarCreaCliente();
                break;

            case _BTN_VOLVER_LISTADO:
                Singletons.CrearEF.dispose();
                Singletons.PagerEF.setVisible(true);
                break;

            case _TXT_EMAIL:
                BLLGrafico.pideEmail();
                break;

            case _TXT_ModiNOMBRE:
                BLLGrafico.ModiNombre();
                break;

            case _TXT_ModiAPELLIDOS:
                BLLGrafico.ModApellidos();
                break;

            case _TXT_ModiTELEFONO:
                BLLGrafico.ModpideTelefono();
                break;

            case _TXT_ModiFNACIMIENTO:
                BLLGrafico.ModpideFNacimiento();
                break;

            case _TXT_ModiFALTA:
                BLLGrafico.ModpideFAlta();
                break;

            case _TXT_ModiUSUARIO:
                BLLGrafico.ModipideUsuario();
                break;

            case _TXT_ModiPASSWORD:
                BLLGrafico.ModpidePassword();
                break;

            case _TXT_ModiEMAIL:
                BLLGrafico.ModpideEmail();
                break;

            case _BTN_MODIFICAR_EMP:
                BLLGrafico.ModificarEF();
                break;

            case _BTN_CANCELAR:
                BLLGrafico.LimpiarModificar();
                break;

            case _BTN_VOLVER_ModiLISTADO:
                Singletons.ModificarEF.dispose();
                Singletons.PagerEF.setVisible(true);
                break;

            case _BTN_EDADMINMAX:
                BLLBD _empleado = new BLLBD();
                _empleado.empleadoMenorMayorBLL();
                break;

            case _BTN_EDAD_MEDIA:
                BLLBD _empleadoDAO = new BLLBD();
                _empleadoDAO.EdadMediaBLL();
                break;

            case _BTN_CAMBIARAVATAR:
                FileUploader.guardar_img();
                break;

            case _CMB_TIPO_ALTA:
                AltaEF.cmbTipo.getSelectedItem().toString();
                break;

            case _CMB_TIPO_Modif:
                ModificarEF.cmbTipoUser.getSelectedItem().toString();
                break;

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

        switch (Accion.valueOf(e.getComponent().getName())) {

            case _TXT_NOMBRE:
                BLLGrafico.pideNombreKey();
                break;

            case _TXT_APELLIDOS:
                BLLGrafico.pideApellidosKey();
                break;

            case _TXT_DNI:
                BLLGrafico.pideDNIkey();
                break;

            case _TXT_TELEFONO:
                BLLGrafico.pideTelefono();
                break;

            case _TXT_EMAIL:
                BLLGrafico.pideEmailKey();
                break;

            case _TXT_ModiNOMBRE:
                BLLGrafico.ModiNombreKey();
                break;

            case _TXT_ModiAPELLIDOS:
                BLLGrafico.ModipideApellidosKey();
                break;

            case _TXT_ModiTELEFONO:
                BLLGrafico.ModpideTelefono();
                break;

            case _TXT_ModiUSUARIO:
                BLLGrafico.ModipideUsuario();
                break;

            case _TXT_ModiPASSWORD:
                BLLGrafico.ModpidePassword();
                break;

            case _TXT_ModiEMAIL:
                BLLGrafico.ModpideEmailKey();
                break;

            // Funcion para filtrar empleados por Dni
            case _BUSCADOR:
                pagina.currentPageIndex = 1;
                ((miniSimpleTableModel_Cli) Singletons.PagerEF.TABLA.getModel()).filtrar();
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (Accion.valueOf(e.getComponent().getName())) {

            case _TXT_NOMBRE:
                BLLGrafico.pideNombreKeyPressed();
                break;

            case _TXT_APELLIDOS:
                BLLGrafico.pideApellidosKeyPressed();
                break;

            case _TXT_DNI:
                BLLGrafico.pideDNIKeyPressed();
                break;

            case _TXT_TELEFONO:
                BLLGrafico.pideTelefono();
                break;

            case _TXT_EMAIL:
                BLLGrafico.pideEmailKeyPressed();
                break;

            case _TXT_ModiNOMBRE:
                BLLGrafico.ModiNombreKeyPressed();
                break;

            case _TXT_ModiAPELLIDOS:
                BLLGrafico.ModipideApellidosKeyPressed();
                break;

            case _TXT_ModiTELEFONO:
                BLLGrafico.ModpideTelefono();
                break;

            case _TXT_ModiUSUARIO:
                BLLGrafico.ModipideUsuario();
                break;

            case _TXT_ModiPASSWORD:
                BLLGrafico.ModpidePassword();
                break;

            case _TXT_ModiEMAIL:
                BLLGrafico.ModpideEmailKeyPressed();
                break;

            // Funcion para filtrar empleados por Dni
            case _BUSCADOR:
                pagina.currentPageIndex = 1;
                ((miniSimpleTableModel_Cli) Singletons.PagerEF.TABLA.getModel()).filtrar();
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        switch (Accion.valueOf(me.getComponent().getName())) {
            case _TABLA_CLICKED:
                try {
                    Singletons.e = new Clientes(interfaz_Clientes.TABLA.getValueAt(interfaz_Clientes.TABLA.getSelectedRow(), 2).toString());
                    BLLBD.buscarPorDniBLL();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No has seleccionado ningún empleado", "ERROR", JOptionPane.WARNING_MESSAGE);
                }
                break;

            case _AVATAR_MIPERFIL:
                LoginBLL _tipoUsuario = new LoginBLL();
                String usua = Singletons.log.txtUsuario.getText();
                Singletons.tipoUsuario = _tipoUsuario.TipoUsuarioBLL(usua);

                if (Singletons.tipoUsuario.equals("user")) {
                    Singletons.PagerEF.dispose();
                    new Controlador_EF(new ModificarEF(), 1).iniciar(1);
                }
                break;

            case _CERRAR:
                Singletons.PagerEF.dispose();
                new Controlador_Login(new Login(), 0).iniciar(0);
                Singletons.conectado = "no";
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
    public void mouseEntered(MouseEvent me) {
        switch (Accion.valueOf(me.getComponent().getName())) {

            case _BTN_CREAR:
                Singletons.PagerEF.btnCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV/Img/edit_add.png")));
                break;

            case _BTN_MODIFICAR:
                Singletons.PagerEF.btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV/Img/color_line.png")));
                break;

            case _BTN_ELIMINAR:
                Singletons.PagerEF.btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV/Img/cancel.png")));
                break;

            case _BTN_INFO:
                Singletons.PagerEF.btnInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV/Img/info.png")));
                break;

            case _BTN_ABRIR:
                Singletons.PagerEF.btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV/Img/folder_orange_open.png")));
                break;

            case _BTN_GUARDAR:
                Singletons.PagerEF.btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV/Img/guardar.png")));
                break;

            case _CERRAR:
                Singletons.PagerEF.txtCerrar.setForeground(Color.white);
                break;
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {

        switch (Accion.valueOf(me.getComponent().getName())) {

            case _BTN_CREAR:
                Singletons.PagerEF.btnCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV/Img/edit_add_NS.png")));
                break;

            case _BTN_MODIFICAR:
                Singletons.PagerEF.btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV/Img/color_line_NS.png")));
                break;

            case _BTN_ELIMINAR:
                Singletons.PagerEF.btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV/Img/cancel_NS.png")));
                break;

            case _BTN_INFO:
                Singletons.PagerEF.btnInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV/Img/info_NS.png")));
                break;

            case _BTN_ABRIR:
                Singletons.PagerEF.btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV/Img/folder_yellow_open_NS.png")));
                break;

            case _BTN_GUARDAR:
                Singletons.PagerEF.btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV/Img/guardar_NS.png")));
                break;

            case _CERRAR:
                Singletons.PagerEF.txtCerrar.setForeground(Color.orange);
                break;

        }
    }

    public static void comboActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("word selected: " + ((JComboBox) Singletons.combo).getSelectedItem());
        pagina.currentPageIndex = 1;
        ((miniSimpleTableModel_Cli) TABLA.getModel()).filtrar();
    }
}
