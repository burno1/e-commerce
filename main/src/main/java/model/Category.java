package model;

/**
 * Author: Bruno Fernandes
 * Created at : 22/03/2021
 */
public class Category {
    private String name;

    public Category(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                '}';
    }
}
