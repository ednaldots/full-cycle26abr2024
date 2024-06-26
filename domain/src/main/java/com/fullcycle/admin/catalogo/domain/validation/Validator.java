package com.fullcycle.admin.catalogo.domain.validation;

public abstract class Validator {

    private final ValidationHandler handler;

    protected Validator(final ValidationHandler aHandler) {
        this.handler = aHandler;
    }

    public abstract void validate() throws Exception;

    protected ValidationHandler validateHandler() {
        return this.handler;
    }
}