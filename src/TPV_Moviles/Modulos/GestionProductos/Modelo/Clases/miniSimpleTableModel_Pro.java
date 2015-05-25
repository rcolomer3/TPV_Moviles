/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPV_Moviles.Modulos.GestionProductos.Modelo.Clases;

import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.DAOCliente;
import TPV_Moviles.Modulos.GestionProductos.Modelo.Pager.pagina;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;
import projectefinal_moviles.Modulos.Gestion_Productos.Vista.Ventana_Prod;

/**
 *
 * @author Raul
 */
public class miniSimpleTableModel_Pro extends AbstractTableModel {

    public static ArrayList<Productos> datos = new ArrayList<Productos>();
    public static ArrayList<Productos> datosaux = new ArrayList<Productos>();
    String[] columnas = {"Referencia", "Modelo", "Marca"};

    ////////////////////estos métodos son necesarios para que jtable funcione/////////////////////
    @Override
    public String getColumnName(int col) {
        return columnas[col].toString();
    }

    //Devuelve el numero de filas
    @Override
    public int getRowCount() {
        return datos.size();
    }

    //Devuelve el numero de columnas
    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    //Devuelve el valor del objeto en la fila y columna
    @Override
    public Object getValueAt(int row, int col) {

        Object dev = null;
        Productos fila = (Productos) datos.get(row);

        switch (col) {
            case 0:
                dev = fila.getReferencia();
                break;

            case 1:
                dev = fila.getModelo();
                break;

            case 2:
                dev = fila.getMarca();
                break;
        }
        return dev;
    }

    //Determina si una fila y columna ha de ser editable
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    //Actualiza un objeto de una fila y columna
    @Override
    public void setValueAt(Object value, int row, int col) {
        Productos fila = (Productos) datos.get(row);

        switch (col) {
            case 0:
                fila.setReferencia(value.toString());
                break;

            case 1:
                fila.setModelo(value.toString());
                break;

            case 2:
                fila.setMarca(value.toString());
                break;

            case 3:
                fila.setFechaMercado(DAOCliente.sacaFecha(value.toString()));
                break;

            case 4:
                ((Productos) fila).setAntiguedad(new Integer(value.toString()));
                break;

            case 5:
                fila.setPrecio(new Integer(value.toString()));
                break;

            case 6:
                ((Productos) fila).setStock(new Integer(value.toString()));
                break;

            case 7:
                fila.setTipo(value.toString());
                break;

            case 8:
                fila.setAvatar(value.toString());
                break;

        }
        fireTableCellUpdated(row, col);
    }

    public void addRow(Productos pro) {

        datos.add(pro);
        fireTableDataChanged();
    }

    public void cargar() {

        datos.clear();
        datosaux.clear();

        BLLBD _produ = new BLLBD();
        _produ.listarClienteBLL();

        for (int i = 0; i <= SingletonsPro.pro.size() - 1; i++) {
            addRow(SingletonsPro.pro.get(i));
            datosaux.add(SingletonsPro.pro.get(i));
        }
        try {
            Thread.sleep(1); //1 milliseconds
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void filtrar() {
        datos.clear();

        int cont = 0;
        String ref = (String) ((JComboBox) SingletonsPro.combo).getSelectedItem();
        if (ref != null) {
            for (int i = 0; i < datosaux.size(); i++) {
                if (datosaux.get(i).getReferencia().contains(ref)) {
                    addRow(datosaux.get(i));
                    cont++;
                }
            }
            Ventana_Prod.contFiltrar.setText(String.valueOf(cont));
            System.out.println("word selected: " + ref);
            pagina.initLinkBox();
        }
    }

    public Productos buscar(String u) {
        datos.clear();
        cargar();

        String res;
        for (int i = 0; i < datos.size(); i++) {
            res = datos.get(i).toString();
            if (res.contains(u)) {
                return datos.get(i);
            }
        }
        return null;
    }

    public int buscaUsuario(Productos u) {
        datos.clear();
        cargar();

        for (int i = 0; i < datos.size(); i++) {
            if (datos.get(i).equals(u)) {
                return i;
            }
        }
        return -1;
    }

    public void removeRow(int fila) {
        datos.remove(fila);
        fireTableDataChanged();
    }

    //para pintar ImageIcon
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }
}
