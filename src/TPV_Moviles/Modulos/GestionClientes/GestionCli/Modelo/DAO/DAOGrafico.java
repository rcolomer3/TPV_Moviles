/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.DAO;

import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.DAOCliente;
import TPV_Moviles.Clases.Fecha;
import TPV_Moviles.Librerias.FileUploader;
import TPV_Moviles.Clases.JavaMail;
import TPV_Moviles.Librerias.Encrypt;
import TPV_Moviles.Librerias.Funciones;
import TPV_Moviles.Librerias.Validate;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.BLL.BLLGrafico;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.Clientes;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.Singletons;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.AltaCli;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.ModificarCli;
import TPV_Moviles.Modulos.Login.BLL.LoginBLL;
import TPV_Moviles.Modulos.Login.Vista.Login;
import com.toedter.calendar.JTextFieldDateEditor;
import javax.swing.JOptionPane;

/**
 *
 * @author Raul
 */
public class DAOGrafico {

    public static void crearCliente() {
        String nombre = "", apellidos = "", dni = "", telefono = "", usuario = "", password = "", email = "", tipo = "", avatar = "",
                subject = "Tu contraseña de registro es:  ", mensaje = "Gracias por registrarte", passwordEn = "";
        int estado = 0;
        float saldo = 0.0f;
        Fecha fechaNacimiento = null, fechaAlta = null;

        nombre = pideNombre();
        apellidos = pideApellidos();
        dni = pideDNI();
        telefono = pideTelefono();
        fechaNacimiento = pideFechaNac();
        fechaAlta = pideFechaAlta();
        usuario = Funciones.getCadenaAleatoria(5);
        password = Funciones.getCadenaAleatoria(7);
        passwordEn = Encrypt.encriptarTokenMD5(password);
        email = pideEmail();
        estado = 0;
        tipo = AltaCli.cmbTipo.getSelectedItem().toString();
        avatar = Singletons.ruta;
        
        if ((AltaCli.NoNombre.isVisible() == false) && (AltaCli.NoApellidos.isVisible() == false) && (AltaCli.NoDNI.isVisible() == false) && (AltaCli.NoTelefono.isVisible() == false) && (AltaCli.NOFNAC.isVisible() == false) && (AltaCli.NOFALTA.isVisible() == false)
                && (AltaCli.NoEmail.isVisible() == false)) {
            Singletons.e = new Clientes(nombre, apellidos, dni, telefono, fechaNacimiento, fechaAlta, usuario, passwordEn, email, estado, tipo, avatar, saldo);

            //creamos el objeto Mail
            JavaMail mail = new JavaMail(email, password, subject, mensaje);
            //enviamos el mensaje
            
            //JOptionPane.showMessageDialog(null, mail.toString(), "Envio Email OK", JOptionPane.INFORMATION_MESSAGE);
            
            String error = mail.send();
            if (error.equals("")) {
                JOptionPane.showMessageDialog(null, "Envio Correcto", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error de envio:\n" + error, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static String pideNombre() {

        String nomb = "";
        boolean validar;

        nomb = AltaCli.txtNombre.getText();
        if (nomb.isEmpty()) {
            AltaCli.NoNombre.setVisible(true);
            AltaCli.txtNombre.requestFocus();
        } else {
            nomb = AltaCli.txtNombre.getText();
            validar = Validate.validaNombre(nomb);
            if (validar == false) {
                AltaCli.txtNombre.requestFocus();
                AltaCli.NoNombre.setVisible(true);
            } else {
                AltaCli.NoNombre.setVisible(false);
            }
        }
        return nomb;
    }

    public static String pideNombreKey() {
        String nomb = "";
        boolean validar;

        nomb = AltaCli.txtNombre.getText();
        if (nomb.isEmpty()) {
            AltaCli.NoNombre.setVisible(true);
            AltaCli.txtNombre.requestFocus();
        } else {
            nomb = AltaCli.txtNombre.getText();
            validar = Validate.validaNombre(nomb);
            if (validar == false) {
                AltaCli.txtNombre.requestFocus();
                AltaCli.NoNombre.setVisible(true);
            } else {
                AltaCli.NoNombre.setVisible(false);
            }
        }
        return nomb;
    }

    public static String pideNombreKeyPressed() {
        String nomb = "";
        boolean validar;

        nomb = AltaCli.txtNombre.getText();
        if (nomb.isEmpty()) {
            AltaCli.NoNombre.setVisible(true);
            AltaCli.txtNombre.requestFocus();
        } else {
            nomb = AltaCli.txtNombre.getText();
            validar = Validate.validaNombre(nomb);
            if (validar == false) {
                AltaCli.txtNombre.requestFocus();
                AltaCli.NoNombre.setVisible(true);
            } else {
                AltaCli.NoNombre.setVisible(false);
            }
        }
        return nomb;
    }

    public static String ModiPideNombre() {
        String nomb = "";
        boolean validar;

        nomb = ModificarCli.txtNombre.getText();
        if (nomb.isEmpty()) {
            ModificarCli.NoNombre.setVisible(true);
            ModificarCli.txtNombre.requestFocus();
        } else {
            nomb = ModificarCli.txtNombre.getText();
            validar = Validate.validaNombre(nomb);
            if (validar == false) {
                ModificarCli.txtNombre.requestFocus();
                ModificarCli.NoNombre.setVisible(true);
            } else {
                ModificarCli.NoNombre.setVisible(false);
            }
        }
        return nomb;
    }

    public static String ModiPideNombreKey() {
        String nomb = "";
        boolean validar;

        nomb = ModificarCli.txtNombre.getText();
        if (nomb.isEmpty()) {
            ModificarCli.NoNombre.setVisible(true);
            ModificarCli.txtNombre.requestFocus();
        } else {
            nomb = ModificarCli.txtNombre.getText();
            validar = Validate.validaNombre(nomb);
            if (validar == false) {
                ModificarCli.txtNombre.requestFocus();
                ModificarCli.NoNombre.setVisible(true);
            } else {
                ModificarCli.NoNombre.setVisible(false);
            }
        }
        return nomb;
    }

    public static String ModiPideNombreKeyPressed() {
        String nomb = "";
        boolean validar;

        nomb = ModificarCli.txtNombre.getText();
        if (nomb.isEmpty()) {
            ModificarCli.NoNombre.setVisible(true);
            ModificarCli.txtNombre.requestFocus();
        } else {
            nomb = ModificarCli.txtNombre.getText();
            validar = Validate.validaNombre(nomb);
            if (validar == false) {
                ModificarCli.txtNombre.requestFocus();
                ModificarCli.NoNombre.setVisible(true);
            } else {
                ModificarCli.NoNombre.setVisible(false);
            }
        }
        return nomb;
    }

    public static String pideApellidos() {
        String apel = "";
        boolean validar;

        apel = AltaCli.txtApellidos.getText();
        if (apel.isEmpty()) {
            AltaCli.NoApellidos.setVisible(true);
            AltaCli.txtApellidos.requestFocus();
        } else {
            apel = AltaCli.txtApellidos.getText();
            validar = Validate.validaNombre(apel);
            if (validar == false) {
                AltaCli.txtApellidos.requestFocus();
                AltaCli.NoApellidos.setVisible(true);
            } else {
                AltaCli.NoApellidos.setVisible(false);
            }
        }
        return apel;
    }

    public static String pideApellidosKey() {
        String apel = "";
        boolean validar;

        apel = AltaCli.txtApellidos.getText();
        if (apel.isEmpty()) {
            AltaCli.NoApellidos.setVisible(true);
            AltaCli.txtApellidos.requestFocus();
        } else {
            apel = AltaCli.txtApellidos.getText();
            validar = Validate.validaNombre(apel);
            if (validar == false) {
                AltaCli.txtApellidos.requestFocus();
                AltaCli.NoApellidos.setVisible(true);
            } else {
                AltaCli.NoApellidos.setVisible(false);
            }
        }
        return apel;
    }

    public static String pideApellidosKeyPressed() {
        String apel = "";
        boolean validar;

        apel = AltaCli.txtApellidos.getText();
        if (apel.isEmpty()) {
            AltaCli.NoApellidos.setVisible(true);
            AltaCli.txtApellidos.requestFocus();
        } else {
            apel = AltaCli.txtApellidos.getText();
            validar = Validate.validaNombre(apel);
            if (validar == false) {
                AltaCli.txtApellidos.requestFocus();
                AltaCli.NoApellidos.setVisible(true);
            } else {
                AltaCli.NoApellidos.setVisible(false);
            }
        }
        return apel;
    }

    public static String ModPideApellidos() {
        String apel = "";
        boolean validar;

        apel = ModificarCli.txtApellidos.getText();
        if (apel.isEmpty()) {
            ModificarCli.NoApellidos.setVisible(true);
            ModificarCli.txtApellidos.requestFocus();
        } else {
            apel = ModificarCli.txtApellidos.getText();
            validar = Validate.validaNombre(apel);
            if (validar == false) {
                ModificarCli.txtApellidos.requestFocus();
                ModificarCli.NoApellidos.setVisible(true);
            } else {
                ModificarCli.NoApellidos.setVisible(false);
            }
        }
        return apel;
    }

    public static String ModipideApellidosKey() {
        String apel = "";
        boolean validar;

        apel = ModificarCli.txtApellidos.getText();
        if (apel.isEmpty()) {
            ModificarCli.NoApellidos.setVisible(true);
            ModificarCli.txtApellidos.requestFocus();
        } else {
            apel = ModificarCli.txtApellidos.getText();
            validar = Validate.validaNombre(apel);
            if (validar == false) {
                ModificarCli.txtApellidos.requestFocus();
                ModificarCli.NoApellidos.setVisible(true);
            } else {
                ModificarCli.NoApellidos.setVisible(false);
            }
        }
        return apel;
    }

    public static String ModipideApellidosKeyPressed() {
        String apel = "";
        boolean validar;

        apel = ModificarCli.txtApellidos.getText();
        if (apel.isEmpty()) {
            ModificarCli.NoApellidos.setVisible(true);
            ModificarCli.txtApellidos.requestFocus();
        } else {
            apel = ModificarCli.txtApellidos.getText();
            validar = Validate.validaNombre(apel);
            if (validar == false) {
                ModificarCli.txtApellidos.requestFocus();
                ModificarCli.NoApellidos.setVisible(true);
            } else {
                ModificarCli.NoApellidos.setVisible(false);
            }
        }
        return apel;
    }

    public static String pideDNI() {
        String dni = "";
        boolean validar;

        dni = AltaCli.txtDNI.getText();
        if (dni.isEmpty()) {
            AltaCli.txtDNI.requestFocus();
            AltaCli.NoDNI.setVisible(true);
        } else {
            dni = AltaCli.txtDNI.getText();
            validar = Validate.validaDNI(dni);
            if (validar == false) {
                AltaCli.txtDNI.requestFocus();
                AltaCli.NoDNI.setVisible(true);
            } else {
                AltaCli.NoDNI.setVisible(false);
            }
        }
        return dni;
    }

    public static String pideDNIkey() {
        String dni = "";
        boolean validar;

        dni = AltaCli.txtDNI.getText();
        if (dni.isEmpty()) {
            AltaCli.txtDNI.requestFocus();
            AltaCli.NoDNI.setVisible(true);
        } else {
            dni = AltaCli.txtDNI.getText();
            validar = Validate.validaDNI(dni);
            if (validar == false) {
                AltaCli.txtDNI.requestFocus();
                AltaCli.NoDNI.setVisible(true);
            } else {
                AltaCli.NoDNI.setVisible(false);
            }
        }
        return dni;
    }

    public static String pideDNIKeyPressed() {
        String dni = "";
        boolean validar;

        dni = AltaCli.txtDNI.getText();
        if (dni.isEmpty()) {
            AltaCli.txtDNI.requestFocus();
            AltaCli.NoDNI.setVisible(true);
        } else {
            dni = AltaCli.txtDNI.getText();
            validar = Validate.validaDNI(dni);
            if (validar == false) {
                AltaCli.txtDNI.requestFocus();
                AltaCli.NoDNI.setVisible(true);
            } else {
                AltaCli.NoDNI.setVisible(false);
            }
        }
        return dni;
    }

    public static String pideTelefono() {
        String telef = "";
        boolean validar;

        telef = AltaCli.txtTelefono.getText();
        if (telef.isEmpty()) {
            AltaCli.txtTelefono.requestFocus();
            AltaCli.NoTelefono.setVisible(true);
        } else {
            telef = AltaCli.txtTelefono.getText();
            validar = Validate.validaTelefono(telef);
            if (validar == false) {
                AltaCli.txtTelefono.requestFocus();
                AltaCli.NoTelefono.setVisible(true);
            } else {
                AltaCli.NoTelefono.setVisible(false);
            }
        }
        return telef;
    }

    public static String ModPideTelefono() {
        String telef = "";
        boolean validar;

        telef = ModificarCli.txtTelefono.getText();
        if (telef.isEmpty()) {
            ModificarCli.txtTelefono.requestFocus();
            ModificarCli.NoTelefono.setVisible(true);
        } else {
            telef = ModificarCli.txtTelefono.getText();
            validar = Validate.validaTelefono(telef);
            if (validar == false) {
                ModificarCli.txtTelefono.requestFocus();
                ModificarCli.NoTelefono.setVisible(true);
            } else {
                ModificarCli.NoTelefono.setVisible(false);
            }
        }
        return telef;
    }

    public static Fecha pideFechaNac() {
        String fecha = "";
        Fecha fechaNacimiento = null;
        int edad = 0;

        if (AltaCli.dcfnac.getDate() == null) {
            AltaCli.NOFNAC.setVisible(true);
        } else {
            fecha = ((JTextFieldDateEditor) AltaCli.dcfnac.getDateEditor()).getText();
            fechaNacimiento = DAOCliente.introFecha(fecha);
            edad = fechaNacimiento.restaFechas();
            if (edad < 16) {
                AltaCli.NOFNAC.setVisible(true);
            } else {
                AltaCli.txtEdad.setText(Integer.toString(edad));
                AltaCli.NOFNAC.setVisible(false);
            }
        }
        return fechaNacimiento;
    }

    public static Fecha ModipideFechaNac() {
        String fecha = "";
        Fecha fechaNacimiento = null;
        int edad = 0;

        if (ModificarCli.dcFnac.getDate() == null) {
            ModificarCli.NOFNAC.setVisible(true);
        } else {
            fecha = ((JTextFieldDateEditor) ModificarCli.dcFnac.getDateEditor()).getText();
            fechaNacimiento = DAOCliente.introFecha(fecha);
            edad = fechaNacimiento.restaFechas();
            if (edad < 16) {
                ModificarCli.NOFNAC.setVisible(true);
            } else {
                ModificarCli.txtEdad.setText(Integer.toString(edad));
                ModificarCli.NOFNAC.setVisible(false);
            }
        }
        return fechaNacimiento;
    }

    public static Fecha pideFechaAlta() {
        String fecha1 = "";
        Fecha fechaAlta = null;
        int antiguedad = 0, edad = 0;

        if (AltaCli.dcFAlta.getDate() == null) {
            AltaCli.NOFALTA.setVisible(true);
        } else {
            fecha1 = ((JTextFieldDateEditor) AltaCli.dcFAlta.getDateEditor()).getText();
            fechaAlta = DAOCliente.introFecha(fecha1);
            if (AltaCli.dcFAlta.getCalendar().before(AltaCli.dcfnac.getCalendar())) {
                JOptionPane.showMessageDialog(null, "La fecha de contratación no puede ser anterior a la de nacimiento");
            } else {
                antiguedad = fechaAlta.restaFechas();
                edad = Integer.parseInt(AltaCli.txtEdad.getText());
                if ((edad - antiguedad) < 16) {
                    AltaCli.txtEdad.setText("");
                    AltaCli.txtAntiguedad.setText("");
                    AltaCli.NOFALTA.setVisible(true);
                } else {
                    AltaCli.txtAntiguedad.setText(Integer.toString(antiguedad));
                    AltaCli.NOFALTA.setVisible(false);
                }
            }
        }
        return fechaAlta;
    }

    public static Fecha ModipideFechaAlta() {
        String fecha1 = "";
        Fecha fechaAlta = null;
        int antiguedad = 0, edad = 0;

        if (ModificarCli.dcFalta.getDate() == null) {
            ModificarCli.NOFALTA.setVisible(true);
        } else {
            fecha1 = ((JTextFieldDateEditor) ModificarCli.dcFalta.getDateEditor()).getText();
            fechaAlta = DAOCliente.introFecha(fecha1);
            if (ModificarCli.dcFalta.getCalendar().before(ModificarCli.dcFnac.getCalendar())) {
                JOptionPane.showMessageDialog(null, "La fecha de contratación no puede ser anterior a la de nacimiento");
            } else {
                antiguedad = fechaAlta.restaFechas();
                edad = Integer.parseInt(ModificarCli.txtEdad.getText());
                if ((edad - antiguedad) < 16) {
                    ModificarCli.txtEdad.setText("");
                    ModificarCli.txtAntiguedad.setText("");
                    ModificarCli.NOFALTA.setVisible(true);
                } else {
                    ModificarCli.txtAntiguedad.setText(Integer.toString(antiguedad));
                    ModificarCli.NOFALTA.setVisible(false);
                }
            }
        }
        return fechaAlta;
    }

    public static String pideEmail() {
        String email = "";
        boolean validar;

        email = AltaCli.txtEmail.getText();
        if (email.isEmpty()) {
            AltaCli.txtEmail.requestFocus();
            AltaCli.NoEmail.setVisible(true);
        } else {
            email = AltaCli.txtEmail.getText();
            validar = Validate.validaEmail(email);
            if (validar == false) {
                AltaCli.txtEmail.requestFocus();
                AltaCli.NoEmail.setVisible(true);
            } else {
                AltaCli.NoEmail.setVisible(false);
            }
        }
        return email;
    }

    public static String pideEmailKey() {
        String email = "";
        boolean validar;

        email = AltaCli.txtEmail.getText();
        if (email.isEmpty()) {
            AltaCli.txtEmail.requestFocus();
            AltaCli.NoEmail.setVisible(true);
        } else {
            email = AltaCli.txtEmail.getText();
            validar = Validate.validaEmail(email);
            if (validar == false) {
                AltaCli.txtEmail.requestFocus();
                AltaCli.NoEmail.setVisible(true);
            } else {
                AltaCli.NoEmail.setVisible(false);
            }
        }
        return email;
    }

    public static String pideEmailKeyPressed() {
        String email = "";
        boolean validar;

        email = AltaCli.txtEmail.getText();
        if (email.isEmpty()) {
            AltaCli.txtEmail.requestFocus();
            AltaCli.NoEmail.setVisible(true);
        } else {
            email = AltaCli.txtEmail.getText();
            validar = Validate.validaEmail(email);
            if (validar == false) {
                AltaCli.txtEmail.requestFocus();
                AltaCli.NoEmail.setVisible(true);
            } else {
                AltaCli.NoEmail.setVisible(false);
            }
        }
        return email;
    }

    public static String ModPideEmail() {
        String email = "";
        boolean validar;

        email = ModificarCli.txtEmail.getText();
        if (email.isEmpty()) {
            ModificarCli.txtEmail.requestFocus();
            ModificarCli.NoEmail.setVisible(true);
        } else {
            email = ModificarCli.txtEmail.getText();
            validar = Validate.validaEmail(email);
            if (validar == false) {
                ModificarCli.txtEmail.requestFocus();
                ModificarCli.NoEmail.setVisible(true);
            } else {
                ModificarCli.NoEmail.setVisible(false);
            }
        }
        return email;
    }

    public static String ModPideEmailKey() {
        String email = "";
        boolean validar;

        email = ModificarCli.txtEmail.getText();
        if (email.isEmpty()) {
            ModificarCli.txtEmail.requestFocus();
            ModificarCli.NoEmail.setVisible(true);
        } else {
            email = ModificarCli.txtEmail.getText();
            validar = Validate.validaEmail(email);
            if (validar == false) {
                ModificarCli.txtEmail.requestFocus();
                ModificarCli.NoEmail.setVisible(true);
            } else {
                ModificarCli.NoEmail.setVisible(false);
            }
        }
        return email;
    }

    public static String ModPideEmailKeyPressed() {
        String email = "";
        boolean validar;

        email = ModificarCli.txtEmail.getText();
        if (email.isEmpty()) {
            ModificarCli.txtEmail.requestFocus();
            ModificarCli.NoEmail.setVisible(true);
        } else {
            email = ModificarCli.txtEmail.getText();
            validar = Validate.validaEmail(email);
            if (validar == false) {
                ModificarCli.txtEmail.requestFocus();
                ModificarCli.NoEmail.setVisible(true);
            } else {
                ModificarCli.NoEmail.setVisible(false);
            }
        }
        return email;
    }

    public static String ModpideUsuario() {
        String usuario = "";

        usuario = ModificarCli.txtUsuario.getText();
        if (usuario.isEmpty()) {
            ModificarCli.txtUsuario.requestFocus();
            ModificarCli.NoUsuario.setVisible(true);
        } else {
            usuario = ModificarCli.txtUsuario.getText();
            ModificarCli.NoUsuario.setVisible(false);
        }
        return usuario;
    }

    public static String ModpidePassword() {
        String password = "";

        password = ModificarCli.txtPassword.getText();

        if (password.isEmpty()) {
            ModificarCli.txtPassword.requestFocus();
            ModificarCli.NoPassword.setVisible(true);
        } else {
            password = Encrypt.encriptarTokenMD5(password);
            ModificarCli.NoPassword.setVisible(false);
        }
        return password;
    }
    
    public static void LimpiarCreaCliente() {
        AltaCli.txtNombre.setText("");
        AltaCli.txtApellidos.setText("");
        AltaCli.txtDNI.setText("");
        AltaCli.txtTelefono.setText("");
        AltaCli.txtEdad.setText("");
        AltaCli.txtAntiguedad.setText("");
        AltaCli.dcfnac.setDate(null);
        AltaCli.dcFAlta.setDate(null);
        AltaCli.txtEmail.setText("");
    }

    public static void LimpiarModificarCliente() {
        ModificarCli.txtNombre.setText("");
        ModificarCli.txtApellidos.setText("");
        ModificarCli.txtTelefono.setText("");
        ModificarCli.txtUsuario.setText("");
        ModificarCli.txtAntiguedad.setText("");
        ModificarCli.dcFnac.setDate(null);
        ModificarCli.dcFalta.setDate(null);
        ModificarCli.txtPassword.setText("");
        ModificarCli.txtEmail.setText("");
        ModificarCli.txtEdad.setText("");
    }

    public static void OcultarErrores() {

        LoginBLL _tipoUsu = new LoginBLL();
        String usuario = Singletons.log.txtUsuario.getText();
        Singletons.tipoUsuario = _tipoUsu.TipoUsuarioBLL(usuario);

        if (Singletons.conectado.equals("si")) {

            if (Singletons.tipoUsuario.equals("Administrador")) {

                AltaCli.NoNombre.setVisible(false);
                AltaCli.NoApellidos.setVisible(false);
                AltaCli.NoDNI.setVisible(false);
                AltaCli.txtEdad.setEditable(false);
                AltaCli.NoTelefono.setVisible(false);
                AltaCli.NOFNAC.setVisible(false);
                AltaCli.NOFALTA.setVisible(false);
                AltaCli.NoEmail.setVisible(false);
                AltaCli.txtAntiguedad.setEditable(false);
            }
        }
    }

    public static void OcultarErroresRegistro() {

        if (Singletons.conectado.equals("no")) {
            AltaCli.NoNombre.setVisible(false);
            AltaCli.NoApellidos.setVisible(false);
            AltaCli.NoDNI.setVisible(false);
            AltaCli.txtEdad.setEditable(false);
            AltaCli.NoTelefono.setVisible(false);
            AltaCli.NOFNAC.setVisible(false);
            AltaCli.NOFALTA.setVisible(false);
            AltaCli.NoEmail.setVisible(false);
            AltaCli.txtAntiguedad.setEditable(false);
            AltaCli.btnVolver.setVisible(false);
            AltaCli.cmbTipo.setVisible(false);
            AltaCli.etiTipo.setVisible(false);
            AltaCli.labelFotoUsu.setVisible(false);
        }
    }

    public static void OcultarErroresModif() {

        LoginBLL _tipoUsuario = new LoginBLL();
        String usua = Singletons.log.txtUsuario.getText();
        Singletons.tipoUsuario = _tipoUsuario.TipoUsuarioBLL(usua);

        if (Singletons.tipoUsuario.equals("Administrador")) {
            ModificarCli.NoNombre.setVisible(false);
            ModificarCli.NoApellidos.setVisible(false);
            ModificarCli.NoTelefono.setVisible(false);
            ModificarCli.NOFNAC.setVisible(false);
            ModificarCli.NOFALTA.setVisible(false);
            ModificarCli.txtAntiguedad.setEditable(false);
            ModificarCli.NoUsuario.setVisible(false);
            ModificarCli.NoPassword.setVisible(false);
            ModificarCli.NoEmail.setVisible(false);
            ModificarCli.cmbTipoUser.setEnabled(true);
            ModificarCli.btnVolverPro.setVisible(false);
   
        } else if (Singletons.tipoUsuario.equals("Cliente")) {
            ModificarCli.NoNombre.setVisible(false);
            ModificarCli.NoApellidos.setVisible(false);
            ModificarCli.NoTelefono.setVisible(false);
            ModificarCli.NOFNAC.setVisible(false);
            ModificarCli.NOFALTA.setVisible(false);
            ModificarCli.txtAntiguedad.setEditable(false);
            ModificarCli.NoUsuario.setVisible(false);
            ModificarCli.NoPassword.setVisible(false);
            ModificarCli.NoEmail.setVisible(false);
            ModificarCli.cmbTipoUser.setVisible(false);
            ModificarCli.etiTipoUser.setVisible(false);
            ModificarCli.btnVolver.setVisible(false);
           
        }
    }

    public static void Modificar() {

        LoginBLL _tipoUsuario = new LoginBLL();
        String usua = Singletons.log.txtUsuario.getText();
        Singletons.tipoUsuario = _tipoUsuario.TipoUsuarioBLL(usua);

        if (Singletons.tipoUsuario.equals("Administrador")) {

            ModificarCli.txtNombre.setText((Singletons.e).getNombre());
            ModificarCli.txtApellidos.setText((Singletons.e).getApellidos());
            ModificarCli.txtTelefono.setText((Singletons.e).getTelefono());
            ModificarCli.txtAntiguedad.setText(Integer.toString((Singletons.e).getAntiguedad()));
            ModificarCli.txtEdad.setText(Integer.toString((Singletons.e).getEdad()));
            ((JTextFieldDateEditor) ModificarCli.dcFnac.getDateEditor()).setText((Singletons.e).getFechaNacimiento().toStringFecha());
            ((JTextFieldDateEditor) ModificarCli.dcFalta.getDateEditor()).setText((Singletons.e).getFechaAlta().toStringFecha());
            ModificarCli.txtUsuario.setText((Singletons.e).getUsuario());
            ModificarCli.txtPassword.setText("");
            ModificarCli.txtEmail.setText((Singletons.e).getEmail());
            FileUploader.leer_imag(3);
            
        } else if (Singletons.tipoUsuario.equals("Cliente")) {

            Clientes empf = DAOGrafico.ObtenerClienteLogeado();
            ModificarCli.txtNombre.setText(empf.getNombre());
            ModificarCli.txtApellidos.setText(empf.getApellidos());
            ModificarCli.txtTelefono.setText(empf.getTelefono());
            ModificarCli.txtAntiguedad.setText(Integer.toString(empf.getAntiguedad()));
            ModificarCli.txtEdad.setText(Integer.toString(empf.getEdad()));
            ((JTextFieldDateEditor) ModificarCli.dcFnac.getDateEditor()).setText(empf.getFechaNacimiento().toStringFecha());
            ((JTextFieldDateEditor) ModificarCli.dcFalta.getDateEditor()).setText(empf.getFechaAlta().toStringFecha());
            ModificarCli.txtUsuario.setText(empf.getUsuario());
            ModificarCli.txtPassword.setText("");
            ModificarCli.txtEmail.setText(empf.getEmail());
            FileUploader.leer_imag(4);
        }
    }

    public static Clientes ObtenerClienteLogeado() {
        Clientes clie = pidednivaciopers(Login.txtUsuario.getText());
        Singletons.pos = BLLGrafico.buscar(clie);
        clie = Singletons.efi.get(Singletons.pos);

        return clie;
    }
   
    public static Clientes pidednivaciopers(String dnimatch) {
        Clientes empf = null;
        String dni;

        do {
            dni = dnimatch;
        } while (Validate.validaDNI(dni) == false);

        empf = new Clientes(dni) {};

        return empf;
    } 
}
