package io.github._7isenko.junitlearning.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author 7isenko
 */
public class SaneEntityTest {

    private SaneEntity arthur;
    private SaneEntity mosquito;
    private final double DEFAULT_PLOV_LEVEL = 1.0;

    @BeforeEach
    void setupEntities() {
        arthur = new Person("Артур");
        mosquito = new Insect();

        arthur.explore("Галактические дела", 0);
        arthur.explore("Рецепт плова", DEFAULT_PLOV_LEVEL);

        mosquito.explore("Жизнь в Илфорде", 0.2);
        mosquito.explore("Кровеносные системы", 0.7);
    }

    @Test
    void plotTest() {
        Assertions.assertTrue(arthur.getExplorationLevel("Галактические дела") <= mosquito.getExplorationLevel("Жизнь в Пекине"));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1, 1.1, Double.MAX_VALUE, -Double.MIN_VALUE})
    void outOfRangeTest(double val) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> arthur.explore("Blah-blah", val));
    }

    @Test
    void forgetTest(){
        Assertions.assertEquals(arthur.getExplorationLevel("Рецепт плова"), DEFAULT_PLOV_LEVEL);

        arthur.forget("Рецепт плова");
        Assertions.assertEquals(arthur.getExplorationLevel("Рецепт плова"), 0);

        arthur.explore("Рецепт плова", DEFAULT_PLOV_LEVEL);
        Assertions.assertEquals(arthur.getExplorationLevel("Рецепт плова"), DEFAULT_PLOV_LEVEL);
    }

    @Test
    void nullTest() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->arthur.forget(null));
        Assertions.assertThrows(IllegalArgumentException.class, ()->arthur.explore(null, 1));
    }
}
