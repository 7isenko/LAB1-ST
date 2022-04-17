package io.github._7isenko.junitlearning.model;

/**
 * @author 7isenko
 */
public class Person extends SaneEntity {

    private final String name;
    private Emotion currentEmotion = Emotion.UNDEFINED;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Emotion emote() {
        return currentEmotion;
    }

    public void setCurrentEmotion(Emotion emotion) {
        this.currentEmotion = emotion;
    }
}
