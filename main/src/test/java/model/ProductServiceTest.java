package model;

import exception.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.ProductService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Bruno Fernandes
 * Created at : 22/03/2021
 */
class ProductServiceTest {
    static ProductService productService;
    static Product product;

    @BeforeEach
    void setUp() {
        product = new Product
                .Builder("name")
                .price(123)
                .description("description")
                .quantity(10)
                .collection("category")
                .build();
        productService.addProduct(product);
    }

    @BeforeAll
    static void beforeAll() {
        productService = new ProductService();
    }

    @DisplayName(value = "Test add product")
    @Test
    void addProduct() {
        try{
            assertEquals(1, productService.getProducts().size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DisplayName(value = "Test the list of products")
    @Test
    void listProducts() {
        List<Product> products = new ArrayList<>();
        products.add(product);
        assertEquals(products, productService.listProducts());
    }

    @DisplayName(value = "Test searching the products")
    @Test
    void search() {
        assertNotNull(productService.search("name"));

    }

    @DisplayName(value = "Test searching the products throwing exception")
    @Test
    void searchException(){
        assertThrows(ObjectNotFoundException.class, () -> productService.search("produto1"));
    }

    @DisplayName(value = "Test searching the list of products throwing exception")
    @Test
    void searchListException(){
        ProductService productService = new ProductService();
        assertThrows(ObjectNotFoundException.class, productService::listProducts);
    }

    @DisplayName(value = "Test adding the products throwing exception")
    @Test
    void addException(){
        assertThrows(NullPointerException.class, () -> productService.addProduct(null));
    }

}