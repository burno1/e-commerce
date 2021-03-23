package exception;

import java.io.Serializable;

/**
 * Author: Bruno Fernandes
 * Created at : 22/03/2021
 */
public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String msg) {
        super (msg);
    }
}