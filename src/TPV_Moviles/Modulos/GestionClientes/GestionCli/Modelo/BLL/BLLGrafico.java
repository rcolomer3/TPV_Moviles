/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.BLL;

import TPV_Moviles.Clases.Config;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.Clientes;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.Singletons;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.miniSimpleTableModel_Cli;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.DAO.DAOGrafico;
import static TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.DAO.DAOGrafico.ModPideApellidos;
import static TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.DAO.DAOGrafico.ModPideTelefono;
import static TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.DAO.DAOGrafico.ModiPideNombre;
import static TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.DAO.DAOGrafico.ModipideFechaAlta;
import static TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.DAO.DAOGrafico.ModipideFechaNac;
import static TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.DAO.DAOGrafico.ModpideUsuario;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Pager.pagina;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.AltaCli;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.ModificarCli;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.interfaz_Clientes;
import TPV_Moviles.Modulos.Login.Controlador_Login.Controlador_Login;
import TPV_Moviles.Modulos.Login.Vista.Login;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author Raul
 */
public class BLLGrafico {

    public static void guardarEmpleadoEF() {

        DAOGrafico.crearCliente();
        //dni no repes
        if (Singletons.e != null) {
            if (Singletons.conectado.equals("si")) {
                Singletons.efi.add(Singletons.e);
                BLLBD.nuevoClienteBLL();
                ((miniSimpleTableModel_Cli) Singletons.PagerCli.TABLA.getModel()).cargar();
            } else if (Singletons.conectado.equals("no")) {
                Singletons.efi.add(Singletons.e);
                BLLBD.nuevoClienteBLL();
                Singletons.CrearCli.dispose();
                new Controlador_Login(new Login(), 0).iniciar(0);
            }
        }
    }

    public static int buscar(Clientes ef) {// Buscar
        int aux = -1;

        for (int i = 0; i <= (Singletons.efi.size() - 1); i++) {
            if ((Singletons.efi.get(i)).equals(ef)) {
                aux = i;
            }
        }
        return aux;
    }

    public static void ModificarCliente() {
        ModificarCli();
    }

    public static void ModificarPager() {
        DAOGrafico.Modificar();
    }

    public static void Imprimir() {
        imprimir(Singletons.efi);
    }

    public static void LimpiarModificar() {
        DAOGrafico.LimpiarModificarCliente();
    }

    public static void pideNombre() {
        DAOGrafico.pideNombre();
        AltaCli.txtApellidos.requestFocus();
    }

    public static void pideApellidos() {
        DAOGrafico.pideApellidos();
        AltaCli.txtDNI.requestFocus();
    }

    public static void pideDNI() {
        int pos = 0;
        Clientes e = new Clientes(DAOGrafico.pideDNI());
        pos = buscar(e);

        if (pos != -1) {
            JOptionPane.showMessageDialog(null, "DNI repetido", "Aviso", JOptionPane.QUESTION_MESSAGE);
            AltaCli.NoDNI.setVisible(true);
            AltaCli.txtDNI.requestFocus();
        } else {
            AltaCli.NoDNI.setVisible(false);
            AltaCli.txtTelefono.requestFocus();
        }
    }

    public static void pideTelefono() {
        DAOGrafico.pideTelefono();
    }

    public static void pideFNacimiento() {
        DAOGrafico.pideFechaNac();
    }

    public static void pideFAlta() {
        DAOGrafico.pideFechaAlta();
    }

    public static void pideEmail() {
        DAOGrafico.pideEmail();
    }

    public static void ModipideEmail() {
        DAOGrafico.ModPideEmail();
    }

    public static void ModipideUsuario() {

        int pos = 0;

        Clientes e = new Clientes(DAOGrafico.ModpideUsuario());
        pos = buscar(e);

        if (pos != -1) {
            ModificarCli.NoUsuario.setVisible(true);
            ModificarCli.txtUsuario.requestFocus();
        } else {
            ModificarCli.NoUsuario.setVisible(false);
        }
    }

    public static String ModpidePassword() {
        return DAOGrafico.ModpidePassword();
    }

    public static void LimpiarCreaCliente() {
        DAOGrafico.LimpiarCreaCliente();
    }

    public static void pideNombreKey() {
        DAOGrafico.pideNombreKey();
    }

    public static void pideApellidosKey() {
        DAOGrafico.pideApellidosKey();
    }

    public static void pideDNIkey() {
        int pos = 0;
        Clientes e = new Clientes(DAOGrafico.pideDNIkey());
        pos = buscar(e);

        if (pos != -1) {
            AltaCli.NoDNI.setVisible(true);
            AltaCli.txtDNI.requestFocus();
        } else {
            AltaCli.NoDNI.setVisible(false);
        }
    }

    public static void pideEmailKey() {
        DAOGrafico.pideEmailKey();
    }

    public static void pideNombreKeyPressed() {
        DAOGrafico.pideNombreKeyPressed();
    }

    public static void pideApellidosKeyPressed() {
        DAOGrafico.pideApellidosKeyPressed();
    }

    public static void pideDNIKeyPressed() {
        int pos = 0;
        Clientes e = new Clientes(DAOGrafico.pideDNIKeyPressed());
        pos = buscar(e);

        if (pos != -1) {
            //JOptionPane.showMessageDialog(null, "DNI repetido", "Aviso", JOptionPane.QUESTION_MESSAGE);
            AltaCli.NoDNI.setVisible(true);
            AltaCli.txtDNI.requestFocus();
        } else {
            AltaCli.NoDNI.setVisible(false);
        }
    }

    public static void pideEmailKeyPressed() {
        DAOGrafico.pideEmailKeyPressed();
    }

    public static void ModiNombre() {
        DAOGrafico.ModiPideNombre();
        ModificarCli.txtApellidos.requestFocus();
    }

    public static void ModiNombreKey() {
        DAOGrafico.ModiPideNombreKey();
    }

    public static void ModiNombreKeyPressed() {
        DAOGrafico.ModiPideNombreKeyPressed();
    }

    public static void ModApellidos() {
        DAOGrafico.ModPideApellidos();
        ModificarCli.txtTelefono.requestFocus();
    }

    public static void ModipideApellidosKey() {
        DAOGrafico.ModipideApellidosKey();
    }

    public static void ModipideApellidosKeyPressed() {
        DAOGrafico.ModipideApellidosKeyPressed();
    }

    public static void ModpideTelefono() {
        DAOGrafico.ModPideTelefono();
    }

    public static void ModpideFNacimiento() {
        DAOGrafico.ModipideFechaNac();
    }

    public static void ModpideFAlta() {
        DAOGrafico.ModipideFechaAlta();
    }

    public static String ModpideEmail() {
        return DAOGrafico.ModPideEmail();
    }

    public static void ModpideEmailKey() {
        DAOGrafico.ModPideEmailKey();
    }

    public static void ModpideEmailKeyPressed() {
        DAOGrafico.ModPideEmailKeyPressed();
    }

    public static void ModificarCli() {

        if (ModificarCli.NoNombre.isVisible() == false) {
            Singletons.e.setNombre(ModiPideNombre());
        }
        if (ModificarCli.NoApellidos.isVisible() == false) {
            Singletons.e.setApellidos(ModPideApellidos());
        }
        if (ModificarCli.NoTelefono.isVisible() == false) {
            Singletons.e.setTelefono(ModPideTelefono());
        }
        if (ModificarCli.NOFNAC.isVisible() == false) {
            Singletons.e.setFechaNacimiento(ModipideFechaNac());
            Singletons.e.calcularEdad(ModipideFechaNac());
        }
        if (ModificarCli.NOFALTA.isVisible() == false) {
            Singletons.e.setFechaAlta(ModipideFechaAlta());
            Singletons.e.calcularAntiguedad(ModipideFechaAlta());
        }

        if (ModificarCli.NoUsuario.isVisible() == false) {
            Singletons.e.setUsuario(ModpideUsuario());
        }

        if (ModificarCli.NoPassword.isVisible() == false) {
            Singletons.e.setPassword(ModpidePassword());
        }

        if (ModificarCli.NoEmail.isVisible() == false) {
            Singletons.e.setEmail(ModpideEmail());
        }

        Singletons.e.setSaldo(Singletons.e.getSaldo());

        if (Singletons.PATH_auto != null) {
            Singletons.e.setAvatar(Singletons.PATH_auto);
        }

        if (ModificarCli.cmbTipoUser.getSelectedItem() != null) {
            Singletons.e.setTipo(ModificarCli.cmbTipoUser.getSelectedItem().toString());
        }

        if ((ModificarCli.NoNombre.isVisible() == false) && (ModificarCli.NoApellidos.isVisible() == false) && (ModificarCli.NoTelefono.isVisible() == false) && (ModificarCli.NOFNAC.isVisible() == false)
                && (ModificarCli.NOFALTA.isVisible() == false) && (ModificarCli.NoUsuario.isVisible() == false) && (ModificarCli.NoPassword.isVisible() == false) && (ModificarCli.NoEmail.isVisible() == false)) {
            Singletons.efi.set(Singletons.pos, Singletons.e);
            BLLBD.modificarClienteBLL();
            ((miniSimpleTableModel_Cli) Singletons.PagerCli.TABLA.getModel()).cargar();

            ModificarCli.txtNombre.requestFocus();
            ModificarCli.txtNombre.setText("");
            ModificarCli.txtApellidos.setText("");
            ModificarCli.txtTelefono.setText("");
            ModificarCli.txtUsuario.setText("");
            ModificarCli.txtEdad.setText("");
            ModificarCli.txtAntiguedad.setText("");
            ModificarCli.dcFnac.setDate(null);
            ModificarCli.dcFalta.setDate(null);
            ModificarCli.txtPassword.setText("");
            ModificarCli.txtEmail.setText("");
        }
    }

    public static void imprimir(ArrayList<? extends Clientes> l) {

        Clientes ef;
        String cad = "";
        Iterator<Clientes> it = (Iterator<Clientes>) l.iterator();
        while (it.hasNext()) {
            ef = it.next();
            cad = Singletons.e + "\n" + "\n";
        }
        JOptionPane.showMessageDialog(null, cad);
    }

    public static void InformacionEFPager() {
        imprimir(Singletons.efi);
    }

    public static void OcultarErroresAlta() {
        DAOGrafico.OcultarErrores();
    }

    public static void OcultarErroresRegistro() {
        DAOGrafico.OcultarErroresRegistro();
    }

    public static void OcultarErroresModificar() {
        DAOGrafico.OcultarErroresModif();
    }

    public static void GuardarAPeticionUsuario() {// Guardar en el formato elegido por el
        // usuario previamente en configuracion
        if (!Singletons.efi.isEmpty()) {
            ((miniSimpleTableModel_Cli) Singletons.PagerCli.TABLA.getModel()).cargar();
            switch (Config.getGuardar()) {
                case "1":
                    TPV_Moviles.Librerias.json.generajsonCliente();
                    break;
                case "2":
                    TPV_Moviles.Librerias.txt.generatxtCliente();
                    break;
                case "3":
                    TPV_Moviles.Librerias.xml.generaxmlCliente();
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "ArrayList vacio", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void AbrirAPeticionUsuario() { // Abrir en el formato elegido por el usuario
        // previamente en configuracion

        switch (Config.getAbrir()) {
            case "1":
                Singletons.efi = TPV_Moviles.Librerias.json.abrir_jsonCliente();
                break;
            case "2":
                Singletons.efi = TPV_Moviles.Librerias.txt.abrir_txtClientes();
                break;
            case "3":
                Singletons.efi = TPV_Moviles.Librerias.xml.abrir_xmlCliente();
                break;
        }
    }

    public static void EliminarPager() {

        String dni;
        int selection, inicio, selection1;

        int n = ((miniSimpleTableModel_Cli) interfaz_Clientes.TABLA.getModel()).getRowCount();
        if (n != 0) {
            inicio = (pagina.currentPageIndex - 1) * pagina.itemsPerPage;
            selection = interfaz_Clientes.TABLA.getSelectedRow();
            selection1 = inicio + selection;
            if (n == -1) {
                JOptionPane.showMessageDialog(null, "No hay una persona seleccionada", "Error!", 2);
            } else {
                dni = (String) interfaz_Clientes.TABLA.getModel().getValueAt(selection1, 2);
                int opc = JOptionPane.showConfirmDialog(null, "Deseas borrar a la persona con DNI: " + dni,
                        "Info", JOptionPane.WARNING_MESSAGE);
                if (opc == 0) {
                    ((miniSimpleTableModel_Cli) interfaz_Clientes.TABLA.getModel()).removeRow(selection1);
                    BLLBD.borrarClienteBLL();
                    ((miniSimpleTableModel_Cli) Singletons.PagerCli.TABLA.getModel()).cargar();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay empleados", "Error!", 2);
        }
    }
}
