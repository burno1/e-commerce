package enums.menu;

import java.util.Arrays;

/**
 * Author: Bruno Fernandes
 * Created at : 29/03/2021
 */
public enum ProductMenuOptionsEnum  {
    ADD(1,"Add product"),
    LIST(2,"List products"),
    SEARCH(3,"Search product"),
    EXIT (4,"Back to main menu");

    private final int code;
    private final String name;

    ProductMenuOptionsEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static ProductMenuOptionsEnum getById(int id) {
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
