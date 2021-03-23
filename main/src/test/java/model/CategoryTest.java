package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Bruno Fernandes
 * Created at : 23/03/2021
 */
class CategoryTest {

    @DisplayName(value = "Test toString")
    @Test
    void testToString() {
        Category category = new Category("Category");

        assertNotEquals("",category.toString());
    }
}