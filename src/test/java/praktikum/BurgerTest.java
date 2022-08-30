package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import static praktikum.IngredientType.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredientFirst;

    @Mock
    Ingredient ingredientSecond;

    @Mock
    Ingredient ingredientThird;

    Burger burger;

    @Before
    public void init() {

        burger = new Burger();
        burger.ingredients.add(ingredientFirst);
        burger.ingredients.add(ingredientSecond);

    }

    @Test
    public void addIngredientToBurgerIncreaseNumberOfIngredients() {

        int expectedSize = burger.ingredients.size() + 1;

        burger.addIngredient(ingredientThird);
        List<Ingredient> actualIngredients = burger.ingredients;
        int actualSize = actualIngredients.size();

        assertThat(actualSize, is(expectedSize));
        assertThat(actualIngredients, hasItems(ingredientThird));

    }

    @Test
    public void removeIngredientFromBurgerDecreaseNumberOfIngredients() {

        int expectedSize = burger.ingredients.size() - 1;

        burger.removeIngredient(0);
        List<Ingredient> actualIngredients = burger.ingredients;
        int actualSize = actualIngredients.size();

        assertThat(actualSize, is(expectedSize));
        assertThat(actualIngredients, not(hasItems(ingredientFirst)));

    }

    @Test
    public void moveIngredientInBurgerChangeOrderIngredient() {

        int expectedSize = burger.ingredients.size();

        burger.moveIngredient(1, 0);
        List<Ingredient> actualIngredients = burger.ingredients;
        int actualSize = actualIngredients.size();

        assertThat(actualSize, is(expectedSize));
        assertThat(actualIngredients.get(0), is(ingredientSecond));
        assertThat(actualIngredients.get(1), is(ingredientFirst));

    }

    @Test
    public void getBurgerPriceReturnCorrectValue() {

        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(4.11F);
        Mockito.when(ingredientFirst.getPrice()).thenReturn(2.24F);
        Mockito.when(ingredientSecond.getPrice()).thenReturn(4.01F);

        float expected = 14.47F;

        float actual = burger.getPrice();

        assertThat(actual, is(expected));

    }

    @Test
    public void getBurgerReceiptReturnCorrectValue() {

        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("Вкусная булочка");
        Mockito.when(ingredientFirst.getName()).thenReturn("Ингредиент №1");
        Mockito.when(ingredientFirst.getType()).thenReturn(SAUCE);
        Mockito.when(ingredientSecond.getName()).thenReturn("Ингредиент №2");
        Mockito.when(ingredientSecond.getType()).thenReturn(FILLING);

        Burger burgerSpy = Mockito.spy(burger);
        Mockito.when(burgerSpy.getPrice()).thenReturn(4.22F);

        StringBuilder receipt = new StringBuilder(String.format("(==== Вкусная булочка ====)%n"));
        receipt.append(String.format("= sauce Ингредиент №1 =%n"));
        receipt.append(String.format("= filling Ингредиент №2 =%n"));
        receipt.append(String.format("(==== Вкусная булочка ====)%n"));
        receipt.append(String.format("%nPrice: %f%n", 4.22F));
        String expected = receipt.toString();

        String actual = burger.getReceipt();

        assertThat(actual, is(expected));

    }

}
