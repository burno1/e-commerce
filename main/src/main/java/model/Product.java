package model;

import java.util.List;
import java.util.Objects;

/**
 * Author: Bruno Fernandes
 * Created at : 22/03/2021
 */
public class Product {
    private String name;
    private String description;
    private String collection;
    private List<Image> images;
    private int quantity;
    private double price;

    public Product(Builder builder) {
        name = builder.name;
        description = builder.description;
        collection = builder.collection;
        price = builder.price;
        quantity = builder.quantity;
        images = builder.images;
    }

    public Product(String name) {
        this.name = name;
    }

    public static class Builder {
        private final String name;
        private String description;
        private List<Image> images;
        private String collection;
        private double price;
        private int quantity;

        public Builder (String name){
            this.name = name;
        }

        public Builder description(String description){
            this.description = description;
            return this;
        }

        public Builder price(double price){
            this.price = price;
            return this;
        }

        public Builder collection(String collection){
            this.collection = collection;
            return this;
        }

        public Builder quantity(int quantity){
            this.quantity = quantity;
            return this;
        }

        public Builder images(List<Image> images){
            this.images = images;
            return this;
        }

        public Product build(){
            return new Product(this);
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Product product = (Product) o;
        return name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", description='" + description + '\'' +
                ","+ collection +
                '}';
    }

    public String customPrint(){
       return "name=" + name +
                " price=" + price +
                " description=" + description;
    }

}
