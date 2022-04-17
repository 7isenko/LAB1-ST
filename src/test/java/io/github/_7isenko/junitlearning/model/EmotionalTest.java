package io.github._7isenko.junitlearning.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author 7isenko
 */
public class EmotionalTest {
    private Person arthur;
    private Person ford;

    @BeforeEach
    void setupEntities() {
        arthur = new Person("Артур");
        ford = new Person("Форд");

        arthur.setCurrentEmotion(Emotion.CALM);
        ford.setCurrentEmotion(Emotion.VEXATIOUS);
    }

    @Test
    void plotTest() {
        ford.setCurrentEmotion(Emotion.ANGER);
        Assertions.assertEquals(Emotion.ANGER, ford.emote(), String.format("%s яростно сверкает глазами", ford.getName()));

        ford.setCurrentEmotion(Emotion.VEXATIOUS);
        Assertions.assertEquals(Emotion.VEXATIOUS, ford.emote(), String.format("%s почувствовал досаду", ford.getName()));
    }
}
