/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases;

import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.AltaEF;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.ModificarEF;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.autocomplete.AutocompleteJComboBox;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.interfaz_Clientes;
import TPV_Moviles.Modulos.Inicio.Vista.Ventana_Empleados;
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
    public static Ventana_Empleados menuPpal;
    public static Ventana_Empleados config;
    public static AltaEF CrearEF;
    public static ModificarEF ModificarEF;
    public static interfaz_Clientes PagerEF;
    public static ArrayList<Clientes> efi;
    public static Clientes e;
    public static int pos;
    public static ArrayList<Clientes> AL_Clie = new ArrayList<Clientes>();
    public static Login log = new Login();
    public static CambiarPassword cbpass = new CambiarPassword();
    public static String PATH_auto;
    public static String PintaNombre = "";
    public static String tipoUsuario = "nulo";
    public static Clientes usu;
    public static String conectado = "no";
    public static String ruta = "src/TPV/Img/empleado.png";
}