package model;

import exception.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Bruno Fernandes
 * Created at : 22/03/2021
 */
class StoreTest {
    static Store store;
    static Product product;

    @BeforeEach
    void setUp() {
        product = new Product
                .Builder("name")
                .price(123)
                .description("description")
                .quantity(10)
                .category("category")
                .build();
        store.addProduct(product);
    }

    @BeforeAll
    static void beforeAll() {
        store = new Store();
    }

    @DisplayName(value = "Test add product")
    @Test
    void addProduct() {
        try{
            assertEquals(1, store.getProducts().size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DisplayName(value = "Test the list of products")
    @Test
    void listProducts() {
        List<Product> products = new ArrayList<>();
        products.add(product);
        assertEquals(products,store.listProducts());
    }

    @DisplayName(value = "Test searching the products")
    @Test
    void search() {
        assertNotNull(store.search("name"));

    }

    @DisplayName(value = "Test searching the products throwing exception")
    @Test
    void searchException(){
        assertThrows(ObjectNotFoundException.class, () -> store.search("produto1"));
    }

    @DisplayName(value = "Test adding the products throwing exception")
    @Test
    void addException(){
        assertThrows(NullPointerException.class, () -> store.addProduct(null));
    }

}