package model.variants;

import enums.GenderEnum;
import enums.ShirtSizeEnum;
import enums.SleeveEnum;
import model.Product;

/**
 * Author: Bruno Fernandes
 * Created at : 31/03/2021
 */
public class TShirt extends Product {
    private String color;
    private ShirtSizeEnum size;
    private GenderEnum gender;
    private SleeveEnum sleeve;

    public TShirt(Builder builder) {
        super(builder);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ShirtSizeEnum getSize() {
        return size;
    }

    public void setSize(ShirtSizeEnum size) {
        this.size = size;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public SleeveEnum getSleeve() {
        return sleeve;
    }

    public void setSleeve(SleeveEnum sleeve) {
        this.sleeve = sleeve;
    }
}
