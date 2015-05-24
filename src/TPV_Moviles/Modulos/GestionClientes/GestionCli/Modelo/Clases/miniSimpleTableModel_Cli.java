package TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases;

import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.interfaz_Clientes;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.BLL.BLLBD;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Pager.pagina;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;

public class miniSimpleTableModel_Cli extends AbstractTableModel {

    public static ArrayList<Clientes> datos = new ArrayList<Clientes>();
    public static ArrayList<Clientes> datosaux = new ArrayList<Clientes>();
    String[] columnas = {"Nombre", "Apellidos", "DNI", "Edad", "Teléfono", "FNac", "FAlta"};

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
        Clientes fila = (Clientes) datos.get(row);

        switch (col) {
            case 0:
                dev = fila.getNombre();
                break;

            case 1:
                dev = fila.getApellidos();
                break;

            case 2:
                dev = fila.getDni();
                break;

            case 3:
                dev = fila.getEdad();
                break;

            case 4:
                dev = fila.getTelefono();
                break;

            case 5:
                dev = fila.getFechaNacimiento().toStringFecha();
                break;

            case 6:
                dev = fila.getFechaAlta().toStringFecha();
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
        Clientes fila = (Clientes) datos.get(row);

        switch (col) {
            case 0:
                fila.setNombre(value.toString());
                break;

            case 1:
                fila.setApellidos(value.toString());
                break;

            case 2:
                fila.setDni(value.toString());
                break;

            case 3:
                fila.setEdad(new Integer(value.toString()));
                break;

            case 4:
                fila.setTelefono(value.toString());
                break;

            case 5:
                fila.setFechaNacimiento(DAOCliente.sacaFecha(value.toString()));
                break;

            case 6:
                fila.setFechaAlta(DAOCliente.sacaFecha(value.toString()));
                break;

            case 7:
                fila.setUsuario(value.toString());
                break;

            case 8:
                fila.setPassword(value.toString());
                break;

            case 9:
                fila.setEmail(value.toString());
                break;

            case 10:
                fila.setEstado(new Integer(value.toString()));
                break;

            case 11:
                fila.setTipo(value.toString());
                break;

            case 12:
                fila.setAvatar(value.toString());
                break;

            case 13:
                ((Clientes) fila).setAntiguedad(new Integer(value.toString()));
                break;

            case 14:
                ((Clientes) fila).setSaldo(Float.parseFloat(value.toString()));
                break;
        }
        fireTableCellUpdated(row, col);
    }

    public void addRow(Clientes usu) {

        datos.add(usu);
        fireTableDataChanged();
    }

    public void cargar() {

        datos.clear();
        datosaux.clear();

        BLLBD _clientes = new BLLBD();
        _clientes.listarClienteBLL();
        
        for (int i = 0; i <= Singletons.efi.size() - 1; i++) {
            addRow(Singletons.efi.get(i));
            datosaux.add(Singletons.efi.get(i));
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
        String dni = (String) ((JComboBox) Singletons.combo).getSelectedItem();
        if (dni != null) {
            for (int i = 0; i < datosaux.size(); i++) {
                if (datosaux.get(i).getDni().contains(dni)) {
                    addRow(datosaux.get(i));
                    cont++;
                }
            }
            interfaz_Clientes.contFiltrar.setText(String.valueOf(cont));
            System.out.println("word selected: " + dni);
            pagina.initLinkBox();
        }
    }

    public Clientes buscar(String u) {
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

    public int buscaUsuario(Clientes u) {
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
