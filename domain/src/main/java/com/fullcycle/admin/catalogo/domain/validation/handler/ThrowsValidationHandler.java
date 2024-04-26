package com.fullcycle.admin.catalogo.domain.validation.handler;

import com.fullcycle.admin.catalogo.domain.validation.Error;
import com.fullcycle.admin.catalogo.domain.validation.ValidationHandler;
import com.fullcycle.admin.catalogo.domain.exceptions.DomainException;

import java.util.List;

public class ThrowsValidationHandler implements ValidationHandler {


    @Override
    public ValidationHandler append ( final Error anError) {
        throw DomainException.with(List.of ( anError));
    }

    @Override
    public ValidationHandler append (final ValidationHandler  anHandler) {
        throw DomainException.with (anHandler.getErrors ());
    }

    @Override
    public ValidationHandler validate(final ValidationHandler.Validation aValidation) {
        try {
            aValidation.validate ();
        } catch (final Exception ex) {
            throw DomainException.with(List.of(new Error(ex.getMessage())));
        }
        return this;
    }


    @Override
    public List<Error> getErrors () {
        return List.of();
    }

    @Override
    public
    void append ( java.lang.Error error ) {

    }


}