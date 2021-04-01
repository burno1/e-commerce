package service;

import exception.ObjectNotFoundException;
import model.Product;

import java.util.*;

/**
 * Author: Bruno Fernandes
 * Created at : 22/03/2021
 */
public class ProductService {
    private HashMap<Integer, Product> products = new HashMap<>();

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

    public List<Product> listProducts() {
        if(products.size() == 0){
            throw new ObjectNotFoundException("No products to show");
        }
        return new ArrayList<>(products.values());
    }

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
