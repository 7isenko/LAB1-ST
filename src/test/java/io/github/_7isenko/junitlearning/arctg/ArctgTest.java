package io.github._7isenko.junitlearning.arctg;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author 7isenko
 */
class ArctgTest {

    private Arctg arctg;
    @BeforeEach
    void setupArctg(){
        arctg = new Arctg(0.00001);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/arctg/good_data.csv")
    void arctgShouldReturnExpectedValuesOnGoodPoints(double input, double expected) {
        Assertions.assertEquals(expected, arctg.arctg(input), arctg.getEpsilon());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/arctg/bad_data.csv")
    void arctgShouldThrowIllegalArgumentExceptionOnBadPoints(double input) {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> arctg.arctg(input));
    }

    @ParameterizedTest
    @CsvSource({"1,0.78", "-1,-0.78"})
    void arctgShouldReturnApproximateValuesOnFarPoints(double input, double expected) {
        Assertions.assertEquals(expected, arctg.arctg(input), 0.01);
    }
}