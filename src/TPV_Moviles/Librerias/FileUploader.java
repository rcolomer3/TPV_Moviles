/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPV_Moviles.Librerias;

import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.Clientes;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.Singletons;
import static TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.Singletons.ModificarEF;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.DAO.DAOGrafico;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.AltaEF;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.interfaz_Clientes;
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

    public static void guardar_img() {
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
                ImageIcon icon = new ImageIcon(Singletons.ruta);
                Image img = icon.getImage();
                Image newimg = img.getScaledInstance(49, 40, java.awt.Image.SCALE_SMOOTH);
                ImageIcon newIcon = new ImageIcon(newimg);
                Singletons.PagerEF.labelAvatar.setIcon(newIcon); //pintamos la imagen en jlabel1

                ImageIcon icon1 = new ImageIcon(Singletons.ruta);
                Image img1 = icon1.getImage();
                Image newimg1 = img1.getScaledInstance(101, 114, java.awt.Image.SCALE_SMOOTH);
                ImageIcon newIcon1 = new ImageIcon(newimg1);
                Singletons.ModificarEF.labelAvatar.setIcon(newIcon1); //pintamos la imagen en jlabel1
                
            }
            try {
                //guardamos la imagen
                image = ImageIO.read(fileChooser.getSelectedFile().toURL());
                extension = fileChooser.getSelectedFile().toURL().toString().substring(
                        fileChooser.getSelectedFile().toURL().toString().length() - 3);
                String cad = Funciones.getCadenaAleatoria(10);

                Singletons.PATH_auto = new java.io.File("") + "src/TPV/Img/" + cad + "." + extension;
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
                ModificarEF.labelFotoUsuario.setIcon(newIcon);
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
                AltaEF.labelFotoUsu.setIcon(newIcon);
            }

            if (i == 3) {
                //pintamos la imagen en el Jlabel
                ImageIcon icon = new ImageIcon(Singletons.e.getAvatar());
                //Se extrae la imagen del icono
                Image img = icon.getImage();
                //Se modifica su tamaño
                Image newimg = img.getScaledInstance(101, 114, java.awt.Image.SCALE_SMOOTH);
                //SE GENERA EL IMAGE ICON CON LA NUEVA IMAGEN
                ImageIcon newIcon = new ImageIcon(newimg);
                ModificarEF.labelAvatar.setIcon(newIcon);
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
                ModificarEF.labelAvatar.setIcon(newIcon);
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error eee imagen", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
