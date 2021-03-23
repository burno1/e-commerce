package utilities;

import enums.MenuOptionEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Bruno Fernandes
 * Created at : 23/03/2021
 */
class MenuTest {
    Menu menu;

    @BeforeEach
    void setUp() {
        List<String> enumNames = Stream.of(MenuOptionEnum.values())
                .map(Enum::name)
                .collect(Collectors.toList());

      menu = new Menu("Main Menu", "the main menu", enumNames);
    }

    @DisplayName(value = "Spawn menu test")
    @Test
    void spawnMenu() {

        ByteArrayInputStream in = new ByteArrayInputStream(("4").getBytes());
        System.setIn(in);

        assertDoesNotThrow(() -> {
            menu.spawnMenu();
        });
    }

    @DisplayName(value = "User String entry test")
    @Test
    void prompt() {
        ByteArrayInputStream in = new ByteArrayInputStream(("Edson").getBytes());
        System.setIn(in);


        assertDoesNotThrow(() -> {
            Menu.prompt("Question Test");
        });
    }

    @DisplayName(value = "User int entered")
    @Test
    void promptInt() {
        ByteArrayInputStream in = new ByteArrayInputStream(("1").getBytes());
        System.setIn(in);

        assertDoesNotThrow(() -> {
            Menu.promptInt("Question Test",0);
        });
    }

    @DisplayName(value = "User double entry test ")
    @Test
    void promptDouble() {
        ByteArrayInputStream in = new ByteArrayInputStream(("1").getBytes());
        System.setIn(in);

        assertDoesNotThrow(() -> {
            Menu.promptDouble("Question Test",0);
        });
    }
}