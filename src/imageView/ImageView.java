package imageView;

import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class ImageView extends JLabel {

    private static final int TAMANNO_DEFECTO = 100;

    private String urlImagen;
    private int Ancho, Alto;
    private URL url;
    private Image imagen;
    private Icon icono;
    private ObtenerImagen obtenerImagen;
    private Border borde;

    /**
     * Constructor de imagen con valores por defecto ancho y altura de 100 e
     * imagen por defecto
     */
    public ImageView() {
        setText("");
        obtenerImagen = new ObtenerImagen(this);
        Ancho = TAMANNO_DEFECTO;
        Alto = TAMANNO_DEFECTO;
        borde = LineBorder.createGrayLineBorder();
        setSize(Ancho, Alto);
        setBorder(borde);
        icono = new ImageIcon(getClass().getResource("/Img/imagenDefecto.png"));
        //obtenerImagen.run();
        //obtenerIcono();
        setIcon(icono);

    }

    /**
     * Constructor de un ImageView
     *
     * @param urlimagen Url de la imagen que quieres insertar
     * @param ancho ancho que quieres darle al Image view(imagen)
     * @param alto alto que queires darle al imageView(imagen)
     */
    public ImageView(String urlimagen, int ancho, int alto) {
        setText("");
        obtenerImagen = new ObtenerImagen(this);
        urlImagen = urlimagen;
        Ancho = ancho;
        Alto = alto;
        setSize(Ancho, Alto);
        obtenerImagen.run();
        //obtenerIcono();
        setIcon(icono);

    }

    public void setIcon(Image imagen) {
        icono = new ImageIcon(imagen.getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
    }

    /**
     * Metodo privado para obtener un icono desde una URL
     */
    private void obtenerIcono() {
        try {

            url = new URL(this.urlImagen);
            imagen = ImageIO.read(url);
            icono = new ImageIcon(imagen.getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));

        } catch (MalformedURLException ex) {
            Logger.getLogger(ImageView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImageView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Metodo para asignar el nuevo tamaño al imageView
     *
     * @param ancho
     * @param alto
     */
    private void setTamanio() {
        super.setSize(Ancho, Alto);
        obtenerImagen.run();
        //obtenerIcono();
        setIcon(icono);
    }

    /**
     * Metodo para establecer nueva imagen al imageView
     *
     * @param urlImagen Url de la imagen
     */
    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
        obtenerImagen.run();
        //obtenerIcono();
        setIcon(icono);
    }

    public void setAncho(int ancho) {
        Ancho = ancho;
        setTamanio();
    }

    public void setAlto(int alto) {
        Alto = alto;
        setTamanio();
    }

    public String getUrlImagen() {
        return urlImagen;
    }

}
