package imageView;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class ImageView extends JLabel {

    private static final int TAMANNO_DEFECTO = 100;

    private String urlImagen;
    private int Ancho, Alto;
    private Icon icono;
    private ObtenerImagen obtenerImagen;
    private Border borde;

    /**
     * Constructor de imagen con valores por defecto ancho y altura de 100 e
     * imagen por defecto
     */
    public ImageView() {
        urlImagen = "";
        setText("");
        obtenerImagen = new ObtenerImagen(this);
        Ancho = TAMANNO_DEFECTO;
        Alto = TAMANNO_DEFECTO;
        borde = LineBorder.createGrayLineBorder();
        setSize(Ancho, Alto);
        setBorder(borde);
        icono = new ImageIcon(getClass().getResource("/Img/imagenDefecto.png"));

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
        setIcon(icono);

    }

    public void setIcon(Image imagen) {
        try {
            icono = new ImageIcon(imagen.getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido establecer la imagen", "Error con la URL", JOptionPane.ERROR_MESSAGE);
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
        if (!urlImagen.isEmpty()) {
            obtenerImagen.run();
        }
        setIcon(icono);
    }

    /**
     * Metodo para establecer nueva imagen al imageView
     *
     * @param urlImagen Url de la imagen
     */
    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
        setBorder(null);
        if (!urlImagen.isEmpty()) {
            obtenerImagen.run();
        }
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
