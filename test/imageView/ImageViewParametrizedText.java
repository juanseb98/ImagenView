/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageView;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author Juan Sebastián González Sánchez
 */
@RunWith(Parameterized.class)
public class ImageViewParametrizedText {

    @Parameters
    public static Iterable data() {
        return Arrays.asList(new Object[][]{
            {3, 3}, {5, 5}, {5, 4}
        });
    }

    private int num1;
    private int result;
    private static ImageView imagenView;

    public ImageViewParametrizedText(int num1, int result) {
        this.num1 = num1;
        this.result = result;
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
     * Testeo del metodo setAncho de ImageView
     */
    @Test
    public void testSetAncho() {
        System.out.println("setAncho");
        imagenView.setAncho(num1);
        assertEquals(result, imagenView.getWidth());
    }

    /**
     * Testeo del metodo setAlto de ImageView
     */
    @Test
    public void testSetAlto() {
        System.out.println("setAlto");
        imagenView.setAlto(num1);
        assertEquals(result, imagenView.getHeight());
    }

}
