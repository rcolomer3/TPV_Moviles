/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases;

import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.AltaCli;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.ModificarCli;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.autocomplete.AutocompleteJComboBox;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.interfaz_Clientes;
import TPV_Moviles.Modulos.Inicio.Vista.SobreNosotros;
import TPV_Moviles.Modulos.Inicio.Vista.Ventana_Inicio;
import TPV_Moviles.Modulos.Login.Vista.CambiarPassword;
import TPV_Moviles.Modulos.Login.Vista.Login;
import java.util.ArrayList;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Raul
 */
public class Singletons {

    public static TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(new miniSimpleTableModel_Cli());
    public static AutocompleteJComboBox combo = null;
    public static Ventana_Inicio menuPpal;
    public static Ventana_Inicio config;
    public static AltaCli CrearCli;
    public static ModificarCli ModificarCli;
    public static interfaz_Clientes PagerCli;
    public static ArrayList<Clientes> efi;
    public static Clientes e;
    public static int pos;
    public static ArrayList<Clientes> AL_Clie = new ArrayList<Clientes>();
    public static Login log = new Login();
    public static SobreNosotros sobre = new SobreNosotros();
    public static CambiarPassword cbpass = new CambiarPassword();
    public static String PATH_auto;
    public static String PintaNombre = "";
    public static String tipoUsuario = "nulo";
    public static Clientes usu = new Clientes(); //cliente logeado
    public static String conectado = "no";
    public static String ruta = "src/TPV_Moviles/Img/empleado.png";
}
