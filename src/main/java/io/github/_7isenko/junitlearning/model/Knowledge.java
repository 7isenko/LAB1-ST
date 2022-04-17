package io.github._7isenko.junitlearning.model;

/**
 * @author 7isenko
 */
public class Knowledge {
    private final String name;
    private double level = 0;

    public Knowledge(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getLevel() {
        return level;
    }

    /**
     * Must be between 0 and 1.0
     * @throws IllegalArgumentException if level is out of bounds
     */
    public void setLevel(double level) throws IllegalArgumentException {
        if (level > 1.0D || level < 0) throw new IllegalArgumentException("Level is out of bounds");
        this.level = level;
    }

}
