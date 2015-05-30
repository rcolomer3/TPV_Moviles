/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPV_Moviles.Modulos.GestionProductos.Modelo.BLL;

import TPV_Moviles.Clases.Config;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.Singletons;
import TPV_Moviles.Modulos.GestionProductos.Modelo.Clases.Productos;
import TPV_Moviles.Modulos.GestionProductos.Modelo.Clases.SingletonsPro;
import TPV_Moviles.Modulos.GestionProductos.Modelo.Clases.miniSimpleTableModel_Pro;
import TPV_Moviles.Modulos.GestionProductos.Modelo.DAO.DAOGraficoPro;
import static TPV_Moviles.Modulos.GestionProductos.Modelo.DAO.DAOGraficoPro.ModipideDescripcion;
import static TPV_Moviles.Modulos.GestionProductos.Modelo.DAO.DAOGraficoPro.ModipideMarca;
import static TPV_Moviles.Modulos.GestionProductos.Modelo.DAO.DAOGraficoPro.ModipideModelo;
import static TPV_Moviles.Modulos.GestionProductos.Modelo.DAO.DAOGraficoPro.ModpideFechaMercado;
import TPV_Moviles.Modulos.GestionProductos.Modelo.Pager.pagina;
import TPV_Moviles.Modulos.GestionProductos.Vista.RegistroPro;
import TPV_Moviles.Modulos.GestionProductos.Vista.ModificarPro;
import TPV_Moviles.Modulos.GestionProductos.Vista.Ventana_Prod;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Raul
 */
public class BLLGraficoPro {

    public static void guardarProducto() {

        DAOGraficoPro.crearProductos();
        //referencia no repe
        if (SingletonsPro.p != null) {
            if (Singletons.conectado.equals("si")) {
                SingletonsPro.pro.add(SingletonsPro.p);
                BLLProBD.nuevoProductoBLL();
                ((miniSimpleTableModel_Pro) SingletonsPro.PagerPro.TablaProductos.getModel()).cargar();
            }
        }
    }

    public static int buscar(Productos pr) {// Buscar
        int aux = -1;

        for (int i = 0; i <= (SingletonsPro.pro.size() - 1); i++) {
            if ((SingletonsPro.pro.get(i)).equals(pr)) {
                aux = i;
            }
        }
        return aux;
    }

    public static void ModificarProductos() {
        ModificarPro();
    }

    public static void ModificarPager() {
        DAOGraficoPro.Modificar();
    }

    public static void Imprimir() {
        imprimir(SingletonsPro.pro);
    }

    public static void LimpiarModificar() {
        DAOGraficoPro.LimpiarModificarProd();
    }

    public static void LimpiarCreaProd() {
        DAOGraficoPro.LimpiarCreaProd();
    }

    public static void pideReferencia() {
        int pos = 0;
        Productos e = new Productos(DAOGraficoPro.pideReferencia());
        pos = buscar(e);

        if (pos != -1) {
            JOptionPane.showMessageDialog(null, "Codigo Referencia repetido", "Aviso", JOptionPane.QUESTION_MESSAGE);
            RegistroPro.NoRef.setVisible(true);
            RegistroPro.txtReferencia.requestFocus();
        } else {
            RegistroPro.NoRef.setVisible(false);
            RegistroPro.txtModelo.requestFocus();
        }
    }

    public static void pideModelo() {
        DAOGraficoPro.pideModelo();
    }

    public static void pideMarca() {
        DAOGraficoPro.pideMarca();
    }

    public static void pideDescripcion() {
        DAOGraficoPro.pideDescripcion();
    }

    public static void pideFMercado() {
        DAOGraficoPro.pideFechaMercado();
    }

    public static void ModpideReferencia() {
        int pos = 0;
        Productos e = new Productos(DAOGraficoPro.ModpideReferencia());
        pos = buscar(e);

        if (pos != -1) {
            JOptionPane.showMessageDialog(null, "Codigo Referencia repetido", "Aviso", JOptionPane.QUESTION_MESSAGE);
            ModificarPro.NoRef.setVisible(true);
            ModificarPro.txtReferencia.requestFocus();
        } else {
            ModificarPro.NoRef.setVisible(false);
            ModificarPro.txtModelo.requestFocus();
        }
    }

    public static void ModpideModelo() {
        DAOGraficoPro.ModipideModelo();
    }

    public static void ModpideMarca() {
        DAOGraficoPro.ModipideMarca();
    }

    public static void ModpideDescripcion() {
        DAOGraficoPro.ModipideDescripcion();
    }

    public static void ModpideFMercado() {
        DAOGraficoPro.ModpideFechaMercado();
    }

    public static void pideModeloKey() {
        DAOGraficoPro.pideModeloKey();
    }

    public static void pideMarcaKey() {
        DAOGraficoPro.pideMarcaKey();
    }

    public static void pideModeloKeyPressed() {
        DAOGraficoPro.pideModeloKeyPressed();
    }

    public static void pideMarcaKeyPressed() {
        DAOGraficoPro.pideMarcaKeyPressed();
    }

    public static void ModpideModeloKey() {
        DAOGraficoPro.ModipideModeloKey();
    }

    public static void ModpideMarcaKey() {
        DAOGraficoPro.ModipideMarcaKey();
    }

    public static void ModpideModeloKeyPressed() {
        DAOGraficoPro.ModipideModeloKeyPressed();
    }

    public static void ModpideMarcaKeyPressed() {
        DAOGraficoPro.ModipideMarcaKeyPressed();
    }

    public static void ModificarPro() {

        if (ModificarPro.NoRef.isVisible() == false) {
            SingletonsPro.p.setReferencia(DAOGraficoPro.ModpideReferencia());
        }
        if (ModificarPro.NoModelo.isVisible() == false) {
            SingletonsPro.p.setModelo(ModipideModelo());
        }
        if (ModificarPro.NoMarca.isVisible() == false) {
            SingletonsPro.p.setMarca(ModipideMarca());
        }

        if (ModificarPro.NoFmercado.isVisible() == false) {
            SingletonsPro.p.setFechaMercado(ModpideFechaMercado());
            SingletonsPro.p.calcularAntiguedad(ModpideFechaMercado());
        }

        if (ModificarPro.NoDesc.isVisible() == false) {
            SingletonsPro.p.setDescripcion(ModipideDescripcion());
        }

        if (Singletons.PATH_auto != null) {
            SingletonsPro.p.setAvatar(Singletons.PATH_auto);
        }

        if (ModificarPro.cmbTipoP.getSelectedItem() != null) {
            SingletonsPro.p.setTipo(ModificarPro.cmbTipoP.getSelectedItem().toString());
        }

        if ((ModificarPro.NoRef.isVisible() == false) && (ModificarPro.NoModelo.isVisible() == false) && (ModificarPro.NoMarca.isVisible() == false) && (ModificarPro.NoDesc.isVisible() == false)
                && (ModificarPro.NoFmercado.isVisible() == false)) {
            SingletonsPro.pro.set(SingletonsPro.pos, SingletonsPro.p);
            BLLProBD.modificarProductoBLL();
            ((miniSimpleTableModel_Pro) SingletonsPro.PagerPro.TablaProductos.getModel()).cargar();

            ModificarPro.txtReferencia.requestFocus();
            ModificarPro.txtReferencia.setText("");
            ModificarPro.txtModelo.setText("");
            ModificarPro.txtMarca.setText("");
            ModificarPro.txtDesc.setText("");
            ModificarPro.dcFmercado.setDate(null);
        }
    }

    public static void imprimir(ArrayList<? extends Productos> l) {

        Productos ef;
        String cad = "";
        Iterator<Productos> it = (Iterator<Productos>) l.iterator();
        while (it.hasNext()) {
            ef = it.next();
            cad = SingletonsPro.p + "\n" + "\n";
        }
        JOptionPane.showMessageDialog(null, cad);
    }

    public static void InformacionEFPager() {
        imprimir(SingletonsPro.pro);
    }

    public static void OcultarErroresAlta() {
        DAOGraficoPro.OcultarErrores();
    }

    public static void OcultarErrores() {
        DAOGraficoPro.OcultarProd();
    }

    public static void OcultarErroresRegistro() {
        DAOGraficoPro.OcultarErrores();
    }

    public static void OcultarErroresModificar() {
        DAOGraficoPro.OcultarErroresModif();
    }

    public static void EliminarPagerPro() {

        String ref;
        int selection, inicio, selection1;

        int n = ((miniSimpleTableModel_Pro) Ventana_Prod.TablaProductos.getModel()).getRowCount();
        if (n != 0) {
            inicio = (pagina.currentPageIndex - 1) * pagina.itemsPerPage;
            selection = Ventana_Prod.TablaProductos.getSelectedRow();
            selection1 = inicio + selection;
            if (n == -1) {
                JOptionPane.showMessageDialog(null, "No hay un producto seleccionada", "Error!", 0);
            } else {
                ref = (String) Ventana_Prod.TablaProductos.getModel().getValueAt(selection1, 0);
                int opc = JOptionPane.showConfirmDialog(null, "Deseas borrar al producto con referencia: " + ref,
                        "Info", JOptionPane.WARNING_MESSAGE);
                if (opc == 0) {
                    ((miniSimpleTableModel_Pro) Ventana_Prod.TablaProductos.getModel()).removeRow(selection1);
                    BLLProBD.borrarProductoBLL();
                    ((miniSimpleTableModel_Pro) SingletonsPro.PagerPro.TablaProductos.getModel()).cargar();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay productos", "Error!", 0);
        }
    }

    public static void PintaProductos(Productos prod) {
        Ventana_Prod.txtRef.setText(prod.getReferencia());
        Ventana_Prod.txtMarca.setText(prod.getMarca());
        Ventana_Prod.txtModelo.setText(prod.getModelo());
        Ventana_Prod.txtDescripcion.setText(prod.getDescripcion());
        Ventana_Prod.txtPrecio.setText(Float.toString(prod.getPrecio()) + Config.getMoneda());
        ImageIcon icon = new ImageIcon(prod.getAvatar());
        Image img = icon.getImage();
        
        ImageIcon newIcon = new ImageIcon(img);
        Ventana_Prod.jLabelFotoProd.setIcon(newIcon);
    }

    public static void PintarProd() {

        String ref;
        int selection, inicio, selection1;

        int n = ((miniSimpleTableModel_Pro) Ventana_Prod.TablaProductos.getModel()).getRowCount();
        if (n != 0) {
            inicio = (pagina.currentPageIndex - 1) * pagina.itemsPerPage;
            selection = Ventana_Prod.TablaProductos.getSelectedRow();
            selection1 = inicio + selection;
            
                ref = (String) Ventana_Prod.TablaProductos.getModel().getValueAt(selection1, 0);
                Productos prod = DAOGraficoPro.pideRefvacio(ref);
                SingletonsPro.pos = BLLGraficoPro.buscar(prod);
                prod = SingletonsPro.pro.get(SingletonsPro.pos);
                BLLGraficoPro.PintaProductos(prod);
        }
    }
}
