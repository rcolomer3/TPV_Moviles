/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPV_Moviles.Clases;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JPanel;

/**
 *
 * @author Raul
 */
public class JPanelConFondo extends JPanel
{
    URL imagen1 = JPanelConFondo.class.getResource("/src/TPV/Img/fondo4.jpg");
    Image imagen=Toolkit.getDefaultToolkit().getImage(imagen1);
    public void paint(Graphics g)
    {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
    }
    
}
