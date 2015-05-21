/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPV_Moviles;

import TPV_Moviles.Clases.Config;
import TPV_Moviles.Modulos.Login.Controlador_Login.Controlador_Login;
import TPV_Moviles.Modulos.Login.Vista.Login;

/**
 *
 * @author Raul
 */
public class Ppal {

    public static Config conf = null;

    public static void main(String[] args) {

        conf = new Config();
        //new Controlador_Inicio(new Ventana_Empleados(),0).iniciar(0);
        new Controlador_Login(new Login(), 0).iniciar(0);
    }
}
