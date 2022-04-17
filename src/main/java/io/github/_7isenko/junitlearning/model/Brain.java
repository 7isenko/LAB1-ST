package io.github._7isenko.junitlearning.model;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author 7isenko
 */
public class Brain {
    private final ArrayList<Knowledge> knowledgeList = new ArrayList<>();

    /**
     * Gets knowledge with given name or creates one with 0 level.
     */
    public double getKnowledgeLevel(String name) {
        return Objects.requireNonNullElseGet(findKnowledge(name), () -> createKnowledge(name)).getLevel();
    }

    /**
     * Sets knowledge level. Must be between 0 and 1.0
     * @throws IllegalArgumentException if level is out of bounds
     */
    public void setKnowledgeLevel(String name, double level) throws IllegalArgumentException{
        Objects.requireNonNullElseGet(findKnowledge(name), () -> createKnowledge(name)).setLevel(level);
    }

    private Knowledge findKnowledge(String name) {
        for (Knowledge knowledge : knowledgeList) {
            if (knowledge.getName().equals(name)) {
                return knowledge;
            }
        }
        return null;
    }

    private Knowledge createKnowledge(String name) {
        Knowledge knowledge = new Knowledge(name);
        knowledgeList.add(knowledge);
        return knowledge;
    }
}
