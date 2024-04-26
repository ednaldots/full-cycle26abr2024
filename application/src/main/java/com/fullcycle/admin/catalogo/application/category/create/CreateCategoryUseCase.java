package com.fullcycle.admin.catalogo.application.category.create;

import com.fullcycle.admin.catalogo.application.UseCase;

public abstract class CreateCategoryUseCase
    extends UseCase <CreateCategoryCommand, CreateCategoryOutput>{

    public abstract
    com.fullcycle.admin.catalogo.application.category.create.CreateCategoryOutput execute( com.fullcycle.admin.catalogo.application.category.create.CreateCategoryCommand aCommand ) throws Exception;
}
