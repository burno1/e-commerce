package model;

import java.util.List;

/**
 * Author: Bruno Fernandes
 * Created at : 31/03/2021
 */
public class SubCollection extends Collection {
    private List<Product> products;
    private String parentName;
    public SubCollection(String name, String description, List<String> keywords) {
        super(name, description, keywords);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
