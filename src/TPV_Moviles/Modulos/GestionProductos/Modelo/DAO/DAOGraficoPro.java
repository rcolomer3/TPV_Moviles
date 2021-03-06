/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPV_Moviles.Modulos.GestionProductos.Modelo.DAO;

import TPV_Moviles.Clases.Fecha;
import TPV_Moviles.Librerias.FileUploader;
import TPV_Moviles.Librerias.Validate;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.DAOCliente;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.Singletons;
import TPV_Moviles.Modulos.GestionProductos.Modelo.BLL.BLLGraficoPro;
import TPV_Moviles.Modulos.GestionProductos.Modelo.Clases.Productos;
import TPV_Moviles.Modulos.GestionProductos.Modelo.Clases.SingletonsPro;
import TPV_Moviles.Modulos.GestionProductos.Vista.ModificarPro;
import TPV_Moviles.Modulos.GestionProductos.Vista.RegistroPro;
import TPV_Moviles.Modulos.GestionProductos.Vista.Ventana_Prod;
import TPV_Moviles.Modulos.Login.BLL.LoginBLL;
import com.toedter.calendar.JTextFieldDateEditor;

/**
 *
 * @author Raul
 */
public class DAOGraficoPro {

    public static void crearProductos() {
        String referencia = "", modelo = "", marca = "", descripcion = "", tipo = "", avatar = "";
        int stock = 0;
        float precio = 0.0f;
        Fecha fechaMercado = null;

        referencia = pideReferencia();
        modelo = pideModelo();
        marca = pideMarca();
        descripcion = pideDescripcion();
        fechaMercado = pideFechaMercado();
        stock = 15;
        tipo = RegistroPro.cmbTipoP.getSelectedItem().toString();
        avatar = SingletonsPro.ruta;
       
        if ((RegistroPro.NoRef.isVisible() == false) && (RegistroPro.NoModelo.isVisible() == false) && (RegistroPro.NoMarca.isVisible() == false) && (RegistroPro.NoDesc.isVisible() == false)
                && (RegistroPro.NoFmercado.isVisible() == false)) {
            SingletonsPro.p = new Productos(referencia, modelo, marca, descripcion, fechaMercado, precio, stock, tipo, avatar);
        }
    }

    public static String pideReferencia() {
        String ref = "";

        ref = RegistroPro.txtReferencia.getText();
        if (ref.isEmpty()) {
            RegistroPro.txtReferencia.requestFocus();
            RegistroPro.NoRef.setVisible(true);
        } else {
            ref = RegistroPro.txtReferencia.getText();
            RegistroPro.NoRef.setVisible(false);

        }
        return ref;
    }

    public static String ModpideReferencia() {
        String ref = "";

        ref = ModificarPro.txtReferencia.getText();
        if (ref.isEmpty()) {
            ModificarPro.txtReferencia.requestFocus();
            ModificarPro.NoRef.setVisible(true);
        } else {
            ref = ModificarPro.txtReferencia.getText();
            ModificarPro.NoRef.setVisible(false);

        }
        return ref;
    }

    public static String pideModelo() {

        String modelo = "";

        modelo = RegistroPro.txtModelo.getText();
        if (modelo.isEmpty()) {
            RegistroPro.NoModelo.setVisible(true);
            RegistroPro.txtModelo.requestFocus();
        } else {
            modelo = RegistroPro.txtModelo.getText();
            RegistroPro.NoModelo.setVisible(false);
        }
        return modelo;
    }

    public static String pideModeloKey() {
        String modelo = "";

        modelo = RegistroPro.txtModelo.getText();
        if (modelo.isEmpty()) {
            RegistroPro.NoModelo.setVisible(true);
            RegistroPro.txtModelo.requestFocus();
        } else {
            modelo = RegistroPro.txtModelo.getText();
            RegistroPro.NoModelo.setVisible(false);
        }
        return modelo;
    }

    public static String pideModeloKeyPressed() {
        String modelo = "";

        modelo = RegistroPro.txtModelo.getText();
        if (modelo.isEmpty()) {
            RegistroPro.NoModelo.setVisible(true);
            RegistroPro.txtModelo.requestFocus();
        } else {
            modelo = RegistroPro.txtModelo.getText();

            RegistroPro.NoModelo.setVisible(false);

        }
        return modelo;
    }

    public static String ModipideModelo() {
        String modelo = "";

        modelo = ModificarPro.txtModelo.getText();
        if (modelo.isEmpty()) {
            ModificarPro.NoModelo.setVisible(true);
            ModificarPro.txtModelo.requestFocus();
        } else {
            modelo = ModificarPro.txtModelo.getText();
            ModificarPro.NoModelo.setVisible(false);

        }
        return modelo;
    }

    public static String ModipideModeloKey() {
        String modelo = "";

        modelo = ModificarPro.txtModelo.getText();
        if (modelo.isEmpty()) {
            ModificarPro.NoModelo.setVisible(true);
            ModificarPro.txtModelo.requestFocus();
        } else {
            modelo = ModificarPro.txtModelo.getText();

            ModificarPro.NoModelo.setVisible(false);

        }
        return modelo;
    }

    public static String ModipideModeloKeyPressed() {
        String nomb = "";

        nomb = ModificarPro.txtModelo.getText();
        if (nomb.isEmpty()) {
            ModificarPro.NoModelo.setVisible(true);
            ModificarPro.txtModelo.requestFocus();
        } else {
            nomb = ModificarPro.txtModelo.getText();
            ModificarPro.NoModelo.setVisible(false);

        }
        return nomb;
    }

    public static String pideMarca() {

        String modelo = "";
        boolean validar;

        modelo = RegistroPro.txtMarca.getText();
        if (modelo.isEmpty()) {
            RegistroPro.NoMarca.setVisible(true);
            RegistroPro.txtMarca.requestFocus();
        } else {
            modelo = RegistroPro.txtMarca.getText();
            validar = Validate.validaNombre(modelo);
            if (validar == false) {
                RegistroPro.txtMarca.requestFocus();
                RegistroPro.NoMarca.setVisible(true);
            } else {
                RegistroPro.NoMarca.setVisible(false);
            }
        }
        return modelo;
    }

    public static String pideMarcaKey() {
        String marca = "";
        boolean validar;

        marca = RegistroPro.txtMarca.getText();
        if (marca.isEmpty()) {
            RegistroPro.NoMarca.setVisible(true);
            RegistroPro.txtMarca.requestFocus();
        } else {
            marca = RegistroPro.txtMarca.getText();
            validar = Validate.validaNombre(marca);
            if (validar == false) {
                RegistroPro.txtMarca.requestFocus();
                RegistroPro.NoMarca.setVisible(true);
            } else {
                RegistroPro.NoMarca.setVisible(false);
            }
        }
        return marca;
    }

    public static String pideMarcaKeyPressed() {
        String marca = "";
        boolean validar;

        marca = RegistroPro.txtMarca.getText();
        if (marca.isEmpty()) {
            RegistroPro.NoMarca.setVisible(true);
            RegistroPro.txtMarca.requestFocus();
        } else {
            marca = RegistroPro.txtMarca.getText();
            validar = Validate.validaNombre(marca);
            if (validar == false) {
                RegistroPro.txtMarca.requestFocus();
                RegistroPro.NoMarca.setVisible(true);
            } else {
                RegistroPro.NoMarca.setVisible(false);
            }
        }
        return marca;
    }

    public static String ModipideMarca() {
        String marca = "";
        boolean validar;

        marca = ModificarPro.txtMarca.getText();
        if (marca.isEmpty()) {
            ModificarPro.NoMarca.setVisible(true);
            ModificarPro.txtMarca.requestFocus();
        } else {
            marca = ModificarPro.txtMarca.getText();
            validar = Validate.validaNombre(marca);
            if (validar == false) {
                ModificarPro.txtMarca.requestFocus();
                ModificarPro.NoMarca.setVisible(true);
            } else {
                ModificarPro.NoMarca.setVisible(false);
            }
        }
        return marca;
    }

    public static String ModipideMarcaKey() {
        String marca = "";
        boolean validar;

        marca = ModificarPro.txtMarca.getText();
        if (marca.isEmpty()) {
            ModificarPro.NoMarca.setVisible(true);
            ModificarPro.txtMarca.requestFocus();
        } else {
            marca = ModificarPro.txtMarca.getText();
            validar = Validate.validaNombre(marca);
            if (validar == false) {
                ModificarPro.txtMarca.requestFocus();
                ModificarPro.NoMarca.setVisible(true);
            } else {
                ModificarPro.NoMarca.setVisible(false);
            }
        }
        return marca;
    }

    public static String ModipideMarcaKeyPressed() {
        String marca = "";
        boolean validar;

        marca = ModificarPro.txtMarca.getText();
        if (marca.isEmpty()) {
            ModificarPro.NoMarca.setVisible(true);
            ModificarPro.txtMarca.requestFocus();
        } else {
            marca = ModificarPro.txtMarca.getText();
            validar = Validate.validaNombre(marca);
            if (validar == false) {
                ModificarPro.txtMarca.requestFocus();
                ModificarPro.NoMarca.setVisible(true);
            } else {
                ModificarPro.NoMarca.setVisible(false);
            }
        }
        return marca;
    }

    public static String pideDescripcion() {

        String descp = "";
        boolean validar;

        descp = RegistroPro.txtDesc.getText();
        if (descp.isEmpty()) {
            RegistroPro.NoDesc.setVisible(true);
            RegistroPro.txtDesc.requestFocus();
        } else {
            descp = RegistroPro.txtDesc.getText();
            validar = Validate.validaNombre(descp);
            if (validar == false) {
                RegistroPro.txtDesc.requestFocus();
                RegistroPro.NoDesc.setVisible(true);
            } else {
                RegistroPro.NoDesc.setVisible(false);
            }
        }
        return descp;
    }

    public static String ModipideDescripcion() {
        String descp = "";
        boolean validar;

        descp = ModificarPro.txtDesc.getText();
        if (descp.isEmpty()) {
            ModificarPro.NoDesc.setVisible(true);
            ModificarPro.txtDesc.requestFocus();
        } else {
            descp = ModificarPro.txtDesc.getText();
            validar = Validate.validaNombre(descp);
            if (validar == false) {
                ModificarPro.txtDesc.requestFocus();
                ModificarPro.NoDesc.setVisible(true);
            } else {
                ModificarPro.NoDesc.setVisible(false);
            }
        }
        return descp;
    }

    public static Fecha pideFechaMercado() {
        String fecha1 = "";
        Fecha fechaMercado = null;

        if (RegistroPro.dcFmercado.getDate() == null) {
            RegistroPro.NoFmercado.setVisible(true);
        } else {
            fecha1 = ((JTextFieldDateEditor) RegistroPro.dcFmercado.getDateEditor()).getText();
            fechaMercado = DAOCliente.introFecha(fecha1);
            RegistroPro.NoFmercado.setVisible(false);
        }
        return fechaMercado;
    }

    public static Fecha ModpideFechaMercado() {
        String fecha1 = "";
        Fecha fechaMercado = null;

        if (ModificarPro.dcFmercado.getDate() == null) {
            ModificarPro.NoFmercado.setVisible(true);
        } else {
            fecha1 = ((JTextFieldDateEditor) ModificarPro.dcFmercado.getDateEditor()).getText();
            fechaMercado = DAOCliente.introFecha(fecha1);
            ModificarPro.NoFmercado.setVisible(false);
        }
        return fechaMercado;
    }

    public static void LimpiarCreaProd() {
        RegistroPro.txtReferencia.setText("");
        RegistroPro.txtModelo.setText("");
        RegistroPro.txtMarca.setText("");
        RegistroPro.txtDesc.setText("");
        RegistroPro.dcFmercado.setDate(null);
    }

    public static void LimpiarModificarProd() {
        ModificarPro.txtReferencia.setText("");
        ModificarPro.txtModelo.setText("");
        ModificarPro.txtMarca.setText("");
        ModificarPro.txtDesc.setText("");
        ModificarPro.dcFmercado.setDate(null);
    }

    public static void OcultarErrores() {

        LoginBLL _tipoUsu = new LoginBLL();
        String usuario = Singletons.log.txtUsuario.getText();
        Singletons.tipoUsuario = _tipoUsu.TipoUsuarioBLL(usuario);

        if (Singletons.conectado.equals("si")) {

            if (Singletons.tipoUsuario.equals("Administrador")) {

                RegistroPro.NoRef.setVisible(false);
                RegistroPro.NoModelo.setVisible(false);
                RegistroPro.NoMarca.setVisible(false);
                RegistroPro.NoDesc.setVisible(false);
                RegistroPro.NoFmercado.setVisible(false);
            }
        }
    }

    public static void OcultarProd() {
        LoginBLL _tipoUsu = new LoginBLL();
        String usuario = Singletons.log.txtUsuario.getText();
        Singletons.tipoUsuario = _tipoUsu.TipoUsuarioBLL(usuario);

        if (Singletons.conectado.equals("no")) {
            SingletonsPro.PagerPro.btnAnyadir.setVisible(false);
            SingletonsPro.PagerPro.btnModif.setVisible(false);
            SingletonsPro.PagerPro.btnEliminar.setVisible(false);
            SingletonsPro.PagerPro.btnInfo.setVisible(false);
        }
    }

    public static void OcultarErroresModif() {

        LoginBLL _tipoUsuario = new LoginBLL();
        String usua = Singletons.log.txtUsuario.getText();
        Singletons.tipoUsuario = _tipoUsuario.TipoUsuarioBLL(usua);

        if (Singletons.tipoUsuario.equals("Administrador")) {
            ModificarPro.NoRef.setVisible(false);
            ModificarPro.NoModelo.setVisible(false);
            ModificarPro.NoMarca.setVisible(false);
            ModificarPro.NoDesc.setVisible(false);
            ModificarPro.NoFmercado.setVisible(false);
        }
    }

    public static void Modificar() {

        LoginBLL _tipoUsuario = new LoginBLL();
        String usua = Singletons.log.txtUsuario.getText();
        Singletons.tipoUsuario = _tipoUsuario.TipoUsuarioBLL(usua);

        if (Singletons.tipoUsuario.equals("Administrador")) {

            ModificarPro.txtReferencia.setText((SingletonsPro.p).getReferencia());
            ModificarPro.txtModelo.setText((SingletonsPro.p).getModelo());
            ModificarPro.txtMarca.setText((SingletonsPro.p).getMarca());
            ModificarPro.txtDesc.setText((SingletonsPro.p).getDescripcion());
            ((JTextFieldDateEditor) ModificarPro.dcFmercado.getDateEditor()).setText((SingletonsPro.p).getFechaMercado().toStringFecha());
            FileUploader.leer_imag(5);

        }
    }

    public static Productos ObtenerProductoListado() {
        Productos prod = pideRefvacio(Ventana_Prod.txtRef.getText());
        SingletonsPro.pos = BLLGraficoPro.buscar(prod);
        prod = SingletonsPro.pro.get(SingletonsPro.pos);
        return prod;
    }

    public static Productos pideRefvacio(String idmatch) {
        Productos prod = null;
        String ref;

        ref = idmatch;

        prod = new Productos(ref);

        return prod;
    }
}
