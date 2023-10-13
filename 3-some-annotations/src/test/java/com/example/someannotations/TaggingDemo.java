package com.example.someannotations;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * @author manhdt14
 * created in 10/13/2023 4:55 PM
 */
@Tag("fast")
@Tag("model")
class TaggingDemo {

    @Test
    @Tag("taxes")
    void testingTaxCalculation() {
    }

}
