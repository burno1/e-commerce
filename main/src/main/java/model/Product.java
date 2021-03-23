package model;

import java.util.Objects;

/**
 * Author: Bruno Fernandes
 * Created at : 22/03/2021
 */
public class Product {
    private String name;
    private int quantity;
    private double price;
    private String description;
    private Category category;

    public Product(Builder builder) {
        name = builder.name;
        description = builder.description;
        category = builder.category;
        price = builder.price;
        quantity = builder.quantity;
    }

    public Product(String name) {
        this.name = name;
    }

    public static class Builder {
        private final String name;
        private String description;
        private double price;
        private Category category;
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

        public Builder category(String categoryName){
            this.category = new Category(categoryName);
            return this;
        }

        public Builder quantity(int quantity){
            this.quantity = quantity;
            return this;
        }

        public Product build(){
            return new Product(this);
        }
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
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
                ","+ category +
                '}';
    }

    public String customPrint(){
       return "name=" + name +
                " price=" + price +
                " description=" + description;
    }

}
