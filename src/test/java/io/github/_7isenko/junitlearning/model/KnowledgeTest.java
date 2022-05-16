package io.github._7isenko.junitlearning.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author 7isenko
 */
public class KnowledgeTest {

    private Knowledge knowledge;

    @BeforeEach
    void setup() {
        knowledge = new Knowledge("test");
    }

    @Test
    void setNegativeValueThrowsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> knowledge.setLevel(-1));
    }

    @Test
    void setOutOfBoundsValueThrowsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> knowledge.setLevel(100));
    }

    @Test
    void setZeroPasses() {
        knowledge.setLevel(0);
        Assertions.assertEquals(0, knowledge.getLevel());
    }

    @Test
    void setOnePasses() {
        knowledge.setLevel(1);
        Assertions.assertEquals(1, knowledge.getLevel());
    }

    @Test
    void setValidValuePasses() {
        knowledge.setLevel(0.2451);
        Assertions.assertEquals(0.2451, knowledge.getLevel());
    }
}
