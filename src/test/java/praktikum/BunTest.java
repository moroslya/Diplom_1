package praktikum;

import org.junit.Test;
import org.junit.Assert;

public class BunTest {

    @Test
    public void getBunNameReturnCorrectValue() {

        String setBunName = "Сладкая булочка";

        Bun bun = new Bun(setBunName, 100);

        String actualBunName = bun.getName();

        Assert.assertEquals(setBunName, actualBunName);

    }

    @Test
    public void getBunPriceReturnCorrectValue() {

        float setBunPrice = 120.36F;

        Bun bun = new Bun("Сладкая булочка", setBunPrice);

        float actualBunPrice = bun.getPrice();

        Assert.assertEquals(setBunPrice, actualBunPrice, 0);

    }

}
