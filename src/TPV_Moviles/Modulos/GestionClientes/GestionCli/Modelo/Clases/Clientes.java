/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases;

import TPV_Moviles.Clases.Config;
import java.io.Serializable;

import TPV_Moviles.Clases.Fecha;
import TPV_Moviles.Librerias.Formato;
import TPV_Moviles.Ppal;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Clientes")
public class Clientes implements Comparable<Clientes>, Serializable {

    @XStreamAlias("nombre")
    private String nombre;

    @XStreamAlias("apellidos")
    private String apellidos;

    @XStreamAlias("DNI")
    private String DNI;

    @XStreamAlias("edad")
    private int edad;

    @XStreamAlias("telefono")
    private String telefono;

    @XStreamAlias("fechaNacimiento")
    private Fecha fechaNacimiento;

    @XStreamAlias("fechaAlta")
    private Fecha fechaAlta;

    @XStreamAlias("usuario")
    private String usuario;

    @XStreamAlias("password")
    private String password;

    @XStreamAlias("E-mail")
    private String email;

    @XStreamAlias("estado")
    private int estado;

    @XStreamAlias("tipo")
    private String tipo;

    @XStreamAlias("avatar")
    private String avatar;

    @XStreamAlias("antiguedad")
    private int antiguedad;

    @XStreamAlias("saldo")
    private float saldo;

    public Clientes(String nombre, String apellidos, String dni, String telefono, Fecha fechaNacimiento,
            Fecha fechaAlta, String usuario, String password, String email, int estado, String tipo, String avatar, float saldo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = dni;
        this.setEdad(fechaNacimiento.restaFechas());
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaAlta = fechaAlta;
        this.usuario = usuario;
        this.password = password;
        this.email = email;
        this.estado = estado;
        this.tipo = tipo;
        this.avatar = avatar;
        this.setAntiguedad(this.calcularAntiguedad(fechaAlta));
        this.saldo = (this.calcularSueldo());
    }

    public String toString() {
        String cad = "";
        if (Ppal.conf == null) {
            cad = "Cliente" + "\n" + "Nombre= " + getNombre() + "\n" + "Apellidos= "
                    + getApellidos() + "\n" + "DNI= " + getDni() + "\n" + "Edad= " + getEdad() + "\n"
                    + "Telefono= " + getTelefono() + "\n" + "Fecha Nacimiento= "
                    + getFechaNacimiento().toStringFecha() + "\n" + "Fecha Alta= "
                    + getFechaAlta().toStringFecha() + "\n" + "Antiguedad= " + getAntiguedad() + "\n"
                    + "Saldo= " + Formato.formato1d(getSaldo()) + Config.getMoneda() + "\n"
                    + "Usuario= " + getUsuario() + "\n" + "E-mail= " + getEmail();
        } else {
            if (Config.getNumdecimal().equals("1")) {
                cad = "Cliente" + "\n" + "Nombre= " + getNombre() + "\n" + "Apellidos= "
                        + getApellidos() + "\n" + "DNI= " + getDni() + "\n" + "Edad= " + getEdad() + "\n"
                        + "Telefono= " + getTelefono() + "\n" + "Fecha Nacimiento= "
                        + getFechaNacimiento().toStringFecha() + "\n" + "Fecha Alta= "
                        + getFechaAlta().toStringFecha() + "\n" + "Antiguedad= " + getAntiguedad() + "\n"
                        + "Saldo= " + Formato.formato1d(getSaldo()) + Config.getMoneda() + "\n"
                        + "Usuario= " + getUsuario() + "\n" + "E-mail= " + getEmail();

            } else if (Config.getNumdecimal().equals("2")) {
                cad = "Cliente" + "\n" + "Nombre= " + getNombre() + "\n" + "Apellidos= "
                        + getApellidos() + "\n" + "DNI= " + getDni() + "\n" + "Edad= " + getEdad() + "\n"
                        + "Telefono= " + getTelefono() + "\n" + "Fecha Nacimiento= "
                        + getFechaNacimiento().toStringFecha() + "\n" + "Fecha Alta= "
                        + getFechaAlta().toStringFecha() + "\n" + "Antiguedad= " + getAntiguedad() + "\n"
                        + "Saldo= " + Formato.formato2d(getSaldo()) + Config.getMoneda() + "\n"
                        + "Usuario= " + getUsuario() + "\n" + "E-mail= " + getEmail();

            } else if (Config.getNumdecimal().equals("3")) {
                cad = "Cliente" + "\n" + "Nombre= " + getNombre() + "\n" + "Apellidos= "
                        + getApellidos() + "\n" + "DNI= " + getDni() + "\n" + "Edad= " + getEdad() + "\n"
                        + "Telefono= " + getTelefono() + "\n" + "Fecha Nacimiento= "
                        + getFechaNacimiento().toStringFecha() + "\n" + "Fecha Alta= "
                        + getFechaAlta().toStringFecha() + "\n" + "Antiguedad= " + getAntiguedad() + "\n"
                        + "Saldo= " + Formato.formato3d(getSaldo()) + Config.getMoneda() + "\n"
                        + "Usuario= " + getUsuario() + "\n" + "E-mail= " + getEmail();
            }
        }
        return cad;
    }

    public Clientes(String dni) {
        this.DNI = dni;
    }

    public Clientes() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return DNI;
    }

    public void setDni(String dni) {
        DNI = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Fecha fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Fecha getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Fecha fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public int calcularEdad(Fecha fechaNacimiento) {
        this.setEdad(fechaNacimiento.restaFechas());
        return this.getEdad();
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public int calcularAntiguedad(Fecha fechaAlta) {
        this.setAntiguedad(fechaAlta.restaFechas());
        return this.getAntiguedad();
    }

    public int compareTo(Clientes emp) {// para ordenar los empleados
        if (this.getDni().compareTo(emp.getDni()) > 0) {
            return 1;
        }
        if (this.getDni().compareTo(emp.getDni()) < 0) {
            return -1;
        }
        return 0;
    }

    public boolean equals(Object c) {
        return getDni().equals(((Clientes) c).getDni());
    }
    
    public float calcularSueldo() {
        if ((this.getEdad() > 16) && (this.getEdad() < 25)) {
            this.setSaldo(700);
        }
        else if ((this.getEdad() > 25) && (this.getEdad() < 50)) {
            this.setSaldo(900);
        } 
        else if (this.getEdad() > 50) {
            this.setSaldo(1000);
        }
        return this.getSaldo();
    }
}
