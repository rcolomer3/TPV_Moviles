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
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.AltaEF;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.ModificarEF;
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

        DAOGrafico.crearEF();
        //dni no repes
        if (Singletons.e != null) {
            if (Singletons.conectado.equals("si")) {
                Singletons.efi.add(Singletons.e);
                BLLBD.nuevoEmpleadoBLL();
                ((miniSimpleTableModel_Cli) Singletons.PagerEF.TABLA.getModel()).cargar();
            } else if (Singletons.conectado.equals("no")) {
                Singletons.efi.add(Singletons.e);
                BLLBD.nuevoEmpleadoBLL();
                Singletons.CrearEF.dispose();
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

    public static void ModificarEFj() {
        ModificarEF();
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
        AltaEF.txtApellidos.requestFocus();
    }

    public static void pideApellidos() {
        DAOGrafico.pideApellidos();
        AltaEF.txtDNI.requestFocus();
    }

    public static void pideDNI() {
        int pos = 0;
        Clientes e = new Clientes(DAOGrafico.pideDNI());
        pos = buscar(e);

        if (pos != -1) {
            JOptionPane.showMessageDialog(null, "DNI repetido", "Aviso", JOptionPane.QUESTION_MESSAGE);
            AltaEF.NoDNI.setVisible(true);
            AltaEF.txtDNI.requestFocus();
        } else {
            AltaEF.NoDNI.setVisible(false);
            AltaEF.txtTelefono.requestFocus();
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
            ModificarEF.NoUsuario.setVisible(true);
            ModificarEF.txtUsuario.requestFocus();
        } else {
            ModificarEF.NoUsuario.setVisible(false);
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
            AltaEF.NoDNI.setVisible(true);
            AltaEF.txtDNI.requestFocus();
        } else {
            AltaEF.NoDNI.setVisible(false);
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
            AltaEF.NoDNI.setVisible(true);
            AltaEF.txtDNI.requestFocus();
        } else {
            AltaEF.NoDNI.setVisible(false);
        }
    }

    public static void pideEmailKeyPressed() {
        DAOGrafico.pideEmailKeyPressed();
    }

    public static void ModiNombre() {
        DAOGrafico.ModiPideNombre();
        ModificarEF.txtApellidos.requestFocus();
    }

    public static void ModiNombreKey() {
        DAOGrafico.ModiPideNombreKey();
    }

    public static void ModiNombreKeyPressed() {
        DAOGrafico.ModiPideNombreKeyPressed();
    }

    public static void ModApellidos() {
        DAOGrafico.ModPideApellidos();
        ModificarEF.txtTelefono.requestFocus();
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

    public static void ModificarEF() {

        if (ModificarEF.NoNombre.isVisible() == false) {
            Singletons.e.setNombre(ModiPideNombre());
        }
        if (ModificarEF.NoApellidos.isVisible() == false) {
            Singletons.e.setApellidos(ModPideApellidos());
        }
        if (ModificarEF.NoTelefono.isVisible() == false) {
            Singletons.e.setTelefono(ModPideTelefono());
        }
        if (ModificarEF.NOFNAC.isVisible() == false) {
            Singletons.e.setFechaNacimiento(ModipideFechaNac());
            Singletons.e.calcularEdad(ModipideFechaNac());
        }
        if (ModificarEF.NOFALTA.isVisible() == false) {
            Singletons.e.setFechaAlta(ModipideFechaAlta());
            Singletons.e.calcularAntiguedad(ModipideFechaAlta());
        }

        if (ModificarEF.NoUsuario.isVisible() == false) {
            Singletons.e.setUsuario(ModpideUsuario());
        }

        if (ModificarEF.NoPassword.isVisible() == false) {
            Singletons.e.setPassword(ModpidePassword());
        }

        if (ModificarEF.NoEmail.isVisible() == false) {
            Singletons.e.setEmail(ModpideEmail());
        }

        if (Singletons.PATH_auto != null) {
            Singletons.e.setAvatar(Singletons.PATH_auto);
        }

        Singletons.e.setTipo(ModificarEF.cmbTipoUser.getSelectedItem().toString());

        if ((ModificarEF.NoNombre.isVisible() == false) && (ModificarEF.NoApellidos.isVisible() == false) && (ModificarEF.NoTelefono.isVisible() == false) && (ModificarEF.NOFNAC.isVisible() == false)
                && (ModificarEF.NOFALTA.isVisible() == false) && (ModificarEF.NoUsuario.isVisible() == false) && (ModificarEF.NoPassword.isVisible() == false) && (ModificarEF.NoEmail.isVisible() == false)) {
            Singletons.efi.set(Singletons.pos, Singletons.e);
            BLLBD.modificarEmpleadoBLL();
            ((miniSimpleTableModel_Cli) Singletons.PagerEF.TABLA.getModel()).cargar();

            ModificarEF.txtNombre.requestFocus();
            ModificarEF.txtNombre.setText("");
            ModificarEF.txtApellidos.setText("");
            ModificarEF.txtTelefono.setText("");
            ModificarEF.txtUsuario.setText("");
            ModificarEF.txtEdad.setText("");
            ModificarEF.txtAntiguedad.setText("");
            ModificarEF.dcFnac.setDate(null);
            ModificarEF.dcFalta.setDate(null);
            ModificarEF.txtPassword.setText("");
            ModificarEF.txtEmail.setText("");
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
            ((miniSimpleTableModel_Cli) Singletons.PagerEF.TABLA.getModel()).cargar();
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
                    BLLBD.borrarEmpleadoBLL();
                    ((miniSimpleTableModel_Cli) Singletons.PagerEF.TABLA.getModel()).cargar();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay empleados", "Error!", 2);
        }
    }
}
