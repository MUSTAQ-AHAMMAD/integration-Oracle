package com.oracle.xmlns.utils;

import com.oracle.xmlns.apps.shared.ObjectList;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


public class FusionObjectListType<X> implements ParameterizedType {

    private Class<?> wrapped;

    public FusionObjectListType(Class<X> wrapped) {
        this.wrapped = wrapped;
    }

    public Type[] getActualTypeArguments() {
        return new Type[] { wrapped };
    }

    public Type getRawType() {
        return ObjectList.class;
    }

    public Type getOwnerType() {
        return null;
    }

}
