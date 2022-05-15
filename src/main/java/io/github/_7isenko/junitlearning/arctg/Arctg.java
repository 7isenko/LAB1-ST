package io.github._7isenko.junitlearning.arctg;

/**
 * @author 7isenko
 */
public class Arctg {

    private final double epsilon;

    public Arctg(double epsilon) {
        this.epsilon = epsilon;
    }

    public double arctg(double x) {
        if (Math.abs(x) > 1) {
            throw new IllegalArgumentException("|x| must be <= 1");
        }

        double result = 0;
        double step;
        int i = 0;
        do {
            step = step(x, i);
            result += step;
            i++;
        } while (Math.abs(step) > epsilon && i < 1000);


        return result;
    }

    private double step(double x, int step) {
        return (Math.pow(-1, step) / (2 * step + 1)) * Math.pow(x, (2 * step + 1));
    }

    public double getEpsilon() {
        return epsilon;
    }

}
