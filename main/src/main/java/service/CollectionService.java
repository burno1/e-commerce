package service;

import exception.ObjectNotFoundException;
import model.Collection;
import model.Product;

import java.util.*;

/**
 * Author: Bruno Fernandes
 * Created at : 31/03/2021
 */
public class CollectionService {
    private Map<Integer, Collection<Collection<Product>>> collections = new HashMap<>();


    public void addMainCollection(Collection<Collection<Product>> collection) {
        try {
            collections.putIfAbsent(collection.hashCode(), collection);

            System.out.println("collection added successfuly");

        } catch (NullPointerException e) {
            throw new NullPointerException("Collection cannot be null");
        }
    }

    public void addSubCollection(Collection<Product> subCollection) {
        try {
            Collection<Collection<Product>> collection = collections.get(new Collection<Collection<Product>>(subCollection
                                                                                                    .getParentName())
                                                                                                    .hashCode());

            if ( collection != null ){
                if (collection.getSubCollection() != null && !collection.getSubCollection().isEmpty()) {
                    collection.getSubCollection().add(subCollection);
                } else {
                    collection.setSubCollection(Arrays.asList(subCollection));
                }
            }

            collections.put(collection.hashCode(), collection);
            System.out.println("collection added successfuly");
        } catch (NullPointerException e) {
            throw new NullPointerException("Error adding new subcollection");
        }
    }

    public List<Collection> listCollections() {
        if (collections.size() == 0) {
            throw new ObjectNotFoundException("No products to show");
        }
        return new ArrayList<>(collections.values());
    }
}
