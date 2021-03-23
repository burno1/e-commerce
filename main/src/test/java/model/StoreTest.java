package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Author: Bruno Fernandes
 * Created at : 22/03/2021
 */
class StoreTest {
    static Store store;
    @BeforeAll
    static void beforeAll() {
        store = new Store();
    }

    @DisplayName(value = "Test add product")
    @Test
    void addProduct() {
        ByteArrayInputStream in = new ByteArrayInputStream("My string".getBytes());
        System.setIn(in);
        store.addProduct();

        assertEquals(1, store.getProducts().size());

    }

    @DisplayName(value = "Test the list of products")
    @Test
    void listProducts() {
        assertDoesNotThrow(()->{store.listProducts();});

    }

    @DisplayName(value = "Test searching the products")
    @Test
    void search() {
    }
}