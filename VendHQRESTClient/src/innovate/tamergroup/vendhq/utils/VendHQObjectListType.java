package innovate.tamergroup.vendhq.utils;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import innovate.tamergroup.vendhq.model.shared.VendHQObjectList;

public class VendHQObjectListType<X> implements ParameterizedType {
    
    private Class<?> wrapped;

    public VendHQObjectListType(Class<X> wrapped) {
        this.wrapped = wrapped;
    }

    public Type[] getActualTypeArguments() {
        return new Type[] { wrapped };
    }

    public Type getRawType() {
        return VendHQObjectList.class;
    }

    public Type getOwnerType() {
        return null;
    }
}
