package model;

import java.util.List;

/**
 * Author: Bruno Fernandes
 * Created at : 31/03/2021
 */
public class MainCollection extends Collection {
    private List<SubCollection> subCollections;

    public MainCollection(String name, String description, List<String> keywords) {
        super(name, description, keywords);
    }

    public MainCollection(String parentName) {
        super(parentName);
    }

    public List<SubCollection> getSubCollections() {
        return subCollections;
    }

    public void setSubCollections(List<SubCollection> subCollections) {
        this.subCollections = subCollections;
    }
}
