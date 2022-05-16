package io.github._7isenko.junitlearning.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author 7isenko
 */
public class BrainTest {
    private Brain brain;
    @BeforeEach
    void setupBrain() {
        brain = new Brain();
    }

    @Test
    void getExistingKnowledgeIsValid() {
        brain.setKnowledgeLevel("test", 1);
        Assertions.assertEquals(1, brain.getKnowledgeLevel("test"));
    }

    @Test
    void getNotExistingKnowledgeIsValid() {
        Assertions.assertEquals(0, brain.getKnowledgeLevel("test"));
    }
}
