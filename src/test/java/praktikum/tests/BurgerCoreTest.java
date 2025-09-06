package praktikum.tests;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerCoreTest {

    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient sauce;

    @Mock
    private Ingredient filling;

    @Before
    public void setUp() {
        burger = new Burger();

        // стабы для булки
        when(bun.getName()).thenReturn("Краторная булка N200i");
        when(bun.getPrice()).thenReturn(100f);

        // стабы для ингредиентов
        when(sauce.getType()).thenReturn(IngredientType.SAUCE);
        when(sauce.getName()).thenReturn("Соус Spicy-X");
        when(sauce.getPrice()).thenReturn(10f);

        when(filling.getType()).thenReturn(IngredientType.FILLING);
        when(filling.getName()).thenReturn("Говяжий метеорит");
        when(filling.getPrice()).thenReturn(20f);

        burger.setBuns(bun);
    }

    @Test
    public void addAddsTwoIngredientsSizeIs2Test() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        assertThat(burger.ingredients, hasSize(2));
    }

    @Test
    public void addAddsTwoIngredientsOrderSauceThenFillingTest() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        assertThat(burger.ingredients, contains(sauce, filling));
    }

    @Test
    public void moveSwapsOrderFillingThenSauceTest() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        burger.moveIngredient(1, 0);

        assertThat(burger.ingredients, contains(filling, sauce));
    }

    @Test
    public void removeFirstLeavesOnlySauceTest() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        burger.moveIngredient(1, 0); // ensure sauce at index 1
        burger.removeIngredient(0);

        assertThat(burger.ingredients, contains(sauce));
    }

    @Test
    public void removeFirstResultsSize1Test() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        burger.moveIngredient(1, 0); // ensure sauce at index 1
        burger.removeIngredient(0);

        assertThat(burger.ingredients, hasSize(1));
    }

    /**
     * Полная проверка текста рецепта: сравниваем строку целиком.
     * Один тест — одна проверка.
     */
    @Test
    public void receiptMatchesExpectedTest() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        String expectedReceipt = String.format(
                "(==== %s ====)%n" +
                "= sauce %s =%n" +
                "= filling %s =%n" +
                "(==== %s ====)%n" +
                "%nPrice: %f%n",
                bun.getName(), sauce.getName(), filling.getName(), bun.getName(), 230f
        );

        String actualReceipt = burger.getReceipt();

        Assert.assertEquals(expectedReceipt, actualReceipt);
    }
}