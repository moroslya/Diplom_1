package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final String ingredientTypeName;

    public IngredientTypeTest(String ingredientTypeName) {

        this.ingredientTypeName = ingredientTypeName;

    }

    @Test
    public void checkThatIngredientTypeExists() {

        Assert.assertNotNull(IngredientType.valueOf(ingredientTypeName));

    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}")
    public static Object[][] getData() {
        return new Object[][] {
                {"SAUCE"},
                {"FILLING"}
        };
    }

}
