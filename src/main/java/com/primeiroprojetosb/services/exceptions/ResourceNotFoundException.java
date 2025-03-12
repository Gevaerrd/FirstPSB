
package com.primeiroprojetosb.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Object id) {
        super("Resource not found. Id " + id);
        // O super chama o extends da classe pai, passando a string que vai ser tratada
        // lá
    }

}
