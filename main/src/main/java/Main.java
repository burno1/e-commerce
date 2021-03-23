import enums.MenuOptionEnum;
import utilities.Menu;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author: Bruno Fernandes
 * Created at : 22/03/2021
 */
public class Main {
    public static void main(String[] args){

        List<String> enumNames = Stream.of(MenuOptionEnum.values())
                .map(Enum::name)
                .collect(Collectors.toList());

        Menu menu = new Menu("Main Menu","Select the operation you want to do", enumNames);
        menu.spawnMenu();
    }
}
