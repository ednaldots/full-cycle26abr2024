package com.fullcycle.admin.catalogo.domain.category;

import com.fullcycle.admin.catalogo.domain.validation.ValidationHandler;
import com.fullcycle.admin.catalogo.domain.validation.Validator;

import com.fullcycle.admin.catalogo.domain.validation.Error;

public class CategoryValidator extends Validator  {

    private final Category category;

    public CategoryValidator (final Category aCategory, final ValidationHandler aHandler ) {
        super (aHandler);
        this.category = aCategory;
    }

    @Override
    public void validate () throws Exception {
        extracted ( );
    }

    private
    void extracted () throws Exception {
        checkNameConstraints ( );
    }

    private
    void checkNameConstraints () throws Exception {
        final var name = this.category.getName ();
        if (name == null) {
            this.validateHandler ().append (new Error ("'name' should not be null"));
            return;
        }

        if (name.isBlank ()) {
            this.validateHandler ().append (new Error ("'name' should not be empty"));
            return;
        }

        final int length = name.trim().length();
        int NAME_MIN_LENGTH= 3;
        int NAME_MAX_LENGTH = 255;
        if (length > NAME_MAX_LENGTH || length < NAME_MIN_LENGTH) {
            this.validateHandler ().append (new Error ("'name' must be between 3 and 255 characters"));
        }
    }
}
