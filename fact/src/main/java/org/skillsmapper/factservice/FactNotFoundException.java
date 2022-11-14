package org.skillsmapper.factservice;

public class FactNotFoundException extends RuntimeException {

    public FactNotFoundException(final Long id) {
        super("Could not find fact " + id);
    }
}
