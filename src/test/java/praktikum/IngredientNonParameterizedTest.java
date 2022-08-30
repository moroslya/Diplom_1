package praktikum;

import org.junit.Assert;
import org.junit.Test;

import static praktikum.IngredientType.*;

public class IngredientNonParameterizedTest {

    @Test
    public void getIngredientNameReturnCorrectValue() {

        Database database = new Database();
        Ingredient ingredient = database.availableIngredients().get(0);

        String expected = "hot sauce";

        String actualIngredientName = ingredient.getName();

        Assert.assertEquals(expected, actualIngredientName);

    }

    @Test
    public void getIngredientPriceReturnCorrectValue() {

        float setIngredientPrice = 60.36F;

        Ingredient ingredient = new Ingredient(SAUCE, "Кисло-сладкий соус", setIngredientPrice);

        float actualIngredientPrice = ingredient.getPrice();

        Assert.assertEquals(setIngredientPrice, actualIngredientPrice, 0);

    }

}
