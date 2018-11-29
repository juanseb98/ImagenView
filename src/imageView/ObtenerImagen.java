/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageView;

import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author sastian
 */
public class ObtenerImagen implements Runnable {

    public static String urlImagen;
    private static URL url;
    private static Image imagen;
    private ImageView imageView;

    public ObtenerImagen(ImageView thisImage) {
        imageView = thisImage;
    }

    @Override
    public void run() {
        try {

            url = new URL(imageView.getUrlImagen());
            imagen = ImageIO.read(url);
            imageView.setIcon(imagen);

        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "Url no valida", "Error con la URL", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "La url no contiene ninguna imagen", "Error con la URL", JOptionPane.ERROR_MESSAGE);
        }
    }

}
