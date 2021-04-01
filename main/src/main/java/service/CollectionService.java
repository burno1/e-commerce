package service;

import exception.ObjectNotFoundException;
import model.Collection;
import model.MainCollection;
import model.Product;
import model.SubCollection;
import sun.tools.jar.Main;

import java.util.*;

/**
 * Author: Bruno Fernandes
 * Created at : 31/03/2021
 */
public class CollectionService {
    private Map<Integer, MainCollection> collections = new HashMap<>();

    /**
     * Add a new product
     * @param collection product to be added to the structure
     */
    public void addMainCollection(MainCollection collection) {
        try {
            collections.put(collection.hashCode(), collection);

            System.out.println("product added successfuly");

        } catch (NullPointerException e) {
            throw new NullPointerException("Collection cannot be null");
        }
    }

    public void addSubCollection(SubCollection subCollection){
        try {
            MainCollection mainCollection = collections.get(new MainCollection(subCollection.getParentName()).hashCode());

            if ((mainCollection.getSubCollections() != null)) {
                mainCollection.getSubCollections().add(subCollection);
            } else {
                mainCollection.setSubCollections(Arrays.asList(subCollection));
            }
            collections.put(mainCollection.hashCode(), mainCollection);

        } catch (NullPointerException e) {
            throw new NullPointerException("Collection cannot be null");
        }
    }
    /**
     * list all collections
     * @return collections in storage
     */
    public List<MainCollection> listCollections() {
        if(collections.size() == 0){
            throw new ObjectNotFoundException("No products to show");
        }
        return new ArrayList<>(collections.values());
    }
}
