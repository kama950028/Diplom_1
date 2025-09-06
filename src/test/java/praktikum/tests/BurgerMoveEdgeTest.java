package praktikum.tests;

import org.junit.Test;
import praktikum.*;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class BurgerMoveEdgeTest {

    @Test
    public void moveFromStartToEndOnceTest() {
        Burger burger = new Burger();

        // Bun as mock
        Bun bun = mock(Bun.class);
        when(bun.getName()).thenReturn("Булка");
        when(bun.getPrice()).thenReturn(1f);
        burger.setBuns(bun);

        // Ingredients as mocks (no magic numbers in names)
        Ingredient sauceFirst = mock(Ingredient.class);
        when(sauceFirst.getType()).thenReturn(IngredientType.SAUCE);
        when(sauceFirst.getName()).thenReturn("SpicySauce");
        when(sauceFirst.getPrice()).thenReturn(1f);

        Ingredient filling = mock(Ingredient.class);
        when(filling.getType()).thenReturn(IngredientType.FILLING);
        when(filling.getName()).thenReturn("BeefFilling");
        when(filling.getPrice()).thenReturn(1f);

        Ingredient sauceSecond = mock(Ingredient.class);
        when(sauceSecond.getType()).thenReturn(IngredientType.SAUCE);
        when(sauceSecond.getName()).thenReturn("MildSauce");
        when(sauceSecond.getPrice()).thenReturn(1f);

        burger.addIngredient(sauceFirst);
        burger.addIngredient(filling);
        burger.addIngredient(sauceSecond);

        // 0,1,2 -> move index 0 to index 2 => 1,2,0
        burger.moveIngredient(0, 2);

        // one test — one assertion
        assertThat(burger.ingredients, contains(filling, sauceSecond, sauceFirst));
    }

    @Test
    public void moveFromEndToStartOnceTest() {
        Burger burger = new Burger();

        // Bun as mock
        Bun bun = mock(Bun.class);
        when(bun.getName()).thenReturn("Булка");
        when(bun.getPrice()).thenReturn(1f);
        burger.setBuns(bun);

        // Ingredients as mocks
        Ingredient sauceFirst = mock(Ingredient.class);
        when(sauceFirst.getType()).thenReturn(IngredientType.SAUCE);
        when(sauceFirst.getName()).thenReturn("SpicySauce");
        when(sauceFirst.getPrice()).thenReturn(1f);

        Ingredient filling = mock(Ingredient.class);
        when(filling.getType()).thenReturn(IngredientType.FILLING);
        when(filling.getName()).thenReturn("BeefFilling");
        when(filling.getPrice()).thenReturn(1f);

        Ingredient sauceSecond = mock(Ingredient.class);
        when(sauceSecond.getType()).thenReturn(IngredientType.SAUCE);
        when(sauceSecond.getName()).thenReturn("MildSauce");
        when(sauceSecond.getPrice()).thenReturn(1f);

        burger.addIngredient(sauceFirst);
        burger.addIngredient(filling);
        burger.addIngredient(sauceSecond);

        // 0,1,2 -> 1,2,0 -> move index 2 to index 0 => 0,1,2
        burger.moveIngredient(0, 2);
        burger.moveIngredient(2, 0);

        // one test — one assertion
        assertThat(burger.ingredients, contains(sauceFirst, filling, sauceSecond));
    }
}