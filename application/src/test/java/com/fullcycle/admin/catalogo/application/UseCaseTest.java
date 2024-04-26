package com.fullcycle.admin.catalogo.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public abstract
class UseCaseTest {
    @Test
    public void testCreateUseCase(){

    }

    protected abstract
    java.util.List<Object> getMocks ();
}
