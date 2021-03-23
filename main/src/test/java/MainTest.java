import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Bruno Fernandes
 * Created at : 23/03/2021
 */
class MainTest {

    @DisplayName(value = "main method test")
    @Test
    void main() {

        ByteArrayInputStream in = new ByteArrayInputStream(("4").getBytes());
        System.setIn(in);


        assertDoesNotThrow(() -> Main.main(null));

    }
}