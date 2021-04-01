package enums.menu;

import java.util.Arrays;

/**
 * Author: Bruno Fernandes
 * Created at : 22/03/2021
 */
public enum MainMenuOptionEnum {
    PRODUCT_MANAGEMENT(1,"Product Management"),
    COLLECTION_MANAGEMENT(2,"Collection Management"),
    EXIT (3,"Exit");

    private final int code;
    private final String name;

    MainMenuOptionEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static MainMenuOptionEnum getById(int id) {
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
