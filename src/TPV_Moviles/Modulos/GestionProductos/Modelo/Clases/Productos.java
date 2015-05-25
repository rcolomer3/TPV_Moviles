/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPV_Moviles.Modulos.GestionProductos.Modelo.Clases;

import TPV_Moviles.Clases.Config;
import TPV_Moviles.Clases.Fecha;
import TPV_Moviles.Librerias.Formato;
import TPV_Moviles.Ppal;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

/**
 *
 * @author Raul
 */
public class Productos implements Comparable<Productos>, Serializable {

    @XStreamAlias("referencia")
    public String referencia;
    @XStreamAlias("modelo")
    public String modelo;
    @XStreamAlias("marca")
    public String marca;
    @XStreamAlias("descripcion")
    public String descripcion;
    @XStreamAlias("fechaMercado")
    private Fecha fechaMercado;
    @XStreamAlias("antiguedad")
    private int antiguedad;
    @XStreamAlias("precio")
    public float precio;
    @XStreamAlias("stock")
    public int stock;
    @XStreamAlias("tipo")
    private String tipo;
    @XStreamAlias("avatar")
    private String avatar;

    public Productos(String referencia, String modelo, String marca, String descripcion,
            Fecha fechaMercado, float precio, int stock, String tipo, String avatar) {
        this.referencia = referencia;
        this.modelo = modelo;
        this.marca = marca;
        this.descripcion = descripcion;
        this.fechaMercado = fechaMercado;
        this.setAntiguedad(this.calcularAntiguedad(fechaMercado));
        this.precio = (this.calcularPrecio());
        this.stock = stock;
        this.tipo = tipo;
        this.avatar = avatar;
    }

    public Productos(String referencia) {
        this.referencia = referencia;
    }

    public Productos() {
    }

    public String getReferencia() {
        return referencia;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Fecha getFechaMercado() {
        return fechaMercado;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public float getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public String getTipo() {
        return tipo;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFechaMercado(Fecha fechaMercado) {
        this.fechaMercado = fechaMercado;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int calcularAntiguedad(Fecha fechaMercado) {
        this.setAntiguedad(fechaMercado.restaFechas());
        return this.getAntiguedad();
    }

    public int compareTo(Productos pro) {//para ordenar los clientes
        if (this.getReferencia().compareTo(pro.getReferencia()) > 0) {
            return 1;
        }
        if (this.getReferencia().compareTo(pro.getReferencia()) < 0) {
            return -1;
        }
        return 0;
    }

    public boolean equals(Object c) {
        return getReferencia().equals(((Productos) c).getReferencia());
    }

    @Override
    public String toString() {
        String cad = "";
        if (Ppal.conf == null) {
            cad = "Productos" + "\n" + "Referencia= " + getReferencia() + "\n" + "Modelo= "
                    + getModelo() + "Marca= " + getMarca() + "\n" + "Precio= " + Formato.formato1d(getPrecio()) + "\n"
                    + "Tipo= " + getTipo();
        } else {
            if (Config.getNumdecimal().equals("1")) {
                cad = "Productos" + "\n" + "Referencia= " + getReferencia() + "\n" + "Modelo= "
                        + getModelo() + "Marca= " + getMarca() + "\n" + "Precio= " + Formato.formato1d(getPrecio()) + "\n"
                        + "Tipo= " + getTipo();
            } else if (Config.getNumdecimal().equals("2")) {
                cad = "Productos" + "\n" + "Referencia= " + getReferencia() + "\n" + "Modelo= "
                        + getModelo() + "Marca= " + getMarca() + "\n" + "Precio= " + Formato.formato1d(getPrecio()) + "\n"
                        + "Tipo= " + getTipo();
            } else if (Config.getNumdecimal().equals("3")) {
                cad = "Productos" + "\n" + "Referencia= " + getReferencia() + "\n" + "Modelo= "
                        + getModelo() + "Marca= " + getMarca() + "\n" + "Precio= " + Formato.formato1d(getPrecio()) + "\n"
                        + "Tipo= " + getTipo();
            }
        }
        return cad;
    }
    
    public float calcularPrecio() {
        if ((this.getAntiguedad() > 1) && (this.getAntiguedad() < 2)) {
            this.setPrecio(600);
        }
        else if ((this.getAntiguedad() > 2) && (this.getAntiguedad() < 3)) {
            this.setPrecio(300);
        } 
        else if (this.getAntiguedad() > 3) {
            this.setPrecio(120);
        }
        return this.getPrecio();
    }
}
