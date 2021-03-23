package model;

import exception.ObjectNotFoundException;

import java.util.*;

/**
 * Author: Bruno Fernandes
 * Created at : 22/03/2021
 */
public class Store {
    private HashMap<Integer, Product> products = new HashMap<>();

    /**
     * Adds a new product to the set
     */
    public void addProduct(Product product) {
        try {
            Product productOnStorage = products.get(product.hashCode());
            if (productOnStorage != null) {
                product.setQuantity(productOnStorage.getQuantity() + product.getQuantity());
            }
            products.put(product.hashCode(), product);

            System.out.println("product added successfuly");

        } catch (NullPointerException e) {
            throw new NullPointerException("Product cannot be null");
        }
    }


    /**
     * List products
     */
    public List<Product> listProducts() {
        return new ArrayList<>(products.values());
    }

    /**
     * search for a product using the name prompted
     */
    public Product search(String name) {

        Product product = products.get(new Product(name).hashCode());

        if(product == null){
            throw new ObjectNotFoundException("Product not found");
        }

        return product;
    }

    public HashMap<Integer, Product> getProducts() {
        return products;
    }
}
