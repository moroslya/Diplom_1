package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {

    private final IngredientType setIngredientType;

    public IngredientParameterizedTest(IngredientType setIngredientType) {

        this.setIngredientType = setIngredientType;

    }

    @Test
    public void getIngredientTypeReturnCorrectValue() {

        Ingredient ingredient = new Ingredient(setIngredientType, "Кисло-сладкий соус", 100);

        IngredientType actualIngredientType = ingredient.getType();

        Assert.assertEquals(setIngredientType, actualIngredientType);

    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}")
    public static Object[][] getData() {
        return new Object[][] {
                {SAUCE},
                {FILLING}
        };
    }

}
