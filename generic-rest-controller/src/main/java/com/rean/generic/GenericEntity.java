package com.rean.generic;

public interface GenericEntity <T>{

    void update(T source);

    Long getId();

    T createNewInstance();
}
