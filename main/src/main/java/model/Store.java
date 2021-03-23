package model;

import utilities.Menu;

import java.util.HashMap;

/**
 * Author: Bruno Fernandes
 * Created at : 22/03/2021
 */
public class Store {
    private HashMap<Integer, Product> products = new HashMap<>();


    /**
     * Adds a new product to the set
     */
    public void addProduct(){
        Product product = new Product
                .Builder(Menu.prompt("What is the product name?"))
                .price(Menu.promptDouble("What is the product Price?", 0))
                .build();

        Product productOnStorage =products.get(product.hashCode());
        if( productOnStorage!=null ) {
            product.setQuantity(productOnStorage.getQuantity() + 1);
        }
        products.put(product.hashCode(), product);
    }


    /**
     * List products
     */
    public void listProducts(){
        System.out.println("Listando produtos");
        products.forEach((integer, product) -> {
            System.out.println(product);
        });

    }

    /**
     * search for a product using the name prompted
     */
    public void search() {
        String name = Menu.prompt("Type the name of the product");

        System.out.println(products.get(new Product(name).hashCode()));
    }

    public HashMap<Integer, Product> getProducts() {
        return products;
    }

    public void setProducts(HashMap<Integer, Product> products) {
        this.products = products;
    }
}
