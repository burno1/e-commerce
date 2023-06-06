import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.NoSuchElementException;

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


        assertThrows(NoSuchElementException.class,() -> Main.main(null));

    }

    @Test
    void arrayStream(){
        int arr[] = {1,2,3,4,5,6,7,8,9};
        arr = Arrays.stream(arr).filter(n -> n%2==0).toArray();

    }
}