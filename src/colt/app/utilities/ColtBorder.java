/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colt.app.utilities;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

/**
 *
 * @author user
 */
public class ColtBorder implements Border {

    public BufferedImage back;
    
    public ColtBorder(String resource) {
        
         try {
            URL imagePath = new URL(getClass().getResource(resource).toString());
            back = ImageIO.read(imagePath);
        } catch (Exception ex) {            
        }
        
    }

    public ColtBorder() {
        
         try {
            URL imagePath = new URL(getClass().getResource("/img/colt-screen-welcome.jpg").toString());
            back = ImageIO.read(imagePath);
        } catch (Exception ex) {            
        }
        
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawImage(back, (x + (width - back.getWidth()) / 2), (y + (height - back.getHeight()) / 2), null);
    }

    @Override
    public Insets getBorderInsets(Component c) {
          return new Insets(0,0,0,0);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }
}