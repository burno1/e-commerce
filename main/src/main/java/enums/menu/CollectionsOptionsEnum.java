package enums.menu;

import java.util.Arrays;

/**
 * Author: Bruno Fernandes
 * Created at : 29/03/2021
 */
public enum CollectionsOptionsEnum {
    ADD(1,"Create new collection"),
    ADD_SUB(2,"Create sub-collection"),
    LIST(3,"List collections and subcollections"),
    SEARCH(4,"Search for product"),
    LIST_PRODUCTS(5,"List products in collection"),
    EXIT (6,"Exit");


    private final int code;
    private final String name;

    CollectionsOptionsEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static CollectionsOptionsEnum getById(int id) {
        return Arrays.stream(values())
                .filter(enu -> enu.code == id)
                .findFirst()
                .get();
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }
}
