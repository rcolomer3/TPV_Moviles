/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPV_Moviles.Modulos.GestionProductos.Controlador;

import TPV_Moviles.Librerias.FileUploader;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.Clientes;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.Singletons;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.DAO.DAOGrafico;
import TPV_Moviles.Modulos.GestionProductos.Modelo.BLL.BLLGraficoPro;
import TPV_Moviles.Modulos.GestionProductos.Modelo.BLL.BLLProBD;
import TPV_Moviles.Modulos.GestionProductos.Modelo.Clases.Productos;
import TPV_Moviles.Modulos.GestionProductos.Modelo.Clases.SingletonsPro;
import static TPV_Moviles.Modulos.GestionProductos.Modelo.Clases.SingletonsPro.AL_Prod;
import TPV_Moviles.Modulos.GestionProductos.Modelo.Clases.miniSimpleTableModel_Pro;
import TPV_Moviles.Modulos.GestionProductos.Modelo.Pager.pagina;
import TPV_Moviles.Modulos.GestionProductos.Vista.ModificarPro;
import TPV_Moviles.Modulos.GestionProductos.Vista.RegistroPro;
import TPV_Moviles.Modulos.GestionProductos.Vista.Ventana_Prod;
import static TPV_Moviles.Modulos.GestionProductos.Vista.Ventana_Prod.TablaProductos;
import static TPV_Moviles.Modulos.GestionProductos.Vista.Ventana_Prod.buscadorP;
import static TPV_Moviles.Modulos.GestionProductos.Vista.Ventana_Prod.panelProd;
import TPV_Moviles.Modulos.GestionProductos.Vista.autocomplete.AutocompleteJComboBox;
import TPV_Moviles.Modulos.GestionProductos.Vista.autocomplete.StringSearchable;
import TPV_Moviles.Modulos.Inicio.ControladorInicio.Controlador_Inicio;
import TPV_Moviles.Modulos.Inicio.Vista.Ventana_Inicio;
import TPV_Moviles.Modulos.Login.BLL.LoginBLL;
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
public class Controlador_Pro implements ActionListener, KeyListener, MouseListener {

    public static TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(new miniSimpleTableModel_Pro());

    public enum Accion {

        // Acciones de Alta Producto 
        _TXT_REFERENCIA,
        _TXT_MODELO,
        _TXT_MARCA,
        _TXT_DESCRIPCION,
        _TXT_FMERCADO,
        _CMB_TIPO_ALTA,
        _BTN_ANYADIR,
        _BTN_LIMPIAR,
        _BTN_VOLVER_LISTADO,
        // Acciones de Modificar Producto
        _TXT_REFERENCIA_M,
        _TXT_MODELO_M,
        _TXT_MARCA_M,
        _TXT_DESCRIPCION_M,
        _TXT_FMERCADO_M,
        _CMB_TIPO_ModIF,
        _BTN_MODIFICAR_PRO,
        _BTN_CANCELAR,
        _BTN_VOLVER_LISTPRO,
        _BTN_CAMBIARAVATAR,
        // Acciones del Pager Productos
        _BTN_ANTERIOR,
        _BTN_SIGUIENTE,
        _BTN_ULTIMO,
        _BTN_PRIMERO,
        _COMBOX,
        _BUSCADOR,
        _TABLA_CLICKED,
        _BTN_CREAR,
        _BTN_MODIFICAR,
        _BTN_ELIMINAR,
        _BTN_INFO,
        _BTN_VOLVER,
        _BTN_PRECIOBACA,
        _BTN_PRECIO_MEDIO,
        _PAGER,
        _CERRAR
    }

    public Controlador_Pro(JFrame pagerpro, int i) {

        if (i == 0) {
            SingletonsPro.CrearPro = (RegistroPro) pagerpro;
        }

        if (i == 1) {
            SingletonsPro.ModificarPro = (ModificarPro) pagerpro;
        }

        if (i == 2) {
            SingletonsPro.PagerPro = (Ventana_Prod) pagerpro;
        }
    }

    public void iniciar(int i) {

        if (i == 0) { // Ventana de Alta producto

            SingletonsPro.CrearPro.setVisible(true);
            SingletonsPro.CrearPro.setResizable(false);
            SingletonsPro.CrearPro.setSize(730, 570); //ancho x alto
            SingletonsPro.CrearPro.setTitle("Alta Nuevo Producto");

            SingletonsPro.CrearPro.setLocationRelativeTo(null);
            Image icono = Toolkit.getDefaultToolkit().getImage("src/TPV_Moviles/Img/logo.png");
            SingletonsPro.CrearPro.setIconImage(icono);

            SingletonsPro.CrearPro.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    JOptionPane.showMessageDialog(null, "Saliendo de la aplicación");
                    System.exit(0);
                }
            });

            if (Singletons.conectado.equals("si")) {

                BLLGraficoPro.OcultarErroresAlta();

                Clientes clien = DAOGrafico.ObtenerClienteLogeado();
                SingletonsPro.CrearPro.labelNomUsu.setVisible(true);

                SingletonsPro.PintaNombre = clien.getUsuario();
                SingletonsPro.CrearPro.labelNomUsu.setText(SingletonsPro.PintaNombre);

                FileUploader.leer_imag(6);
            }

            SingletonsPro.CrearPro.txtReferencia.setName("_TXT_REFERENCIA");
            SingletonsPro.CrearPro.txtReferencia.setActionCommand("_TXT_REFERENCIA");
            SingletonsPro.CrearPro.txtReferencia.addActionListener(this);
            SingletonsPro.CrearPro.txtReferencia.addKeyListener(this);

            SingletonsPro.CrearPro.txtModelo.setName("_TXT_MODELO");
            SingletonsPro.CrearPro.txtModelo.setActionCommand("_TXT_MODELO");
            SingletonsPro.CrearPro.txtModelo.addActionListener(this);
            SingletonsPro.CrearPro.txtModelo.addKeyListener(this);

            SingletonsPro.CrearPro.txtMarca.setName("_TXT_MARCA");
            SingletonsPro.CrearPro.txtMarca.setActionCommand("_TXT_MARCA");
            SingletonsPro.CrearPro.txtMarca.addActionListener(this);
            SingletonsPro.CrearPro.txtMarca.addKeyListener(this);

            SingletonsPro.CrearPro.txtDesc.setName("_TXT_DESCRIPCION");
            SingletonsPro.CrearPro.txtDesc.setActionCommand("_TXT_DESCRIPCION");
            SingletonsPro.CrearPro.txtDesc.addActionListener(this);
            SingletonsPro.CrearPro.txtDesc.addKeyListener(this);

            SingletonsPro.CrearPro.dcFmercado.setName("_TXT_FMERCADO");
            SingletonsPro.CrearPro.dcFmercado.addKeyListener(this);

            SingletonsPro.CrearPro.cmbTipoP.setActionCommand("_CMB_TIPO_ALTA");
            SingletonsPro.CrearPro.cmbTipoP.setName("_CMB_TIPO_ALTA");
            SingletonsPro.CrearPro.cmbTipoP.addActionListener(this);

            SingletonsPro.CrearPro.btnAnyadir.setActionCommand("_BTN_ANYADIR");
            SingletonsPro.CrearPro.btnAnyadir.addActionListener(this);

            SingletonsPro.CrearPro.btnCancelar.setActionCommand("_BTN_LIMPIAR");
            SingletonsPro.CrearPro.btnCancelar.addActionListener(this);

            SingletonsPro.CrearPro.btnIrPager.setActionCommand("_BTN_VOLVER_LISTADO");
            SingletonsPro.CrearPro.btnIrPager.addActionListener(this);

        }

        if (i == 1) { // Ventana de Modificar Empleado

            SingletonsPro.ModificarPro.setVisible(true);
            SingletonsPro.ModificarPro.setResizable(false);
            SingletonsPro.ModificarPro.setLocation(2, 30);
            SingletonsPro.ModificarPro.setSize(790, 515); //ancho x alto
            SingletonsPro.ModificarPro.setTitle("Modificar Producto Registrado");
            SingletonsPro.ModificarPro.setLocationRelativeTo(null);
            Image icono = Toolkit.getDefaultToolkit().getImage("src/TPV_Moviles/Img/logo.png");
            SingletonsPro.ModificarPro.setIconImage(icono);

            SingletonsPro.ModificarPro.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    JOptionPane.showMessageDialog(null, "Saliendo de la aplicación");
                    System.exit(0);
                }
            });

            BLLGraficoPro.OcultarErroresModificar();
            BLLGraficoPro.ModificarPager();

            Clientes clien = DAOGrafico.ObtenerClienteLogeado();
            SingletonsPro.ModificarPro.labelNomUsu.setVisible(true);

            SingletonsPro.PintaNombre = clien.getUsuario();
            SingletonsPro.ModificarPro.labelNomUsu.setText(SingletonsPro.PintaNombre);

            FileUploader.leer_imag(7);

            SingletonsPro.ModificarPro.txtReferencia.setName("_TXT_REFERENCIA_M");
            SingletonsPro.ModificarPro.txtReferencia.setActionCommand("_TXT_REFERENCIA_M");
            SingletonsPro.ModificarPro.txtReferencia.addActionListener(this);
            SingletonsPro.ModificarPro.txtReferencia.addKeyListener(this);

            SingletonsPro.ModificarPro.txtModelo.setName("_TXT_MODELO_M");
            SingletonsPro.ModificarPro.txtModelo.setActionCommand("_TXT_MODELO_M");
            SingletonsPro.ModificarPro.txtModelo.addActionListener(this);
            SingletonsPro.ModificarPro.txtModelo.addKeyListener(this);

            SingletonsPro.ModificarPro.txtMarca.setName("_TXT_MARCA_M");
            SingletonsPro.ModificarPro.txtMarca.setActionCommand("_TXT_MARCA_M");
            SingletonsPro.ModificarPro.txtMarca.addActionListener(this);
            SingletonsPro.ModificarPro.txtMarca.addKeyListener(this);

            SingletonsPro.ModificarPro.txtDesc.setName("_TXT_DESCRIPCION_M");
            SingletonsPro.ModificarPro.txtDesc.setActionCommand("_TXT_DESCRIPCION_M");
            SingletonsPro.ModificarPro.txtDesc.addActionListener(this);
            SingletonsPro.ModificarPro.txtDesc.addKeyListener(this);

            SingletonsPro.ModificarPro.dcFmercado.setName("_TXT_FMERCADO_M");
            SingletonsPro.ModificarPro.dcFmercado.addKeyListener(this);

            SingletonsPro.ModificarPro.cmbTipoP.setActionCommand("_CMB_TIPO_ModIF");
            SingletonsPro.ModificarPro.cmbTipoP.setName("_CMB_TIPO_ModIF");
            SingletonsPro.ModificarPro.cmbTipoP.addActionListener(this);

            SingletonsPro.ModificarPro.btnActualizar.setActionCommand("_BTN_MODIFICAR_PRO");
            SingletonsPro.ModificarPro.btnActualizar.addActionListener(this);

            SingletonsPro.ModificarPro.btnCancelar.setActionCommand("_BTN_CANCELAR");
            SingletonsPro.ModificarPro.btnCancelar.addActionListener(this);

            SingletonsPro.ModificarPro.btnIrPager.setActionCommand("_BTN_VOLVER_LISTPRO");
            SingletonsPro.ModificarPro.btnIrPager.addActionListener(this);

            SingletonsPro.ModificarPro.btnElegir_M.setActionCommand("_BTN_CAMBIARAVATAR");
            SingletonsPro.ModificarPro.btnElegir_M.addActionListener(this);
        }

        if (i == 2) { //Ventana del pager

            SingletonsPro.PagerPro.setLocationRelativeTo(null);
            SingletonsPro.PagerPro.setTitle("Productos Registrados");
            SingletonsPro.PagerPro.setResizable(false);
            Container content = SingletonsPro.PagerPro.getContentPane();
            content.setLayout(new BorderLayout());
            //content.add(fondo, BorderLayout.CENTER);

            panelProd.setOpaque(false);
            panelProd.setVisible(true);

            SingletonsPro.PagerPro.setSize(1100, 540); // //ancho x alto
            Image icono = Toolkit.getDefaultToolkit().getImage("src/TPV_Moviles/Img/logo.png");
            SingletonsPro.PagerPro.setIconImage(icono);

            SingletonsPro.PagerPro.TablaProductos.setModel(new miniSimpleTableModel_Pro());
            ((miniSimpleTableModel_Pro) SingletonsPro.PagerPro.TablaProductos.getModel()).cargar();
            SingletonsPro.PagerPro.TablaProductos.setFillsViewportHeight(true);
            SingletonsPro.PagerPro.TablaProductos.setRowSorter(SingletonsPro.sorter);

            pagina.inicializa();
            pagina.initLinkBox();

            SingletonsPro.PagerPro.contFiltrar.setText(String.valueOf(SingletonsPro.AL_Prod.size()));

            SingletonsPro.PagerPro.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    JOptionPane.showMessageDialog(null, "Saliendo de la aplicacion");
                    System.exit(0);
                }
            });

            List<String> myWords = new ArrayList<String>();
            for (int k = 0; k <= AL_Prod.size() - 1; k++) {
                myWords.add(AL_Prod.get(k).getReferencia());
            }

            StringSearchable searchable = new StringSearchable(myWords);
            SingletonsPro.combo = new AutocompleteJComboBox(searchable);
            buscadorP.setLayout(new java.awt.BorderLayout());
            buscadorP.add(SingletonsPro.combo);

            SingletonsPro.combo.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    comboActionPerformed(evt);
                }
            });

            LoginBLL _tipoUsu = new LoginBLL();
            String usuario = Singletons.log.txtUsuario.getText();
            Singletons.tipoUsuario = _tipoUsu.TipoUsuarioBLL(usuario);

            if ((Singletons.conectado.equals("si")) && (Singletons.tipoUsuario.equals("Administrador"))) {

                Clientes clien = DAOGrafico.ObtenerClienteLogeado();
                SingletonsPro.PagerPro.labNombre.setVisible(true);

                SingletonsPro.PagerPro.txtcese.setVisible(true);
                SingletonsPro.PagerPro.txtcese.setText("Cerrar sesión");

                SingletonsPro.PintaNombre = clien.getUsuario();
                SingletonsPro.PagerPro.labNombre.setText(SingletonsPro.PintaNombre);
                SingletonsPro.PagerPro.fotoUsu.setVisible(true);
                FileUploader.leer_imag(8);

            } else if ((Singletons.conectado.equals("si")) && (Singletons.tipoUsuario.equals("Cliente"))) {

                Clientes clien = DAOGrafico.ObtenerClienteLogeado();
                SingletonsPro.PagerPro.labNombre.setVisible(true);
                SingletonsPro.PagerPro.btnAnyadir.setVisible(false);
                SingletonsPro.PagerPro.btnModif.setVisible(false);
                SingletonsPro.PagerPro.btnEliminar.setVisible(false);
                SingletonsPro.PagerPro.txtcese.setVisible(true);
                SingletonsPro.PagerPro.txtcese.setText("Cerrar sesión");

                SingletonsPro.PintaNombre = clien.getUsuario();
                SingletonsPro.PagerPro.labNombre.setText(SingletonsPro.PintaNombre);
                SingletonsPro.PagerPro.fotoUsu.setVisible(true);
                FileUploader.leer_imag(8);
            } else {
                SingletonsPro.PagerPro.fotoUsu.setVisible(false);
                BLLGraficoPro.OcultarErrores();
            }

            SingletonsPro.PagerPro.anterior.setActionCommand("_BTN_ANTERIOR");
            SingletonsPro.PagerPro.anterior.addActionListener(this);

            SingletonsPro.PagerPro.siguiente.setActionCommand("_BTN_SIGUIENTE");
            SingletonsPro.PagerPro.siguiente.addActionListener(this);

            SingletonsPro.PagerPro.ultimo.setActionCommand("_BTN_ULTIMO");
            SingletonsPro.PagerPro.ultimo.addActionListener(this);

            SingletonsPro.PagerPro.primero.setActionCommand("_BTN_PRIMERO");
            SingletonsPro.PagerPro.primero.addActionListener(this);

            SingletonsPro.PagerPro.combobox.setActionCommand("_COMBOX");
            SingletonsPro.PagerPro.combobox.addActionListener(this);

            SingletonsPro.PagerPro.buscadorP.setName("_BUSCADOR");
            SingletonsPro.PagerPro.buscadorP.setActionCommand("_BUSCADOR");
            SingletonsPro.PagerPro.buscadorP.addActionListener(this);
            SingletonsPro.PagerPro.buscadorP.addKeyListener(this);

            SingletonsPro.PagerPro.TablaProductos.setName("_TABLA_CLICKED");
            SingletonsPro.PagerPro.TablaProductos.addMouseListener(this);
            SingletonsPro.PagerPro.TablaProductos.addKeyListener(this);

            SingletonsPro.PagerPro.btnAnyadir.setActionCommand("_BTN_CREAR");
            SingletonsPro.PagerPro.btnAnyadir.setName("_BTN_CREAR");
            SingletonsPro.PagerPro.btnAnyadir.addActionListener(this);
            SingletonsPro.PagerPro.btnAnyadir.addMouseListener(this);

            SingletonsPro.PagerPro.btnModif.setActionCommand("_BTN_MODIFICAR");
            SingletonsPro.PagerPro.btnModif.setName("_BTN_MODIFICAR");
            SingletonsPro.PagerPro.btnModif.addActionListener(this);
            SingletonsPro.PagerPro.btnModif.addMouseListener(this);

            SingletonsPro.PagerPro.btnEliminar.setActionCommand("_BTN_ELIMINAR");
            SingletonsPro.PagerPro.btnEliminar.setName("_BTN_ELIMINAR");
            SingletonsPro.PagerPro.btnEliminar.addActionListener(this);
            SingletonsPro.PagerPro.btnEliminar.addMouseListener(this);

            SingletonsPro.PagerPro.btnInfo.setActionCommand("_BTN_INFO");
            SingletonsPro.PagerPro.btnInfo.setName("_BTN_INFO");
            SingletonsPro.PagerPro.btnInfo.addActionListener(this);
            SingletonsPro.PagerPro.btnInfo.addMouseListener(this);

            SingletonsPro.PagerPro.btnVolver.setActionCommand("_BTN_VOLVER");
            SingletonsPro.PagerPro.btnVolver.addActionListener(this);

            SingletonsPro.PagerPro.btnPrecioBarato_Caro.setActionCommand("_BTN_PRECIOBACA");
            SingletonsPro.PagerPro.btnPrecioBarato_Caro.addActionListener(this);

            SingletonsPro.PagerPro.btnPrecioMedio.setActionCommand("_BTN_PRECIO_MEDIO");
            SingletonsPro.PagerPro.btnPrecioMedio.addActionListener(this);

            SingletonsPro.PagerPro.txtcese.setName("_CERRAR");
            SingletonsPro.PagerPro.txtcese.addMouseListener(this);

            SingletonsPro.PagerPro.TablaProductos.setName("_PAGER");
            SingletonsPro.PagerPro.TablaProductos.addMouseListener(this);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (Accion.valueOf(e.getActionCommand())) {

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
                pagina.itemsPerPage = Integer.parseInt(SingletonsPro.PagerPro.combobox.getSelectedItem().toString());
                pagina.currentPageIndex = 1;
                pagina.initLinkBox();
                break;

            case _BTN_CREAR:
                LoginBLL _tipoUsu = new LoginBLL();
                String usuario = Singletons.log.txtUsuario.getText();
                Singletons.tipoUsuario = _tipoUsu.TipoUsuarioBLL(usuario);

                if (Singletons.conectado.equals("si")) {
                    if (Singletons.tipoUsuario.equals("Administrador")) {
                        SingletonsPro.PagerPro.dispose();
                        new Controlador_Pro(new RegistroPro(), 0).iniciar(0);
                    } else {
                        SingletonsPro.PagerPro.btnAnyadir.setVisible(false);
                    }
                }
                break;

            case _BTN_MODIFICAR:
                LoginBLL _tipoUsua = new LoginBLL();
                String usu = Singletons.log.txtUsuario.getText();
                Singletons.tipoUsuario = _tipoUsua.TipoUsuarioBLL(usu);

                if (Singletons.conectado.equals("si")) {
                    if (Singletons.tipoUsuario.equals("Administrador")) {
                        if (SingletonsPro.p != null) {
                            SingletonsPro.PagerPro.dispose();
                            new Controlador_Pro(new ModificarPro(), 1).iniciar(1);
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay un producto seleccionado", "Error", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        SingletonsPro.PagerPro.btnModif.setVisible(false);
                    }
                }
                break;

            case _BTN_ELIMINAR:
                LoginBLL _tipoUsuario = new LoginBLL();
                String usua = Singletons.log.txtUsuario.getText();
                Singletons.tipoUsuario = _tipoUsuario.TipoUsuarioBLL(usua);

                if (Singletons.conectado.equals("si")) {
                    if (Singletons.tipoUsuario.equals("Administrador")) {
                        if (SingletonsPro.p != null) {
                            BLLGraficoPro.EliminarPagerPro();
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay un producto seleccionado", "Info", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        SingletonsPro.PagerPro.btnEliminar.setVisible(false);
                    }
                }
                break;

            case _BTN_INFO:
                LoginBLL _tipoUsuari = new LoginBLL();
                String us = Singletons.log.txtUsuario.getText();
                Singletons.tipoUsuario = _tipoUsuari.TipoUsuarioBLL(us);

                if (Singletons.conectado.equals("si")) {
                    if (Singletons.tipoUsuario.equals("Administrador")) {
                        if (SingletonsPro.p != null) {
                            BLLGraficoPro.InformacionEFPager();
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay un producto seleccionado", "Error", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else if (Singletons.tipoUsuario.equals("Cliente")) {
                        if (SingletonsPro.p != null) {
                            SingletonsPro.PagerPro.btnInfo.setVisible(true);
                            BLLGraficoPro.InformacionEFPager();
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay un producto seleccionado", "Error", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
                break;

            case _BTN_VOLVER:
                SingletonsPro.PagerPro.dispose();
                new Controlador_Inicio(new Ventana_Inicio(), 0).iniciar(0);
                break;

            case _TXT_REFERENCIA:
                BLLGraficoPro.pideReferencia();
                break;

            case _TXT_MODELO:
                BLLGraficoPro.pideModelo();
                break;

            case _TXT_MARCA:
                BLLGraficoPro.pideMarca();
                break;

            case _TXT_DESCRIPCION:
                BLLGraficoPro.pideDescripcion();
                break;

            case _TXT_FMERCADO:
                BLLGraficoPro.pideFMercado();
                break;

            case _BTN_ANYADIR:
                BLLGraficoPro.guardarProducto();
                break;

            case _BTN_LIMPIAR:
                BLLGraficoPro.LimpiarCreaProd();
                break;

            case _BTN_VOLVER_LISTADO:
                SingletonsPro.CrearPro.dispose();
                SingletonsPro.PagerPro.setVisible(true);
                break;

            case _TXT_REFERENCIA_M:
                BLLGraficoPro.ModpideReferencia();
                break;

            case _TXT_MODELO_M:
                BLLGraficoPro.ModpideModelo();
                break;

            case _TXT_MARCA_M:
                BLLGraficoPro.ModpideMarca();
                break;

            case _TXT_FMERCADO_M:
                BLLGraficoPro.ModpideFMercado();
                break;

            case _TXT_DESCRIPCION_M:
                BLLGraficoPro.ModpideDescripcion();
                break;

            case _BTN_MODIFICAR_PRO:
                BLLGraficoPro.ModificarPro();
                break;

            case _BTN_CANCELAR:
                BLLGraficoPro.LimpiarModificar();
                break;

            case _BTN_VOLVER_LISTPRO:

                LoginBLL _tipoUsuar = new LoginBLL();
                String u = Singletons.log.txtUsuario.getText();
                Singletons.tipoUsuario = _tipoUsuar.TipoUsuarioBLL(u);

                if (Singletons.tipoUsuario.equals("Administrador")) {
                    if (SingletonsPro.p != null) {
                        SingletonsPro.ModificarPro.dispose();
                        SingletonsPro.PagerPro.setVisible(true);
                    }
                } else if (Singletons.tipoUsuario.equals("Cliente")) {
                    if (SingletonsPro.p != null) {
                        SingletonsPro.ModificarPro.dispose();
                        SingletonsPro.PagerPro.setVisible(true);
                    }
                }
                break;

            case _BTN_PRECIOBACA:
                BLLProBD _producto = new BLLProBD();
                _producto.productoBaratoCaroBLL();
                break;

            case _BTN_PRECIO_MEDIO:
                BLLProBD _productoo = new BLLProBD();
                _productoo.PrecioMedioBLL();
                break;

            case _BTN_CAMBIARAVATAR:
                FileUploader.guardar_img(2);
                break;

            case _CMB_TIPO_ALTA:
                RegistroPro.cmbTipoP.getSelectedItem().toString();
                break;

            case _CMB_TIPO_ModIF:
                ModificarPro.cmbTipoP.getSelectedItem().toString();
                break;

        }
    }

    @Override
    public void keyTyped(KeyEvent e
    ) {

    }

    @Override
    public void keyReleased(KeyEvent e
    ) {

        switch (Accion.valueOf(e.getComponent().getName())) {

            case _TXT_MODELO:
                BLLGraficoPro.pideModeloKey();
                break;

            case _TXT_MARCA:
                BLLGraficoPro.pideMarcaKey();
                break;

            case _TXT_MODELO_M:
                BLLGraficoPro.ModpideModeloKey();
                break;

            case _TXT_MARCA_M:
                BLLGraficoPro.ModpideMarcaKey();
                break;

            // Funcion para filtrar productos por Referencia
            case _BUSCADOR:
                pagina.currentPageIndex = 1;
                ((miniSimpleTableModel_Pro) SingletonsPro.PagerPro.TablaProductos.getModel()).filtrar();
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e
    ) {

        switch (Accion.valueOf(e.getComponent().getName())) {

            case _TXT_MODELO:
                BLLGraficoPro.pideModeloKeyPressed();
                break;

            case _TXT_MARCA:
                BLLGraficoPro.pideMarcaKeyPressed();
                break;

            case _TXT_MODELO_M:
                BLLGraficoPro.ModpideModeloKeyPressed();
                break;

            case _TXT_MARCA_M:
                BLLGraficoPro.ModpideMarcaKeyPressed();
                break;

            // Funcion para filtrar productos por Referencia
            case _BUSCADOR:
                pagina.currentPageIndex = 1;
                ((miniSimpleTableModel_Pro) SingletonsPro.PagerPro.TablaProductos.getModel()).filtrar();
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent me
    ) {
        switch (Accion.valueOf(me.getComponent().getName())) {
            case _TABLA_CLICKED:
                try {
                    SingletonsPro.p = new Productos(Ventana_Prod.TablaProductos.getValueAt(Ventana_Prod.TablaProductos.getSelectedRow(), 0).toString());
                    BLLProBD.buscarPorReferenciaBLL();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No has seleccionado ningún producto", "ERROR", JOptionPane.WARNING_MESSAGE);
                }
                break;

            case _CERRAR:
                LoginBLL _tipoUsuar = new LoginBLL();
                String u = Singletons.log.txtUsuario.getText();
                Singletons.tipoUsuario = _tipoUsuar.TipoUsuarioBLL(u);

                if (Singletons.tipoUsuario.equals("Administrador")) {
                    Singletons.conectado = "no";
                    SingletonsPro.PagerPro.dispose();
                    new Controlador_Inicio(new Ventana_Inicio(), 0).iniciar(0);
                } else if (Singletons.tipoUsuario.equals("Cliente")) {
                    Singletons.conectado = "no";
                    SingletonsPro.PagerPro.dispose();
                    new Controlador_Inicio(new Ventana_Inicio(), 0).iniciar(0);
                }
                break;

            case _PAGER:
                BLLGraficoPro.PintarProd();
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e
    ) {

    }

    @Override
    public void mouseReleased(MouseEvent e
    ) {

    }

    @Override
    public void mouseEntered(MouseEvent me
    ) {
        switch (Accion.valueOf(me.getComponent().getName())) {

            case _BTN_CREAR:
                SingletonsPro.PagerPro.btnAnyadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/edit_add.png")));
                break;

            case _BTN_MODIFICAR:
                SingletonsPro.PagerPro.btnModif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/color_line.png")));
                break;

            case _BTN_ELIMINAR:
                SingletonsPro.PagerPro.btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/cancel.png")));
                break;

            case _BTN_INFO:
                SingletonsPro.PagerPro.btnInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/info.png")));
                break;

            case _BTN_VOLVER:
                SingletonsPro.PagerPro.btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/volver.png")));
                break;

            case _CERRAR:
                SingletonsPro.PagerPro.txtcese.setForeground(Color.white);
                break;
        }
    }

    @Override
    public void mouseExited(MouseEvent me
    ) {

        switch (Accion.valueOf(me.getComponent().getName())) {

            case _BTN_CREAR:
                SingletonsPro.PagerPro.btnAnyadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/edit_add_NS.png")));
                break;

            case _BTN_MODIFICAR:
                SingletonsPro.PagerPro.btnModif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/color_line_NS.png")));
                break;

            case _BTN_ELIMINAR:
                SingletonsPro.PagerPro.btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/cancel_NS.png")));
                break;

            case _BTN_INFO:
                SingletonsPro.PagerPro.btnInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/info_NS.png")));
                break;

            case _BTN_VOLVER:
                SingletonsPro.PagerPro.btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/volver_NS.png")));
                break;

            case _CERRAR:
                SingletonsPro.PagerPro.txtcese.setForeground(Color.orange);
                break;

        }
    }

    public static void comboActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("word selected: " + ((JComboBox) SingletonsPro.combo).getSelectedItem());
        pagina.currentPageIndex = 1;
        ((miniSimpleTableModel_Pro) TablaProductos.getModel()).filtrar();
    }
}
