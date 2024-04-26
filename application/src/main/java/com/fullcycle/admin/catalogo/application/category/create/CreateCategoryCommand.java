package com.fullcycle.admin.catalogo.application.category.create;

public record CreateCategoryCommand(
        String name,
        String description,
        boolean isActive

) {

    public static
    com.fullcycle.admin.catalogo.application.category.create.CreateCategoryCommand with (
            final String aName,
            final String aDescription,
            final boolean IsActive
    ) {
        return new CreateCategoryCommand (aName, aDescription, IsActive);
    }
}

