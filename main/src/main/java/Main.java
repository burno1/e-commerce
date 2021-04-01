import enums.menu.MainMenuOptionEnum;
import view.MainMenu;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author: Bruno Fernandes
 * Created at : 22/03/2021
 */
public class Main {
    public static void main(String[] args){

        List<String> enumNames = Stream.of(MainMenuOptionEnum.values())
                .map(MainMenuOptionEnum::getName)
                .collect(Collectors.toList());

        MainMenu menu = new MainMenu("Main Menu","Select the operation you want to do", enumNames);
        menu.spawnMenu();
    }
}
