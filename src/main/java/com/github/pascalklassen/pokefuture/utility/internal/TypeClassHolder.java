package com.github.pascalklassen.pokefuture.utility.internal;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class TypeClassHolder<T> {

    @JsonIgnore
    private Class<T> typeClass;

    public Class<T> getTypeClass() {
        return typeClass;
    }

    public void setTypeClass(Class<T> typeClass) {
        this.typeClass = typeClass;
    }

    @Override
    public String toString() {
        return "TypeClassHolder{" +
                "typeClass=" + typeClass +
                '}';
    }
}
