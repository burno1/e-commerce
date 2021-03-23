package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Bruno Fernandes
 * Created at : 23/03/2021
 */
class ProductTest {
    Product product;
    @BeforeEach
    void setUp() {
         product = new Product
                .Builder("name")
                .price(1)
                .description("description")
                .quantity(123)
                .category("category")
                .build();
    }

    @DisplayName(value = "get name test")
    @Test
    void getName() {
        assertEquals("name",product.getName());
    }

    @DisplayName(value = "get price test")
    @Test
    void getPrice() {
        assertEquals(1, product.getPrice());
    }

    @DisplayName(value = "get description test")
    @Test
    void getDescription() {
        assertEquals("description", product.getDescription());
    }

    @DisplayName(value = "toString test")
    @Test
    void testToString() {
        assertNotEquals("",product.toString());
    }

    @DisplayName(value = "test equals")
    @Test
    void testEquals() {

        Product productEqual = new Product
                .Builder("name")
                .price(1)
                .description("description")
                .quantity(123)
                .category("category")
                .build();

        assertEquals(productEqual,product);
    }

    @DisplayName(value = "Test the custom to String")
    @Test
    void customToString() {
        assertNotEquals("",product.customPrint());
    }
}