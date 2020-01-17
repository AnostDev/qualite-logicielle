package calculatrice;

import org.junit.Assert;
import org.junit.Test;

public class TestCalculatrice {

    private Calculatrice calculatrice;

    public TestCalculatrice() {
        this.calculatrice = new Calculatrice();
    }

    @Test
    public void testAdd() {
        int a = 5, b = 5;

        int c = calculatrice.add(a, b);
        Assert.assertEquals(10, c);
    }

    @Test
    public void testSub() {
        int a = 5, b = 5;

        int c = calculatrice.sub(a, b);
        Assert.assertEquals(0, c);
    }

    @Test
    public void testMult() {
        int a = 5, b = 5;

        int c = calculatrice.mult(a, b);
        Assert.assertEquals(25, c);
    }

    @Test
    public void testDiv() {
        int a = 5, b = 5;

        int c = calculatrice.divis(a, b);
        Assert.assertEquals(1, c);
    }

    @Test
    public void testReste() {
        int a = 5, b = 5;

        int c = calculatrice.reste(a, b);
        Assert.assertEquals(0, c);
    }

}
