package org.nataliya;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SimpleTest {

    @DisplayName("Проверяем, что 3 больше, чем 2")
    @Test
    void simpleTest() {
        Assertions.assertTrue(3 > 2);
    }
}
