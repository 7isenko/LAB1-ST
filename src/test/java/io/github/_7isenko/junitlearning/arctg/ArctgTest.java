package io.github._7isenko.junitlearning.arctg;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/**
 * @author 7isenko
 */
class ArctgTest {
    private final Arctg arctg = new Arctg(0.00001);

    @ParameterizedTest
    @CsvFileSource(resources = "/arctg/good_data.csv")
    void arctg_ShouldReturnExpectedValuesOnGoodPoints(double input, double expected) {
        Assertions.assertEquals(expected, arctg.arctg(input), arctg.getEpsilon());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/arctg/bad_data.csv")
    void arctg_ShouldThrowIllegalArgumentExceptionOnBadPoints(double input) {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> arctg.arctg(input));
    }
}