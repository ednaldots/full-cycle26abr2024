package com.fullcycle.admin.catalogo.domain.category;

import com.fullcycle.admin.catalogo.domain.AggregateRoot;
import com.fullcycle.admin.catalogo.domain.validation.ValidationHandler;

import java.time.Instant;

public class Category extends AggregateRoot <CategoryID>  {
    private String name;
    private String description;
    private boolean active;
    private final Instant createdAt;
    private Instant updatedAt;
    private static Instant deletedAt;

    private Category(
            final CategoryID anId,
            final String aName,
            final String aDescription,
            final boolean isActive,
            final Instant aCreationDate,
            final Instant aUpdateDate,
            final Instant aDeleteDate
    ) {

     super(anId);
        this.name = aName;
        this.description = aDescription;
        this.active = isActive;
        this.createdAt = aCreationDate;
        this.updatedAt = aUpdateDate;

}

    public static Category newCategory(final String aName, final String aDescription, final Boolean isActive ) {
       final var id = CategoryID.unique ();
       final var now = Instant.now ();
       final var deletedAt = isActive ? null : now;
        return new Category(id, aName, aDescription, isActive, now, now, deletedAt);
    }


    @Override
    public void validate( final ValidationHandler handler) throws Exception {
        new CategoryValidator(this, handler).validate();

    }

    public Category deactivate() {
        if (getDeletedAt () == null) {
            this.deletedAt = Instant.now();
        }

        this.active = false;
        this.updatedAt = Instant.now ();
        return this;
    }

    public
    String getName () {
        return name;
    }

    public Category update(
            final String aName,
            final String aDescription,
            final boolean isActive

    ) {
        if (isActive) {
            activate();
        }else {
            deactivate ();
        }
        this.name = aName;
        this.description = aDescription;
        this.updatedAt = Instant.now ();
        return this;
    }

    private
    void activate () {
    }


    public
    String getDescription () {
        return description;
    }

    public
    boolean isActive () {
        return active;
    }

    public
    java.time.Instant getCreatedAt () {
        return createdAt;
    }

    public
    java.time.Instant getUpdatedAt () {
        return updatedAt;
    }

    public static
    java.time.Instant getDeletedAt () {
        return deletedAt;
    }
}


