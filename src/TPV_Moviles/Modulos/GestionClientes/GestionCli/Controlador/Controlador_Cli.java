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
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.AltaCli;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.ModificarCli;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.autocomplete.AutocompleteJComboBox;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.autocomplete.StringSearchable;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.interfaz_Clientes;
import static TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.interfaz_Clientes.TABLA;
import static TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.interfaz_Clientes.buscador;
import static TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.interfaz_Clientes.panelPager;
import TPV_Moviles.Modulos.Inicio.ControladorInicio.Controlador_Inicio;
import TPV_Moviles.Modulos.Inicio.Vista.Ventana_Inicio;
import TPV_Moviles.Modulos.Login.BLL.LoginBLL;
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
public class Controlador_Cli implements ActionListener, KeyListener, MouseListener {

    public static TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(new miniSimpleTableModel_Cli());
    private JDKPConFondo fondo = new JDKPConFondo();

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
        _BTN_VOLVER_PPAL,
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
        _CERRAR
    }

    public Controlador_Cli(JFrame pager, int i) {

        if (i == 0) {
            Singletons.CrearCli = (AltaCli) pager;
        }

        if (i == 1) {
            Singletons.ModificarCli = (ModificarCli) pager;
        }

        if (i == 2) {
            Singletons.PagerCli = (interfaz_Clientes) pager;
        }
    }

    public void iniciar(int i) {

        if (i == 0) { // Ventana de Alta empleado

            Singletons.CrearCli.setVisible(true);
            Singletons.CrearCli.setResizable(false);
            Singletons.CrearCli.setSize(800, 550); //ancho x alto
            Singletons.CrearCli.setTitle("Alta Nuevo Cliente");

            Singletons.CrearCli.setLocationRelativeTo(null);
            Image icono = Toolkit.getDefaultToolkit().getImage("src/TPV_Moviles/Img/logo.png");
            Singletons.CrearCli.setIconImage(icono);

            Singletons.CrearCli.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    JOptionPane.showMessageDialog(null, "Saliendo de la aplicación");
                    System.exit(0);
                }
            });

            if (Singletons.conectado.equals("si")) {
                BLLGrafico.OcultarErroresAlta();
                
                Clientes clien = DAOGrafico.ObtenerClienteLogeado();
                
                Singletons.CrearCli.labelNomUsu.setVisible(true);

                Singletons.PintaNombre = clien.getUsuario();

                Singletons.CrearCli.labelNomUsu.setText(Singletons.PintaNombre);
                FileUploader.leer_imag(2);
            } else if (Singletons.conectado.equals("no")) {
                BLLGrafico.OcultarErroresRegistro();
            }

            Singletons.CrearCli.txtNombre.setName("_TXT_NOMBRE");
            Singletons.CrearCli.txtNombre.setActionCommand("_TXT_NOMBRE");
            Singletons.CrearCli.txtNombre.addActionListener(this);
            Singletons.CrearCli.txtNombre.addKeyListener(this);

            Singletons.CrearCli.txtApellidos.setName("_TXT_APELLIDOS");
            Singletons.CrearCli.txtApellidos.setActionCommand("_TXT_APELLIDOS");
            Singletons.CrearCli.txtApellidos.addActionListener(this);
            Singletons.CrearCli.txtApellidos.addKeyListener(this);

            Singletons.CrearCli.txtDNI.setName("_TXT_DNI");
            Singletons.CrearCli.txtDNI.setActionCommand("_TXT_DNI");
            Singletons.CrearCli.txtDNI.addActionListener(this);
            Singletons.CrearCli.txtDNI.addKeyListener(this);

            Singletons.CrearCli.txtTelefono.setName("_TXT_TELEFONO");
            Singletons.CrearCli.txtTelefono.setActionCommand("_TXT_TELEFONO");
            Singletons.CrearCli.txtTelefono.addActionListener(this);
            Singletons.CrearCli.txtTelefono.addKeyListener(this);

            Singletons.CrearCli.dcfnac.setName("_TXT_FNACIMIENTO");
            Singletons.CrearCli.dcfnac.addKeyListener(this);

            Singletons.CrearCli.dcFAlta.setName("_TXT_FALTA");
            Singletons.CrearCli.dcFAlta.addKeyListener(this);

            Singletons.CrearCli.btnAnyadir.setActionCommand("_BTN_ANYADIR");
            Singletons.CrearCli.btnAnyadir.addActionListener(this);

            Singletons.CrearCli.btnLimpiar.setActionCommand("_BTN_LIMPIAR");
            Singletons.CrearCli.btnLimpiar.addActionListener(this);

            Singletons.CrearCli.btnVolver.setActionCommand("_BTN_VOLVER_LISTADO");
            Singletons.CrearCli.btnVolver.addActionListener(this);

            Singletons.CrearCli.txtEmail.setName("_TXT_EMAIL");
            Singletons.CrearCli.txtEmail.setActionCommand("_TXT_EMAIL");
            Singletons.CrearCli.txtEmail.addActionListener(this);
            Singletons.CrearCli.txtEmail.addKeyListener(this);

            Singletons.CrearCli.cmbTipo.setActionCommand("_CMB_TIPO_ALTA");
            Singletons.CrearCli.cmbTipo.setName("_CMB_TIPO_ALTA");
            Singletons.CrearCli.cmbTipo.addActionListener(this);

        }

        if (i == 1) { // Ventana de Modificar Empleado

            Singletons.ModificarCli.setVisible(true);
            Singletons.ModificarCli.setResizable(false);
            Singletons.ModificarCli.setLocation(2, 30);
            Singletons.ModificarCli.setSize(1000, 550); //ancho x alto
            Singletons.ModificarCli.setTitle("Modificar Cliente Registrado");
            Singletons.ModificarCli.setLocationRelativeTo(null);
            Image icono = Toolkit.getDefaultToolkit().getImage("src/TPV_Moviles/Img/logo.png");
            Singletons.ModificarCli.setIconImage(icono);

            Singletons.ModificarCli.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    JOptionPane.showMessageDialog(null, "Saliendo de la aplicación");
                    System.exit(0);
                }
            });

            BLLGrafico.OcultarErroresModificar();
            BLLGrafico.ModificarPager();

            Clientes clien = DAOGrafico.ObtenerClienteLogeado();

            Singletons.ModificarCli.etiNomUsuario.setVisible(true);

            Singletons.PintaNombre = clien.getUsuario();

            Singletons.ModificarCli.etiNomUsuario.setText(Singletons.PintaNombre);
            FileUploader.leer_imag(1);

            Singletons.ModificarCli.txtNombre.setName("_TXT_ModiNOMBRE");
            Singletons.ModificarCli.txtNombre.setActionCommand("_TXT_ModiNOMBRE");
            Singletons.ModificarCli.txtNombre.addActionListener(this);
            Singletons.ModificarCli.txtNombre.addKeyListener(this);

            Singletons.ModificarCli.txtApellidos.setName("_TXT_ModiAPELLIDOS");
            Singletons.ModificarCli.txtApellidos.setActionCommand("_TXT_ModiAPELLIDOS");
            Singletons.ModificarCli.txtApellidos.addActionListener(this);
            Singletons.ModificarCli.txtApellidos.addKeyListener(this);

            Singletons.ModificarCli.txtTelefono.setName("_TXT_ModiTELEFONO");
            Singletons.ModificarCli.txtTelefono.setActionCommand("_TXT_ModiTELEFONO");
            Singletons.ModificarCli.txtTelefono.addActionListener(this);
            Singletons.ModificarCli.txtTelefono.addKeyListener(this);

            Singletons.ModificarCli.dcFnac.setName("_TXT_ModiFNACIMIENTO");
            Singletons.ModificarCli.dcFnac.addKeyListener(this);

            Singletons.ModificarCli.dcFalta.setName("_TXT_ModiFALTA");
            Singletons.ModificarCli.dcFalta.addKeyListener(this);

            Singletons.ModificarCli.txtUsuario.setName("_TXT_ModiUSUARIO");
            Singletons.ModificarCli.txtUsuario.setActionCommand("_TXT_ModiUSUARIO");
            Singletons.ModificarCli.txtUsuario.addActionListener(this);
            Singletons.ModificarCli.txtUsuario.addKeyListener(this);

            Singletons.ModificarCli.txtPassword.setName("_TXT_ModiPASSWORD");
            Singletons.ModificarCli.txtPassword.setActionCommand("_TXT_ModiPASSWORD");
            Singletons.ModificarCli.txtPassword.addActionListener(this);
            Singletons.ModificarCli.txtPassword.addKeyListener(this);

            Singletons.ModificarCli.txtEmail.setName("_TXT_ModiEMAIL");
            Singletons.ModificarCli.txtEmail.setActionCommand("_TXT_ModiEMAIL");
            Singletons.ModificarCli.txtEmail.addActionListener(this);
            Singletons.ModificarCli.txtEmail.addKeyListener(this);

            Singletons.ModificarCli.btnModificar.setActionCommand("_BTN_MODIFICAR_EMP");
            Singletons.ModificarCli.btnModificar.addActionListener(this);

            Singletons.ModificarCli.btnCancelar.setActionCommand("_BTN_CANCELAR");
            Singletons.ModificarCli.btnCancelar.addActionListener(this);

            Singletons.ModificarCli.btnVolver.setActionCommand("_BTN_VOLVER_ModiLISTADO");
            Singletons.ModificarCli.btnVolver.addActionListener(this);

            Singletons.ModificarCli.btnVolverMenu.setActionCommand("_BTN_VOLVER_PPAL");
            Singletons.ModificarCli.btnVolverMenu.addActionListener(this);

            Singletons.ModificarCli.btnCambiarAvatar.setActionCommand("_BTN_CAMBIARAVATAR");
            Singletons.ModificarCli.btnCambiarAvatar.addActionListener(this);

            Singletons.ModificarCli.cmbTipoUser.setActionCommand("_CMB_TIPO_Modif");
            Singletons.ModificarCli.cmbTipoUser.setName("_CMB_TIPO_Modif");
            Singletons.ModificarCli.cmbTipoUser.addActionListener(this);
        }

        if (i == 2) { //Ventana del pager

            Singletons.PagerCli.setLocationRelativeTo(null);
            Singletons.PagerCli.setTitle("Clientes Registrados");
            Singletons.PagerCli.setResizable(false);
            Container content = Singletons.PagerCli.getContentPane();
            content.setLayout(new BorderLayout());
            //content.add(fondo, BorderLayout.CENTER);

            panelPager.setOpaque(false);
            panelPager.setVisible(true);

            Singletons.PagerCli.setSize(819, 715); // //ancho x alto
            Image icono = Toolkit.getDefaultToolkit().getImage("src/TPV_Moviles/Img/logo.png");
            Singletons.PagerCli.setIconImage(icono);

            Singletons.PagerCli.TABLA.setModel(new miniSimpleTableModel_Cli());
            ((miniSimpleTableModel_Cli) Singletons.PagerCli.TABLA.getModel()).cargar();
            Singletons.PagerCli.TABLA.setFillsViewportHeight(true);
            Singletons.PagerCli.TABLA.setRowSorter(Singletons.sorter);

            pagina.inicializa();
            pagina.initLinkBox();

            Singletons.PagerCli.contFiltrar.setText(String.valueOf(Singletons.AL_Clie.size()));

            Singletons.PagerCli.addWindowListener(new WindowAdapter() {
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

            Clientes clien = DAOGrafico.ObtenerClienteLogeado();

            Singletons.PagerCli.etiNombreUsu.setVisible(true);

            Singletons.PagerCli.txtCerrar.setVisible(true);
            Singletons.PagerCli.txtCerrar.setText("Cerrar sesión");

            Singletons.PintaNombre = clien.getUsuario();

            Singletons.PagerCli.etiNombreUsu.setText(Singletons.PintaNombre);
            Singletons.PagerCli.labelAvatar.setVisible(true);
            FileUploader.leer_imag(0);

            Singletons.PagerCli.ANTERIOR.setActionCommand("_BTN_ANTERIOR");
            Singletons.PagerCli.ANTERIOR.addActionListener(this);

            Singletons.PagerCli.SIGUIENTE.setActionCommand("_BTN_SIGUIENTE");
            Singletons.PagerCli.SIGUIENTE.addActionListener(this);

            Singletons.PagerCli.ultimo.setActionCommand("_BTN_ULTIMO");
            Singletons.PagerCli.ultimo.addActionListener(this);

            Singletons.PagerCli.primero.setActionCommand("_BTN_PRIMERO");
            Singletons.PagerCli.primero.addActionListener(this);

            Singletons.PagerCli.jComboBox1.setActionCommand("_COMBOX");
            Singletons.PagerCli.jComboBox1.addActionListener(this);

            Singletons.PagerCli.buscador.setName("_BUSCADOR");
            Singletons.PagerCli.buscador.setActionCommand("_BUSCADOR");
            Singletons.PagerCli.buscador.addActionListener(this);
            Singletons.PagerCli.buscador.addKeyListener(this);

            Singletons.PagerCli.TABLA.setName("_TABLA_CLICKED");
            Singletons.PagerCli.TABLA.addMouseListener(this);
            Singletons.PagerCli.TABLA.addKeyListener(this);

            Singletons.PagerCli.btnCrear.setActionCommand("_BTN_CREAR");
            Singletons.PagerCli.btnCrear.setName("_BTN_CREAR");
            Singletons.PagerCli.btnCrear.addActionListener(this);
            Singletons.PagerCli.btnCrear.addMouseListener(this);

            Singletons.PagerCli.btnModificar.setActionCommand("_BTN_MODIFICAR");
            Singletons.PagerCli.btnModificar.setName("_BTN_MODIFICAR");
            Singletons.PagerCli.btnModificar.addActionListener(this);
            Singletons.PagerCli.btnModificar.addMouseListener(this);

            Singletons.PagerCli.btnEliminar.setActionCommand("_BTN_ELIMINAR");
            Singletons.PagerCli.btnEliminar.setName("_BTN_ELIMINAR");
            Singletons.PagerCli.btnEliminar.addActionListener(this);
            Singletons.PagerCli.btnEliminar.addMouseListener(this);

            Singletons.PagerCli.btnInfo.setActionCommand("_BTN_INFO");
            Singletons.PagerCli.btnInfo.setName("_BTN_INFO");
            Singletons.PagerCli.btnInfo.addActionListener(this);
            Singletons.PagerCli.btnInfo.addMouseListener(this);

            Singletons.PagerCli.btnVolver.setActionCommand("_BTN_VOLVER");
            Singletons.PagerCli.btnVolver.addActionListener(this);

            Singletons.PagerCli.btnGuardar.setActionCommand("_BTN_GUARDAR");
            Singletons.PagerCli.btnGuardar.setName("_BTN_GUARDAR");
            Singletons.PagerCli.btnGuardar.addActionListener(this);
            Singletons.PagerCli.btnGuardar.addMouseListener(this);

            Singletons.PagerCli.btnAbrir.setActionCommand("_BTN_ABRIR");
            Singletons.PagerCli.btnAbrir.setName("_BTN_ABRIR");
            Singletons.PagerCli.btnAbrir.addActionListener(this);
            Singletons.PagerCli.btnAbrir.addMouseListener(this);

            Singletons.PagerCli.btnEdad.setActionCommand("_BTN_EDADMINMAX");
            Singletons.PagerCli.btnEdad.addActionListener(this);

            Singletons.PagerCli.btnMedia.setActionCommand("_BTN_EDAD_MEDIA");
            Singletons.PagerCli.btnMedia.addActionListener(this);

            Singletons.PagerCli.txtCerrar.setName("_CERRAR");
            Singletons.PagerCli.txtCerrar.addMouseListener(this);
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
                pagina.itemsPerPage = Integer.parseInt(Singletons.PagerCli.jComboBox1.getSelectedItem().toString());
                pagina.currentPageIndex = 1;
                pagina.initLinkBox();
                break;

            case _BTN_CREAR:
                LoginBLL _tipoUsu = new LoginBLL();
                String usuario = Singletons.log.txtUsuario.getText();
                Singletons.tipoUsuario = _tipoUsu.TipoUsuarioBLL(usuario);

                if (Singletons.tipoUsuario.equals("Administrador")) {
                    Singletons.PagerCli.dispose();
                    new Controlador_Cli(new AltaCli(), 0).iniciar(0);
                }
                break;

            case _BTN_MODIFICAR:
                LoginBLL _tipoUsua = new LoginBLL();
                String usu = Singletons.log.txtUsuario.getText();
                Singletons.tipoUsuario = _tipoUsua.TipoUsuarioBLL(usu);

                if (Singletons.tipoUsuario.equals("Administrador")) {
                    if (Singletons.e != null) {
                        Singletons.PagerCli.dispose();
                        new Controlador_Cli(new ModificarCli(), 1).iniciar(1);

                    } else {
                        JOptionPane.showMessageDialog(null, "No hay un empleado seleccionado", "Error", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                break;

            case _BTN_ELIMINAR:
                LoginBLL _tipoUsuario = new LoginBLL();
                String usua = Singletons.log.txtUsuario.getText();
                Singletons.tipoUsuario = _tipoUsuario.TipoUsuarioBLL(usua);

                if (Singletons.tipoUsuario.equals("Administrador")) {
                    if (Singletons.e != null) {
                        BLLGrafico.EliminarPager();
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay un empleado seleccionado", "Info", JOptionPane.INFORMATION_MESSAGE);
                    }
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
                Singletons.PagerCli.dispose();
                new Controlador_Inicio(new Ventana_Inicio(), 0).iniciar(0);
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
                Singletons.CrearCli.dispose();
                Singletons.PagerCli.setVisible(true);
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
                BLLGrafico.ModificarCli();
                break;

            case _BTN_CANCELAR:
                BLLGrafico.LimpiarModificar();
                break;

            case _BTN_VOLVER_ModiLISTADO:

                LoginBLL _tipoUsuari = new LoginBLL();
                String us = Singletons.log.txtUsuario.getText();
                Singletons.tipoUsuario = _tipoUsuari.TipoUsuarioBLL(us);

                if (Singletons.tipoUsuario.equals("Administrador")) {
                    if (Singletons.e != null) {
                        Singletons.ModificarCli.dispose();
                        Singletons.PagerCli.setVisible(true);
                    }
                }
                break;

            case _BTN_VOLVER_PPAL:

                LoginBLL _tipoUsuar = new LoginBLL();
                String u = Singletons.log.txtUsuario.getText();
                Singletons.tipoUsuario = _tipoUsuar.TipoUsuarioBLL(u);

                if (Singletons.tipoUsuario.equals("Cliente")) {
                    if (Singletons.e != null) {
                        Singletons.ModificarCli.dispose();
                        Singletons.menuPpal.setVisible(true);
                    }
                }
                break;

            case _BTN_EDADMINMAX:
                BLLBD _cliente = new BLLBD();
                _cliente.clienteMenorMayorBLL();
                break;

            case _BTN_EDAD_MEDIA:
                BLLBD _empleadoDAO = new BLLBD();
                _empleadoDAO.EdadMediaBLL();
                break;

            case _BTN_CAMBIARAVATAR:
                FileUploader.guardar_img(1);
                break;

            case _CMB_TIPO_ALTA:
                AltaCli.cmbTipo.getSelectedItem().toString();
                break;

            case _CMB_TIPO_Modif:
                ModificarCli.cmbTipoUser.getSelectedItem().toString();
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
                ((miniSimpleTableModel_Cli) Singletons.PagerCli.TABLA.getModel()).filtrar();
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
                ((miniSimpleTableModel_Cli) Singletons.PagerCli.TABLA.getModel()).filtrar();
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

            case _CERRAR:
                LoginBLL _tipoUsuar = new LoginBLL();
                String u = Singletons.log.txtUsuario.getText();
                Singletons.tipoUsuario = _tipoUsuar.TipoUsuarioBLL(u);

                if (Singletons.tipoUsuario.equals("Administrador")) {
                    Singletons.conectado = "no";
                    Singletons.PagerCli.dispose();
                    new Controlador_Inicio(new Ventana_Inicio(), 0).iniciar(0);
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
    public void mouseEntered(MouseEvent me) {
        switch (Accion.valueOf(me.getComponent().getName())) {

            case _BTN_CREAR:
                Singletons.PagerCli.btnCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/edit_add.png")));
                break;

            case _BTN_MODIFICAR:
                Singletons.PagerCli.btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/color_line.png")));
                break;

            case _BTN_ELIMINAR:
                Singletons.PagerCli.btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/cancel.png")));
                break;

            case _BTN_INFO:
                Singletons.PagerCli.btnInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/info.png")));
                break;

            case _BTN_ABRIR:
                Singletons.PagerCli.btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/folder_orange_open.png")));
                break;

            case _BTN_GUARDAR:
                Singletons.PagerCli.btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/guardar.png")));
                break;

            case _CERRAR:
                Singletons.PagerCli.txtCerrar.setForeground(Color.white);
                break;
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {

        switch (Accion.valueOf(me.getComponent().getName())) {

            case _BTN_CREAR:
                Singletons.PagerCli.btnCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/edit_add_NS.png")));
                break;

            case _BTN_MODIFICAR:
                Singletons.PagerCli.btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/color_line_NS.png")));
                break;

            case _BTN_ELIMINAR:
                Singletons.PagerCli.btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/cancel_NS.png")));
                break;

            case _BTN_INFO:
                Singletons.PagerCli.btnInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/info_NS.png")));
                break;

            case _BTN_ABRIR:
                Singletons.PagerCli.btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/folder_yellow_open_NS.png")));
                break;

            case _BTN_GUARDAR:
                Singletons.PagerCli.btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/guardar_NS.png")));
                break;

            case _CERRAR:
                Singletons.PagerCli.txtCerrar.setForeground(Color.orange);
                break;

        }
    }

    public static void comboActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("word selected: " + ((JComboBox) Singletons.combo).getSelectedItem());
        pagina.currentPageIndex = 1;
        ((miniSimpleTableModel_Cli) TABLA.getModel()).filtrar();
    }
}
