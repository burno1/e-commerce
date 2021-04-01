package model;

import java.util.List;
import java.util.Objects;

/**
 * Author: Bruno Fernandes
 * Created at : 31/03/2021
 */
public abstract class Collection {
    protected String name;
    protected String description;
    protected List<String> keywords;

    public Collection(String name, String description, List<String> keywords) {
        this.name = name;
        this.description = description;
        this.keywords = keywords;
    }

    public Collection(String name){
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
