/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPV_Moviles.Modulos.GestionProductos.Modelo.Clases;

import TPV_Moviles.Modulos.GestionProductos.Vista.ModificarPro;
import TPV_Moviles.Modulos.GestionProductos.Vista.RegistroPro;
import TPV_Moviles.Modulos.GestionProductos.Vista.autocomplete.AutocompleteJComboBox;
import java.util.ArrayList;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import projectefinal_moviles.Modulos.Gestion_Productos.Vista.Ventana_Prod;

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
}
