package com.fullcycle.admin.catalogo.domain.validation;
import   java.util.List;

public interface ValidationHandler {

    ValidationHandler append(Error anError) throws Exception;

    ValidationHandler append(ValidationHandler anHandler) throws Exception;

    ValidationHandler validate ( Validation aValidation ) throws Exception;

    List<Error> getErrors();

    default boolean hasError() {
        return getErrors() != null && !getErrors().isEmpty();
    }

    void append ( java.lang.Error error );

    public interface Validation {
        void validate();
    }
}
