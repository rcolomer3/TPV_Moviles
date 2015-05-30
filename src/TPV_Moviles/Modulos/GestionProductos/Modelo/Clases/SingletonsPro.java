/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPV_Moviles.Modulos.GestionProductos.Modelo.Clases;

import TPV_Moviles.Modulos.GestionProductos.Vista.ModificarPro;
import TPV_Moviles.Modulos.GestionProductos.Vista.RegistroPro;
import TPV_Moviles.Modulos.GestionProductos.Vista.Ventana_Prod;
import TPV_Moviles.Modulos.GestionProductos.Vista.autocomplete.AutocompleteJComboBox;
import java.util.ArrayList;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Raul
 */
public class SingletonsPro {

    public static RegistroPro CrearPro;
    public static ModificarPro ModificarPro;
    public static Ventana_Prod PagerPro;
    public static ArrayList<Productos> pro;
    public static Productos p;
    public static int pos;
    public static String ruta = "src/TPV_Moviles/Img/movilalta.png";
    public static TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(new miniSimpleTableModel_Pro());
    public static AutocompleteJComboBox combo = null;
    public static String PATH_auto = "";
    public static String PintaNombre = "";
    public static ArrayList<Productos> AL_Prod = new ArrayList<Productos>();
}
