/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPV_Moviles.Librerias;

import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.Clientes;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.Singletons;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.DAO.DAOGrafico;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.AltaCli;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.ModificarCli;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.interfaz_Clientes;
import TPV_Moviles.Modulos.GestionProductos.Modelo.Clases.SingletonsPro;
import static TPV_Moviles.Modulos.GestionProductos.Modelo.Clases.SingletonsPro.ModificarPro;
import TPV_Moviles.Modulos.GestionProductos.Vista.RegistroPro;
import TPV_Moviles.Modulos.GestionProductos.Vista.Ventana_Prod;
import TPV_Moviles.Modulos.Inicio.Vista.Ventana_Inicio;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Raul
 */
public class FileUploader {

    public static void lista_blanca(JFileChooser buscador) {
        buscador.setAcceptAllFileFilterUsed(false);
        buscador.addChoosableFileFilter(new FileNameExtensionFilter("Imágenes (*.jpg, *.gif, *.png)", "jpg", "jpeg", "gif", "png"));
    }

    public static void guardar_img(int i) {
        File imagen;
        BufferedImage image;
        String extension = "";
        JFileChooser fileChooser = new JFileChooser();

        lista_blanca(fileChooser);
        fileChooser.setCurrentDirectory(null);
        fileChooser.setSelectedFile(null);

        int seleccion = fileChooser.showOpenDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            imagen = fileChooser.getSelectedFile();

            Singletons.ruta = imagen.getAbsolutePath();
            if (Singletons.ruta.length() > 500) {
                JOptionPane.showMessageDialog(null, "La ruta de la imagen debe "
                        + "tener como máximo 500 caracteres", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (i == 0) {
                    ImageIcon icon = new ImageIcon(Singletons.ruta);
                    Image img = icon.getImage();
                    Image newimg = img.getScaledInstance(49, 40, java.awt.Image.SCALE_SMOOTH);
                    ImageIcon newIcon = new ImageIcon(newimg);
                    Singletons.PagerCli.labelAvatar.setIcon(newIcon); //pintamos la imagen en jlabel1
                } else if (i == 1) {
                    ImageIcon icon1 = new ImageIcon(Singletons.ruta);
                    Image img1 = icon1.getImage();
                    Image newimg1 = img1.getScaledInstance(101, 114, java.awt.Image.SCALE_SMOOTH);
                    ImageIcon newIcon1 = new ImageIcon(newimg1);
                    Singletons.ModificarCli.labelAvatar.setIcon(newIcon1); //pintamos la imagen en jlabel1
                } else if (i == 2) {
                    ImageIcon icon2 = new ImageIcon(Singletons.ruta);
                    Image img2 = icon2.getImage();
                    Image newimg2 = img2.getScaledInstance(100, 90, java.awt.Image.SCALE_SMOOTH);
                    ImageIcon newIcon2 = new ImageIcon(newimg2);
                    SingletonsPro.ModificarPro.fotoPro_M.setIcon(newIcon2); //pintamos la imagen en jlabel1
                } 
            }
            try {
                //guardamos la imagen
                image = ImageIO.read(fileChooser.getSelectedFile().toURL());
                extension = fileChooser.getSelectedFile().toURL().toString().substring(
                        fileChooser.getSelectedFile().toURL().toString().length() - 3);
                String cad = Funciones.getCadenaAleatoria(10);

                Singletons.PATH_auto = new java.io.File("") + "src/TPV_Moviles/Img/" + cad + "." + extension;
                File f = new File(Singletons.PATH_auto);

                ImageIO.write(image, extension, f);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error upload imagen", "Error al cargar imagen", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void leer_imag(int i) {

        try {
            Clientes empf = DAOGrafico.ObtenerClienteLogeado();
            if (i == 0) {
                //pintamos la imagen en el Jlabel
                ImageIcon icon = new ImageIcon(empf.getAvatar());
                //Se extrae la imagen del icono
                Image img = icon.getImage();
                //Se modifica su tamaño
                Image newimg = img.getScaledInstance(49, 40, java.awt.Image.SCALE_SMOOTH);
                //SE GENERA EL IMAGE ICON CON LA NUEVA IMAGEN
                ImageIcon newIcon = new ImageIcon(newimg);
                interfaz_Clientes.labelAvatar.setIcon(newIcon);
            }

            if (i == 1) {
                //pintamos la imagen en el Jlabel
                ImageIcon icon = new ImageIcon(empf.getAvatar());
                //Se extrae la imagen del icono
                Image img = icon.getImage();
                //Se modifica su tamaño
                Image newimg = img.getScaledInstance(49, 40, java.awt.Image.SCALE_SMOOTH);
                //SE GENERA EL IMAGE ICON CON LA NUEVA IMAGEN
                ImageIcon newIcon = new ImageIcon(newimg);
                ModificarCli.labelFotoUsuario.setIcon(newIcon);
            }

            if (i == 2) {
                //pintamos la imagen en el Jlabel
                ImageIcon icon = new ImageIcon(empf.getAvatar());
                //Se extrae la imagen del icono
                Image img = icon.getImage();
                //Se modifica su tamaño
                Image newimg = img.getScaledInstance(49, 40, java.awt.Image.SCALE_SMOOTH);
                //SE GENERA EL IMAGE ICON CON LA NUEVA IMAGEN
                ImageIcon newIcon = new ImageIcon(newimg);
                AltaCli.labelFotoUsu.setIcon(newIcon);
            }

            if (i == 3) {
                //pintamos la imagen en el Jlabel
                ImageIcon icon = new ImageIcon(Singletons.e.getAvatar());
                //Se extrae la imagen del icono
                Image img = icon.getImage();
                //Se modifica su tamaño
                Image newimg = img.getScaledInstance(105, 114, java.awt.Image.SCALE_SMOOTH);
                //SE GENERA EL IMAGE ICON CON LA NUEVA IMAGEN
                ImageIcon newIcon = new ImageIcon(newimg);
                ModificarCli.labelAvatar.setIcon(newIcon);
            }

            if (i == 4) {
                //pintamos la imagen en el Jlabel
                ImageIcon icon = new ImageIcon(empf.getAvatar());
                //Se extrae la imagen del icono
                Image img = icon.getImage();
                //Se modifica su tamaño
                Image newimg = img.getScaledInstance(101, 114, java.awt.Image.SCALE_SMOOTH);
                //SE GENERA EL IMAGE ICON CON LA NUEVA IMAGEN
                ImageIcon newIcon = new ImageIcon(newimg);
                ModificarCli.labelAvatar.setIcon(newIcon);
            }
            
            if (i == 5) {
                //pintamos la imagen en el Jlabel
                ImageIcon icon = new ImageIcon(SingletonsPro.p.getAvatar());
                //Se extrae la imagen del icono
                Image img = icon.getImage();
                //Se modifica su tamaño
                Image newimg = img.getScaledInstance(101, 49, java.awt.Image.SCALE_SMOOTH);
                //SE GENERA EL IMAGE ICON CON LA NUEVA IMAGEN
                ImageIcon newIcon = new ImageIcon(newimg);
                ModificarPro.fotoPro_M.setIcon(newIcon);
            }
            
            if (i == 6) {
                //pintamos la imagen en el Jlabel
                ImageIcon icon = new ImageIcon(empf.getAvatar());
                //Se extrae la imagen del icono
                Image img = icon.getImage();
                //Se modifica su tamaño
                Image newimg = img.getScaledInstance(49, 40, java.awt.Image.SCALE_SMOOTH);
                //SE GENERA EL IMAGE ICON CON LA NUEVA IMAGEN
                ImageIcon newIcon = new ImageIcon(newimg);
                RegistroPro.labelFotoUsu.setIcon(newIcon);
            }
            
            if (i == 7) {
                //pintamos la imagen en el Jlabel
                ImageIcon icon = new ImageIcon(empf.getAvatar());
                //Se extrae la imagen del icono
                Image img = icon.getImage();
                //Se modifica su tamaño
                Image newimg = img.getScaledInstance(49, 40, java.awt.Image.SCALE_SMOOTH);
                //SE GENERA EL IMAGE ICON CON LA NUEVA IMAGEN
                ImageIcon newIcon = new ImageIcon(newimg);
                ModificarPro.labelFotoUsu.setIcon(newIcon);
            }
            
            if (i == 8) {
                //pintamos la imagen en el Jlabel
                ImageIcon icon = new ImageIcon(empf.getAvatar());
                //Se extrae la imagen del icono
                Image img = icon.getImage();
                //Se modifica su tamaño
                Image newimg = img.getScaledInstance(50, 40, java.awt.Image.SCALE_SMOOTH);
                //SE GENERA EL IMAGE ICON CON LA NUEVA IMAGEN
                ImageIcon newIcon = new ImageIcon(newimg);
                Ventana_Prod.fotoUsu.setIcon(newIcon);
            }
            
            if (i == 9) {
                //pintamos la imagen en el Jlabel
                ImageIcon icon = new ImageIcon(empf.getAvatar());
                //Se extrae la imagen del icono
                Image img = icon.getImage();
                //Se modifica su tamaño
                Image newimg = img.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                //SE GENERA EL IMAGE ICON CON LA NUEVA IMAGEN
                ImageIcon newIcon = new ImageIcon(newimg);
                Ventana_Inicio.fotoppal.setIcon(newIcon);
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error imagen", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
