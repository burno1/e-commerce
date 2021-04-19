package model;

import java.util.List;
import java.util.Objects;

/**
 * Author: Bruno Fernandes
 * Created at : 31/03/2021
 */
public class Collection<T> {
    protected String name;
    protected String description;
    protected List<String> keywords;
    protected String parentName;
    private List<T> subCollection;


    public Collection(String name, String description, List<String> keywords) {
        this.name = name;
        this.description = description;
        this.keywords = keywords;
    }

    public Collection(String name, String description, List<String> keywords, String parentName) {
        this.name = name;
        this.description = description;
        this.keywords = keywords;
        this.parentName = parentName;
    }

    public Collection(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public List<T> getSubCollection() {
        return subCollection;
    }

    public void setSubCollection(List<T> subCollection) {
        this.subCollection = subCollection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collection<?> that = (Collection<?>) o;
        return name.equals(that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
