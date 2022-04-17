package io.github._7isenko.junitlearning.model;

/**
 * @author 7isenko
 */
public abstract class SaneEntity {

    private final Brain brain = new Brain();

    public void explore(String what, double level) {
        brain.setKnowledgeLevel(what, level);
    }

    public void forget(String what) {
        brain.setKnowledgeLevel(what, 0);
    }

    public double getExplorationLevel(String what) {
        return brain.getKnowledgeLevel(what);
    }

}
