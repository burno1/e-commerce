package utilities;

import enums.MenuOptionEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.NoSuchElementException;
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

        assertDoesNotThrow(() -> menu.spawnMenu());
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

    @DisplayName(value = "User int entered wrong")
    @Test
    void promptWrongInt() {
        ByteArrayInputStream in = new ByteArrayInputStream(("john").getBytes());
        System.setIn(in);

        assertThrows(NoSuchElementException.class, () -> {
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

    @DisplayName(value = "User double entered wrong")
    @Test
    void promptWrongDouble() {
        ByteArrayInputStream in = new ByteArrayInputStream(("john").getBytes());
        System.setIn(in);

        assertThrows(NoSuchElementException.class, () -> {
            Menu.promptDouble("Question Test",0);
        });
    }

    @DisplayName(value = "Spawn menu test with option 1")
    @Test
    void spawnMenuOpt1() {

        ByteArrayInputStream in = new ByteArrayInputStream(("1").getBytes());
        System.setIn(in);
        assertThrows(NoSuchElementException.class, () -> {
            menu.spawnMenu();
        });
    }

    @DisplayName(value = "Spawn menu test with option 2")
    @Test
    void spawnMenuOpt2() {

        ByteArrayInputStream in = new ByteArrayInputStream(("2").getBytes());
        System.setIn(in);
        assertDoesNotThrow( ()-> {
            ByteArrayInputStream in2 = new ByteArrayInputStream(("4").getBytes());
            System.setIn(in2);
            menu.spawnMenu();
        });
    }

    @DisplayName(value = "Spawn menu test with option 3")
    @Test
    void spawnMenuOpt3() {

        ByteArrayInputStream in = new ByteArrayInputStream(("3").getBytes());
        System.setIn(in);
        assertThrows(NoSuchElementException.class, () -> {
            menu.spawnMenu();
        });
    }

    @DisplayName(value = "Spawn menu test with option not available")
    @Test
    void spawnMenuOptWrong() {

        ByteArrayInputStream in = new ByteArrayInputStream(("7").getBytes());
        System.setIn(in);

        assertDoesNotThrow(()-> {
            ByteArrayInputStream in2 = new ByteArrayInputStream(("4").getBytes());
            System.setIn(in2);
            menu.spawnMenu();
        });
    }

    @DisplayName(value = "Spawn menu test with string not available")
    @Test
    void spawnMenuOptString() {

        ByteArrayInputStream in = new ByteArrayInputStream(("asd").getBytes());
        System.setIn(in);

        assertDoesNotThrow(()-> {
            ByteArrayInputStream in2 = new ByteArrayInputStream(("4").getBytes());
            System.setIn(in2);
            menu.spawnMenu();
        });
    }
}
