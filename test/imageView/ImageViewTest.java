package imageView;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DAM-2
 */
public class ImageViewTest {

    private static ImageView imagenView;

    public ImageViewTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        imagenView = new ImageView();
    }

    @After
    public void tearDown() {
        imagenView = null;
    }

    /**
     * Testeo del metodo setUrlImagen de ImageView
     */
    @Test
    public void testSetUrlImagen() {
        System.out.println("setUrlImagen");
        String urlImagen = "http://qnimate.com/wp-content/uploads/2014/03/images2.jpg";
        imagenView.setUrlImagen(urlImagen);
        assertEquals(urlImagen, imagenView.getUrlImagen());
    }

    /**
     * Testeo del metodo setAncho de ImageView
     */
    @Test
    public void testSetAncho() {
        System.out.println("setAncho");
        int ancho = 15;
        imagenView.setAncho(ancho);
        assertEquals(ancho, imagenView.getWidth());
    }

    /**
     * Testeo del metodo setAlto de ImageView
     */
    @Test
    public void testSetAlto() {
        System.out.println("setAlto");
        int alto = 0;
        imagenView.setAlto(alto);
        assertEquals(alto, imagenView.getHeight());
    }

}
