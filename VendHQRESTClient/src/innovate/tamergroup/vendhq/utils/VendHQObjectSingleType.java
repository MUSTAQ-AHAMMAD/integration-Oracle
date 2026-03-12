package innovate.tamergroup.vendhq.utils;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import innovate.tamergroup.vendhq.model.shared.VendHQObjectList;
import innovate.tamergroup.vendhq.model.shared.VendHQObjectSingle;

public class VendHQObjectSingleType<X> implements ParameterizedType {
    
    private Class<?> wrapped;

    public VendHQObjectSingleType(Class<X> wrapped) {
        this.wrapped = wrapped;
    }

    public Type[] getActualTypeArguments() {
        return new Type[] { wrapped };
    }

    public Type getRawType() {
        return VendHQObjectSingle.class;
    }

    public Type getOwnerType() {
        return null;
    }
}
