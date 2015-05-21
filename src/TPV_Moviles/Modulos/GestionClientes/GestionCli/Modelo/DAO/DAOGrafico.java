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
import static TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.Singletons.ModificarEF;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.AltaEF;
import TPV_Moviles.Modulos.Login.BLL.LoginBLL;
import TPV_Moviles.Modulos.Login.Vista.Login;
import com.toedter.calendar.JTextFieldDateEditor;
import javax.swing.JOptionPane;

/**
 *
 * @author Raul
 */
public class DAOGrafico {

    public static void crearEF() {
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
        tipo = AltaEF.cmbTipo.getSelectedItem().toString();
        avatar = Singletons.ruta;
        saldo = 500.00f;
        
        if ((AltaEF.NoNombre.isVisible() == false) && (AltaEF.NoApellidos.isVisible() == false) && (AltaEF.NoDNI.isVisible() == false) && (AltaEF.NoTelefono.isVisible() == false) && (AltaEF.NOFNAC.isVisible() == false) && (AltaEF.NOFALTA.isVisible() == false)
                && (AltaEF.NoEmail.isVisible() == false)) {
            Singletons.e = new Clientes(nombre, apellidos, dni, telefono, fechaNacimiento, fechaAlta, usuario, passwordEn, email, estado, tipo, avatar, saldo);

            //creamos el objeto Mail
            JavaMail mail = new JavaMail(email, password, subject, mensaje);
            //enviamos el mensaje
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

        nomb = AltaEF.txtNombre.getText();
        if (nomb.isEmpty()) {
            AltaEF.NoNombre.setVisible(true);
            AltaEF.txtNombre.requestFocus();
        } else {
            nomb = AltaEF.txtNombre.getText();
            validar = Validate.validaNombre(nomb);
            if (validar == false) {
                AltaEF.txtNombre.requestFocus();
                AltaEF.NoNombre.setVisible(true);
            } else {
                AltaEF.NoNombre.setVisible(false);
            }
        }
        return nomb;
    }

    public static String pideNombreKey() {
        String nomb = "";
        boolean validar;

        nomb = AltaEF.txtNombre.getText();
        if (nomb.isEmpty()) {
            AltaEF.NoNombre.setVisible(true);
            AltaEF.txtNombre.requestFocus();
        } else {
            nomb = AltaEF.txtNombre.getText();
            validar = Validate.validaNombre(nomb);
            if (validar == false) {
                AltaEF.txtNombre.requestFocus();
                AltaEF.NoNombre.setVisible(true);
            } else {
                AltaEF.NoNombre.setVisible(false);
            }
        }
        return nomb;
    }

    public static String pideNombreKeyPressed() {
        String nomb = "";
        boolean validar;

        nomb = AltaEF.txtNombre.getText();
        if (nomb.isEmpty()) {
            AltaEF.NoNombre.setVisible(true);
            AltaEF.txtNombre.requestFocus();
        } else {
            nomb = AltaEF.txtNombre.getText();
            validar = Validate.validaNombre(nomb);
            if (validar == false) {
                AltaEF.txtNombre.requestFocus();
                AltaEF.NoNombre.setVisible(true);
            } else {
                AltaEF.NoNombre.setVisible(false);
            }
        }
        return nomb;
    }

    public static String ModiPideNombre() {
        String nomb = "";
        boolean validar;

        nomb = ModificarEF.txtNombre.getText();
        if (nomb.isEmpty()) {
            ModificarEF.NoNombre.setVisible(true);
            ModificarEF.txtNombre.requestFocus();
        } else {
            nomb = ModificarEF.txtNombre.getText();
            validar = Validate.validaNombre(nomb);
            if (validar == false) {
                ModificarEF.txtNombre.requestFocus();
                ModificarEF.NoNombre.setVisible(true);
            } else {
                ModificarEF.NoNombre.setVisible(false);
            }
        }
        return nomb;
    }

    public static String ModiPideNombreKey() {
        String nomb = "";
        boolean validar;

        nomb = ModificarEF.txtNombre.getText();
        if (nomb.isEmpty()) {
            ModificarEF.NoNombre.setVisible(true);
            ModificarEF.txtNombre.requestFocus();
        } else {
            nomb = ModificarEF.txtNombre.getText();
            validar = Validate.validaNombre(nomb);
            if (validar == false) {
                ModificarEF.txtNombre.requestFocus();
                ModificarEF.NoNombre.setVisible(true);
            } else {
                ModificarEF.NoNombre.setVisible(false);
            }
        }
        return nomb;
    }

    public static String ModiPideNombreKeyPressed() {
        String nomb = "";
        boolean validar;

        nomb = ModificarEF.txtNombre.getText();
        if (nomb.isEmpty()) {
            ModificarEF.NoNombre.setVisible(true);
            ModificarEF.txtNombre.requestFocus();
        } else {
            nomb = ModificarEF.txtNombre.getText();
            validar = Validate.validaNombre(nomb);
            if (validar == false) {
                ModificarEF.txtNombre.requestFocus();
                ModificarEF.NoNombre.setVisible(true);
            } else {
                ModificarEF.NoNombre.setVisible(false);
            }
        }
        return nomb;
    }

    public static String pideApellidos() {
        String apel = "";
        boolean validar;

        apel = AltaEF.txtApellidos.getText();
        if (apel.isEmpty()) {
            AltaEF.NoApellidos.setVisible(true);
            AltaEF.txtApellidos.requestFocus();
        } else {
            apel = AltaEF.txtApellidos.getText();
            validar = Validate.validaNombre(apel);
            if (validar == false) {
                AltaEF.txtApellidos.requestFocus();
                AltaEF.NoApellidos.setVisible(true);
            } else {
                AltaEF.NoApellidos.setVisible(false);
            }
        }
        return apel;
    }

    public static String pideApellidosKey() {
        String apel = "";
        boolean validar;

        apel = AltaEF.txtApellidos.getText();
        if (apel.isEmpty()) {
            AltaEF.NoApellidos.setVisible(true);
            AltaEF.txtApellidos.requestFocus();
        } else {
            apel = AltaEF.txtApellidos.getText();
            validar = Validate.validaNombre(apel);
            if (validar == false) {
                AltaEF.txtApellidos.requestFocus();
                AltaEF.NoApellidos.setVisible(true);
            } else {
                AltaEF.NoApellidos.setVisible(false);
            }
        }
        return apel;
    }

    public static String pideApellidosKeyPressed() {
        String apel = "";
        boolean validar;

        apel = AltaEF.txtApellidos.getText();
        if (apel.isEmpty()) {
            AltaEF.NoApellidos.setVisible(true);
            AltaEF.txtApellidos.requestFocus();
        } else {
            apel = AltaEF.txtApellidos.getText();
            validar = Validate.validaNombre(apel);
            if (validar == false) {
                AltaEF.txtApellidos.requestFocus();
                AltaEF.NoApellidos.setVisible(true);
            } else {
                AltaEF.NoApellidos.setVisible(false);
            }
        }
        return apel;
    }

    public static String ModPideApellidos() {
        String apel = "";
        boolean validar;

        apel = ModificarEF.txtApellidos.getText();
        if (apel.isEmpty()) {
            ModificarEF.NoApellidos.setVisible(true);
            ModificarEF.txtApellidos.requestFocus();
        } else {
            apel = ModificarEF.txtApellidos.getText();
            validar = Validate.validaNombre(apel);
            if (validar == false) {
                ModificarEF.txtApellidos.requestFocus();
                ModificarEF.NoApellidos.setVisible(true);
            } else {
                ModificarEF.NoApellidos.setVisible(false);
            }
        }
        return apel;
    }

    public static String ModipideApellidosKey() {
        String apel = "";
        boolean validar;

        apel = ModificarEF.txtApellidos.getText();
        if (apel.isEmpty()) {
            ModificarEF.NoApellidos.setVisible(true);
            ModificarEF.txtApellidos.requestFocus();
        } else {
            apel = ModificarEF.txtApellidos.getText();
            validar = Validate.validaNombre(apel);
            if (validar == false) {
                ModificarEF.txtApellidos.requestFocus();
                ModificarEF.NoApellidos.setVisible(true);
            } else {
                ModificarEF.NoApellidos.setVisible(false);
            }
        }
        return apel;
    }

    public static String ModipideApellidosKeyPressed() {
        String apel = "";
        boolean validar;

        apel = ModificarEF.txtApellidos.getText();
        if (apel.isEmpty()) {
            ModificarEF.NoApellidos.setVisible(true);
            ModificarEF.txtApellidos.requestFocus();
        } else {
            apel = ModificarEF.txtApellidos.getText();
            validar = Validate.validaNombre(apel);
            if (validar == false) {
                ModificarEF.txtApellidos.requestFocus();
                ModificarEF.NoApellidos.setVisible(true);
            } else {
                ModificarEF.NoApellidos.setVisible(false);
            }
        }
        return apel;
    }

    public static String pideDNI() {
        String dni = "";
        boolean validar;

        dni = AltaEF.txtDNI.getText();
        if (dni.isEmpty()) {
            AltaEF.txtDNI.requestFocus();
            AltaEF.NoDNI.setVisible(true);
        } else {
            dni = AltaEF.txtDNI.getText();
            validar = Validate.validaDNI(dni);
            if (validar == false) {
                AltaEF.txtDNI.requestFocus();
                AltaEF.NoDNI.setVisible(true);
            } else {
                AltaEF.NoDNI.setVisible(false);
            }
        }
        return dni;
    }

    public static String pideDNIkey() {
        String dni = "";
        boolean validar;

        dni = AltaEF.txtDNI.getText();
        if (dni.isEmpty()) {
            AltaEF.txtDNI.requestFocus();
            AltaEF.NoDNI.setVisible(true);
        } else {
            dni = AltaEF.txtDNI.getText();
            validar = Validate.validaDNI(dni);
            if (validar == false) {
                AltaEF.txtDNI.requestFocus();
                AltaEF.NoDNI.setVisible(true);
            } else {
                AltaEF.NoDNI.setVisible(false);
            }
        }
        return dni;
    }

    public static String pideDNIKeyPressed() {
        String dni = "";
        boolean validar;

        dni = AltaEF.txtDNI.getText();
        if (dni.isEmpty()) {
            AltaEF.txtDNI.requestFocus();
            AltaEF.NoDNI.setVisible(true);
        } else {
            dni = AltaEF.txtDNI.getText();
            validar = Validate.validaDNI(dni);
            if (validar == false) {
                AltaEF.txtDNI.requestFocus();
                AltaEF.NoDNI.setVisible(true);
            } else {
                AltaEF.NoDNI.setVisible(false);
            }
        }
        return dni;
    }

    public static String pideTelefono() {
        String telef = "";
        boolean validar;

        telef = AltaEF.txtTelefono.getText();
        if (telef.isEmpty()) {
            AltaEF.txtTelefono.requestFocus();
            AltaEF.NoTelefono.setVisible(true);
        } else {
            telef = AltaEF.txtTelefono.getText();
            validar = Validate.validaTelefono(telef);
            if (validar == false) {
                AltaEF.txtTelefono.requestFocus();
                AltaEF.NoTelefono.setVisible(true);
            } else {
                AltaEF.NoTelefono.setVisible(false);
            }
        }
        return telef;
    }

    public static String ModPideTelefono() {
        String telef = "";
        boolean validar;

        telef = ModificarEF.txtTelefono.getText();
        if (telef.isEmpty()) {
            ModificarEF.txtTelefono.requestFocus();
            ModificarEF.NoTelefono.setVisible(true);
        } else {
            telef = ModificarEF.txtTelefono.getText();
            validar = Validate.validaTelefono(telef);
            if (validar == false) {
                ModificarEF.txtTelefono.requestFocus();
                ModificarEF.NoTelefono.setVisible(true);
            } else {
                ModificarEF.NoTelefono.setVisible(false);
            }
        }
        return telef;
    }

    public static Fecha pideFechaNac() {
        String fecha = "";
        Fecha fechaNacimiento = null;
        int edad = 0;

        if (AltaEF.dcfnac.getDate() == null) {
            AltaEF.NOFNAC.setVisible(true);
        } else {
            fecha = ((JTextFieldDateEditor) AltaEF.dcfnac.getDateEditor()).getText();
            fechaNacimiento = DAOCliente.introFecha(fecha);
            edad = fechaNacimiento.restaFechas();
            if (edad < 16) {
                AltaEF.NOFNAC.setVisible(true);
            } else {
                AltaEF.txtEdad.setText(Integer.toString(edad));
                AltaEF.NOFNAC.setVisible(false);
            }
        }
        return fechaNacimiento;
    }

    public static Fecha ModipideFechaNac() {
        String fecha = "";
        Fecha fechaNacimiento = null;
        int edad = 0;

        if (ModificarEF.dcFnac.getDate() == null) {
            ModificarEF.NOFNAC.setVisible(true);
        } else {
            fecha = ((JTextFieldDateEditor) ModificarEF.dcFnac.getDateEditor()).getText();
            fechaNacimiento = DAOCliente.introFecha(fecha);
            edad = fechaNacimiento.restaFechas();
            if (edad < 16) {
                ModificarEF.NOFNAC.setVisible(true);
            } else {
                ModificarEF.txtEdad.setText(Integer.toString(edad));
                ModificarEF.NOFNAC.setVisible(false);
            }
        }
        return fechaNacimiento;
    }

    public static Fecha pideFechaAlta() {
        String fecha1 = "";
        Fecha fechaAlta = null;
        int antiguedad = 0, edad = 0;

        if (AltaEF.dcFAlta.getDate() == null) {
            AltaEF.NOFALTA.setVisible(true);
        } else {
            fecha1 = ((JTextFieldDateEditor) AltaEF.dcFAlta.getDateEditor()).getText();
            fechaAlta = DAOCliente.introFecha(fecha1);
            if (AltaEF.dcFAlta.getCalendar().before(AltaEF.dcfnac.getCalendar())) {
                JOptionPane.showMessageDialog(null, "La fecha de contratación no puede ser anterior a la de nacimiento");
            } else {
                antiguedad = fechaAlta.restaFechas();
                edad = Integer.parseInt(AltaEF.txtEdad.getText());
                if ((edad - antiguedad) < 16) {
                    AltaEF.txtEdad.setText("");
                    AltaEF.txtAntiguedad.setText("");
                    AltaEF.NOFALTA.setVisible(true);
                } else {
                    AltaEF.txtAntiguedad.setText(Integer.toString(antiguedad));
                    AltaEF.NOFALTA.setVisible(false);
                }
            }
        }
        return fechaAlta;
    }

    public static Fecha ModipideFechaAlta() {
        String fecha1 = "";
        Fecha fechaAlta = null;
        int antiguedad = 0, edad = 0;

        if (ModificarEF.dcFalta.getDate() == null) {
            ModificarEF.NOFALTA.setVisible(true);
        } else {
            fecha1 = ((JTextFieldDateEditor) ModificarEF.dcFalta.getDateEditor()).getText();
            fechaAlta = DAOCliente.introFecha(fecha1);
            if (ModificarEF.dcFalta.getCalendar().before(ModificarEF.dcFnac.getCalendar())) {
                JOptionPane.showMessageDialog(null, "La fecha de contratación no puede ser anterior a la de nacimiento");
            } else {
                antiguedad = fechaAlta.restaFechas();
                edad = Integer.parseInt(ModificarEF.txtEdad.getText());
                if ((edad - antiguedad) < 16) {
                    ModificarEF.txtEdad.setText("");
                    ModificarEF.txtAntiguedad.setText("");
                    ModificarEF.NOFALTA.setVisible(true);
                } else {
                    ModificarEF.txtAntiguedad.setText(Integer.toString(antiguedad));
                    ModificarEF.NOFALTA.setVisible(false);
                }
            }
        }
        return fechaAlta;
    }

    public static String pideEmail() {
        String email = "";
        boolean validar;

        email = AltaEF.txtEmail.getText();
        if (email.isEmpty()) {
            AltaEF.txtEmail.requestFocus();
            AltaEF.NoEmail.setVisible(true);
        } else {
            email = AltaEF.txtEmail.getText();
            validar = Validate.validaEmail(email);
            if (validar == false) {
                AltaEF.txtEmail.requestFocus();
                AltaEF.NoEmail.setVisible(true);
            } else {
                AltaEF.NoEmail.setVisible(false);
            }
        }
        return email;
    }

    public static String pideEmailKey() {
        String email = "";
        boolean validar;

        email = AltaEF.txtEmail.getText();
        if (email.isEmpty()) {
            AltaEF.txtEmail.requestFocus();
            AltaEF.NoEmail.setVisible(true);
        } else {
            email = AltaEF.txtEmail.getText();
            validar = Validate.validaEmail(email);
            if (validar == false) {
                AltaEF.txtEmail.requestFocus();
                AltaEF.NoEmail.setVisible(true);
            } else {
                AltaEF.NoEmail.setVisible(false);
            }
        }
        return email;
    }

    public static String pideEmailKeyPressed() {
        String email = "";
        boolean validar;

        email = AltaEF.txtEmail.getText();
        if (email.isEmpty()) {
            AltaEF.txtEmail.requestFocus();
            AltaEF.NoEmail.setVisible(true);
        } else {
            email = AltaEF.txtEmail.getText();
            validar = Validate.validaEmail(email);
            if (validar == false) {
                AltaEF.txtEmail.requestFocus();
                AltaEF.NoEmail.setVisible(true);
            } else {
                AltaEF.NoEmail.setVisible(false);
            }
        }
        return email;
    }

    public static String ModPideEmail() {
        String email = "";
        boolean validar;

        email = ModificarEF.txtEmail.getText();
        if (email.isEmpty()) {
            ModificarEF.txtEmail.requestFocus();
            ModificarEF.NoEmail.setVisible(true);
        } else {
            email = ModificarEF.txtEmail.getText();
            validar = Validate.validaEmail(email);
            if (validar == false) {
                ModificarEF.txtEmail.requestFocus();
                ModificarEF.NoEmail.setVisible(true);
            } else {
                ModificarEF.NoEmail.setVisible(false);
            }
        }
        return email;
    }

    public static String ModPideEmailKey() {
        String email = "";
        boolean validar;

        email = ModificarEF.txtEmail.getText();
        if (email.isEmpty()) {
            ModificarEF.txtEmail.requestFocus();
            ModificarEF.NoEmail.setVisible(true);
        } else {
            email = ModificarEF.txtEmail.getText();
            validar = Validate.validaEmail(email);
            if (validar == false) {
                ModificarEF.txtEmail.requestFocus();
                ModificarEF.NoEmail.setVisible(true);
            } else {
                ModificarEF.NoEmail.setVisible(false);
            }
        }
        return email;
    }

    public static String ModPideEmailKeyPressed() {
        String email = "";
        boolean validar;

        email = ModificarEF.txtEmail.getText();
        if (email.isEmpty()) {
            ModificarEF.txtEmail.requestFocus();
            ModificarEF.NoEmail.setVisible(true);
        } else {
            email = ModificarEF.txtEmail.getText();
            validar = Validate.validaEmail(email);
            if (validar == false) {
                ModificarEF.txtEmail.requestFocus();
                ModificarEF.NoEmail.setVisible(true);
            } else {
                ModificarEF.NoEmail.setVisible(false);
            }
        }
        return email;
    }

    public static String ModpideUsuario() {
        String usuario = "";

        usuario = ModificarEF.txtUsuario.getText();
        if (usuario.isEmpty()) {
            ModificarEF.txtUsuario.requestFocus();
            ModificarEF.NoUsuario.setVisible(true);
        } else {
            usuario = ModificarEF.txtUsuario.getText();
            ModificarEF.NoUsuario.setVisible(false);
        }
        return usuario;
    }

    public static String ModpidePassword() {
        String password = "";

        password = ModificarEF.txtPassword.getText();

        if (password.isEmpty()) {
            ModificarEF.txtPassword.requestFocus();
            ModificarEF.NoPassword.setVisible(true);
        } else {
            password = Encrypt.encriptarTokenMD5(password);
            ModificarEF.NoPassword.setVisible(false);
        }
        return password;
    }
    
    public static void LimpiarCreaCliente() {
        AltaEF.txtNombre.setText("");
        AltaEF.txtApellidos.setText("");
        AltaEF.txtDNI.setText("");
        AltaEF.txtTelefono.setText("");
        AltaEF.txtEdad.setText("");
        AltaEF.txtAntiguedad.setText("");
        AltaEF.dcfnac.setDate(null);
        AltaEF.dcFAlta.setDate(null);
        AltaEF.txtEmail.setText("");
    }

    public static void LimpiarModificarCliente() {
        ModificarEF.txtNombre.setText("");
        ModificarEF.txtApellidos.setText("");
        ModificarEF.txtTelefono.setText("");
        ModificarEF.txtUsuario.setText("");
        ModificarEF.txtAntiguedad.setText("");
        ModificarEF.dcFnac.setDate(null);
        ModificarEF.dcFalta.setDate(null);
        ModificarEF.txtPassword.setText("");
        ModificarEF.txtEmail.setText("");
        ModificarEF.txtEdad.setText("");
        ModificarEF.txtSaldo.setText("");
    }

    public static void OcultarErrores() {

        LoginBLL _tipoUsu = new LoginBLL();
        String usuario = Singletons.log.txtUsuario.getText();
        Singletons.tipoUsuario = _tipoUsu.TipoUsuarioBLL(usuario);

        if (Singletons.conectado.equals("si")) {

            if (Singletons.tipoUsuario.equals("Administrador")) {

                AltaEF.NoNombre.setVisible(false);
                AltaEF.NoApellidos.setVisible(false);
                AltaEF.NoDNI.setVisible(false);
                AltaEF.txtEdad.setEditable(false);
                AltaEF.NoTelefono.setVisible(false);
                AltaEF.NOFNAC.setVisible(false);
                AltaEF.NOFALTA.setVisible(false);
                AltaEF.NoEmail.setVisible(false);
                AltaEF.txtAntiguedad.setEditable(false);
            }
        }
    }

    public static void OcultarErroresRegistro() {

        if (Singletons.conectado.equals("no")) {
            AltaEF.NoNombre.setVisible(false);
            AltaEF.NoApellidos.setVisible(false);
            AltaEF.NoDNI.setVisible(false);
            AltaEF.txtEdad.setEditable(false);
            AltaEF.NoTelefono.setVisible(false);
            AltaEF.NOFNAC.setVisible(false);
            AltaEF.NOFALTA.setVisible(false);
            AltaEF.NoEmail.setVisible(false);
            AltaEF.txtAntiguedad.setEditable(false);
            AltaEF.btnVolver.setVisible(false);
            AltaEF.cmbTipo.setVisible(false);
            AltaEF.etiTipo.setVisible(false);
            AltaEF.labelFotoUsu.setVisible(false);
        }
    }

    public static void OcultarErroresModif() {

        LoginBLL _tipoUsuario = new LoginBLL();
        String usua = Singletons.log.txtUsuario.getText();
        Singletons.tipoUsuario = _tipoUsuario.TipoUsuarioBLL(usua);

        if (Singletons.tipoUsuario.equals("Administrador")) {
            ModificarEF.NoNombre.setVisible(false);
            ModificarEF.NoApellidos.setVisible(false);
            ModificarEF.NoTelefono.setVisible(false);
            ModificarEF.NOFNAC.setVisible(false);
            ModificarEF.NOFALTA.setVisible(false);
            ModificarEF.txtAntiguedad.setEditable(false);
            ModificarEF.NoUsuario.setVisible(false);
            ModificarEF.NoPassword.setVisible(false);
            ModificarEF.NoEmail.setVisible(false);
            ModificarEF.cmbTipoUser.setEnabled(true);
            ModificarEF.NoSaldo.setVisible(false);
        } else if (Singletons.tipoUsuario.equals("user")) {
            ModificarEF.NoNombre.setVisible(false);
            ModificarEF.NoApellidos.setVisible(false);
            ModificarEF.NoTelefono.setVisible(false);
            ModificarEF.NOFNAC.setVisible(false);
            ModificarEF.NOFALTA.setVisible(false);
            ModificarEF.txtAntiguedad.setEditable(false);
            ModificarEF.NoUsuario.setVisible(false);
            ModificarEF.NoPassword.setVisible(false);
            ModificarEF.NoEmail.setVisible(false);
            ModificarEF.cmbTipoUser.setVisible(false);
            ModificarEF.etiTipoUser.setVisible(false);
            ModificarEF.NoSaldo.setVisible(false);
        }
    }

    public static void Modificar() {

        LoginBLL _tipoUsuario = new LoginBLL();
        String usua = Singletons.log.txtUsuario.getText();
        Singletons.tipoUsuario = _tipoUsuario.TipoUsuarioBLL(usua);

        if (Singletons.tipoUsuario.equals("Administrador")) {

            ModificarEF.txtNombre.setText((Singletons.e).getNombre());
            ModificarEF.txtApellidos.setText((Singletons.e).getApellidos());
            ModificarEF.txtTelefono.setText((Singletons.e).getTelefono());
            ModificarEF.txtAntiguedad.setText(Integer.toString((Singletons.e).getAntiguedad()));
            ModificarEF.txtEdad.setText(Integer.toString((Singletons.e).getEdad()));
            ((JTextFieldDateEditor) ModificarEF.dcFnac.getDateEditor()).setText((Singletons.e).getFechaNacimiento().toStringFecha());
            ((JTextFieldDateEditor) ModificarEF.dcFalta.getDateEditor()).setText((Singletons.e).getFechaAlta().toStringFecha());
            ModificarEF.txtUsuario.setText((Singletons.e).getUsuario());
            ModificarEF.txtPassword.setText("");
            ModificarEF.txtEmail.setText((Singletons.e).getEmail());
            ModificarEF.txtSaldo.setText(Float.toString((Singletons.e).getSaldo()));
            FileUploader.leer_imag(3);
            
        } else if (Singletons.tipoUsuario.equals("user")) {

            Clientes empf = DAOGrafico.ObtenerClienteLogeado();
            ModificarEF.txtNombre.setText(empf.getNombre());
            ModificarEF.txtApellidos.setText(empf.getApellidos());
            ModificarEF.txtTelefono.setText(empf.getTelefono());
            ModificarEF.txtAntiguedad.setText(Integer.toString(empf.getAntiguedad()));
            ModificarEF.txtEdad.setText(Integer.toString(empf.getEdad()));
            ((JTextFieldDateEditor) ModificarEF.dcFnac.getDateEditor()).setText(empf.getFechaNacimiento().toStringFecha());
            ((JTextFieldDateEditor) ModificarEF.dcFalta.getDateEditor()).setText(empf.getFechaAlta().toStringFecha());
            ModificarEF.txtUsuario.setText(empf.getUsuario());
            ModificarEF.txtPassword.setText("");
            ModificarEF.txtEmail.setText(empf.getEmail());
            ModificarEF.txtSaldo.setText(Float.toString((Singletons.e).getSaldo()));
            FileUploader.leer_imag(4);
        }
    }

    public static Clientes ObtenerClienteLogeado() {
        Clientes empf = pidednivaciopers(Login.txtUsuario.getText());
        Singletons.pos = BLLGrafico.buscar(empf);
        empf = Singletons.efi.get(Singletons.pos);

        return empf;
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
